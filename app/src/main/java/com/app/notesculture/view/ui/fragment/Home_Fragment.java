package com.app.notesculture.view.ui.fragment;

import com.app.notesculture.R;

import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Home_Fragment extends Fragment{

@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view  =inflater.inflate(R.layout.home_fragment, container,false);

		LinearLayout rootLayout = view.findViewById(R.id.rootLayout);
		rootLayout.setBackgroundColor(0);

	BitmapDrawable bg = (BitmapDrawable)getResources().getDrawable(R.drawable.main_background);
	bg.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
	rootLayout.setBackgroundDrawable(bg);
	//bg_color=R.drawable.pix2;


		return view;
	}
}
