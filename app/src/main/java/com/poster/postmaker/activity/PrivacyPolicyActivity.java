
package com.poster.postmaker.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;


import com.poster.postmaker.R;

import androidx.appcompat.app.AppCompatActivity;

public class PrivacyPolicyActivity extends AppCompatActivity {

    WebView txtInformtation;
    ImageView imgBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        findViews();
        initViews();

    }

    private void findViews() {


        imgBack = findViewById(R.id.ic_back);
    }


    private void initViews() {

        txtInformtation = findViewById(R.id.txtInformtation);
        txtInformtation.loadUrl("file:///android_asset/privacyPolicy.html");

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }

}