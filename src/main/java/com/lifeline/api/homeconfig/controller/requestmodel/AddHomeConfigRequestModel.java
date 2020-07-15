package com.lifeline.api.homeconfig.controller.requestmodel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddHomeConfigRequestModel {

    // ATTRIBUTS

    @NotNull(message = "Title is mandatory")
    @Size(min = 1, max = 50, message = "Title is mandatory and should be less than 50 character")
    private String title;

    @NotNull(message = "Introduction is mandatory")
    @Size(min = 10, max = 1500, message = "Introduction should be between 10 and 1500 character")
    private String shortIntro;

    @NotNull(message = "Author's description is mandatory")
    @Size(min = 10, max = 1500, message = "Author's description should be between 10 and 1500 characters")
    private String aboutAuthor;

    // Using StringBuffer to iterate through keywords. Exemple : keyword = "#JPA #Hibernate" => JPA, Hibernate
    @NotNull(message = "Keywords are mandatory")
    @Size(min = 2, max = 500, message = "Keywords are mandatory and should be less than 500 characters")
    //  FIXME Make this pattern more robust and check with MSSMS DB
    // @Pattern(regexp="(#(.*)(\\\\s))*",message="keywords must be inserted as follow : #word #word...etc")
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
