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
import com.app.notesculture.databinding.ActivitySignUpBinding;
import com.app.notesculture.view.helper.SharedPrefrenceHelper;
import com.app.notesculture.model.UserModel;
import com.app.notesculture.view.utills.AppUtility;
import com.app.notesculture.view.utills.Const;
import com.app.notesculture.viewmodel.SignUpViewModel;

import retrofit2.Response;

public class ActivitySignUp extends AppCompatActivity {
    private SignUpViewModel signUpViewModel;
    private ActivitySignUpBinding binding;
    private SharedPrefrenceHelper sharedPrefrenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);
        binding = DataBindingUtil.setContentView(ActivitySignUp.this, R.layout.activity_sign_up);
        binding.setLifecycleOwner(this);
        binding.setSignUpViewModel(signUpViewModel);
        sharedPrefrenceHelper=new SharedPrefrenceHelper(getApplicationContext());
        signUpViewModel.getUserLocal().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(@Nullable UserModel userModel) {
                if(isValid(userModel.getPhone_number(), userModel.getPassword(), userModel.getConPassword())){
                    sharedPrefrenceHelper.setSignupInfo(userModel.getPhone_number(), userModel.getPassword());

                    AppUtility.hideSoftkeyboard(ActivitySignUp.this,binding.edConPassword);
                    signUpViewModel.SignUp(userModel.getDevice_id(), userModel.getPhone_number(), userModel.getPassword());
                }

            }
        });

        signUpViewModel.getUserServer().observe(this, new Observer<Response<UserModel>>() {
            @Override
            public void onChanged(@Nullable Response<UserModel> loginUserResponse){
                if(loginUserResponse.body()!=null){
                    UserModel response = loginUserResponse.body();
                    if(response.getStatusCode()== Const.HTTP_OK){

                        Intent intent=new Intent(ActivitySignUp.this,ActivityOtp.class);
                        startActivity(intent);
                    }if(response.getStatusCode()==Const.HTTP_NOT_FOUND)
                        AppUtility.showSimpleSnackbar(ActivitySignUp.this,response.getMessage());

                    }
                }



        });
    }//end of onCreate
    public  boolean isValid(String phone_no , String password,String conPassword){
        if(TextUtils.isEmpty(phone_no)){
            binding.edPhoneNo.setFocusable(true);
            binding.edPhoneNo.setError("Please enter Phone No!");
            return false;
        }
        if(phone_no.length()<10){
            binding.edPhoneNo.setFocusable(true);
            binding.edPhoneNo.setError("Phone No length is least  character!");
            return  false;
        }
        if(TextUtils.isEmpty(password)){
            binding.edPassword.setFocusable(true);
            binding.edPassword.setError("Please enter Password!");
            return false;
        }
        if(password.length()<6 || password.length()==20){
            binding.edPassword.setFocusable(true);
            binding.edPassword.setError("Minimum length of password is 6 character and maximum is 20 chracter!");
            return false;
        }
        if(TextUtils.isEmpty(conPassword)){
            binding.edConPassword.setFocusable(true);
            binding.edConPassword.setError("Please enter Confirm Password!");
            return false;
        }
        if(!conPassword.equals(password)){
            binding.edConPassword.setFocusable(true);
            binding.edConPassword.setError("Password and confirmed password are not same!");
            return false;
        }


        return true;
    }//end of validation method
}//end of main
