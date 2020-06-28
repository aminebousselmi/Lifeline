package com.lifeline.entities;

// FIXME Handle imports in generic utils file

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "HomeConfig")
public class HomeConfig implements Serializable {

    // ATTRIBUTS

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {@Parameter(
                    name="uuid_gen_strategy_class",
                    value="org.hibernate.id.uuid.CustomVersionOneStrategy")
            })
    private UUID uid;

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

    // CONSTRUCTOR

    public HomeConfig() {}

    // GETTERS

    public UUID getUid() {
        return uid;
    }

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

    // Implementing equals, HashCode and toString method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeConfig that = (HomeConfig) o;
        return uid.equals(that.uid) &&
                Objects.equals(title, that.title) &&
                Objects.equals(shortIntro, that.shortIntro) &&
                Objects.equals(aboutAuthor, that.aboutAuthor) &&
                Objects.equals(keywords, that.keywords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, title, shortIntro, aboutAuthor, keywords);
    }

    @Override
    public String toString() {
        return "HomeConfig{" +
                "uid=" + uid +
                ", title='" + title + '\'' +
                ", shortIntro=" + shortIntro +
                ", aboutAuthor=" + aboutAuthor +
                ", keywords=" + keywords +
                '}';
    }
}