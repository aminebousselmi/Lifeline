package com.lifeline.api.homeconfig.service;

import com.lifeline.api.homeconfig.dao.HomeConfigDAO;
import com.lifeline.api.homeconfig.dto.HomeConfigDTO;
import com.lifeline.api.homeconfig.entities.HomeConfig;

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

        // FIXME Use Optional to handle null values
        // Optional<HomeConfig> currHomeConfig = Optional.ofNullable(homeConfig);

        // currHomeConfig.ifPresent(homeConfigDAO::save);
        // HomeConfig orElse = currHomeConfig.orElse(null);

        // if(homeConfigDTO.getUid() != null)
        //    homeConfigDAO.save(homeConfig);
        // else
            // return OptMsgType.BAD_REQUEST;
        // return OptMsgType.CREATED;

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        HomeConfig homeConfig = modelMapper.map(homeConfigDTO, HomeConfig.class);
        homeConfigDAO.save(homeConfig);

        return modelMapper.map(homeConfig, HomeConfigDTO.class);
    }

    @Override
    public HomeConfigDTO getByUID(String uid) {
        UUID id = UUID.fromString(uid);
        HomeConfig homeConfig = homeConfigDAO.findByUid(id);
        return new ModelMapper().map(homeConfig, HomeConfigDTO.class);
    }

    @Override
    public HomeConfigDTO editByUID(String uid, HomeConfigDTO homeConfigDTO) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        HomeConfig homeConfig = modelMapper.map(homeConfigDTO, HomeConfig.class);
        // FIXME Optional<Student> studentOptional = studentRepository.findById(id);

        // FIXME if (!studentOptional.isPresent())
        // FIXME   return ResponseEntity.notFound().build();

        // FIXME student.setId(id);
        UUID currUid = UUID.fromString(uid);
        homeConfig.setUid(currUid);

        homeConfigDAO.save(homeConfig);

        return modelMapper.map(homeConfig, HomeConfigDTO.class);
    }
}
