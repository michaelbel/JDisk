package org.michaelbel.jdisk.rest.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Disk {

    @GET("disk?")
    Call<Disk> info(
        @Query("oauth_token") String token
    );

    @GET("resources?")
    Call<?> resources(
        @Query("oauth_token") String token
    );
}