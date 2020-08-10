package com.lifeline.api.homeconfig.controller.responsemodel;

import com.lifeline.api.homeconfig.dto.SectionDTO;

import java.util.List;
import java.util.UUID;

public class HomeConfigResponse {

    // ATTRIBUTS

    private UUID uid;
    private String shortDescription;
    private List<SectionDTO> sections;

    // GETTERS

    public UUID getUid() { return uid; }
    public String getShortDescription() { return shortDescription; }
    public List<SectionDTO> getSections() { return sections; }

    // SETTERS

    public void setUid(UUID uid) { this.uid = uid; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }
    public void setSections(List<SectionDTO> sections) { this.sections = sections; }

    // Implementing toString method

    @Override
    public String toString() {
        return "HomeConfigResponse{" +
                "uid=" + uid +
                ", shortDescription='" + shortDescription + '\'' +
                ", sections=" + sections +
                '}';
    }
}