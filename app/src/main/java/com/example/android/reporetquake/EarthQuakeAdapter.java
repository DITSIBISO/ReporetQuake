package com.example.android.reporetquake;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by eKasiLab Alex CDTB on 2017/12/05.
 */

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {


    private static final String TAG = "EarthQuakeAdapter";
    private static final String LOCATION_SEPARATOR = " of ";


    public EarthQuakeAdapter(Context context, ArrayList<EarthQuake> data) {
        super(context, 0, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        EarthQuake earthQuake = getItem(position);
        String originalLocation = earthQuake.getLocation();
        String primaryLocation;
        String locationOffset;
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        //取一位小数
        String mag = (new DecimalFormat("0.0")).format(earthQuake.getMagnitude());

        TextView magnitudeView = (TextView) itemView.findViewById(R.id.magnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        magnitudeCircle.setColor(getMagnitudeColor(earthQuake.getMagnitude()));
        magnitudeView.setText(mag);

        ((TextView) itemView.findViewById(R.id.location_offset)).setText(locationOffset);
        ((TextView) itemView.findViewById(R.id.primary_location)).setText(primaryLocation);
        Date date = new Date(earthQuake.getDate());
        ((TextView) itemView.findViewById(R.id.date)).setText(formatDate(date));
        ((TextView) itemView.findViewById(R.id.time)).setText(formatTime(date));
        return itemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        switch ((int) Math.floor(magnitude)) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String formatDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    private String formatTime(Date date) {
        return new SimpleDateFormat("h:mm a").format(date);
    }
}
