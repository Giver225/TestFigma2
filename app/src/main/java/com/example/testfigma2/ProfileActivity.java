package com.example.testfigma2;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ProfileActivity extends AppCompatActivity{
    FragmentManager fragmentManager = getSupportFragmentManager();
    RESTapi resTapi = new RESTapi();
    String login;
    String password;
    String name;
    String status;
    String phone;
    String male;
    String date_of_birth;
    String email;


    public String urlWww = resTapi.getUrlWww();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle arguments = getIntent().getExtras();
        login = arguments.get("login").toString();
        password = arguments.get("password").toString();
        name = arguments.get("name").toString();
        status = arguments.get("status").toString();
        phone = arguments.get("phone").toString();
        male = arguments.get("male").toString();
        date_of_birth = arguments.get("date_of_birth").toString();
        email = arguments.get("email").toString();

//        TODO: загрузить данные в профиль
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        fragmentManager.beginTransaction()
                .add(R.id.profile_frame, fragment_data.class, null)
                .setReorderingAllowed(true)
                .commit();
        TextView nameView = findViewById(R.id.name);
        nameView.setText(name);
        TextView statusView = findViewById(R.id.status);
        if (status.equals("patient")){
            statusView.setText("Статус: Пациент");
        }
        if (status.equals("doctor")){
            statusView.setText("Статус: Врач");
        }
        if (status.equals("admin")){
            statusView.setText("Статус: Администратор");
            View add_member = findViewById(R.id.add_member);
            add_member.setVisibility(View.VISIBLE);
        }


    }
    public void new_member(View v){
        Intent intent = new Intent(this, NewMemberActivity.class);
        startActivity(intent);
    }



    public void entry_fragment(View v){
        fragmentManager.beginTransaction()
                .replace(R.id.profile_frame, fragment_entry.class, null)
                .setReorderingAllowed(true)
                .commit();
    }
    public void data_fragment(View v){


        fragmentManager.beginTransaction()
                .replace(R.id.profile_frame, fragment_data.class, null)
                .setReorderingAllowed(true)
                .commit();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getPhone() {
        return phone;
    }

    public String getMale() {
        return male;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getEmail() {
        return email;
    }
}