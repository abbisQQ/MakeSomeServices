package com.example.babis.makesomeservices;

import android.app.Service;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.IBinder;

import java.util.Date;
import java.util.Locale;

public class BoundService extends Service {

    private final IBinder myBinder =  new MyLocalBinder();



    public BoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
      return myBinder;
    }


    public class MyLocalBinder extends Binder{
        BoundService getService(){
            return BoundService.this;
        }
    }

    public String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.ITALY);
        return (df.format(new Date()));
    }
}
