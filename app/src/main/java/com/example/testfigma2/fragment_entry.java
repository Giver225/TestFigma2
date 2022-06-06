package com.example.testfigma2;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import org.reactivestreams.Subscription;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.O)
public class fragment_entry extends ListFragment {
    String data[] = new String[] { "лул", "two", "three", "four" };
    ArrayList<State> states = new ArrayList<State>();
    RESTapi resTapi = new RESTapi();
    boolean kostil = true;
    public String urlWww = resTapi.getUrlWww();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_entry, null);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1, data);
        setInitialData();
        while (kostil){
            Log.i("wait_kostil", "kostiiiiiiiiiil");
        }
        StateAdapter stateAdapter = new StateAdapter(getActivity(), R.layout.list_item, states);
        setListAdapter(stateAdapter);


    }
    private void setInitialData(){

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // Create URL
                // Create connection
                try {
                    ProfileActivity activity = (ProfileActivity) getActivity();
                    urlWww = urlWww.substring(0, urlWww.length() - 10);
                    assert activity != null;
                    if (activity.getStatus().equals("admin")){
                        urlWww = urlWww + "entry/" + "0";
                    } else {
                        urlWww = urlWww + "entry/" + activity.getName();
                    }

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
                    Log.i("POZHALYUSTA", jsonReader.toString());
                    jsonReader.beginArray(); // Start processing the JSON object
                    while (jsonReader.hasNext()) { // Loop through all keys
                        Log.i("YA_V_CIKLE", states.toString());
                        states.add(readMessage(jsonReader));
                    }
                    jsonReader.endArray();


                } catch (IOException e) {
                    Log.i("PROSHELGOVNO", "2222222222222222222222222222");
                    e.printStackTrace();
                }
                Log.i("PROSHELGOVNO", "333333333333333333333333333333333333333");
                kostil = false;
                }

        });

    }


    public State readMessage(JsonReader reader) throws IOException {
        String patient = null;
        String doctor = null;
        String time = null;
        reader.beginObject();
        while (reader.hasNext()){
            String key = reader.nextName(); // Fetch the next key
            switch (key){
                case ("doctor"):
                    doctor = reader.nextString();
                    break;
                case ("patient"):
                    patient = reader.nextString();
                    break;
                case ("time"):
                    time = reader.nextString();
                    break;
                default:
                    reader.skipValue();
            }
        }
        reader.endObject();
        return new State(patient, doctor, time);
    }
}
