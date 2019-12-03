package com.example.pp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.pp.MainActivity;
import com.example.pp.R;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
            todo
            нарисовать активити-заставку
            - картинка-лого
            - емуляция загрузки
         */
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();

        //goNextActivity();
        goNextActivityWithDelay(2000);
    }

    private void goNextActivity(){
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        this.finish();
    }

    private void goNextActivityWithDelay(int delay){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }, delay);
    }

    @Override
    public void onBackPressed() {
    }
}
