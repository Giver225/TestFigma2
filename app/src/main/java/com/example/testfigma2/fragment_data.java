package com.example.testfigma2;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

public class fragment_data extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_data, container, false);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ProfileActivity activity = (ProfileActivity) getActivity();
        TextView login = (TextView) getView().findViewById(R.id.login_enter);
        TextView phone = (TextView) getView().findViewById(R.id.phone_enter);
        TextView male = (TextView) getView().findViewById(R.id.male_enter);
        TextView date_of_birth = (TextView) getView().findViewById(R.id.date_enter);
        TextView email = (TextView) getView().findViewById(R.id.email_enter);

// загружаем текст
        login.setText(activity.getLogin());
        phone.setText(activity.getPhone());
        male.setText(activity.getMale());
        date_of_birth.setText(activity.getDate_of_birth());
        email.setText(activity.getEmail());
        super.onViewCreated(view, savedInstanceState);
    }
}