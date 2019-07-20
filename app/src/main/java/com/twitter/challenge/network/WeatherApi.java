package com.twitter.challenge.network;

import com.twitter.challenge.model.WeatherResponse;

import io.reactivex.Single;
import retrofit2.http.GET;


public interface WeatherApi {

    @GET("future_1.json")
    Single<WeatherResponse> fetchWeatherReport();
}
