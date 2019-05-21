package com.app.notesculture.viewmodel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import com.app.notesculture.api.ApiInterface;
import com.app.notesculture.model.UserModel;
import com.app.notesculture.view.api.ApiClient;
import com.app.notesculture.view.ui.activity.ActivityForgetPassword;
import com.app.notesculture.view.ui.activity.ActivitySignUp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

   public MutableLiveData<String> PhoneNo = new MutableLiveData<>();
   public MutableLiveData<String> Password = new MutableLiveData<>();
   private int busy = 8;
   /*this method is used for retreiving local data and */
   private MutableLiveData<UserModel> userMutableLiveDataLocal;

    public MutableLiveData<UserModel> getUserLocal() {

        if (userMutableLiveDataLocal == null) {
            userMutableLiveDataLocal = new MutableLiveData<>();
        }
        return userMutableLiveDataLocal;

    }
    /*method is used for retreiving data from server*/
    private MutableLiveData<Response<UserModel>> userMutableLiveData;
    public MutableLiveData<Response<UserModel>> getUserServer() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<Response<UserModel>>();
        }
        return userMutableLiveData;


    }
    public void setBusy(int busy) {
        this.busy = busy;
    }
     /*login button click listener*/
    public void onLoginClick(View view) {
      
        String device_id = Settings.Secure.getString(view.getContext().getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        UserModel userModel = new UserModel(device_id,PhoneNo.getValue(), Password.getValue());
        userMutableLiveDataLocal.setValue(userModel);

    }
     /*forget button login click listener*/
    public void onForgetClick(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, ActivityForgetPassword.class);
        context.startActivity(intent);context = view.getContext();
    }
      /*signup button login click listener*/
    public void onSignClick(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, ActivitySignUp.class);
        context.startActivity(intent);context = view.getContext();
        }

   
        /*Login method is used for communicate with server*/
    public void Login(String deviceId, String phoneNo, String password) {
        setBusy(0);
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        UserModel userModel = new UserModel(deviceId, phoneNo, password);
        Call<UserModel> call = apiService.userLogin(userModel);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                setBusy(8);
                Log.d("SUCCESS","Inside onResponse");
                userMutableLiveData.setValue(response);


                }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                setBusy(8);
                Log.d("FAILURE","Inside onFailure");

            }
        });

    }


}
