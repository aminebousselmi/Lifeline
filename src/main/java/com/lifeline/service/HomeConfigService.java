package com.lifeline.service;

import com.lifeline.entities.HomeConfig;
import com.lifeline.utility.OptMsgType;

import java.util.UUID;

public interface HomeConfigService {

    public OptMsgType add(HomeConfig homeConfig);
    public OptMsgType editByUID(UUID uid, String title, StringBuffer shortIntro, StringBuffer aboutAuthor, StringBuffer keywords);
}
