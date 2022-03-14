package com.example.exercice1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class UserData extends Fragment {

    EditText name, surname, date, email;
    CheckBox sport, music, reading, videogames;
    Button submit;

    public UserData() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootLayout =  inflater.inflate(R.layout.fragment_user_data, container, false);

        name = (EditText)rootLayout.findViewById(R.id.editTextTextPersonName);
        surname = (EditText)rootLayout.findViewById(R.id.editTextTextPersonName3);
        date = (EditText)rootLayout.findViewById(R.id.editTextDate);
        email = (EditText)rootLayout.findViewById(R.id.editTextTextEmailAddress);
        sport = (CheckBox)rootLayout.findViewById(R.id.checkBox);
        music = (CheckBox)rootLayout.findViewById(R.id.checkBox2);
        reading = (CheckBox)rootLayout.findViewById(R.id.checkBox3);
        videogames = (CheckBox)rootLayout.findViewById(R.id.checkBox4);
        submit = (Button)rootLayout.findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                DataForm f = new DataForm(name.getText().toString(),
                        surname.getText().toString(),
                        date.getText().toString(),
                        email.getText().toString(),
                        sport.isChecked(),
                        music.isChecked(),
                        reading.isChecked(),
                        videogames.isChecked());

                bundle.putParcelable("Form", f);

                assert getFragmentManager() != null;
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                ResultData fragment  = new ResultData();
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentContainerView , fragment);
                fragmentTransaction.commit();
            }
        });
        return rootLayout;
    }
}