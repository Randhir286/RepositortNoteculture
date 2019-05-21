package com.app.notesculture.view.ui.activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.app.notesculture.R;
import com.app.notesculture.databinding.ActivityCreateProfileBinding;

import com.app.notesculture.model.CreateUserModel;
import com.app.notesculture.model.StateCityCourseModel;
import com.app.notesculture.model.StateCityCourseResponseData;

import com.app.notesculture.view.helper.SharedPrefrenceHelper;
import com.app.notesculture.viewmodel.CreateUserViewModel;

import java.util.List;


import retrofit2.Response;

public class ActivityCreateProfile extends AppCompatActivity {
    private CreateUserViewModel createUserViewModel;
    private ActivityCreateProfileBinding binding;
    private SharedPrefrenceHelper sharedPrefrenceHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(ActivityCreateProfile.this, R.layout.activity_create_profile);
        createUserViewModel = ViewModelProviders.of(this).get(CreateUserViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setStateCityViewModel(createUserViewModel);
        sharedPrefrenceHelper=new SharedPrefrenceHelper(this);
       // createUserViewModel.getStateData();
       // createUserViewModel.getCityData("138");
       // createUserViewModel.updateUserDetail();
        createUserViewModel.getStateList().observe(this, new Observer<Response<StateCityCourseModel>>() {
            @Override
            public void onChanged(@Nullable Response<StateCityCourseModel> stateResponse) {
                List<StateCityCourseResponseData> response = stateResponse.body().getData();
            }
        });
        createUserViewModel.getCityList().observe(this, new Observer<Response<StateCityCourseModel>>() {
            @Override
            public void onChanged(@Nullable Response<StateCityCourseModel> stateResponse) {
                List<StateCityCourseResponseData> response = stateResponse.body().getData();
                Log.d("cityOutPut",response.get(0).getCityID()+"....."+response.get(0).getCityName());
            }
        });
        createUserViewModel.updateProfile().observe(this, new Observer<Response<CreateUserModel>>() {
            @Override
            public void onChanged(@Nullable Response<CreateUserModel> createUserResponse) {
                Log.d("Update Profile","yes");
            }
        });
        createUserViewModel.getCourseList().observe(this, new Observer<Response<StateCityCourseModel>>() {
            @Override
            public void onChanged(@Nullable Response<StateCityCourseModel> stateCityCourseModelResponse) {
                List<StateCityCourseResponseData> response = stateCityCourseModelResponse.body().getData();
                Log.d("courseOutPut",response.get(0).getCourse_id()+"....."+response.get(0).getCourse_name());
            }
        });

    }




}
