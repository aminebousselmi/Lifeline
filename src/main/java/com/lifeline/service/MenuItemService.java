package com.lifeline.service;

import com.lifeline.entities.MenuItem;
import com.lifeline.utility.OptMsgType;

import java.util.UUID;

public interface MenuItemService {

    public OptMsgType add(MenuItem item);
    public OptMsgType deleteByUID(UUID uid);
    
}
