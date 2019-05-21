package com.app.notesculture.model;

import com.google.gson.annotations.SerializedName;

public class CreateUserModel {
    @SerializedName("status")
    private String status;
    @SerializedName("statusCode")
    private String statusCode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")
    private String message;

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("sex")
    private String sex;
    @SerializedName("dob")
    private String dob;
    @SerializedName("course")
    private String course;
    @SerializedName("state_id")
    private String state_id;
    @SerializedName("name")
    private String name;
    @SerializedName("email_id")
    private String email_id;
    @SerializedName("city_id")
    private String city_id;
    @SerializedName("is_create_profile")
    private String is_create_profile;


     public CreateUserModel(String userId, String userName, String emailId, String sex,
                            String dob, String courseName, String stateId, String cityId, String is_create_profile){

            this.user_id=userId;
            this.name=userName;
            this.email_id=emailId;
            this.sex=sex;
            this.dob=dob;
            this.course=courseName;
            this.state_id=stateId;
            this.city_id=cityId;
            this.is_create_profile=is_create_profile;



     }



}
