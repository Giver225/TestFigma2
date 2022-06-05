package com.example.testfigma2;

import org.json.JSONException;
import org.json.JSONObject;

public class RESTapi {
    public String urlWww = "http://942c-188-126-60-135.ngrok.io/api/accounts/0";


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
