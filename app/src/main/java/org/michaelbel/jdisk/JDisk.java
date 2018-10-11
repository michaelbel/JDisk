package org.michaelbel.jdisk;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class JDisk extends Application {

    public static volatile Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public void setToken(String token) {
        SharedPreferences sharedPreferences = getSharedPreferences("mainconfig", MODE_PRIVATE);
        sharedPreferences.edit().putString("token", token).apply();
    }
}
