package com.codegym.model;

public class MailConfig {
    private String language;
    private Integer pageSize;
    private Boolean spam;
    private String Signature;

    public MailConfig() {
    }

    public MailConfig(String language, Integer pageSize, Boolean spam, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spam = spam;
        Signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpam() {
        return spam;
    }

    public void setSpam(Boolean spam) {
        this.spam = spam;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }
}
