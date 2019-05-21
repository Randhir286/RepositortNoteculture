package com.app.notesculture.model;

import com.google.gson.annotations.SerializedName;

public class HomeUserResponseData {
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("device_id")
    private String device_id;
    @SerializedName("email_id")
    private String email_id;
    @SerializedName("name")
    private String name;
    @SerializedName("sex")
    private String sex;
    @SerializedName("phone_number")
    private String phone_number;
    @SerializedName("dob")
    private String dob;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_create_profile() {
        return is_create_profile;
    }

    public void setIs_create_profile(String is_create_profile) {
        this.is_create_profile = is_create_profile;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @SerializedName("course")
    private String course;
    @SerializedName("status")
    private String status;
    @SerializedName("is_create_profile")
    private String is_create_profile;
    @SerializedName("stateName")
    private String stateName;
    @SerializedName("cityName")
    private String cityName;

}
