package com.example.testfigma2;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void registration_activity(View v){
        Intent intent = new Intent(this, RegistrationActivity.class);
        SetURL(v);
        startActivity(intent);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void enter_activity(View v){
        Intent intent = new Intent(this, EnterActivity.class);
        SetURL(v);
        startActivity(intent);
    }
    public void SetURL(View v){
        EditText editText = findViewById(R.id.edit_url);
        if (!editText.getText().toString().isEmpty()){
            try {
                FileWriter writer = new FileWriter("url.txt", false);
                writer.write(editText.getText().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
