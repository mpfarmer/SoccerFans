package com.soccerfans.model;

import java.util.ArrayList;

import com.soccerfans.R;
public class SubMainImageDataHolder{
	private ArrayList<String> title = new ArrayList<String>();
	private ArrayList<int[]> imgList = new ArrayList<int[]>();
	public SubMainImageDataHolder(){
		int[] temp = {R.drawable.img_news1_1,R.drawable.img_news2_1,R.drawable.img_news3_1};
		imgList.add(temp);
		title.add("ABCD");
	}
	public ArrayList<String> getTitle() {
		return title;
	}
	public ArrayList<int[]> getImgList() {
		return imgList;
	}
}
