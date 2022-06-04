package com.example.testfigma2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EnterActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);
    }
    public void profile(View v){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

}