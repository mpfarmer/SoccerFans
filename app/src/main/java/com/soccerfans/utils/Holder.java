package com.soccerfans.utils;

import android.view.View;

public interface Holder {
	void setUp(View convertView);
	void refreshData(int position);
	int getLength();
	int getResid();
	int getTag();
}
