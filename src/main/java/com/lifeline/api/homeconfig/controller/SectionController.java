package com.lifeline.api.homeconfig.controller;

import com.lifeline.api.homeconfig.controller.requestmodel.AddSectionRequest;
import com.lifeline.api.homeconfig.controller.requestmodel.EditSectionRequest;
import com.lifeline.api.homeconfig.controller.responsemodel.SectionResponse;

import com.lifeline.api.homeconfig.dto.HomeConfigDTO;
import com.lifeline.api.homeconfig.dto.SectionDTO;
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

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/main/config/section")
public class SectionController {

    SectionService sectionService;
    HomeConfigService homeConfigService;

    @Autowired
    public SectionController(
            SectionService sectionService
            ,HomeConfigService homeConfigService
    ){
        this.sectionService = sectionService;
        this.homeConfigService = homeConfigService;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<SectionResponse> add(@Valid @RequestBody AddSectionRequest sectionRequestModel) throws InvalidUUIDSignatureException, HomeConfigNotFoundException{

        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setImplicitMappingEnabled(true);

        SectionDTO sectionDTO = modelMapper.map(sectionRequestModel, SectionDTO.class);

        HomeConfigDTO homeConfigDTO = homeConfigService.getByUID(sectionRequestModel.getHomeConfig());

        sectionDTO.setHomeConfig(homeConfigDTO);
        SectionDTO sectionCreated = sectionService.add(sectionDTO);

        SectionResponse responseModel = modelMapper.map(sectionCreated, SectionResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }

    @GetMapping(
            value = "/{uid}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<SectionResponse> getByUID(@PathVariable String uid) throws InvalidUUIDSignatureException, HomeConfigNotFoundException {
        SectionDTO sectionDTO = sectionService.getByUID(uid);

        SectionResponse responseModel = new ModelMapper().map(sectionDTO, SectionResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @PutMapping(
            value = "/{uid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<SectionResponse> editByUID (@PathVariable String uid, @Valid @RequestBody EditSectionRequest sectionRequestModel) throws HomeConfigNotFoundException, InvalidUUIDSignatureException {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        SectionDTO sectionDTO = modelMapper.map(sectionRequestModel, SectionDTO.class);

        SectionDTO sectionEdited = sectionService.editByUID(uid, sectionDTO);

        SectionResponse responseModel = modelMapper.map(sectionEdited, SectionResponse.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }
}