package com.lifeline.api.homeconfig.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import javax.validation.constraints.Size;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
// @Audited FIXME Check audited
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
    private String shortDescription;

    // RELATIONS

    @OneToMany(mappedBy = "homeConfig", orphanRemoval = true, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Section> sections = new ArrayList<>();

    // GETTERS

    public UUID getUid() { return uid; }
    public String getShortDescription() { return shortDescription; }
    public List<Section> getSections() { return sections; }


    // SETTERS

    public void setUid(UUID uid) { this.uid = uid; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }
    public void setSections(List<Section> sections) { this.sections = sections; }

    // Implementing equals, HashCode and toString method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeConfig that = (HomeConfig) o;
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
        return "HomeConfig{" +
                "uid=" + uid +
                ", shortDescription='" + shortDescription + '\'' +
                ", sections=" + sections +
                '}';
    }
}