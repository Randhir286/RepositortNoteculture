package com.app.notesculture.api;
import com.app.notesculture.model.CreateUserModel;
import com.app.notesculture.model.StateCityCourseModel;
import com.app.notesculture.model.SubjectModel;
import com.app.notesculture.model.UserModel;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface {


    @POST("userLogin")
    Call<UserModel> userLogin(@Body UserModel userModel);

    @POST("createUser")
    Call<UserModel> userSignUp(@Body UserModel userModel);

    @POST("forgotPassword")
    Call<UserModel> userForgetpassword(@Body UserModel userModel);

    @POST("changePassword")
    Call<UserModel> userChangePassword(@Body UserModel userModel);

    @POST("verifyOtp")
    Call<UserModel> userVerifyOtp(@Body UserModel userModel);

    @GET("getstate")
    Call<StateCityCourseModel> GetState();

    @POST("getCity")
    Call<StateCityCourseModel> GetCity(@Body StateCityCourseModel stateCityCourseModel);

    @POST("createProfile")
    Call<CreateUserModel> createProfile(@Body CreateUserModel createUserModel);
    @GET("getcourse")
    Call<StateCityCourseModel> GetCourse();
    @POST("getTopic")
    Call<SubjectModel> GetSubjectDetail(@Body SubjectModel subjectModel);
}
