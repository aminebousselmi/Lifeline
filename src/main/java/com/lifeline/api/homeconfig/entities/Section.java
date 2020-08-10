package com.lifeline.api.homeconfig.entities;

import com.lifeline.api.homeconfig.entities.type.SectionType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

import javax.validation.constraints.Size;

import java.io.Serializable;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "section")
// @Audited FIXME Check audited
public class Section implements Serializable {

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

    @Column
    @Size(min = 1, max = 200)
    private String headerTitle;

    @Column
    @Size(min = 1, max = 200)
    private String subTitle;

    @Column(nullable = false)
    @Size(min = 10, max = 9999)
    private String content;

    @Column(nullable = false)
    private SectionType sectionType;

    // RELATIONS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "config_id")
    private HomeConfig homeConfig;

    // GETTERS

    public UUID getUid() { return uid; }
    public String getTitle() { return title; }
    public String getHeaderTitle() { return headerTitle; }
    public String getSubTitle() { return subTitle; }
    public String getContent() { return content; }
    public SectionType getSectionType() { return sectionType; }

    // SETTERS

    public void setUid(UUID uid) { this.uid = uid; }
    public void setTitle(String title) { this.title = title; }
    public void setHeaderTitle(String headerTitle) { this.headerTitle = headerTitle; }
    public void setSubTitle(String subTitle) { this.subTitle = subTitle; }
    public void setContent(String content) { this.content = content; }
    public void setSectionType(SectionType sectionType) { this.sectionType = sectionType; }
    public void setHomeConfig(HomeConfig homeConfig) { this.homeConfig = homeConfig; }

    // Implementing equals, HashCode and toString method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return uid.equals(section.uid) &&
                title.equals(section.title) &&
                Objects.equals(headerTitle, section.headerTitle) &&
                Objects.equals(subTitle, section.subTitle) &&
                content.equals(section.content) &&
                sectionType == section.sectionType &&
                Objects.equals(homeConfig, section.homeConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, title, headerTitle, subTitle, content, sectionType, homeConfig);
    }

    @Override
    public String toString() {
        return "Section{" +
                "uid=" + uid +
                ", title='" + title + '\'' +
                ", headerTitle='" + headerTitle + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", content='" + content + '\'' +
                ", sectionType=" + sectionType +
                '}';
    }
}
