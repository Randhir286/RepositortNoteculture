package com.app.notesculture.view.ui.fragment;


import com.app.notesculture.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UserAccount_Fragment extends Fragment{

@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view  =inflater.inflate(R.layout.user_account_fragment, container,false);
		return view;
	}
}
