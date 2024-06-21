package com.poster.postmaker.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.poster.postmaker.R;
import com.poster.postmaker.share.GlobalApplication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable myRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_splash);


        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        for (Signature signature : info.signatures) {

            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("SHA");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            md.update(signature.toByteArray());
            Log.e("TAG", "KeyHash:--->" + Base64.encodeToString(md.digest(), Base64.DEFAULT));
        }
        initViews();

    }

    private void initViews() {

        handler = new Handler();

        myRunnable = new Runnable() {
            public void run() {

                if (!GlobalApplication.getInstance().requestNewInterstitial()) {

                    Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(i);
                    finish();

                } else {

                    GlobalApplication.getInstance().mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            super.onAdClosed();

                            GlobalApplication.getInstance().mInterstitialAd.setAdListener(null);
                            GlobalApplication.getInstance().mInterstitialAd = null;
                            GlobalApplication.getInstance().ins_adRequest = null;

                            Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                            startActivity(i);
                            finish();

                        }

                        @Override
                        public void onAdFailedToLoad(int i) {
                            super.onAdFailedToLoad(i);
                        }

                        @Override
                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    });
                }

            }
        };
        handler.postDelayed(myRunnable, 2000);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!GlobalApplication.getInstance().isLoaded()) {

        }

    }

}
