package com.lifeline.api.homeconfig.controller.responsemodel;

import java.util.Objects;

public class SectionResponse {

    // ATTRIBUTS

    private String uid;
    private String title;
    private String headerTitle;
    private String subTitle;
    private String content;

    // GETTERS

    public String getUid() { return uid; }
    public String getTitle() { return title; }
    public String getHeaderTitle() { return headerTitle; }
    public String getSubTitle() { return subTitle; }
    public String getContent() { return content; }

    // SETTERS

    public void setUid(String uid) { this.uid = uid; }
    public void setTitle(String title) { this.title = title; }
    public void setHeaderTitle(String headerTitle) { this.headerTitle = headerTitle; }
    public void setSubTitle(String subTitle) { this.subTitle = subTitle; }
    public void setContent(String content) { this.content = content; }

    // Implementing equals, HashCode and toString method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionResponse that = (SectionResponse) o;
        return uid.equals(that.uid) &&
                title.equals(that.title) &&
                Objects.equals(headerTitle, that.headerTitle) &&
                Objects.equals(subTitle, that.subTitle) &&
                content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, title, headerTitle, subTitle, content);
    }

    @Override
    public String toString() {
        return "SectionResponse{" +
                "uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", headerTitle='" + headerTitle + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}