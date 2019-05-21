package com.app.notesculture.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeResponseData {
    @SerializedName("user_data")
    private HomeUserResponseData homeUserResponseData;
    @SerializedName("subject")
    private List<SubjectListResponse> subjectListResponses;
    @SerializedName("recent_topic")
    private  List<RecentTopicResponseList> recentTopicResponseLists;
    @SerializedName("video")
    private  List<SubjectVideoResponseList> subjectVideoResponseLists;

    public HomeUserResponseData getHomeUserResponseData() {
        return homeUserResponseData;
    }

    public void setHomeUserResponseData(HomeUserResponseData homeUserResponseData) {
        this.homeUserResponseData = homeUserResponseData;
    }

    public List<SubjectListResponse> getSubjectListResponses() {
        return subjectListResponses;
    }

    public void setSubjectListResponses(List<SubjectListResponse> subjectListResponses) {
        this.subjectListResponses = subjectListResponses;
    }

    public List<RecentTopicResponseList> getRecentTopicResponseLists() {
        return recentTopicResponseLists;
    }

    public void setRecentTopicResponseLists(List<RecentTopicResponseList> recentTopicResponseLists) {
        this.recentTopicResponseLists = recentTopicResponseLists;
    }

    public List<SubjectVideoResponseList> getSubjectVideoResponseLists() {
        return subjectVideoResponseLists;
    }

    public void setSubjectVideoResponseLists(List<SubjectVideoResponseList> subjectVideoResponseLists) {
        this.subjectVideoResponseLists = subjectVideoResponseLists;
    }


}
