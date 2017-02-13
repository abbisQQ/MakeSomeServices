package com.example.babis.makesomeservices;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Babis on 2/13/2017.
 */

public class IntentServiceExample  extends IntentService{
    private static final String TAG = "com.example.babis";

    public IntentServiceExample() {
        super("IntentServiceExample");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e(TAG,"Service is started");
    }
}
