package com.twitter.challenge.network;

import android.support.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.twitter.challenge.model.WeatherResponse;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Rest interface to fetch data from server
 */
public class RetrofitService {

    private Retrofit mRetroFit;
    private WeatherApi mWeatherApi;

    private static final String END_POINT = "https://twitter-code-challenge.s3.amazonaws.com/";

    private static class SingletonRetroFitServiceHelper {
        private static final RetrofitService INSTANCE = new RetrofitService();
    }

    public static RetrofitService getInstance() {
        return SingletonRetroFitServiceHelper.INSTANCE;
    }

    private RetrofitService() {
        final Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setLenient()
                .create();
        mRetroFit = new Retrofit.Builder().baseUrl(END_POINT)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    public Single<WeatherResponse> getSearchResults(@NonNull String userQuery) {
        mWeatherApi = mRetroFit.create(WeatherApi.class);
        return mWeatherApi.fetchWeatherReport();
    }
}
