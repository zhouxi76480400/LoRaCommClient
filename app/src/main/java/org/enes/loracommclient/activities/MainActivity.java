package org.enes.loracommclient.activities;

import android.os.Bundle;

import org.enes.loracommclient.R;

public class MainActivity extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);




    }


}