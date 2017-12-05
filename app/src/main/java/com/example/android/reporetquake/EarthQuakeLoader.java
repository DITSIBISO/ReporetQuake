package com.example.android.reporetquake;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by eKasiLab Alex CDTB on 2017/12/05.
 */

public class EarthQuakeLoader extends android.support.v4.content.AsyncTaskLoader<ArrayList<EarthQuake>> {

    public static final String TAG = EarthQuakeLoader.class.getName();

    private String url;

    public EarthQuakeLoader(Context context , String url) {
        super(context);
        this.url = url;
        Log.i(TAG, "EarthQuakeLoader: ");
    }

    @Override
    public ArrayList<EarthQuake> loadInBackground() {
        Log.i(TAG, "loadInBackground: ");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return QueryUtills.extractEarthquakes(url);
//        return null;
        //return null;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
