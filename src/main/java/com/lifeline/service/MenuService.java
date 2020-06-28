package com.lifeline.service;

import com.lifeline.entities.Menu;
import com.lifeline.entities.MenuItem;

import com.lifeline.utility.OptMsgType;

import java.util.UUID;

public interface MenuService {

    public OptMsgType add(Menu menu);
    // delete menu and keep his items for reuse
    public OptMsgType delete(Menu menu);
    // delete menu with his items
    public OptMsgType deleteCascade(Menu menu);

    // add item to a specific menu => add relation between an item and menu
    public OptMsgType addItem(UUID menuId, MenuItem item);
    // remove item from a specific Menu => remove relation between an item and menu
    public OptMsgType removeItemByUID(UUID uid);

}