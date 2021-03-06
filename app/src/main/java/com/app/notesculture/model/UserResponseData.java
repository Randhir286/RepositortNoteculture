package com.app.notesculture.model;

import com.google.gson.annotations.SerializedName;

public class UserResponseData {
    @SerializedName("otp")
    private String otp;
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("device_id")
    private String device_id;

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

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }




}
