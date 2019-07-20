package com.twitter.challenge.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.twitter.challenge.R;
import com.twitter.challenge.model.WeatherModel;
import com.twitter.challenge.viewmodel.WeatherViewModel;

public class MainActivity extends AppCompatActivity {

    private TextView mCtemperature;
    private TextView mPtemperature;
    private TextView mWindSpeed;
    private ImageView mcloudIcon;

    private WeatherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCtemperature = findViewById(R.id.ctemperature);
        mPtemperature = findViewById(R.id.ftemperature);
        mWindSpeed = findViewById(R.id.wind_speed);
        mcloudIcon = findViewById(R.id.cloud_icon);

        viewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);

//        final TextView temperatureView = (TextView) findViewById(R.id.temperature);
//        temperatureView.setText(getString(R.string.temperature, 34f, TemperatureConverter.celsiusToFahrenheit(34)));

        updateUI(viewModel.getWeatherModel());
    }

    private void updateUI(WeatherModel weather) {
        // Update the UI, in this case, a TextView.
        mCtemperature.setText(weather.getcTemperature());

        mPtemperature.setText(weather.getfTemperature());

        mWindSpeed.setText(weather.getWindSpeed());

        if (Integer.getInteger(weather.getCloudinessPercentage()) > 50) {
            mcloudIcon.setVisibility(View.VISIBLE);
        } else {
            mcloudIcon.setVisibility(View.GONE);
        }
    }

}
