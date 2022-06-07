package com.example.testfigma2;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@RequiresApi(api = Build.VERSION_CODES.O)
public class RESTapi {
    
    public String urlWww = "http://4ced-188-126-60-135.ngrok.io/api/accounts/0";


    public String getUrlWww(){
        return this.urlWww;
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
}
