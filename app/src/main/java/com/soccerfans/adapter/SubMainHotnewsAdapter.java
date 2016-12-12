package com.soccerfans.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.soccerfans.R;
import com.soccerfans.model.GlobalData;
import com.soccerfans.model.SubMainDataHolder;

public class SubMainHotnewsAdapter extends SubMainAdapter {

	private final int ISSUE = 0;
	private final int GENERAL = 1;
	private View pagerView;
	private ViewPagerHolder viewPagerHolderholder;
	ImageHandler handler = new ImageHandler();
	private AsyncViewPagerLoader asyncViewPagerLoader;

	public SubMainHotnewsAdapter(Activity activity,SubMainDataHolder dataHolder) {
		super(activity,dataHolder);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return super.getCount() + 1;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return super.getItem(position);
	}

	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position - 1;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		if(0 == position){
			return ISSUE;
		}
		else{
			return GENERAL;
		}
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		viewPagerHolderholder = null;
		int type = getItemViewType(position);
		if (convertView == null) {
			if (ISSUE == type) {
			
				viewPagerHolderholder = new ViewPagerHolder(activity);
				pagerView = activity.getLayoutInflater().inflate(
						R.layout.sub_fragment_host_news, null);
				convertView = pagerView;
				setUpViewPager(pagerView, viewPagerHolderholder.viewPager,
						activity.getLayoutInflater());
				handler.sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE,
						ImageHandler.MSG_DELAY);
				convertView.setTag(viewPagerHolderholder);
				return convertView;
			} else {
				return super.getView(position - 1, convertView, arg2);
			}
			
		}
		else{
			if(ISSUE == type){
				viewPagerHolderholder = (ViewPagerHolder) convertView.getTag();
				return convertView;
			}
			else{
				return super.getView(position - 1, convertView, arg2);
			}
		}
	}

	private void setUpViewPager(View convertView, ViewPager viewPager,
			LayoutInflater inflater) {
		viewPager = (ViewPager) convertView.findViewById(R.id.vp_issue);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				GlobalData.getScreenHeight(activity) / 4);
		viewPager.setLayoutParams(lp);
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			// ���Adapter��currentItem�ֶν������á�
			@Override
			public void onPageSelected(int arg0) {
				handler.sendMessage(Message.obtain(handler,
						ImageHandler.MSG_PAGE_CHANGED, arg0, 0));
			}

			// ��д�÷���ʵ���ֲ�Ч������ͣ�ͻָ�
			@Override
			public void onPageScrollStateChanged(int arg0) {
				switch (arg0) {
				case ViewPager.SCROLL_STATE_DRAGGING:
					handler.sendEmptyMessage(ImageHandler.MSG_KEEP_SILENT);
					break;
				case ViewPager.SCROLL_STATE_IDLE:
					handler.sendEmptyMessageDelayed(
							ImageHandler.MSG_UPDATE_IMAGE,
							ImageHandler.MSG_DELAY);
					break;
				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
		});
		asyncViewPagerLoader = new AsyncViewPagerLoader(viewPager);
		asyncViewPagerLoader.execute();
	}

	static class ViewPagerHolder {

		public ViewPager viewPager;
		private Activity activity;

		public ViewPagerHolder(Activity activity) {
			this.activity = activity;
		}

	}

	private class AsyncViewPagerLoader extends
			AsyncTask<Void, Void, IssueAdapter> {

		private ViewPager viewPager;
		private IssueAdapter issueAdapter;

		public AsyncViewPagerLoader(ViewPager viewPager) {
			super();
			this.viewPager = viewPager;
		}

		@Override
		protected IssueAdapter doInBackground(Void... viewPager) {
			// TODO Auto-generated method stub

			ArrayList<View> relativeLayouts = new ArrayList<View>();
			RelativeLayout relativeLayout1 = (RelativeLayout) activity
					.getLayoutInflater().inflate(R.layout.pagerlayout, null);
			relativeLayout1.setBackgroundResource(R.drawable.issue_1);
			TextView textView1 = (TextView) relativeLayout1
					.findViewById(R.id.tv_pagerdesc);
			textView1.setText("�Ի�,�߽�2002����");

			RelativeLayout relativeLayout2 = (RelativeLayout) activity
					.getLayoutInflater().inflate(R.layout.pagerlayout, null);
			relativeLayout2.setBackgroundResource(R.drawable.issue_2);
			TextView textView2 = (TextView) relativeLayout2
					.findViewById(R.id.tv_pagerdesc);
			textView2.setText("�����,С������������");

			RelativeLayout relativeLayout3 = (RelativeLayout) activity
					.getLayoutInflater().inflate(R.layout.pagerlayout, null);
			relativeLayout3.setBackgroundResource(R.drawable.issue_3);
			TextView textView3 = (TextView) relativeLayout3
					.findViewById(R.id.tv_pagerdesc);
			textView3.setText("��˵����,�й���Ӿ��");

			RelativeLayout relativeLayout4 = (RelativeLayout) activity
					.getLayoutInflater().inflate(R.layout.pagerlayout, null);
			relativeLayout4.setBackgroundResource(R.drawable.issue_4);
			TextView textView4 = (TextView) relativeLayout4
					.findViewById(R.id.tv_pagerdesc);
			textView4.setText("�ٷ�,�����ռ�������");

			RelativeLayout relativeLayout5 = (RelativeLayout) activity
					.getLayoutInflater().inflate(R.layout.pagerlayout, null);
			relativeLayout5.setBackgroundResource(R.drawable.issue_6);
			TextView textView5 = (TextView) relativeLayout5
					.findViewById(R.id.tv_pagerdesc);
			textView5.setText("��!������15���������п���ת��");
			relativeLayouts.add(relativeLayout1);
			relativeLayouts.add(relativeLayout2);
			relativeLayouts.add(relativeLayout3);
			relativeLayouts.add(relativeLayout4);
			relativeLayouts.add(relativeLayout5);

			issueAdapter = new IssueAdapter(relativeLayouts);
			return issueAdapter;
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
			ProgressDialog progressDialog = new ProgressDialog(activity);
			progressDialog.setMessage("loading...");
		}

		@Override
		protected void onPostExecute(IssueAdapter result) {
			viewPager.setAdapter(result);
		}

	}

	private class ImageHandler extends Handler {

		/**
		 * ���������ʾ��View��
		 */
		protected static final int MSG_UPDATE_IMAGE = 1;
		/**
		 * ������ͣ�ֲ���
		 */
		protected static final int MSG_KEEP_SILENT = 2;
		
		/**
		 * ��¼���µ�ҳ�ţ����û��ֶ�����ʱ��Ҫ��¼��ҳ�ţ������ʹ�ֲ���ҳ�����
		 * ���統ǰ����ڵ�һҳ������׼�����ŵ��ǵڶ�ҳ������ʱ���û���������ĩҳ��
		 * ��Ӧ�ò��ŵ��ǵ�һҳ�������������ԭ���ĵڶ�ҳ���ţ����߼��������⡣
		 */
		protected static final int MSG_PAGE_CHANGED = 4;

		// �ֲ����ʱ��
		protected static final long MSG_DELAY = 3000;

		// ʹ�������ñ���Handlerй¶.����ķ��Ͳ������Բ���Activity��Ҳ������Fragment��
		private int currentItem = 0;

		protected ImageHandler() {
		}

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			ViewPager viewPager = (ViewPager) pagerView.findViewById(R.id.vp_issue);
			if (viewPager == null) {
				return;
			}
			if (activity == null) {
				// Activity�Ѿ����գ������ٴ���UI��
				return;
			}
			// �����Ϣ���в��Ƴ�δ���͵���Ϣ������Ҫ�Ǳ����ڸ��ӻ�������Ϣ�����ظ������⡣
			if (handler.hasMessages(MSG_UPDATE_IMAGE)) {
				handler.removeMessages(MSG_UPDATE_IMAGE);
			}
			switch (msg.what) {
			case MSG_UPDATE_IMAGE:
				currentItem++;
				if(currentItem >= 5)
					currentItem %= 5;
				viewPager.setCurrentItem(currentItem);
				// ׼���´β���
				handler.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE, MSG_DELAY);
				break;
			case MSG_KEEP_SILENT:
				// ֻҪ��������Ϣ����ͣ��
				break;
			case MSG_PAGE_CHANGED:
				// ��¼��ǰ��ҳ�ţ����ⲥ�ŵ�ʱ��ҳ����ʾ����ȷ��
				currentItem = msg.arg1;
				break;
			default:
				break;
			}
		}
	}
}
