package com.lifeline.api.homeconfig.dao;

import com.lifeline.api.homeconfig.entities.HomeConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface HomeConfigDAO extends JpaRepository<HomeConfig, UUID> {
    HomeConfig findByUid(UUID uid);

    @Modifying
    @Query(value =
            "UPDATE" +
                    "HomeConfig CONF" +
            "SET" +
                    "CONF.title = :newHomeConfig.title" +
                    ",CONF.shortIntro = :newHomeConfig.shortIntro" +
                    ",CONF.aboutAuthor = :newHomeConfig.aboutAuthor" +
                    ",CONF.keywords = :newHomeConfig.keywords" +
            "WHERE" +
                    "CONF.uid = uid"
            , nativeQuery = true
    )
    void editByUid(@Param("uid") UUID uid, @Param("newHomeConfig") HomeConfig homeConfig);
}