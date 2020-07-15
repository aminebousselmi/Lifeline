package com.lifeline.api.homeconfig.utility.exceptions.custom;

import javassist.NotFoundException;

public class HomeConfigNotFoundException extends NotFoundException {

    public HomeConfigNotFoundException(String msg) {
        super(msg);
    }
}
