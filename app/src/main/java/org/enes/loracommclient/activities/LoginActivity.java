package org.enes.loracommclient.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import org.enes.loracommclient.R;
import org.enes.loracommclient.utils.UserUtil;

public class LoginActivity extends MyActivity implements View.OnClickListener {

    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_login);
        editText = ((TextInputLayout) findViewById(R.id.text_input_layout)).getEditText();
        Button button = findViewById(R.id.btn_ok);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        processNewName();
    }

    private void processNewName() {
        String text = editText.getText().toString().trim();
        if(text.length() == 0) {
            Snackbar snackbar =
                    Snackbar.make(editText, getString(R.string.txt_no_text), Snackbar.LENGTH_SHORT);
            snackbar.setTextColor(getColor(R.color.white));
            snackbar.setBackgroundTint(getResources().getColor(R.color.purple_500, null));
            snackbar.show();
        } else {
            // process
            UserUtil.setLogin(text);
            Toast.makeText(this, getString(R.string.txt_login_success), Toast.LENGTH_SHORT)
                    .show();
            goToActivity();
            finish();
        }
    }

    private void goToActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
