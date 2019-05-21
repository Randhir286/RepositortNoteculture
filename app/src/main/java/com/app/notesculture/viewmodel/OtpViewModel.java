package com.app.notesculture.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import com.app.notesculture.view.api.ApiClient;
import com.app.notesculture.api.ApiInterface;
import com.app.notesculture.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpViewModel extends ViewModel {

    public MutableLiveData<String> edOtp1 = new MutableLiveData<>();
    public MutableLiveData<String> edOtp2 = new MutableLiveData<>();
    public MutableLiveData<String> edOtp3 = new MutableLiveData<>();
    public MutableLiveData<String> edOtp4 = new MutableLiveData<>();
    public MutableLiveData<String> txtPhone = new MutableLiveData<>();
    private String device_id;
    private int busy = 8;
    /*method is used for retreiving data from server*/
    private MutableLiveData<Response<UserModel>> userMutableLiveData;
    public MutableLiveData<Response<UserModel>> getUserServer() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<Response<UserModel>>();
        }
        return userMutableLiveData;


    }
    /*this method is used for retreiving local data and */
    private MutableLiveData<UserModel> userMutableLiveDataLocal;

    public MutableLiveData<UserModel> getUserLocal() {

        if (userMutableLiveDataLocal == null) {
            userMutableLiveDataLocal = new MutableLiveData<>();
        }
        return userMutableLiveDataLocal;

    }
    public void setBusy(int busy) {
        this.busy = busy;
    }


    /*SignUp button click listener*/
    public void onVerifyOtpClick(View view) {
       device_id = Settings.Secure.getString(view.getContext().getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        int otp= Integer.parseInt(edOtp1.getValue()+edOtp2.getValue()+edOtp3.getValue()+edOtp4.getValue());
        UserModel userModel = new UserModel(otp);
        userMutableLiveDataLocal.setValue(userModel);

    }

    /*VerifyOtp method is used for communicate with server*/
    public void VerifyOtp(String phoneNo,String password,int otp) {
        setBusy(0);
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        UserModel userModel = new UserModel(device_id,"0", phoneNo, password,String.valueOf(otp));
        Call<UserModel> call = apiService.userVerifyOtp(userModel);
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
