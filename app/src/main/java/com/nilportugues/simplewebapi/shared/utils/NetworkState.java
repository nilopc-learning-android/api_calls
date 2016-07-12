package com.nilportugues.simplewebapi.shared.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkState {

    private NetworkInfo info;

    public NetworkState(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        this.info = manager.getActiveNetworkInfo();
    }

    public boolean isNetworkConnected() {

        return info != null && info.isAvailable();
    }

    public boolean isWifiConnected() {

        if (info != null) {
            if (info.getType() == ConnectivityManager.TYPE_WIFI)
                return info.isAvailable();
        }

        return false;
    }

    public boolean isMobileDataConnected() {

        if (info != null) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE)
                return true;
        }

        return false;
    }
}