package net.shenru.xposedone;

import android.app.Application;

/**
 * Created by xtdhwl on 27/02/2018.
 */

public class MyApplication extends Application {

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static MyApplication getContext(){
        return mInstance;
    }

}
