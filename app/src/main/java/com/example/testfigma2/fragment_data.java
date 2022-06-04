package com.example.testfigma2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class fragment_data extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_data, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView text = (TextView) getView().findViewById(R.id.test_text);
// загружаем текст
        text.setText("здесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текстздесь должен быть длинный текст");
        super.onViewCreated(view, savedInstanceState);
    }
}