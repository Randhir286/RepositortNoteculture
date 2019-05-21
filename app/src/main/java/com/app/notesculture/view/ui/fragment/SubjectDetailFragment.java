package com.app.notesculture.view.ui.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.app.notesculture.R;
import com.app.notesculture.databinding.SubjectDetailFragmentBinding;
import com.app.notesculture.model.SubjectDetailResponseData;
import com.app.notesculture.model.SubjectModel;
import com.app.notesculture.view.adapter.SubjectDetailAdapter;
import com.app.notesculture.view.utills.Const;
import com.app.notesculture.viewmodel.SubjectDetailViewModel;
import java.util.List;
import retrofit2.Response;

import static com.google.gson.reflect.TypeToken.get;

public class SubjectDetailFragment extends Fragment {

    private SubjectDetailViewModel mViewModel;
    private SubjectDetailFragmentBinding binding;

    public static SubjectDetailFragment newInstance() {
        return new SubjectDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.subject_detail_fragment, container, false);
        mViewModel = ViewModelProviders.of(getActivity()).get(SubjectDetailViewModel.class);
        binding.setSubjectDetailViewModel(mViewModel);
        View view = binding.getRoot();
        setView();
        ObservableViewModel();
        return view;


    }

    private void ObservableViewModel(){
        mViewModel.getSubjectList().observe(this, new Observer<Response<SubjectModel>>() {
            @Override
            public void onChanged(@Nullable Response<SubjectModel> subjectModelResponse) {
                SubjectModel response = subjectModelResponse.body();
                if(response.getStatusCode()== Const.HTTP_OK){
                    binding.txtSubName.setText(response.getSubject_name());
                    binding.txtuserName.setText(response.getName());
                    binding.txtTotalChapter.setText(response.getTotal_number_chapter());
                    binding.txtUserDesc.setText("Start your learning journey");
                    binding.txtSyllabusSub.setText("Syllabus for "+response.getSubject_name());
                    List<SubjectDetailResponseData> subjectDetailResponseData = subjectModelResponse.body().getSubjectDetailResponseData();
                    if(subjectDetailResponseData.size()>0){
                        binding.subjectRecylerView.setAdapter(new SubjectDetailAdapter(subjectDetailResponseData,getActivity()));

                    }
                }
            }
        });
    }



    private void setView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.subjectRecylerView.setLayoutManager(gridLayoutManager);


    }

}
