package com.lifeline.api.homeconfig.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "home_config")
public class HomeConfig implements Serializable {

    // ATTRIBUTS

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {@Parameter(
                    name="uuid_gen_strategy_class",
                    value="org.hibernate.id.uuid.CustomVersionOneStrategy")
            })
    private UUID uid;

    @Column(nullable = false)
    @Size(min = 1, max = 50)
    private String title;

    @Column(nullable = false)
    @Size(min = 10, max = 1500)
    private String shortIntro;

    @Column(nullable = false)
    @Size(min = 10, max = 1500)
    private String aboutAuthor;

    // Using Pattern to iterate through keywords. Exemple : keyword = "#JPA #Hibernate" => JPA, Hibernate
    @Column(nullable = false)
    @Size(min = 1, max = 500)
    //  FIXME Make this pattern more robust and check with MSSMS DB
    // @Pattern(regexp="(#(.*)(\\\\s))*")
    private String keywords;

    // GETTERS

    public UUID getUid() {
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

    public void setUid(UUID uid) {
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

    // Implementing equals, HashCode and toString method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeConfig that = (HomeConfig) o;
        return uid.equals(that.uid) &&
                title.equals(that.title) &&
                shortIntro.equals(that.shortIntro) &&
                aboutAuthor.equals(that.aboutAuthor) &&
                keywords.equals(that.keywords);
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