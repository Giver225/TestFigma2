package com.example.testfigma2;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class ProfileActivity extends AppCompatActivity{
    FragmentManager fragmentManager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle arguments = getIntent().getExtras();
        String login = arguments.get("login").toString();
//        TODO: загрузить данные в профиль
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        fragmentManager.beginTransaction()
                .add(R.id.profile_frame, fragment_data.class, null)
                .setReorderingAllowed(true)
                .commit();
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

}