package com.lifeline.api.homeconfig.dao;

import com.lifeline.api.homeconfig.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SectionDAO extends JpaRepository<Section, UUID> {

    Section findByUid(UUID uid);

}
