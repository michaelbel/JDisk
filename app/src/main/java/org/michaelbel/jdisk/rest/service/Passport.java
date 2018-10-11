package org.michaelbel.jdisk.rest.service;

import org.michaelbel.jdisk.rest.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Passport {

    @GET("info?")
    Call<User> info(
        //@Header("Authorization") String token,
        @Query("format") String format,
        @Query("with_openid_identity") String openid,
        @Query("oauth_token") String token
    );
}