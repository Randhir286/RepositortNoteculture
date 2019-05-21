package com.app.notesculture.view.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.app.notesculture.R;
import com.app.notesculture.model.Navigation_Items;
import com.app.notesculture.view.ui.activity.ActivityMain;

public class Navigation_Drawer_Adapter extends BaseAdapter {

	private ArrayList<Navigation_Items> arrayList;
	private Context context;

	public Navigation_Drawer_Adapter(Context context,
			ArrayList<Navigation_Items> arrayList) {
		this.context = context;
		this.arrayList = arrayList;
	}

	@Override
	public int getCount() {

		return arrayList.size();
	}

	@Override
	public Navigation_Items getItem(int pos) {

		return arrayList.get(pos);
	}

	@Override
	public long getItemId(int pos) {

		return pos;
	}

	@Override
	public View getView(final int pos, View view, ViewGroup parent) {
		ViewHolder holder = null;

		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.custom_view, parent, false);

			holder = new ViewHolder();
			holder.title = (TextView) view.findViewById(R.id.title);


			holder.icon = (ImageView) view.findViewById(R.id.icon);

			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();

		}

		holder.title.setText(arrayList.get(pos).getTitle());

		holder.icon.setBackgroundResource(arrayList.get(pos).getIcon());

		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				//Calling main activity selectPosition method to replpace the fragment
				new ActivityMain().selectItem(pos);

			}
		});

		return view;
	}

	public class ViewHolder {
		TextView title, subtitle;
		ImageView icon;
	}

}
