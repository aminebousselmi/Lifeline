package com.lifeline.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.io.Serializable;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "MenuItem")
public class MenuItem implements Serializable {

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

    @NotNull(message = "label is mandatory")
    @Size(min = 1, max = 30, message = "Label's size should be less than 30 characters")
    private String label;

    @NotNull(message = "Description of menu item is mandatory")
    @Size(min = 1, max = 1500, message = "Description should be less than 1500 characters")
    private StringBuffer shortDescription;

    @NotNull(message = "Link is mandatory")
    private StringBuffer linkEncryptedUrl;

    @Size(max = 2000)
    // FIXME Make this pattern more robust and check with MSSMS DB
    @Pattern(regexp="(#(.*)(\\\\s))*",message="data must be inserted as follow : #word #word...etc")
    private StringBuffer otherFormattedData;

    // RELATION
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "fk_menu")
    private Menu menu;

    // CONSTRUCTOR

    public MenuItem() {}

    // GETTERS

    public UUID getUid() {
        return uid;
    }

    public String getLabel() {
        return label;
    }

    public StringBuffer getShortDescription() {
        return shortDescription;
    }

    public StringBuffer getLinkEncryptedUrl() {
        return linkEncryptedUrl;
    }

    public StringBuffer getOtherFormattedData() {
        return otherFormattedData;
    }

    // SETTERS

    public void setLabel(String label) {
        this.label = label;
    }

    public void setShortDescription(StringBuffer shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLinkEncryptedUrl(StringBuffer linkEncryptedUrl) {
        this.linkEncryptedUrl = linkEncryptedUrl;
    }

    public void setOtherFormattedData(StringBuffer otherFormattedData) {
        this.otherFormattedData = otherFormattedData;
    }

    // Implementing equals, HashCode and toString method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return uid.equals(menuItem.uid) &&
                Objects.equals(label, menuItem.label) &&
                Objects.equals(shortDescription, menuItem.shortDescription) &&
                Objects.equals(linkEncryptedUrl, menuItem.linkEncryptedUrl) &&
                Objects.equals(otherFormattedData, menuItem.otherFormattedData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, label, shortDescription, linkEncryptedUrl, otherFormattedData);
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "uid=" + uid +
                ", label='" + label + '\'' +
                ", shortDescription=" + shortDescription +
                ", linkEncryptedUrl=" + linkEncryptedUrl +
                ", otherFormattedData=" + otherFormattedData +
                '}';
    }
}
