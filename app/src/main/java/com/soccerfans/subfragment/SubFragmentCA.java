package com.soccerfans.subfragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.soccerfans.adapter.SubMainHotnewsAdapter;
import com.soccerfans.model.SubMainDataHolder;
import com.soccerfans.net.LoadingTask;
import com.soccerfans.utils.DataRefreshHandler;

public class SubFragmentCA extends SubFragmentMain{

	private RequestQueue mQueue;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		adapter = new SubMainHotnewsAdapter(getActivity(),
				 dataHolder);
		dataRefreshHandler = new DataRefreshHandler(adapter);
		// CustomApplication.getRefWatcher(getActivity()).watch(this);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	@Override
	protected void setUpDataHolder() {
		// TODO Auto-generated method stub
		this.dataHolder = new SubMainDataHolder();
		dataURL = "http://www.dongqiudi.com/archives/56?page=";
		mQueue = Volley.newRequestQueue(fatherActivity);
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
				"http://www.dongqiudi.com/archives/56?page=1", null,
				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						JSONArray jsonArray;
						
						try {
							jsonArray = response.getJSONArray("data");
							for (int i = 0; i != jsonArray.length(); i++) {
								JSONObject jsonObject = jsonArray
										.getJSONObject(i);
								dataHolder.addImage(jsonObject.getString("thumb"));
								dataHolder.addTitle(jsonObject.getString("title"));
								dataHolder.addDescription(jsonObject.getString("description"));
							}
							adapter.notifyDataSetChanged();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
					}
				});
		count++;
		mQueue.add(jsonObjectRequest);
	}

	@Override
	protected AsyncTask<Void, Void, String> runRefreshTask(
			ListView listView) {
		// TODO Auto-generated method stub
		// return new LoadingTask(mPullToRefreshListView);
		return new LoadingTask(mPullToRefreshListView,fatherActivity,"http://www.dongqiudi.com/archives/56?page=1",
				  dataRefreshHandler,dataHolder);
	}

}
