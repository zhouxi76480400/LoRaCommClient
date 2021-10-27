package org.enes.loracommclient.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import org.enes.loracommclient.common.MyApplication;

public class ModeSelectActivity extends MyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = null;
        if(isLogin()) {
            intent = new Intent(this, MainActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
        finish();
    }

    private boolean isLogin() {
        return MyApplication.getInstance().getNowUser().is_login;
    }

}
