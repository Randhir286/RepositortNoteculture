package com.app.notesculture.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.notesculture.BR;
import com.app.notesculture.R;
import com.app.notesculture.databinding.SubjectDetailCardviewBinding;
import com.app.notesculture.model.SubjectDetailResponseData;
import com.app.notesculture.view.ui.infra.CustomClickListener;

import java.util.List;

public class SubjectDetailAdapter extends RecyclerView.Adapter<SubjectDetailAdapter.ViewHolder>implements CustomClickListener {

    private List<SubjectDetailResponseData> dataModelList;
    private Context context;

    public SubjectDetailAdapter(List<SubjectDetailResponseData> dataModelList, Context ctx) {
        this.dataModelList = dataModelList;
        context = ctx;
    }

    @Override
    public SubjectDetailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        SubjectDetailCardviewBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.subject_detail_cardview, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SubjectDetailResponseData dataModel = dataModelList.get(position);

        holder.itemRowBinding.setViewModel(dataModel);
        holder.bind(dataModel);
        holder.bind(dataModel);
        holder.itemRowBinding.setItemClickListener(this);

    }


    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    @Override
    public void subCardClicked(SubjectDetailResponseData subjectDetailResponseData) {
        Toast.makeText(context, "You clicked " + subjectDetailResponseData.getTopic_id(),
                Toast.LENGTH_LONG).show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SubjectDetailCardviewBinding itemRowBinding;

        public ViewHolder(SubjectDetailCardviewBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.viewModel, obj);
            itemRowBinding.executePendingBindings();
        }
    }

    public void cardClicked(SubjectDetailResponseData f) {
        Toast.makeText(context, "You clicked " + f.getTopic_name(),
                Toast.LENGTH_LONG).show();
    }
}
