package com.example.testfigma2;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import org.reactivestreams.Subscription;

import java.util.ArrayList;

public class fragment_entry extends ListFragment {
    String data[] = new String[] { "лул", "two", "three", "four" };
    ArrayList<State> states = new ArrayList<State>();
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
        StateAdapter stateAdapter = new StateAdapter(getActivity(), R.layout.list_item, states);
        setListAdapter(stateAdapter);
    }
    private void setInitialData(){

        states.add(new State ("Бразилия", "Бразилиа", "123"));
        states.add(new State ("Аргентина", "Буэнос-Айрес", "123"));
        states.add(new State ("Колумбия", "Богота", "123"));
        states.add(new State ("Уругвай", "Монтевидео", "123"));
        states.add(new State ("Чили", "Сантьяго", "123"));
    }
}
