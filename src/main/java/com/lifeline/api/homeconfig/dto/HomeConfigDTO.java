package com.lifeline.api.homeconfig.dto;

// FIXME Handle imports in generic utils file

import java.util.UUID;

public class HomeConfigDTO{

    // ATTRIBUTS
    private String uid;
    private String title;
    private String shortIntro;
    private String aboutAuthor;
    private String keywords;

    // GETTERS

    public String getUid() {
        return uid;
    }
    public String getTitle() {
        return title;
    }
    public String getShortIntro() {
        return shortIntro;
    }
    public String getAboutAuthor() {
        return aboutAuthor;
    }
    public String getKeywords() {
        return keywords;
    }

    // SETTERS

    public void setUid(String uid) {
        this.uid = uid;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setShortIntro(String shortIntro) {
        this.shortIntro = shortIntro;
    }
    public void setAboutAuthor(String aboutAuthor) {
        this.aboutAuthor = aboutAuthor;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "HomeConfig{" +
                ", title='" + title + '\'' +
                ", shortIntro=" + shortIntro +
                ", aboutAuthor=" + aboutAuthor +
                ", keywords=" + keywords +
                '}';
    }
}