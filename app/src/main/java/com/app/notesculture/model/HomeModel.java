package com.app.notesculture.model;

import com.google.gson.annotations.SerializedName;

public class HomeModel {
@SerializedName("status")
    private String status;

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

    public HomeResponseData getHomeResponseData() {
        return homeResponseData;
    }

    public void setHomeResponseData(HomeResponseData homeResponseData) {
        this.homeResponseData = homeResponseData;
    }

    @SerializedName("statusCode")
    private String statusCode;
@SerializedName("data")
    private HomeResponseData homeResponseData;
}
