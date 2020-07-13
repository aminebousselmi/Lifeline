package com.lifeline.api.homeconfig.dao;

import com.lifeline.api.homeconfig.entities.HomeConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HomeConfigDAO extends JpaRepository<HomeConfig, UUID> {

    HomeConfig findByUid(UUID uid);

}