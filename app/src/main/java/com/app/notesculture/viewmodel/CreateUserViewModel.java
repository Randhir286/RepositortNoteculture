package com.app.notesculture.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.app.notesculture.view.api.ApiClient;
import com.app.notesculture.api.ApiInterface;
import com.app.notesculture.model.CreateUserModel;
import com.app.notesculture.model.StateCityCourseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserViewModel extends ViewModel {

    public MutableLiveData<String> Name = new MutableLiveData<>();
    public MutableLiveData<String> EmailId = new MutableLiveData<>();
    public MutableLiveData<String> DOB = new MutableLiveData<>();
    public MutableLiveData<String> State = new MutableLiveData<>();
    public MutableLiveData<String> City = new MutableLiveData<>();
    public MutableLiveData<String> Course = new MutableLiveData<>();
    private ObservableField<String> text;
    private MutableLiveData<Response<StateCityCourseModel>> stateMutableLiveData;
    public MutableLiveData<Response<StateCityCourseModel>> getStateList() {

        if (stateMutableLiveData == null) {
            stateMutableLiveData = new MutableLiveData<Response<StateCityCourseModel>>();
                getStateData();
        }
        return stateMutableLiveData;


    }
    private MutableLiveData<Response<StateCityCourseModel>> cityMutableLiveData;
    public MutableLiveData<Response<StateCityCourseModel>> getCityList() {

        if (cityMutableLiveData == null) {
            cityMutableLiveData = new MutableLiveData<Response<StateCityCourseModel>>();
            getCityData("");

        }
        return cityMutableLiveData;


    }
    private MutableLiveData<Response<StateCityCourseModel>> couresMutableLiveData;
    public MutableLiveData<Response<StateCityCourseModel>> getCourseList() {

        if (couresMutableLiveData == null) {
            couresMutableLiveData = new MutableLiveData<Response<StateCityCourseModel>>();
            getCourseData();
        }
        return couresMutableLiveData;


    }
    private MutableLiveData<Response<CreateUserModel>> userMutableLiveData;
    public MutableLiveData<Response<CreateUserModel>> updateProfile() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<Response<CreateUserModel>>();
                updateUserDetail();
        }
        return userMutableLiveData;


    }



    private void getStateData() {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        //StateCityCourseModel state = new StateCityCourseModel();
        Call<StateCityCourseModel> call = apiService.GetState();
        call.enqueue(new Callback<StateCityCourseModel>() {
            @Override
            public void onResponse(Call<StateCityCourseModel> call, Response<StateCityCourseModel> response) {


                Log.d("SUCCESS","Inside onResponse");
                stateMutableLiveData.setValue(response);


            }
            @Override
            public void onFailure(Call<StateCityCourseModel> call, Throwable t) {

                Log.d("FAILURE","Inside onFailure");

            }
        });

    }
    private void getCityData(String stateId){
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        StateCityCourseModel stateCityCourseModel = new StateCityCourseModel(stateId);
        Call<StateCityCourseModel> call = apiService.GetCity(stateCityCourseModel);
        call.enqueue(new Callback<StateCityCourseModel>() {
            @Override
            public void onResponse(Call<StateCityCourseModel> call, Response<StateCityCourseModel> response) {


                Log.d("SUCCESS","Inside onResponse");
                cityMutableLiveData.setValue(response);


            }
            @Override
            public void onFailure(Call<StateCityCourseModel> call, Throwable t) {

                Log.d("FAILURE","Inside onFailure");

            }
        });

    }
    private void getCourseData(){
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<StateCityCourseModel> call = apiService.GetCourse();
        call.enqueue(new Callback<StateCityCourseModel>() {
            @Override
            public void onResponse(Call<StateCityCourseModel> call, Response<StateCityCourseModel> response) {


                Log.d("SUCCESS","Inside onResponse");
                couresMutableLiveData.setValue(response);


            }
            @Override
            public void onFailure(Call<StateCityCourseModel> call, Throwable t) {

                Log.d("FAILURE","Inside onFailure");

            }
        });

    }
    private void updateUserDetail(){
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        CreateUserModel createUserModel = new CreateUserModel("2","anu","anu@gmail.com","female","15-10-1999","Pat","138","224","0");
        Call<CreateUserModel> call = apiService.createProfile(createUserModel);
        call.enqueue(new Callback<CreateUserModel>() {
            @Override
            public void onResponse(Call<CreateUserModel> call, Response<CreateUserModel> response) {
                Log.d("SUCCESS","Inside onResponse");
                userMutableLiveData.setValue(response);
            }
            @Override
            public void onFailure(Call<CreateUserModel> call, Throwable t) {

                Log.d("FAILURE","Inside onFailure");

            }
        });

    }
    public void onSelectItem(AdapterView<?> parent, View view, int pos, long id)
    {
        String abc=parent.getItemAtPosition(pos).toString();
        Log.d("value",abc);
        //pos                                 get selected item position
        //view.getText()                      get lable of selected item
        //parent.getAdapter().getItem(pos)    get item by pos
        //parent.getAdapter().getCount()      get item count
        //parent.getCount()                   get item count
        //parent.getSelectedItem()            get selected item
        //and other...
    }

}
