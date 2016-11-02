package com.example.myaddress;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by nucur on 10/22/2016.
 */

public class AboutActivity extends Activity {

    private static final String TAG = "MyAddress/About";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i (TAG, "Dmitry Zuev n01112600");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
}