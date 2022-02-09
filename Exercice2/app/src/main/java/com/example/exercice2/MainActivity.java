package com.example.exercice2;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String MESSAGE_PRENOM = "message_prenom";
    public final static String MESSAGE_NOM = "message_nom";
    public final static String MESSAGE_SKILLS = "message_skills";
    public final static String MESSAGE_AGE = "message_age";
    public final static String MESSAGE_TEL = "message_tel";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.button)).
                setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(MainActivity.this, "Et c'est validé !", Toast.LENGTH_LONG).show();
                        new AlertDialog.Builder(v.getContext())
                                .setTitle("Validation de la saisie")
                                .setMessage("Valider")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        EditText editPrenom = findViewById(R.id.prenom);
                                        EditText editNom = findViewById(R.id.nom);
                                        EditText editSkills = findViewById(R.id.skills);
                                        EditText editAge = findViewById(R.id.age);
                                        EditText editTel = findViewById(R.id.tel);

                                         Intent i1 = new Intent(MainActivity.this, MainActivity2.class);

                                         i1.putExtra(MESSAGE_PRENOM, editPrenom.getText().toString());
                                         i1.putExtra(MESSAGE_NOM, editNom.getText().toString());
                                         i1.putExtra(MESSAGE_SKILLS, editSkills.getText().toString());
                                         i1.putExtra(MESSAGE_AGE, editAge.getText().toString());
                                         i1.putExtra(MESSAGE_TEL, editTel.getText().toString());

                                         startActivity(i1);
                                    }
                                })
                                .setNegativeButton(android.R.string.no, null)
                                .show();

                    }
                });
    }
}