package com.soccerfans.utils;

import java.util.ArrayList;

import com.soccerfans.model.GlobalData;

import android.content.Context;

public class HolderFactory {
	private Context context;
	private ArrayList<Holder> holderArrayList;
	
	public HolderFactory(Context context){
		this.context = context;
		holderArrayList = new ArrayList<Holder>();
	}
	public Holder generateHolder(int type,int resid){
		if(GlobalData.TEXT_TYPE == type){
			for(Holder holder : holderArrayList){
				if(holder.getTag() == type && holder.getResid() == resid){
					return holder;
				}
			}
			Holder holder = new SubMainHolder(context,resid);
			holderArrayList.add(holder);
			return holder;
		}
		else{
			for(Holder holder : holderArrayList){
				if(holder.getTag() == type && holder.getResid() == resid){
					return holder;
				}
			}
			Holder holder = new SubMainImageHolder(context,resid);
			holderArrayList.add(holder);
			return holder;
		}
	}
}
