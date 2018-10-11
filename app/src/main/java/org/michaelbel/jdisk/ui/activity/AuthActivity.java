package org.michaelbel.jdisk.ui.activity;

import android.os.Bundle;

import org.michaelbel.jdisk.R;

import androidx.appcompat.app.AppCompatActivity;

public class AuthActivity extends AppCompatActivity {

    public static final int REQUEST_LOGIN_CODE = 2001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
    }
}