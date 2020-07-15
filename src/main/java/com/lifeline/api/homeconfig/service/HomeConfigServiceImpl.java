package com.lifeline.api.homeconfig.service;

import com.lifeline.api.homeconfig.dao.HomeConfigDAO;
import com.lifeline.api.homeconfig.dto.HomeConfigDTO;
import com.lifeline.api.homeconfig.entities.HomeConfig;

import com.lifeline.api.homeconfig.utility.exceptions.custom.HomeConfigNotFoundException;
import com.lifeline.api.homeconfig.utility.exceptions.custom.InvalidUUIDSignatureException;
import com.lifeline.api.homeconfig.utility.helper.StringParser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class HomeConfigServiceImpl implements HomeConfigService {

    private final HomeConfigDAO homeConfigDAO;

    @Autowired
    public HomeConfigServiceImpl(
            HomeConfigDAO homeConfigDAO
    ){
        this.homeConfigDAO = homeConfigDAO;
    }

    @Override
    public HomeConfigDTO add(HomeConfigDTO homeConfigDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        HomeConfig homeConfig = modelMapper.map(homeConfigDTO, HomeConfig.class);
        homeConfigDAO.save(homeConfig);

        return modelMapper.map(homeConfig, HomeConfigDTO.class);
    }

    @Override
    public HomeConfigDTO getByUID(String uid) throws HomeConfigNotFoundException, InvalidUUIDSignatureException {

        if(uid.isEmpty())
            throw new NullPointerException("Please specify a homeConfig ID");

        if(!StringParser.isValidUUID(uid))
            throw new InvalidUUIDSignatureException("Please specify a valid homeConfigID");

        UUID id = UUID.fromString(uid);
        HomeConfig homeConfig = homeConfigDAO.findByUid(id);

        if(homeConfig == null)
            throw new HomeConfigNotFoundException("Configuration ID not found, please insert a correct one");

        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper.map(homeConfig, HomeConfigDTO.class);
    }

    @Override
    public HomeConfigDTO editByUID(String uid, HomeConfigDTO homeConfigDTO) throws HomeConfigNotFoundException, InvalidUUIDSignatureException {
        HomeConfigDTO currConfig = getByUID(uid);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        HomeConfig homeConfig = modelMapper.map(homeConfigDTO, HomeConfig.class);

        UUID currUid = UUID.fromString(currConfig.getUid());
        homeConfig.setUid(currUid);

        homeConfigDAO.save(homeConfig);

        return modelMapper.map(homeConfig, HomeConfigDTO.class);
    }
}
