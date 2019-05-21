package com.app.notesculture.view.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import com.app.notesculture.R;
import com.app.notesculture.databinding.ActivityForgetPasswordBinding;
import com.app.notesculture.model.UserModel;
import com.app.notesculture.view.helper.SharedPrefrenceHelper;
import com.app.notesculture.view.utills.AppUtility;
import com.app.notesculture.view.utills.Const;
import com.app.notesculture.viewmodel.ForgotViewModel;
import retrofit2.Response;


public class ActivityForgetPassword extends AppCompatActivity {
    private ForgotViewModel forgotViewModel;
    private ActivityForgetPasswordBinding binding;
    private SharedPrefrenceHelper sharedPrefrenceHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forgotViewModel = ViewModelProviders.of(this).get(ForgotViewModel.class);
        binding = DataBindingUtil.setContentView(ActivityForgetPassword.this, R.layout.activity_forget_password);
        binding.setLifecycleOwner(this);
        binding.setForgotViewModel(forgotViewModel);
        sharedPrefrenceHelper=new SharedPrefrenceHelper(this);
        forgotViewModel.getUserLocal().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(@Nullable UserModel userModel) {
                if(isValid(userModel.getPhone_number())){
                    AppUtility.hideSoftkeyboard(ActivityForgetPassword.this,binding.edPhoneNo);
                    forgotViewModel.ForgetPassword(userModel.getPhone_number());
                }

            }
        });

        forgotViewModel.getUserServer().observe(this, new Observer<Response<UserModel>>() {
            @Override
            public void onChanged(@Nullable Response<UserModel> loginUserResponse) {
                if(loginUserResponse.body()!=null){
                    UserModel response = loginUserResponse.body();
                    if(response.getStatusCode()== Const.HTTP_OK){
                       String deviceId=response.getData().getDevice_id();
                        String otp=response.getData().getOtp();
                        String userId=response.getData().getUser_id();
                        sharedPrefrenceHelper.setLoginData(userId,deviceId,otp);
                        Intent intent=new Intent(ActivityForgetPassword.this,ActivityLogin.class);
                        startActivity(intent);
                    }else{
                        AppUtility.showSimpleSnackbar(ActivityForgetPassword.this,response.getMessage());

                    }
                }

            }

        });
    }//end of onCreate

    private boolean isValid(String phoneNo){
        if(TextUtils.isEmpty(phoneNo)){
            binding.edPhoneNo.setFocusable(true);
            binding.edPhoneNo.setError("Please enter Phone No!");
            return false;
        }
        if(phoneNo.length()<10){
            binding.edPhoneNo.setFocusable(true);
            binding.edPhoneNo.setError("Phone No length is least  character!");
            return  false;
        }
       return true;
    }
}//end of main
