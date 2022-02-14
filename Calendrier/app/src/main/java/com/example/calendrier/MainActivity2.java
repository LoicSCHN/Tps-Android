package com.example.calendrier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button cancel;
    Button add;
    EditText heure;
    EditText titre;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cancel = findViewById(R.id.buttonCancel);
        add = findViewById(R.id.buttonAdd);
        heure = findViewById(R.id.heure);
        titre = findViewById(R.id.titre);
        date = findViewById(R.id.dateAffiche);


        final Intent intent = getIntent();
        String jour = intent.getStringExtra(MainActivity.MESSAGE_JOUR);
        date.setText(jour);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity2.this.finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity2.this.finish();
            }
        });



    }
}