package com.lifeline.api.homeconfig.service;

import com.lifeline.api.homeconfig.dto.HomeConfigDTO;

public interface HomeConfigService {
    HomeConfigDTO add(HomeConfigDTO homeConfigDTO);
    HomeConfigDTO getByUID(String uid);
    HomeConfigDTO editByUID(String uid, HomeConfigDTO homeConfigDTO);
}
