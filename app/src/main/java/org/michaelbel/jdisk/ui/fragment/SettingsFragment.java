package org.michaelbel.jdisk.ui.fragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.michaelbel.jdisk.R;
import org.michaelbel.jdisk.rest.ApiFactory;
import org.michaelbel.jdisk.rest.service.Passport;
import org.michaelbel.jdisk.rest.model.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingsFragment extends Fragment {

    AppCompatImageView poster;
    AppCompatTextView name;
    AppCompatTextView email;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        poster = view.findViewById(R.id.poster);
        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getUserInfo();
    }

    private void getUserInfo() {
        SharedPreferences preferences = getActivity().getSharedPreferences("mainconfig", Activity.MODE_PRIVATE);
        String token = preferences.getString("token", null);

        Passport service = ApiFactory.createService(Passport.class, ApiFactory.YANDEX_PASSPORT_API_ENDPOINT);
        service.info(ApiFactory.API_FORMAT_JSON, ApiFactory.API_OPENID_IDENTITY, token).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Log.e("258", "response successful");
                    User user = response.body();
                    Log.e("258", user.name);
                } else {
                    Log.e("258", "response error");
                    Log.e("258", response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("258", t.getMessage());
            }
        });
    }
}