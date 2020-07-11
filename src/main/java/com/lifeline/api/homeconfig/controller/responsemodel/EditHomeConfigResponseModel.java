package com.lifeline.api.homeconfig.controller.responsemodel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EditHomeConfigResponseModel {

    // ATTRIBUTS

    @NotNull(message = "Title is mandatory")
    @Size(min = 1, max = 50)
    private String title;

    @NotNull(message = "Introduction is mandatory")
    @Size(min = 10, max = 1500, message = "Introduction should be less than 1500 character")
    private StringBuffer shortIntro;

    @NotNull(message = "Author's description is mandatory")
    @Size(min = 10, max = 1500, message = "Author's description should be less than 1500 characters")
    private StringBuffer aboutAuthor;

    // Using StringBuffer to iterate through keywords. Exemple : keyword = "#JPA #Hibernate" => JPA, Hibernate
    @NotNull(message = "Keywords are mandatory")
    @Size(min = 1, max = 500, message = "Keywords should be less than 500 characters")
    //  FIXME Make this pattern more robust and check with MSSMS DB
    @Pattern(regexp="(#(.*)(\\\\s))*",message="keywords must be inserted as follow : #word #word...etc")
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
