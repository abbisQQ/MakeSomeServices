package com.example.babis.makesomeservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "com.example.babis";
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    //when service starts
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service onStartCommand method was called");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        wait(5000);
                        Log.i(TAG, "Run has started we are in a thread");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    };
        Thread myThread = new Thread(runnable);
        myThread.start();

        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Service is destroyed");
    }
}
