package com.lifeline.dao;

import com.lifeline.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenuDAO extends JpaRepository<Menu, UUID> {}