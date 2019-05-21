package com.app.notesculture.model;

import com.google.gson.annotations.SerializedName;

public class SubjectListResponse {
    @SerializedName("subject_id")
    private String subject_id ;

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_image() {
        return subject_image;
    }

    public void setSubject_image(String subject_image) {
        this.subject_image = subject_image;
    }

    @SerializedName("subject_name")
    private String subject_name;
    @SerializedName("subject_image")
    private String subject_image;

}
