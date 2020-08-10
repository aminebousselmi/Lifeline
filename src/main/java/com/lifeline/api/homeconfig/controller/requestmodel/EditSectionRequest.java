package com.lifeline.api.homeconfig.controller.requestmodel;

import com.lifeline.api.homeconfig.entities.type.SectionType;
import com.lifeline.api.homeconfig.utility.validation.OptionalField;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

// @OptionalField FIXME Review multiple Optional field & Add HomeConfig
public class EditSectionRequest {

    // ATTRIBUTS

    private String uid;

    @NotNull(message = "Title is mandatory")
    @Size(min = 1, max = 50, message = "Title is mandatory and should be less than 50 character")
    private String title;
    private String headerTitle;
    private String subTitle;

    @NotNull(message = "Content is mandatory")
    @Size(min = 10, max = 9999, message = "Content should be between 10 and 9999 character")
    private String content;

    @NotNull(message = "Section Type is mandatory")
    private SectionType sectionType;

    // GETTERS

    public String getUid() { return uid; }
    public String getTitle() {
        return title;
    }
    public String getHeaderTitle() { return headerTitle; }
    public String getSubTitle() { return subTitle; }
    public String getContent() { return content; }
    public SectionType getSectionType() { return sectionType; }

    // SETTERS

    public void setUid(String uid) { this.uid = uid; }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setHeaderTitle(String headerTitle) { this.headerTitle = headerTitle; }
    public void setSubTitle(String subTitle) { this.subTitle = subTitle; }
    public void setContent(String content) { this.content = content; }

    public void setSectionType(SectionType sectionType) { this.sectionType = sectionType; }

    // Implementing equals, HashCode and toString method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditSectionRequest that = (EditSectionRequest) o;
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
        return "EditSectionRequest{" +
                "uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", headerTitle='" + headerTitle + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", content='" + content + '\'' +
                ", sectionType=" + sectionType +
                '}';
    }
}