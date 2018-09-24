package com.dtechterminal.relawable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import spencerstudios.com.bungeelib.Bungee;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread splash = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    Bungee.zoom(MainActivity.this);
                }
            }
        };
        splash.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
