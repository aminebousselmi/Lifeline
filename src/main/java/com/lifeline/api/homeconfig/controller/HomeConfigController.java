package com.lifeline.api.homeconfig.controller;

import com.lifeline.api.homeconfig.controller.requestmodel.AddHomeConfigRequestModel;
import com.lifeline.api.homeconfig.controller.requestmodel.EditHomeConfigRequestModel;
import com.lifeline.api.homeconfig.controller.responsemodel.AddHomeConfigResponseModel;
import com.lifeline.api.homeconfig.controller.responsemodel.EditHomeConfigResponseModel;
import com.lifeline.api.homeconfig.controller.responsemodel.GetHomeConfigResponseModel;

import com.lifeline.api.homeconfig.dto.HomeConfigDTO;

import com.lifeline.api.homeconfig.service.HomeConfigService;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/home/config")
public class HomeConfigController {

    HomeConfigService homeConfigService;

    @Autowired
    public HomeConfigController(
            HomeConfigService homeConfigService
    ){
        this.homeConfigService = homeConfigService;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<AddHomeConfigResponseModel> add(@Valid @RequestBody AddHomeConfigRequestModel configRequestModel){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        HomeConfigDTO homeConfigDTO = modelMapper.map(configRequestModel, HomeConfigDTO.class);
        HomeConfigDTO homeConfigCreated = homeConfigService.add(homeConfigDTO);

        AddHomeConfigResponseModel responseModel = modelMapper.map(homeConfigCreated, AddHomeConfigResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }

    @GetMapping(
            value = "/{uid}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<GetHomeConfigResponseModel> getByUID(@PathVariable String uid){
        HomeConfigDTO homeConfigDTO = homeConfigService.getByUID(uid);

        GetHomeConfigResponseModel responseModel = new ModelMapper().map(homeConfigDTO, GetHomeConfigResponseModel.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @PutMapping(
            value = "/{uid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<EditHomeConfigResponseModel> editByUID (@PathVariable String uid, @Valid @RequestBody EditHomeConfigRequestModel configRequestModel){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        HomeConfigDTO homeConfigDTO = modelMapper.map(configRequestModel, HomeConfigDTO.class);

        HomeConfigDTO homeConfigEdited = homeConfigService.editByUID(uid, homeConfigDTO);

        EditHomeConfigResponseModel responseModel = modelMapper.map(homeConfigEdited, EditHomeConfigResponseModel.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }
}