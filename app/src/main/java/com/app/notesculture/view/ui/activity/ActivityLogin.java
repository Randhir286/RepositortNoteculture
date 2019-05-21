package com.app.notesculture.view.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import com.app.notesculture.R;
import com.app.notesculture.model.UserModel;
import com.app.notesculture.view.helper.SharedPrefrenceHelper;
import com.app.notesculture.view.utills.AppUtility;
import com.app.notesculture.view.utills.Const;
import com.app.notesculture.viewmodel.LoginViewModel;
import com.app.notesculture.databinding.ActivityLoginBinding;

import retrofit2.Response;


public class ActivityLogin extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;
    private SharedPrefrenceHelper sharedPrefrenceHelper;

  //  ActivityLoginBinding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding = DataBindingUtil.setContentView(ActivityLogin.this, R.layout.activity_login);
        binding.setLifecycleOwner(this);
        binding.setLoginViewModel(loginViewModel);
        sharedPrefrenceHelper=new SharedPrefrenceHelper(this);

        loginViewModel.getUserLocal().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(@Nullable UserModel loginUserModel) {

                 if(isValid(loginUserModel.getPhone_number(), loginUserModel.getPassword()));{
                     sharedPrefrenceHelper.setSignupInfo(loginUserModel.getPhone_number(), loginUserModel.getPassword());
                    AppUtility.hideSoftkeyboard(ActivityLogin.this,binding.edPassword);
                    loginViewModel.Login(loginUserModel.getDevice_id(), loginUserModel.getPhone_number(), loginUserModel.getPassword());
                }


            }
        });


        loginViewModel.getUserServer().observe(this, new Observer<Response<UserModel>>() {
            @Override
            public void onChanged(@Nullable Response<UserModel> loginUserResponse){
              if(loginUserResponse.body()!=null){
                  UserModel response = loginUserResponse.body();
                  if(response.getStatusCode()== Const.HTTP_OK){
                      String deviceId=response.getData().getDevice_id();
                      String otp=response.getData().getOtp();
                      String userId=response.getData().getUser_id();
                      sharedPrefrenceHelper.setLoginData(userId,deviceId,otp);
                      Intent intent=new Intent(ActivityLogin.this, ActivityCreateProfile.class);
                      //Intent intent=new Intent(ActivityLogin.this,ActivityOtp.class);
                      startActivity(intent);
                  }
                  if(response.getStatusCode()==Const.HTTP_NOT_FOUND){

                      AppUtility.showSimpleSnackbar(ActivityLogin.this,response.getMessage());

                  }

              }

            }

        });


    }//end of onCreate()
    public  boolean isValid(String phone_no , String password){
        if(TextUtils.isEmpty(phone_no)){
            binding.edPhoneNo.setFocusable(true);
            binding.edPhoneNo.setError("Please enter Phone No!");
            return false;
        }
        if(phone_no.length()<6){
            binding.edPhoneNo.setFocusable(true);
            binding.edPhoneNo.setError("Phone No length is least  character!");
            return  false;
        }
        if(TextUtils.isEmpty(password)){
            binding.edPassword.setFocusable(true);
            binding.edPassword.setError("Please enter Password!");
            return false;
        }
        if(password.length()<10 && password.length()==20){
            binding.edPassword.setFocusable(true);
            binding.edPassword.setError("Minimum length of password is 10 character and maximum is 20 chracter!");
            return false;
        }


        return true;
    }//end of validation method
}//end of main

