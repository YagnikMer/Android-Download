package com.example.mer.androiddownloadex;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    String strUrl = "https://www.google.co.in/imgres?imgurl=https://upload.wikimedia.org/wikipedia/en/thumb/c/c9/Dhoom_series.JPG/220px-Dhoom_series.JPG&imgrefurl=https://en.wikipedia.org/wiki/Dhoom_(film_series)&h=253&w=220&tbnid=63CFGIrqoqZHJM:&q=dhoom+4&tbnh=186&tbnw=161&usg=AI4_-kTLUyq79MbkOe-0srh2C5pv3dxrBg&vet=12ahUKEwi9g9250cveAhXEXCsKHeZQDckQ_B0wGnoECAUQBg..i&docid=u28OkkcdrSteyM&itg=1&sa=X&ved=2ahUKEwi9g9250cveAhXEXCsKHeZQDckQ_B0wGnoECAUQBg#h=253&imgdii=D_hVPwT6qhH1LM:&tbnh=186&tbnw=161&vet=12ahUKEwi9g9250cveAhXEXCsKHeZQDckQ_B0wGnoECAUQBg..i&w=220";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap bitmap = getBitmapFromUrl(strUrl);
    }

    public Bitmap getBitmapFromUrl(String strUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(strUrl);
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);

        } catch (Exception e) {
        }
        return bitmap;
    }
}
