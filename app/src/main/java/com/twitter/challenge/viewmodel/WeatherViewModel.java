package com.twitter.challenge.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import com.twitter.challenge.model.WeatherModel;

import java.util.Timer;
import java.util.TimerTask;

public class WeatherViewModel extends ViewModel {

    private static final int ONE_SECOND = 1000;

    private WeatherModel weatherModel;

    private MutableLiveData<WeatherModel> mWeatherViewModel = new MutableLiveData<>();

    private long initialTime;

    public WeatherViewModel() {
        initialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();

        // Update the elapsed time every second.
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000;
                // setValue() cannot be called from a background thread so post to main thread.
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {

                        weatherModel = new WeatherModel();
                        weatherModel.setWindSpeed(String.valueOf(newValue));

                        mWeatherViewModel.setValue(weatherModel);

                    }
                });
            }
        }, ONE_SECOND, ONE_SECOND);
    }

    public WeatherModel getWeatherModel() {
        return weatherModel;
    }

    public void setWeatherModel(WeatherModel weatherModel) {
        this.weatherModel = weatherModel;
    }
}
