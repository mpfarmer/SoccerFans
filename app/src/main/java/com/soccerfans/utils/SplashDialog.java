package com.soccerfans.utils;
import com.soccerfans.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

public class SplashDialog extends Dialog {
    int splashTime = 4000;

    public SplashDialog(Context context, int theme) {
        super(context, theme);
    }

    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setCancelable(false);;
        getWindow().setWindowAnimations(R.anim.dialog_alpha);
        new Handler().postDelayed(new Runnable() {
        	
            @Override
            public void run() {
              dismiss();
            }
        }, splashTime);

    }
    
}