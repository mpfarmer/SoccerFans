package com.soccerfans.utils;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.soccerfans.R;
import com.soccerfans.model.GlobalData;
import com.soccerfans.model.SubMainDataHolder;

public class SubMainHolder implements Holder{
	private int Tag = GlobalData.TEXT_TYPE;
	private int resid;
	public TextView headTextView;
	public TextView summaryTextView;
	public ImageView imageView;
	private SubMainDataHolder subMainDataHolder;
	private Context context;
	private List<String> mListItems;
	private List<String> sListItems;
	private List<String> iListItems;
	public SubMainHolder(Context context,int resid){
		this.context = context;
		subMainDataHolder = new SubMainDataHolder();
		mListItems = subMainDataHolder.getTitleSet();
		sListItems = subMainDataHolder.getSummarySet();
	    iListItems = subMainDataHolder.getImgSet();
	    this.resid = resid;
	}
	@Override
	public void setUp(View convertView) {
		// TODO Auto-generated method stub
		headTextView = (TextView) convertView.findViewById(R.id.tv_title);
		summaryTextView = (TextView) convertView.findViewById(R.id.tv_summary);
		imageView = (ImageView) convertView.findViewById(R.id.iv_title);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				GlobalData.getScreenWidth(context)/3,
				GlobalData.getScreenHeight(context)/8);
		params.addRule(RelativeLayout.CENTER_VERTICAL);
		imageView.setLayoutParams(params);
	}

	@Override
	public void refreshData(int position) {
		// TODO Auto-generated method stub
		
		headTextView.setText(mListItems.get(position));
		summaryTextView.setText(sListItems.get(position));
		Drawable drawable = Drawable.createFromPath(iListItems.get(position));
		imageView.setImageDrawable(drawable);
		
	}

	public void clear(){
		imageView.setImageDrawable(null);
	}
	
	public Object getImageTag(){
		return imageView.getTag();
	}
	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return mListItems.size();
	}

	public int getTag(){
		return Tag;
	}
	
	public int getResid(){
		return resid;
	}
}
