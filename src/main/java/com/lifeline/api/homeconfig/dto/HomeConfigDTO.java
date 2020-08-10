package com.lifeline.api.homeconfig.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class HomeConfigDTO{

    // ATTRIBUTS

    private UUID uid;
    private String shortDescription;
    private List<SectionDTO> sections = new ArrayList<>();

    // GETTERS

    public UUID getUid() {
        return uid;
    }
    public String getShortDescription() { return shortDescription; }
    public List<SectionDTO> getSections() { return sections; }

    // SETTERS

    public void setUid(UUID uid) {
        this.uid = uid;
    }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }
    public void setSections(List<SectionDTO> sections) { this.sections = sections; }

    // Implementing equals, HashCode and toString method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeConfigDTO that = (HomeConfigDTO) o;
        return uid.equals(that.uid) &&
                shortDescription.equals(that.shortDescription) &&
                Objects.equals(sections, that.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, shortDescription, sections);
    }

    @Override
    public String toString() {
        return "HomeConfigDTO{" +
                "uid=" + uid +
                ", shortDescription='" + shortDescription + '\'' +
                ", sections=" + sections +
                '}';
    }
}