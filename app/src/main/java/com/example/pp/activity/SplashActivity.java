package com.example.pp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.pp._old.MainActivity;
import com.example.pp.R;
import com.example.pp.activity.controller.imp.LoadControllerImp;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private static final int DELAY = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Objects.requireNonNull(getSupportActionBar()).hide();
        /*
            todo
            нарисовать активити-заставку
            - картинка-лого
            - емуляция загрузки
         */
        setContentView(R.layout.activity_splash);

        runLoadData();
        //goNextActivity();
        goNextActivityWithDelay();
    }

    private void goNextActivity(){
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        this.finish();
    }

    private void goNextActivityWithDelay(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //todo fix next activity
                Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }, DELAY);
    }

    private void runLoadData(){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                new LoadControllerImp(getApplicationContext()).load();
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
