package com.segu.service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.segu.service.alarm.AlarmHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlarmHelper.get().init(this);
    }
}