package com.lifeline.api.homeconfig.service;

import com.lifeline.api.homeconfig.dto.HomeConfigDTO;
import com.lifeline.api.homeconfig.utility.exceptions.custom.HomeConfigNotFoundException;
import com.lifeline.api.homeconfig.utility.exceptions.custom.InvalidUUIDSignatureException;

public interface HomeConfigService {
    HomeConfigDTO add(HomeConfigDTO homeConfigDTO);
    HomeConfigDTO getByUID(String uid) throws HomeConfigNotFoundException, InvalidUUIDSignatureException;
    HomeConfigDTO editByUID(String uid, HomeConfigDTO homeConfigDTO) throws HomeConfigNotFoundException, InvalidUUIDSignatureException;
}
