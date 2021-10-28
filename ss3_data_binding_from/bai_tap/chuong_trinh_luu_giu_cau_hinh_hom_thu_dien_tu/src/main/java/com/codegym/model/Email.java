package com.codegym.model;

public class Email {
    private String language;
    private Integer size;
    private String filter;
    private String signature;

    public Email() {
    }

    public Email( String language, Integer size, String filter, String signature) {

        this.language = language;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
