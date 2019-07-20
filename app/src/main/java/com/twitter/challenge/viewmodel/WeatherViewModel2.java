package com.twitter.challenge.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;

import com.twitter.challenge.db.WeatherLocal;

/**
 * Created on 7/13/19.
 */

public class WeatherViewModel2 extends AndroidViewModel {

    private final MediatorLiveData<WeatherLocal> mObservableProducts;

    public WeatherViewModel2(@NonNull Application application) {
        super(application);
        mObservableProducts = null;
    }
}
