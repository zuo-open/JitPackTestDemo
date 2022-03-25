package com.zxl.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zxl.testmodule.utils.MyUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyUtils.logTest();
    }
}