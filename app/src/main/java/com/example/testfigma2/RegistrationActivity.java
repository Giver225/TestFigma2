package com.example.testfigma2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import javax.net.ssl.HttpsURLConnection;

public class RegistrationActivity extends AppCompatActivity{

    public String urlWww = RESTapi.class.newInstance().urlWww;

    public RegistrationActivity() throws IllegalAccessException, InstantiationException {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
    }
    public String getJSON(String login,
                          String password,
                          String name, String status,
                          String phone, String male,
                          String date, String email) // получаем json объект в виде строки
    {
        JSONObject bot = new JSONObject();
        try {
            bot.put("login", login);
            bot.put("password", password);
            bot.put("name", name);
            bot.put("status", status);
            bot.put("phone", phone);
            bot.put("male", male);
            bot.put("date", date);
            bot.put("email", email);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bot.toString();
    }
    public void registration_post(View v){
        EditText login = findViewById(R.id.edit_login);
        EditText password = findViewById(R.id.edit_password);
        EditText email = findViewById(R.id.edit_email);
        EditText name = findViewById(R.id.name);
        EditText date = findViewById(R.id.date);
        EditText male = findViewById(R.id.male);
        EditText phone = findViewById(R.id.phone);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // Create URL
                // Create connection
                try {
                    URL Endpoint = new URL(urlWww);
                    HttpURLConnection myConnection =  (HttpURLConnection) Endpoint.openConnection();

                    // Enable writing
                    myConnection.setDoOutput(true);
                    myConnection.setRequestMethod("POST");
                    myConnection.setRequestProperty("Content-Type", "application/json");
                    myConnection.setRequestProperty("Accept", "application/json");
                    String jsonInputString = getJSON(login.getText().toString(), password.getText().toString(), name.getText().toString(), "patient", phone.getText().toString(), male.getText().toString(), date.getText().toString(), email.getText().toString());
                    try(OutputStream os = myConnection.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes("utf-8");
                        os.write(input, 0, input.length);
                    }
                    InputStream responseBody = myConnection.getInputStream();
                    InputStreamReader responseBodyReader =
                            new InputStreamReader(responseBody, "UTF-8");
                    JsonReader jsonReader = new JsonReader(responseBodyReader);
                    jsonReader.beginObject(); // Start processing the JSON object
                    while (jsonReader.hasNext()) { // Loop through all keys
                        String key = jsonReader.nextName(); // Fetch the next key
                        if (key.equals("login")) { // Check if desired key
                            // Fetch the value as a String
                            String login_str = jsonReader.nextString();

                            // Do something with the value
                            // ...

                            break; // Break out of the loop
                        } else {
                            jsonReader.skipValue(); // Skip values of other keys
                        }
                    }
                    if (myConnection.getResponseCode() == 200) {
                        // Success
                        // Further processing here
                        Log.i("123123", "Это мое сообщение для записи в журнале");
                    } else {
                        // Error handling code goes here
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("login", login.getText().toString());
        startActivity(intent);
    }
    public void goBack(View v){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }


}