package com.lifeline.api.homeconfig.service;

import com.lifeline.api.homeconfig.dao.SectionDAO;
import com.lifeline.api.homeconfig.dto.HomeConfigDTO;
import com.lifeline.api.homeconfig.dto.SectionDTO;

import com.lifeline.api.homeconfig.entities.HomeConfig;
import com.lifeline.api.homeconfig.entities.Section;

import com.lifeline.api.homeconfig.utility.exceptions.custom.HomeConfigNotFoundException;
import com.lifeline.api.homeconfig.utility.exceptions.custom.InvalidUUIDSignatureException;
import com.lifeline.api.homeconfig.utility.helper.StringParser;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class SectionServiceImpl implements SectionService{

    private final SectionDAO sectionDAO;

    @Autowired
    public SectionServiceImpl(
            SectionDAO sectionDAO
    ){
        this.sectionDAO = sectionDAO;
    }

    @Override
    public SectionDTO add(SectionDTO sectionDTO) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        HomeConfigDTO homeConfigDTO = sectionDTO.getHomeConfig();
        UUID currConfigID = homeConfigDTO.getUid();

        PropertyMap<HomeConfigDTO, HomeConfig> homeConfigMap = new PropertyMap<HomeConfigDTO, HomeConfig>() {
            @Override
            protected void configure() {
                map().setUid(currConfigID);
            }
        };
        modelMapper.addMappings(homeConfigMap);

        HomeConfig homeConfig  = modelMapper.map(homeConfigDTO, HomeConfig.class);

        PropertyMap<SectionDTO, Section> sectionMap = new PropertyMap<SectionDTO, Section>() {
            @Override
            protected void configure() {
                map().setHomeConfig(homeConfig);
            }
        };
        modelMapper.addMappings(sectionMap);

        Section section = modelMapper.map(sectionDTO, Section.class);

        sectionDAO.save(section);

        return modelMapper.map(section, SectionDTO.class);
    }

    @Override
    public SectionDTO getByUID(String uid) throws HomeConfigNotFoundException, InvalidUUIDSignatureException {

        if(uid.isEmpty())
            throw new NullPointerException("Please specify a Section ID");

        if(!StringParser.isValidUUID(uid))
            throw new InvalidUUIDSignatureException("Please specify a valid Section ID");

        UUID id = UUID.fromString(uid);
        Section section = sectionDAO.findByUid(id);

        if(section == null)
            throw new HomeConfigNotFoundException("Section ID not found, please insert a correct one");

        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper.map(section, SectionDTO.class);
    }

    @Override
    public SectionDTO editByUID(String uid, SectionDTO sectionDTO) throws HomeConfigNotFoundException, InvalidUUIDSignatureException {
        SectionDTO currSection = getByUID(uid);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        Section section = modelMapper.map(sectionDTO, Section.class);

        UUID currUid = currSection.getUid();
        section.setUid(currUid);

        sectionDAO.save(section);

        return modelMapper.map(section, SectionDTO.class);
    }
}
