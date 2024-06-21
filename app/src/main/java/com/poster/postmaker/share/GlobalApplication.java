package com.poster.postmaker.share;


import android.os.StrictMode;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.poster.postmaker.R;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class GlobalApplication extends MultiDexApplication {

    public PublisherInterstitialAd mInterstitialAd;
    public PublisherAdRequest ins_adRequest;

    private static final String TAG = "Application";

    private static GlobalApplication appInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        appInstance = this;
        MultiDex.install(this);
        //TODO to solve camera issue
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }

    public boolean requestNewInterstitial() {

        try {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isLoaded() {

        try {
            if (mInterstitialAd.isLoaded() && mInterstitialAd != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static synchronized GlobalApplication getInstance() {
        return appInstance;
    }

}
