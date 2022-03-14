package com.example.exercice1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultData extends Fragment {

    TextView name, surname, date, email;
    CheckBox sport, music, reading, videogames;
    Button submit;

    public ResultData() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootLayout =  inflater.inflate(R.layout.fragment_result_data, container, false);

        name = (TextView) rootLayout.findViewById(R.id.textView);
        surname = (TextView) rootLayout.findViewById(R.id.textView2);
        date = (TextView) rootLayout.findViewById(R.id.textView3);
        email = (TextView) rootLayout.findViewById(R.id.textView4);
        sport = (CheckBox)rootLayout.findViewById(R.id.checkBox5);
        music = (CheckBox)rootLayout.findViewById(R.id.checkBox6);
        reading = (CheckBox)rootLayout.findViewById(R.id.checkBox7);
        videogames = (CheckBox)rootLayout.findViewById(R.id.checkBox8);
        submit = (Button)rootLayout.findViewById(R.id.button2);

        assert this.getArguments() != null;
        DataForm form =this.getArguments().getParcelable("Form");

        name.setText(form.getName());
        surname.setText(form.getSurname());
        date.setText(form.getDate());
        email.setText(form.getEmail());
        sport.setChecked(form.isSport());
        music.setChecked(form.isMusic());
        reading.setChecked(form.isReading());
        videogames.setChecked(form.isVideogames());

        return rootLayout;
    }
}