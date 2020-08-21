package com.everis.base.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"company", "url", "text"})
public class Ad {

    private String company;
    private String url;
    private String text;

    @Override
    public String toString() {
        return "Ad{" +
                "company='" + company + '\'' +
                ", url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
