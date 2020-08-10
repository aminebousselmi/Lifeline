package com.lifeline.api.homeconfig.controller;

import com.lifeline.api.homeconfig.controller.requestmodel.HomeConfigRequest;
import com.lifeline.api.homeconfig.controller.responsemodel.HomeConfigResponse;
import com.lifeline.api.homeconfig.dto.HomeConfigDTO;

import com.lifeline.api.homeconfig.service.HomeConfigService;
import com.lifeline.api.homeconfig.service.SectionService;

import com.lifeline.api.homeconfig.utility.exceptions.custom.HomeConfigNotFoundException;
import com.lifeline.api.homeconfig.utility.exceptions.custom.InvalidUUIDSignatureException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;

@RestController
@RequestMapping("/main/config/home")
public class HomeConfigController {

    HomeConfigService homeConfigService;
    SectionService sectionService;

    @Autowired
    public HomeConfigController(
            HomeConfigService homeConfigService
            ,SectionService sectionService
            ){
        this.homeConfigService = homeConfigService;
        this.sectionService = sectionService;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<HomeConfigResponse> add(@RequestBody @Valid HomeConfigRequest configRequestModel) {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        HomeConfigDTO homeConfigDTO = modelMapper.map(configRequestModel, HomeConfigDTO.class);

        HomeConfigDTO homeConfigCreated = homeConfigService.add(homeConfigDTO);

        HomeConfigResponse responseModel = modelMapper.map(homeConfigCreated, HomeConfigResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }

    @GetMapping(
            value = "/{uid}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<HomeConfigResponse> getByUID(@PathVariable String uid) throws InvalidUUIDSignatureException, HomeConfigNotFoundException {
        HomeConfigDTO homeConfigDTO = homeConfigService.getByUID(uid);

        HomeConfigResponse responseModel = new ModelMapper().map(homeConfigDTO, HomeConfigResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }
}