package com.example.babis.makesomeservices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent serviceIntent,justService,boundServiceIntent;
    BoundService boundService;
    boolean isBound = false;
    TextView timeDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceIntent = new Intent(this,IntentServiceExample.class);
        justService = new Intent(this,MyService.class);
        boundServiceIntent = new Intent(this,BoundService.class);
        timeDisplay = (TextView)findViewById(R.id.time_display);
        bindService(boundServiceIntent,myConnection, Context.BIND_AUTO_CREATE);
    }



    public void startIntentService(View view) {
        startService(serviceIntent);
    }

    public void JustService(View view) {
        startService(justService);
    }
        //bound service
    private ServiceConnection myConnection  =  new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                BoundService.MyLocalBinder binder = (BoundService.MyLocalBinder)service;
                boundService = binder.getService();
                isBound=true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                isBound=false;
            }
        };

    public void BoundServiceClicked(View view) {

        String currentTime = boundService.getCurrentTime();
        timeDisplay.setText(currentTime);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(myConnection);
    }
}
