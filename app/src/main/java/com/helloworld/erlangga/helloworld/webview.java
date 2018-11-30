package com.helloworld.erlangga.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        final String url = getIntent().getStringExtra("url");

        WebView webView = findViewById(R.id.web);

        webView.loadUrl(url);
    }
}
