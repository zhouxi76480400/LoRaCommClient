package org.enes.loracommclient.utils;

import android.content.SharedPreferences;

import org.enes.loracommclient.objects.UserObject;

public class UserUtil {

    public static UserObject getUser() {
        boolean isLogin = false;
        UserObject object = new UserObject();
        SharedPreferences sharedPreferences =
            SharedPreferencesUtil.getSharedPreferences(SharedPreferencesUtil.kUserName);
        isLogin = sharedPreferences.
                        getBoolean(SharedPreferencesUtil.kUserObjectIsLogin, false);
        if (isLogin) {


        }
        object.is_login = isLogin;
        return object;
    }

    public static void setLogin(String userName) {
        SharedPreferences sharedPreferences =
                SharedPreferencesUtil.getSharedPreferences(SharedPreferencesUtil.kUserName);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SharedPreferencesUtil.kUserObjectIsLogin, true);
        editor.putString(SharedPreferencesUtil.kUserNameKey, userName);
        editor.apply();
    }



}
