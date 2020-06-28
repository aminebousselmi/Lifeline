package com.lifeline.dao;

import com.lifeline.entities.HomeConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HomeConfigDAO extends JpaRepository<HomeConfig, UUID> {}