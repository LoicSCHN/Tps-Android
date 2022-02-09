package com.example.exercice2;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    public final static String MESSAGE_TEL = "message_tel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Intent intent = getIntent();
        String prenom = intent.getStringExtra(MainActivity.MESSAGE_PRENOM);
        String nom = intent.getStringExtra(MainActivity.MESSAGE_NOM);
        String skills = intent.getStringExtra(MainActivity.MESSAGE_SKILLS);
        String age = intent.getStringExtra(MainActivity.MESSAGE_AGE);
        String tel = intent.getStringExtra(MainActivity.MESSAGE_TEL);

        TextView TextPrenom = findViewById(R.id.affichagePrenom);
        TextView TextNom = findViewById(R.id.affichageNom);
        TextView TextSkills = findViewById(R.id.affichageSkills);
        TextView TextAge = findViewById(R.id.affichageAge);
        TextView TextTel = findViewById(R.id.affichageTel);

        TextPrenom.setText(prenom);
        TextNom.setText(nom);
        TextSkills.setText(skills);
        TextAge.setText(age);
        TextTel.setText(tel);

        ((Button) findViewById(R.id.BouttonRetour))
                .setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MainActivity2.this.finish();
                    }
                });

        ((Button) findViewById(R.id.BouttonOk))
                .setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        intent.putExtra(MESSAGE_TEL, tel);

                        startActivity(intent);
                    }
                });


    }
}