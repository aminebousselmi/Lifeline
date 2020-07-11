package com.lifeline.api.homeconfig.service;

import com.lifeline.api.homeconfig.dto.HomeConfigDTO;

import java.util.UUID;

public interface HomeConfigService {
    HomeConfigDTO add(HomeConfigDTO homeConfigDTO);
    HomeConfigDTO getByUID(UUID uid);
    HomeConfigDTO editByUID(UUID uid, HomeConfigDTO homeConfigDTO);
}
