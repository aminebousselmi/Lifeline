package com.lifeline.api.homeconfig.dto;

import com.lifeline.api.homeconfig.entities.type.SectionType;

import java.util.Objects;
import java.util.UUID;

public class SectionDTO {

    // ATTRIBUTS

    private UUID uid;
    private String title;
    private String headerTitle;
    private String subTitle;
    private String content;
    private SectionType sectionType;
    private HomeConfigDTO homeConfig;

    // GETTERS

    public UUID getUid() { return uid; }
    public String getTitle() { return title; }
    public String getHeaderTitle() { return headerTitle; }
    public String getSubTitle() { return subTitle; }
    public String getContent() { return content; }
    public SectionType getSectionType() { return sectionType; }
    public HomeConfigDTO getHomeConfig() { return homeConfig; }

    // SETTERS

    public void setUid(UUID uid) { this.uid = uid; }
    public void setTitle(String title) { this.title = title; }
    public void setHeaderTitle(String headerTitle) { this.headerTitle = headerTitle; }
    public void setSubTitle(String subTitle) { this.subTitle = subTitle; }
    public void setContent(String content) { this.content = content; }
    public void setSectionType(SectionType sectionType) { this.sectionType = sectionType; }
    public void setHomeConfig(HomeConfigDTO homeConfig) { this.homeConfig = homeConfig; }

    // Implementing equals, HashCode and toString method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionDTO that = (SectionDTO) o;
        return uid.equals(that.uid) &&
                title.equals(that.title) &&
                Objects.equals(headerTitle, that.headerTitle) &&
                Objects.equals(subTitle, that.subTitle) &&
                content.equals(that.content) &&
                sectionType == that.sectionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, title, headerTitle, subTitle, content, sectionType);
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
