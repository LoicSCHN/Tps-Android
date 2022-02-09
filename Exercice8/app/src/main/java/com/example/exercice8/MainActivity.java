package com.example.exercice8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Voyage[] voyages;
    Voyage[] voy;
    ArrayList<Voyage> VoyageList;
    ArrayAdapter<Voyage> arrayAdapter;
    EditText villeDepart;
    EditText villeArrivee;
    ListView listView;

    Voyage v1 = new Voyage("Montpellier", "Valence", "08H30");
    Voyage v2 = new Voyage("Montpellier", "Valence", "09H30");
    Voyage v3 = new Voyage("Montpellier", "Valence", "10H30");
    Voyage v4 = new Voyage("Montpellier", "Valence", "11H30");
    Voyage v5 = new Voyage("Montpellier", "Valence", "12H30");
    Voyage v6 = new Voyage("Montpellier", "Valence", "14H30");
    Voyage v7 = new Voyage("Montpellier", "Valence", "15H30");

    Voyage v8 = new Voyage("Mulhouse", "Paris", "08H30");
    Voyage v9 = new Voyage("Montpellier", "Paris", "09H30");
    Voyage v10 = new Voyage("Montpellier", "Paris", "10H30");
    Voyage v11 = new Voyage("Montpellier", "Marseille", "11H30");
    Voyage v12 = new Voyage("Montpellier", "Dijon", "12H30");
    Voyage v13 = new Voyage("Montpellier", "Paris", "14H30");
    Voyage v14 = new Voyage("Montpellier", "Paris", "15H30");

    Voyage v15 = new Voyage("Annecy", "Grenoble", "08H30");
    Voyage v16 = new Voyage("Annecy", "Grenoble", "09H30");
    Voyage v17 = new Voyage("Annecy", "Grenoble", "10H30");
    Voyage v18 = new Voyage("Annemasse", "Grenoble", "11H30");
    Voyage v19 = new Voyage("Chambéry", "Grenoble", "12H30");
    Voyage v20 = new Voyage("Annecy", "Grenoble", "14H30");
    Voyage v21 = new Voyage("Annecy", "Grenoble", "15H30");

    private ArrayList<String> trajet = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        villeDepart = findViewById(R.id.villeDepart);
        villeArrivee = findViewById(R.id.villeArrivee);
        listView = (ListView)findViewById(R.id.listeVoyage);
        initList();

        villeDepart.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                initList();
                if (s.toString().equals("") && villeArrivee.getText().toString().equals("")){
                    initList();
                }else{
                    searchTravel(s.toString());
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        villeArrivee.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                initList();
                if (s.toString().equals("") && villeDepart.getText().toString().equals("")){
                    initList();
                }else{
                    searchTravel(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void initList() {

        voyages = new Voyage[]{};
        voy = new Voyage[]{v1, v2, v3, v4,v5,v6,v7,v8,v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21};
        VoyageList = new ArrayList<Voyage>(Arrays.asList(voyages));
        arrayAdapter = new ArrayAdapter<Voyage>(this, R.layout.list_voyage,R.id.voyage_txt , VoyageList);
        listView.setAdapter(arrayAdapter);
    }

    public void searchTravel(String text){
        for(Voyage v:voy){
            if (v.getVilleDepart().toString().contains(villeDepart.getText().toString()) && v.getVilleArrivée().toString().contains(villeArrivee.getText().toString()) && !VoyageList.contains(v)){
                VoyageList.add(v);
            }
        }

        arrayAdapter.notifyDataSetChanged();
    }
}