package com.example.testfigma2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StateAdapter extends ArrayAdapter<State> {

    private LayoutInflater inflater;
    private int layout;
    private List<State> states;

    public StateAdapter(Context context, int resource, List<State> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView doctorView = view.findViewById(R.id.doctor_enter);
        TextView patientView = view.findViewById(R.id.patient_enter);
        TextView timeView = view.findViewById(R.id.time_enter);

        State state = states.get(position);

        doctorView.setText(state.getState_doctor());
        patientView.setText(state.getState_patient());
        timeView.setText(state.getState_time());

        return view;
    }
}