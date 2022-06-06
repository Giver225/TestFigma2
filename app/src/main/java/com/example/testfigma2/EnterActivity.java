package com.example.testfigma2;

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

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@RequiresApi(api = Build.VERSION_CODES.O)
public class EnterActivity extends AppCompatActivity{

    RESTapi resTapi = new RESTapi();
    public String urlWww = resTapi.getUrlWww();
    String right_password;
    Intent intent;
    String login;
    String name;
    String status;
    String phone;
    String male;
    String date_of_birth;
    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);
        intent = new Intent(this, ProfileActivity.class);
    }
    public void profile(View v){
        EditText loginView = findViewById(R.id.edit_login);
        EditText password = findViewById(R.id.edit_password);
        Log.i("123123", password.getText().toString());
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // Create URL
                // Create connection
                try {
                    Log.i("123123123123", urlWww);
                    urlWww = urlWww.substring(0, urlWww.length() - 1);
                    urlWww = urlWww + loginView.getText().toString();
                    URL Endpoint = new URL(urlWww);
                    Log.i("PROSHELGOVNO", urlWww);
                    HttpURLConnection myConnection =  (HttpURLConnection) Endpoint.openConnection();
                    Log.i("PROSHELGOVNO", "sssssssssssssssssssssssssssssssssssssssssssssssss");
                    Log.i("PROSHELGOVNO", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//                    myConnection.setDoOutput(true);
                    myConnection.setRequestMethod("GET");
                    myConnection.setRequestProperty("User-Agent", "my-rest-app-v0.1");
                    myConnection.setRequestProperty("Content-Type", "application/json");
                    myConnection.setRequestProperty("Accept", "application/json");
                    InputStream responseBody = myConnection.getInputStream();
                    Log.i("PROSHELGOVNO", "sssssssssssssssssssssssssssssssssssssssssssssssss");
                    InputStreamReader responseBodyReader =
                            new InputStreamReader(responseBody, "UTF-8");

                    JsonReader jsonReader = new JsonReader(responseBodyReader);
                    jsonReader.beginObject(); // Start processing the JSON object
                    while (jsonReader.hasNext()) { // Loop through all keys
                        String key = jsonReader.nextName(); // Fetch the next key
                        switch (key){
                            case ("login"):
                                login = jsonReader.nextString();
                                break;
                            case ("password"):
                                right_password = jsonReader.nextString();
                                break;
                            case ("name"):
                                name = jsonReader.nextString();
                                break;
                            case ("status"):
                                status = jsonReader.nextString();
                                break;
                            case ("phone"):
                                phone = jsonReader.nextString();
                                break;
                            case ("male"):
                                male = jsonReader.nextString();
                                break;
                            case ("date_of_birth"):
                                date_of_birth = jsonReader.nextString();
                                break;
                            case ("email"):
                                email = jsonReader.nextString();
                                break;
                            default:
                                jsonReader.skipValue();
                        }
                    }

                } catch (IOException e) {
                    Log.i("PROSHELGOVNO", "2222222222222222222222222222");
                    e.printStackTrace();
                }
                Log.i("PROSHELGOVNO", "333333333333333333333333333333333333333");
                if (right_password.equals(password.getText().toString())){
                    intent.putExtra("login", login);
                    intent.putExtra("password", right_password);
                    intent.putExtra("name", name);
                    intent.putExtra("status", status);
                    intent.putExtra("phone", phone);
                    intent.putExtra("male", male);
                    intent.putExtra("date_of_birth", date_of_birth);
                    intent.putExtra("email", email);
                    startActivity(intent);
                }
            }
        });


    }

}