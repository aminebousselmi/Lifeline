package com.lifeline.api.homeconfig.controller.requestmodel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HomeConfigRequest {

    // ATTRIBUTS

    @NotNull(message = "A short description is mandatory")
    @Size(min = 1, max = 50, message = "A short description is mandatory and should be less than 50 character")
    private String shortDescription;

    // GETTERS

    public String getShortDescription() { return shortDescription; }

    // SETTERS

    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    // Implementing toString method

    @Override
    public String toString() {
        return "HomeConfigRequest{" +
                "shortDescription='" + shortDescription + '\'' +
                '}';
    }
}