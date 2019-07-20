package com.twitter.challenge.model;

public class WeatherModel {

    String location;

    String cTemperature;

    String fTemperature;

    String windSpeed;

    String cloudinessPercentage;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getcTemperature() {
        return cTemperature;
    }

    public void setcTemperature(String cTemperature) {
        this.cTemperature = cTemperature;
    }

    public String getfTemperature() {
        return fTemperature;
    }

    public void setfTemperature(String fTemperature) {
        this.fTemperature = fTemperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getCloudinessPercentage() {
        return cloudinessPercentage;
    }

    public void setCloudinessPercentage(String cloudinessPercentage) {
        this.cloudinessPercentage = cloudinessPercentage;
    }
}
