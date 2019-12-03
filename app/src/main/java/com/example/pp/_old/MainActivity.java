package com.example.pp._old;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pp.R;
import com.example.pp._old.CityselectionActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.button_start);
        btnStart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_start:
                Intent intent = new Intent(this, CityselectionActivity.class);
                startActivity(intent);
//                TelephonyManager tMgr = (TelephonyManager)AppContext.getSystemService(Context.TELEPHONY_SERVICE);
//                String mPhoneNumber = tMgr.getLine1Number();
                break;
            default:
                break;
        }
    }
}