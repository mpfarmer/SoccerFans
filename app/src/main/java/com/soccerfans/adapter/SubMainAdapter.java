package com.soccerfans.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.soccerfans.R;
import com.soccerfans.model.GlobalData;
import com.soccerfans.model.SubMainDataHolder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;


public class SubMainAdapter extends BaseAdapter {

	protected ListView mListView;
	DisplayImageOptions options; 
	protected ImageLoader auto_imageLoader;
	protected SubMainDataHolder dataHolder ;
	protected Activity activity;
	private AbsListView.LayoutParams lp;
	private RelativeLayout.LayoutParams params ;

	public SubMainAdapter(Activity activity,SubMainDataHolder dataHolder) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
		lp = new AbsListView.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				GlobalData.getScreenHeight(activity) / 7);
		params = new RelativeLayout.LayoutParams(
				GlobalData.getScreenWidth(activity) / 3,
				GlobalData.getScreenHeight(activity) / 8);
		auto_imageLoader =  ImageLoader.getInstance();
		options  = new DisplayImageOptions.Builder().
				cacheInMemory(false).
				showImageOnLoading(android.R.color.white).
				resetViewBeforeLoading(true).
				build();
		this.dataHolder = dataHolder;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataHolder.getLength();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		SubMainHolder holder;
		
		if (convertView == null) {
			holder = new SubMainHolder(activity);
			convertView = setUpConvertView(holder);
			setUp(convertView,holder);
			convertView.setTag(holder);
		}
		else{
			holder = (SubMainHolder) convertView.getTag();
		}
		refreshData(holder,position);
		return convertView;
	}

	protected View setUpConvertView(SubMainHolder holder) {
		View convertView = activity.getLayoutInflater().inflate(holder.resid,
				null);
		convertView.setLayoutParams(lp);
		return convertView;
	}

	public void setUp(View convertView,SubMainHolder holder) {
		// TODO Auto-generated method stub
		holder.headTextView = (TextView) convertView
				.findViewById(R.id.tv_title);
		holder.summaryTextView = (TextView) convertView
				.findViewById(R.id.tv_summary);
		holder.imageView = (ImageView) convertView.findViewById(R.id.iv_title);
		params.addRule(RelativeLayout.CENTER_VERTICAL);
		holder.imageView.setLayoutParams(params);
	}

	public void refreshData(SubMainHolder holder, int position) {
		// TODO Auto-generated method stub
		auto_imageLoader.displayImage(dataHolder.getImgSet().get(position), holder.imageView,options);
		holder.headTextView.setText(dataHolder.getTitleSet().get(position));
		holder.summaryTextView
				.setText(dataHolder.getSummarySet().get(position));
	}

	static class SubMainHolder {
		public int resid = R.layout.item_list;
		public TextView headTextView;
		public TextView summaryTextView;
		public ImageView imageView;
		private Activity activity;

		public SubMainHolder(Activity activity) {
			this.activity = activity;
		}

		public int getResid() {
			return resid;
		}
	}
	public SubMainDataHolder getDataHolder(){
		return dataHolder;
	}
}
