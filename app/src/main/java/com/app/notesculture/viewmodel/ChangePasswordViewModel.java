package com.app.notesculture.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.view.View;

import com.app.notesculture.view.api.ApiClient;
import com.app.notesculture.api.ApiInterface;
import com.app.notesculture.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordViewModel extends ViewModel {

    public MutableLiveData<String> Password = new MutableLiveData<>();
    public MutableLiveData<String> ConPassword = new MutableLiveData<>();
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
    public void onChangePassClick(View view) {

        UserModel userModel = new UserModel(Password.getValue(),ConPassword.getValue());
        userMutableLiveDataLocal.setValue(userModel);

    }



    /*Change Password method is used for communicate with server*/
    public void ChangePassword(String password) {
        setBusy(0);
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        UserModel userModel = new UserModel(  password);
        Call<UserModel> call = apiService.userChangePassword(userModel);
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
