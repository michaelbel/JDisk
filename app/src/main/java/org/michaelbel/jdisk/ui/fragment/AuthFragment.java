package org.michaelbel.jdisk.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

import org.michaelbel.jdisk.AuthActivityCallback;
import org.michaelbel.jdisk.AuthActivityModel;
import org.michaelbel.jdisk.R;
import org.michaelbel.jdisk.ui.activity.AuthActivity;
import org.michaelbel.jdisk.ui.activity.MainActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;

public class AuthFragment extends Fragment implements View.OnClickListener, AuthActivityCallback {

    private AuthActivity activity;
    private AuthActivityModel model;

    private MaterialButton loginButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (AuthActivity) getActivity();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == AuthActivity.REQUEST_LOGIN_CODE) {
            model.saveData(resultCode,data);
            startActivity(new Intent(activity, MainActivity.class));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth, container, false);
        loginButton = view.findViewById(R.id.auth_button);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new AuthActivityModel(this, getContext());
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        model.auth();
    }

    @Override
    public void onCreateLoginIntent(Intent intent) {
        startActivityForResult(intent, AuthActivity.REQUEST_LOGIN_CODE);
    }

    @Override
    public void onAuth() {
        Intent data = new Intent();
        activity.setResult(RESULT_OK, data);
        activity.finish();
    }

    @Override
    public void onError() {}
}