package org.michaelbel.jdisk;

import android.content.Intent;

public interface AuthActivityCallback {

    void onCreateLoginIntent(Intent intent);

    void onAuth();

    void onError();
}