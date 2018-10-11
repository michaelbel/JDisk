package org.michaelbel.jdisk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.yandex.authsdk.YandexAuthException;
import com.yandex.authsdk.YandexAuthOptions;
import com.yandex.authsdk.YandexAuthSdk;
import com.yandex.authsdk.YandexAuthToken;

import androidx.annotation.Nullable;

public class AuthActivityModel {

    private AuthActivityCallback callback;
    private Context context;
    private YandexAuthSdk sdk;

    public AuthActivityModel(AuthActivityCallback callback, Context context){
        this.callback = callback;
        this.context = context;
        sdk = new YandexAuthSdk(context, new YandexAuthOptions(context, true));
    }

    public void auth(){
        callback.onCreateLoginIntent(sdk.createLoginIntent(context,null));
    }

    public void saveData(int resultCode, @Nullable Intent data){
        try {
            final YandexAuthToken yandexAuthToken = sdk.extractToken(resultCode, data);
            if (yandexAuthToken != null) {
                SharedPreferences sharedPreferences = JDisk.context.getSharedPreferences("mainconfig", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("token", yandexAuthToken.getValue()).apply();
                callback.onAuth();
            }
        } catch (YandexAuthException e) {
            callback.onError();
        }
    }
}