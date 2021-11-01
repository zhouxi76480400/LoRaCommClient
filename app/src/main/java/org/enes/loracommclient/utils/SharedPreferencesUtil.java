package org.enes.loracommclient.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.enes.loracommclient.common.MyApplication;

public class SharedPreferencesUtil {

    public static final String kUserName = "UserName";

    public static final String kUserObjectIsLogin = "isLogin";

    public static final String kUserNameKey = "uname";

    public static SharedPreferences getSharedPreferences(String name) {
        SharedPreferences sharedPreferences =
                MyApplication.getInstance().getSharedPreferences(name, Context.MODE_PRIVATE);
        return sharedPreferences;
    }

}
