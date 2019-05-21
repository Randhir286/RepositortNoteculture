package com.app.notesculture.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StateCityCourseResponseData {


    @SerializedName("stateName")
    private String stateName;
    @SerializedName("stateID")
    private String stateID;
    @SerializedName("cityID")
    private String cityID;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @SerializedName("course_id")
    private String course_id;
    @SerializedName("course_name")
    private String course_name;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @SerializedName("cityName")
    private String cityName;


    public String getCityID() {
        return cityID;
    }

    public void setCityID(String countryID) {
        this.cityID = countryID;
    }
/*
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }*/

//    @SerializedName("latitude")
//    private String latitude;
//    @SerializedName("longitude")
//    private String longitude;

    public String getStateID() {
        return stateID;
    }

    public void setStateID(String stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }



}
