package org.enes.loracommclient.common;

import android.app.Application;

import org.enes.loracommclient.objects.UserObject;
import org.enes.loracommclient.utils.UserUtil;

public class MyApplication extends Application {

    private static MyApplication application;

    public static MyApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public UserObject getNowUser() {
        return UserUtil.getUser();
    }

}
