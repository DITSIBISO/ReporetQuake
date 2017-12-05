package com.example.android.reporetquake;

/**
 * Created by eKasiLab Alex CDTB on 2017/12/05.
 */

public class EarthQuake {
    private double mMagnitude;
    private String mLocation;
    private long mDate;
    private String mUrl;

    public EarthQuake(double magnitude, String location, long timeInMilliseconds, String url) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mDate = timeInMilliseconds;
        this.mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getDate() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }
}