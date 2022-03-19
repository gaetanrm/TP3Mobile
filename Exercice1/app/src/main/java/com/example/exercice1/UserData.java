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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class UserData extends Fragment {

    EditText name, surname, date, email;
    CheckBox sport, music, reading, videogames;
    Button submit, download;

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
        download = (Button)rootLayout.findViewById(R.id.button4);

        /* //Exercice 2
           if (this.getArguments() != null){
            String form =this.getArguments().getString("Form");
            DataForm f = new Gson().fromJson(form, DataForm.class);

            name.setText(f.getName());
            surname.setText(f.getSurname());
            date.setText(f.getDate());
            email.setText(f.getEmail());
            sport.setChecked(f.isSport());
            music.setChecked(f.isMusic());
            reading.setChecked(f.isReading());
            videogames.setChecked(f.isVideogames());
        }*/

        //Si fichier fileName non vide : On récupère les infos dans le fichier.
            // Une fois fait on vide le fichier
        //Sinon : on récupère si il y en a, les infos dans le bundle
        File file = new File(getActivity().getFilesDir() + "/" + MainActivity.fileName);
        if(file.exists() && file.length() > 0){
            try {
                InputStream input= getActivity().openFileInput(MainActivity.fileName);

                byte[] buffer = new byte[input.available()];
                input.read(buffer);
                input.close();

                String text = new String(buffer);
                DataForm f = new Gson().fromJson(text, DataForm.class);

                name.setText(f.getName());
                surname.setText(f.getSurname());
                date.setText(f.getDate());
                email.setText(f.getEmail());
                sport.setChecked(f.isSport());
                music.setChecked(f.isMusic());
                reading.setChecked(f.isReading());
                videogames.setChecked(f.isVideogames());

                getActivity().openFileOutput(MainActivity.fileName,0).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            if (this.getArguments() != null) {
                String form = this.getArguments().getString("Form");
                DataForm f = new Gson().fromJson(form, DataForm.class);

                name.setText(f.getName());
                surname.setText(f.getSurname());
                date.setText(f.getDate());
                email.setText(f.getEmail());
                sport.setChecked(f.isSport());
                music.setChecked(f.isMusic());
                reading.setChecked(f.isReading());
                videogames.setChecked(f.isVideogames());
            }
        }
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

                bundle.putString("Form", new Gson().toJson(f));

                assert getFragmentManager() != null;
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                ResultData fragment  = new ResultData();
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentContainerView , fragment);
                fragmentTransaction.commit();
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="http://192.168.0.13:8888/form/_id/6231f282cdbb5e37f295acad";
                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Gson gson = new Gson(); //Create a Gson object
                                DataForm f = gson.fromJson(response, DataForm.class);

                                Bundle bundle = new Bundle();
                                bundle.putString("Form", new Gson().toJson(f));

                                assert getFragmentManager() != null;
                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                ResultData fragment  = new ResultData();
                                fragment.setArguments(bundle);
                                fragmentTransaction.replace(R.id.fragmentContainerView , fragment);
                                fragmentTransaction.commit();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
            }
        });
        return rootLayout;
    }
}