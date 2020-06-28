package com.lifeline.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Menu")
public class Menu implements Serializable {

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

    // RELATIONS
    @OneToMany(
            mappedBy = "menu"
            ,orphanRemoval = true
            ,cascade = CascadeType.ALL
    )
    private List<MenuItem> items = new ArrayList<>();

    // CONSTRUCTOR

    public Menu() {}

    // GETTERS

    public UUID getUid() {
        return uid;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    // SETTERS

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    // Implementing equals, HashCode and toString method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return uid.equals(menu.uid) &&
                Objects.equals(items, menu.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, items);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "uid=" + uid +
                ", items=" + items +
                '}';
    }
}
