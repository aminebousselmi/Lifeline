package com.lifeline.api.homeconfig.dto;

// FIXME Handle imports in generic utils file

public class HomeConfigDTO{

    // ATTRIBUTS
    private String title;
    private StringBuffer shortIntro;
    private StringBuffer aboutAuthor;
    private StringBuffer keywords;

    // GETTERS

    public String getTitle() {
        return title;
    }

    public StringBuffer getShortIntro() {
        return shortIntro;
    }

    public StringBuffer getAboutAuthor() {
        return aboutAuthor;
    }

    public StringBuffer getKeywords() {
        return keywords;
    }

    // SETTERS

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortIntro(StringBuffer shortIntro) {
        this.shortIntro = shortIntro;
    }

    public void setAboutAuthor(StringBuffer aboutAuthor) {
        this.aboutAuthor = aboutAuthor;
    }

    public void setKeywords(StringBuffer keywords) {
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