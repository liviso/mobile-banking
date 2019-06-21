package com.certificatic.mobilebanking.common;

import android.app.Application;
import android.content.Context;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class GlobalContext extends Application{

    private static GlobalContext instance;

    public static GlobalContext getInstance(){
        return instance;
    }

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        instance=this;
        super.onCreate();
        Fabric.with(this, new Crashlytics());
    }
}
