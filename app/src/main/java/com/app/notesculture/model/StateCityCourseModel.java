package com.app.notesculture.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
public class StateCityCourseModel {
    @SerializedName("stateID")
    private String stateID;
    @SerializedName("status")
    private String status;
    @SerializedName("statusCode")
    private String statusCode;
    @SerializedName("message")
    private String msg;
    @SerializedName("data")
    private List<StateCityCourseResponseData> data;
    @SerializedName("cityName")
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<StateCityCourseResponseData> getData() {
        return data;
    }

    public void setData(List<StateCityCourseResponseData> data) {
        this.data = data;
    }


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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public StateCityCourseModel(String stateId){
        this.stateID=stateId;
    }






}
