package com.app.notesculture.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubjectModel extends BaseObservable {
    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @SerializedName("subject_id")
    private  String subject_id;
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("status")
    private String status;
    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("name")
    private String name;

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    @SerializedName("subject_name")
    private  String subject_name;

    public List<SubjectDetailResponseData> getSubjectDetailResponseData() {
        return subjectDetailResponseData;
    }

    public void setSubjectDetailResponseData(List<SubjectDetailResponseData >subjectDetailResponseData) {
        this.subjectDetailResponseData = subjectDetailResponseData;
    }

    @SerializedName("data")
    private List<SubjectDetailResponseData> subjectDetailResponseData;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal_number_chapter() {
        return total_number_chapter;
    }

    public void setTotal_number_chapter(String total_number_chapter) {
        this.total_number_chapter = total_number_chapter;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    @SerializedName("total_number _chapter")
    private String total_number_chapter;
    @SerializedName("profile_image")
    private String profile_image;

    public  SubjectModel(String subject_id,String user_id ){
        this.subject_id=subject_id;
        this.user_id=user_id;
    }
}
