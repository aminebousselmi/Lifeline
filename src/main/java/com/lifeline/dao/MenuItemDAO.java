package com.lifeline.dao;

import com.lifeline.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenuItemDAO extends JpaRepository<MenuItem, UUID> {}