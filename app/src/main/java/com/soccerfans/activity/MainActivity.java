package com.soccerfans.activity;

import java.util.ArrayList;

import com.soccerfans.adapter.TextSettingAdapter;
import com.soccerfans.model.GlobalData;
import com.soccerfans.utils.SplashDialog;

import com.soccerfans.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MainActivity extends FragmentActivity {
	private DrawerLayout drawerLayout;
	private RelativeLayout drawerSettings;
	private FragmentTabHost mTabHost;
	private Dialog splashDialog ;
	private ArrayList<String>individual_items;
	private TextSettingAdapter textSettingAdapter;
	
	private void initTabHost(){
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(),android.R.id.tabcontent);
	}
	
	private View getIndicatorView(int index){
		return getLayoutInflater().inflate(GlobalData.tab_layouts[index], null);
	}
	
	private void setTitleStyle(){
		getActionBar().setDisplayHomeAsUpEnabled(false);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setDisplayShowTitleEnabled(false);
	    getActionBar().setDisplayShowCustomEnabled(true);	
		View actionbarLayout = LayoutInflater.from(this).inflate(
					R.layout.title_style, null);
		getActionBar().setCustomView(actionbarLayout);
	}
	
	
	private void initView(){
		individual_items = new ArrayList<String>();
		individual_items.add("ABCD");
		individual_items.add("ABCD");
		individual_items.add("ABCD");
		individual_items.add("ABCD ");
		individual_items.add("ABCD");
		individual_items.add("ABCD");
		textSettingAdapter = new TextSettingAdapter(individual_items, this);
		drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
		drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
		drawerSettings = (RelativeLayout) drawerLayout.findViewById(R.id.main_right_drawer_layout);
		ListView listView = (ListView) drawerSettings.findViewById(R.id.lv_individual);
		listView.setAdapter(textSettingAdapter);
		for(int i = 0;i != GlobalData.num_of_fragments;i ++){
			View indicatorView = getIndicatorView(i);
			mTabHost.addTab(mTabHost.newTabSpec(GlobalData.fragment_tags[i]).setIndicator(indicatorView),
					GlobalData.fragment_class[i],new Bundle());
		}
		ImageView imageView = (ImageView) drawerLayout.findViewById(R.id.riv_image);
		ImageLoader imageLoader = ImageLoader.getInstance();
		DisplayImageOptions options = new DisplayImageOptions.Builder()
	    .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
	    .cacheOnDisk(true)
	    .resetViewBeforeLoading(true)
	    .displayer(new RoundedBitmapDisplayer(112)).build();
		imageLoader.displayImage("drawable://"+R.drawable.individual,imageView, options);
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashDialog = new SplashDialog(this, R.style.mydialog);
        splashDialog.show();
        //setTitleStyle();
        setContentView(R.layout.activity_main);
        initTabHost();
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void Switch(View view){
    	if(drawerLayout.isDrawerOpen(drawerSettings)){
    		drawerLayout.closeDrawer(drawerSettings);
    	}
    	else{
    		drawerLayout.openDrawer(drawerSettings);
    	}
    }
   }
