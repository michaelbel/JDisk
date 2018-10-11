package org.michaelbel.jdisk.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import androidx.annotation.NonNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings("all")
public class ApiFactory {

    public static final String YANDEX_PASSPORT_API_ENDPOINT = "https://login.yandex.ru/";
    private static Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

    public static final String API_FORMAT_JSON = "json";
    public static final String API_FORMAT_XML = "xml";
    public static final String API_OPENID_IDENTITY = "yes";

    public static final String AVATAR_URL = "https://avatars.yandex.net/get-yapic/%d/%s";

    // Avatar sizes:
    public static final String ISLANDS_SMALL = "islands-small"; // 28x28 px
    public static final String ISLANDS_34 = "islands-34"; // 34x34 px
    public static final String ISLANDS_MIDDLE = "islands-middle"; // 42x42 px
    public static final String ISLANDS_50 = "islands-50"; // 50x50 px
    public static final String ISLANDS_RETINA_SMALL = "islands-retina-small"; // 56x56 px
    public static final String ISLANDS_68 = "islands-68"; // 68x68 px
    public static final String ISLANDS_75 = "islands-75"; // 75x75 px
    public static final String ISLANDS_RETINA_MIDDLE = "islands-retina-middle"; // 84x84 px
    public static final String ISLANDS_RETINA_50 = "islands-retina-50"; // 100x100 px
    public static final String ISLANDS_200 = "islands-200"; // 200x200 px

    public static final String YANDEX_DISK_API_ENDPOINT = "https://cloud-api.yandex.net/v1/";

    @NonNull
    private static Retrofit getRetrofit(String baseUrl) {
        return new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        return getRetrofit(baseUrl).create(serviceClass);
    }
}