package com.example.testfigma2;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);
    }
    public void registration_activity(View v){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
    public void enter_activity(View v){
        Intent intent = new Intent(this, EnterActivity.class);
        startActivity(intent);
    }
}
