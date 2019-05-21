package com.app.notesculture.view.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.app.notesculture.R;
import com.app.notesculture.databinding.ActivityChangePasswordBinding;

import com.app.notesculture.model.UserModel;

import com.app.notesculture.view.helper.SharedPrefrenceHelper;
import com.app.notesculture.view.utills.AppUtility;
import com.app.notesculture.view.utills.Const;
import com.app.notesculture.viewmodel.ChangePasswordViewModel;

import retrofit2.Response;

public class ActivityChangePassword extends AppCompatActivity {
    private ChangePasswordViewModel changePasswordViewModel;
    private ActivityChangePasswordBinding binding;
    private SharedPrefrenceHelper sharedPrefrenceHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changePasswordViewModel = ViewModelProviders.of(this).get(ChangePasswordViewModel.class);
        binding = DataBindingUtil.setContentView(ActivityChangePassword.this, R.layout.activity_change_password);
        binding.setLifecycleOwner(this);
        binding.setChangePasswordViewModel(changePasswordViewModel);
        sharedPrefrenceHelper = new SharedPrefrenceHelper(this);
        changePasswordViewModel.getUserLocal().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(@Nullable UserModel userModel) {
                if (isValid(userModel.getPassword(), userModel.getConPassword())) {
                    AppUtility.hideSoftkeyboard(ActivityChangePassword.this,binding.edConPassword);
                    changePasswordViewModel.ChangePassword(userModel.getPassword());
                }

            }
        });

        changePasswordViewModel.getUserServer().observe(this, new Observer<Response<UserModel>>() {
            @Override
            public void onChanged(@Nullable Response<UserModel> loginUserResponse) {
                if (loginUserResponse.body() != null) {
                    UserModel response = loginUserResponse.body();
                    if (response.getStatusCode() == Const.HTTP_OK) {
                        String deviceId = response.getData().getDevice_id();
                        String otp = response.getData().getOtp();
                        String userId = response.getData().getUser_id();
                        sharedPrefrenceHelper.setLoginData(userId, deviceId, otp);
                        /*Intent intent=new Intent(ActivityChangePassword.this,ActivityLogin.class);
                        startActivity(intent);*/
                    } else {
                        AppUtility.showSimpleSnackbar(ActivityChangePassword.this,response.getMessage());

                    }
                }

            }

        });
    }//end of onCreate

    private boolean isValid(String password, String conPassword) {
        if (TextUtils.isEmpty(password)) {
            binding.edPassword.setFocusable(true);
            binding.edPassword.setError("Please enter Password!");
            return false;
        }
        if (password.length() < 10 && password.length() == 20) {
            binding.edPassword.setFocusable(true);
            binding.edPassword.setError("Minimum length of password is 10 character and maximum is 20 chracter!");
            return false;
        }
        if (TextUtils.isEmpty(conPassword)) {
            binding.edConPassword.setFocusable(true);
            binding.edConPassword.setError("Please enter Confirm Password!");
            return false;
        }
        if (conPassword != password) {
            binding.edConPassword.setFocusable(true);
            binding.edConPassword.setError("Password and confirmed password are not same!");
            return false;
        }
        return true;
    }
}//end of main