package com.app.notesculture.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.app.notesculture.view.api.ApiClient;
import com.app.notesculture.api.ApiInterface;
import com.app.notesculture.model.SubjectModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubjectDetailViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData <Response<SubjectModel>> subjectMutableLiveData;
        public MutableLiveData<Response<SubjectModel>> getSubjectList() {

            if (subjectMutableLiveData == null) {
                subjectMutableLiveData = new MutableLiveData<Response<SubjectModel>>();
                getSubjectDetail("1","5");
            }
            return subjectMutableLiveData;


        }

        public  void getSubjectDetail(String subject_id,String user_id){
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        SubjectModel subjectModel = new SubjectModel(subject_id,user_id);
        Call<SubjectModel> call = apiService.GetSubjectDetail(subjectModel);
         call.enqueue(new Callback<SubjectModel>() {
             @Override
             public void onResponse(Call<SubjectModel> call, Response<SubjectModel> response) {
                 subjectMutableLiveData.setValue(response);


             }

             @Override
             public void onFailure(Call<SubjectModel> call, Throwable t) {
                 Log.d("msg", t.toString());

             }
         });

    }
}
