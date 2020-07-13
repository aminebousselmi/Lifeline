package com.lifeline.api.homeconfig.controller.responsemodel;

public class GetHomeConfigResponseModel {

    // ATTRIBUTS

    private String title;
    private String shortIntro;
    private String aboutAuthor;
    private String keywords;

    // GETTERS

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
