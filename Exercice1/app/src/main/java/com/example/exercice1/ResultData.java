package com.example.exercice1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

public class ResultData extends Fragment {

    TextView name, surname, date, email;
    CheckBox sport, music, reading, videogames;
    Button submit, ret;

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
        ret = (Button)rootLayout.findViewById(R.id.button3);


        assert this.getArguments() != null;
        String form =this.getArguments().getString("Form");
        DataForm f = new Gson().fromJson(form, DataForm.class) ;

        name.setText(f.getName());
        surname.setText(f.getSurname());
        date.setText(f.getDate());
        email.setText(f.getEmail());
        sport.setChecked(f.isSport());
        music.setChecked(f.isMusic());
        reading.setChecked(f.isReading());
        videogames.setChecked(f.isVideogames());

        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Form", new Gson().toJson(f));

                assert getFragmentManager() != null;
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                UserData fragment  = new UserData();
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentContainerView , fragment);
                fragmentTransaction.commit();
            }
        });

        return rootLayout;
    }
}