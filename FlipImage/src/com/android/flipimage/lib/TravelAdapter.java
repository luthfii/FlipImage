package com.android.flipimage.lib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.flipimage.Travels;
import com.android.flipimage.R;
import com.android.flipimage.R.id;
import com.android.flipimage.R.layout;
import com.android.flipimage.Travels.Data;
import com.android.flipimage.lib.AphidLog;
import com.android.flipimage.lib.IO;
import com.android.flipimage.lib.UI;

public class TravelAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	
	private int repeatCount = 1;

	public TravelAdapter(Context context) {
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return Travels.IMG_DESCRIPTIONS.size() * repeatCount;
	}

	public int getRepeatCount() {
		return repeatCount;
	}

	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View layout = convertView;
		if (convertView == null) {
			layout = inflater.inflate(R.layout.activity_main, null);
			AphidLog.d("created new view from adapter: %d", position);
		}

		final Travels.Data data = Travels.IMG_DESCRIPTIONS.get(position % Travels.IMG_DESCRIPTIONS.size());
		
		
//		UI
//			.<ImageView>findViewById(layout, R.id.photo)
//			.setImageBitmap(IO.readBitmap(inflater.getContext().getAssets(), data.imageFilename));
//		
//		UI
//			.<TextView>findViewById(layout, R.id.description)
//			.setText(Html.fromHtml(data.description));
		
		return layout;
	}
}
