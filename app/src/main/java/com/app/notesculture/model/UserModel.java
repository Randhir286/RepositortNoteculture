package com.app.notesculture.model;

import com.google.gson.annotations.SerializedName;

public class UserModel {
    public String getConPassword() {
        return conPassword;
    }

    public void setConPassword(String conPassword) {
        this.conPassword = conPassword;
    }

    private String conPassword;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
    @SerializedName("otp")
    private String otp;
    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private String status;
    @SerializedName("statusCode")
    private int statusCode;

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

    public UserResponseData getData() {
        return data;
    }

    public void setData(UserResponseData data) {
        this.data = data;
    }

    @SerializedName("data")
    private UserResponseData data;




    @SerializedName("device_id")
    private String device_id;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @SerializedName("phone_number")
    private String phone_number;
    @SerializedName("password")
    private String password;

    public UserModel(String DeviceId, String PhoneNo, String Password) {
        this.device_id=DeviceId;
        this.phone_number = PhoneNo;
        this.password = Password;
    }
    public UserModel(String DeviceId, String PhoneNo, String Password, String conPassword) {
        this.device_id=DeviceId;
        this.phone_number = PhoneNo;
        this.password = Password;
        this.conPassword=conPassword;
    }
    public UserModel(String DeviceId, String DeviceToken, String PhoneNo, String Password, String Otp) {
        this.device_id=DeviceId;
        this.phone_number = PhoneNo;
        this.password = Password;
        this.otp=Otp;
    }
    public UserModel(String PhoneNo) {

        this.phone_number = PhoneNo;

    }
    public UserModel(int otp) {

        this.otp= String.valueOf(otp);


    }

    public UserModel(String password, String conPassword) {

        this.password = password;
        this.conPassword=conPassword;

    }
    public UserModel(String phone_number, int otp) {

        this.phone_number = phone_number;
        this.otp= String.valueOf(otp);

    }


    @SerializedName("id")
    int mId;

    @SerializedName("name")
    String mName;

    public UserModel(int id, String name ) {
        this.mId = id;
        this.mName = name;
    }



}

