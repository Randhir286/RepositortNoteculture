package com.app.notesculture.view.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.app.notesculture.R;
import com.app.notesculture.databinding.ActivityOtpBinding;
import com.app.notesculture.model.UserModel;
import com.app.notesculture.view.helper.SharedPrefrenceHelper;
import com.app.notesculture.view.utills.AppUtility;
import com.app.notesculture.view.utills.Const;
import com.app.notesculture.viewmodel.OtpViewModel;
import retrofit2.Response;


public class ActivityOtp extends AppCompatActivity {
    private OtpViewModel otpViewModel;
    private ActivityOtpBinding binding;
    private SharedPrefrenceHelper sharedPrefrenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        otpViewModel = ViewModelProviders.of(this).get(OtpViewModel.class);
        binding = DataBindingUtil.setContentView(ActivityOtp.this, R.layout.activity_otp);
        binding.setLifecycleOwner(this);
        binding.setOtpViewModel(otpViewModel);
        sharedPrefrenceHelper=new SharedPrefrenceHelper(getApplicationContext());
        String str=sharedPrefrenceHelper.getPhoneNumber();
        binding.txtPhoneno.setText(str);
        otpViewModel.getUserLocal().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(@Nullable UserModel userModel) {
                /*if(isValid(userModel.getPhone_number(),userModel.getPassword(),userModel.getConPassword())){

                }*/
                AppUtility.hideSoftkeyboard(ActivityOtp.this,binding.edOtp4);
                otpViewModel.VerifyOtp(sharedPrefrenceHelper.getPhoneNumber(), sharedPrefrenceHelper.getPhoneNumber(),Integer.parseInt(userModel.getOtp()));

            }
        });

        otpViewModel.getUserServer().observe(this, new Observer<Response<UserModel>>() {
            @Override
            public void onChanged(@Nullable Response<UserModel> loginUserResponse) {
                if(loginUserResponse.body()!=null){
                    UserModel response = loginUserResponse.body();
                    if(response.getStatusCode()== Const.HTTP_OK){
                       String deviceId=response.getData().getDevice_id();
                        String otp=response.getData().getOtp();
                        String userId=response.getData().getUser_id();
                        sharedPrefrenceHelper.setLoginData(userId,deviceId,otp);
                        sharedPrefrenceHelper.setLogedIn(false);
                        Intent intent=new Intent(ActivityOtp.this, ActivityCreateProfile.class);
                        startActivity(intent);
                    }if(response.getStatusCode()== Const.HTTP_NOT_FOUND)
                        AppUtility.showSimpleSnackbar(ActivityOtp.this,response.getMessage());


                }

            }

        });
    }//end of onCreate
}//end of main
