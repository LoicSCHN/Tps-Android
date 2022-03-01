package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String MESSAGE_EXO = "message_exo";
    Button exo1;
    Button exo2;
    Button exo3;
    Button exo4;
    Button exo5;
    Button exo6;
    Button exo7;
    Button exos[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exo1 = findViewById(R.id.exo1);
        exo2 = findViewById(R.id.exo2);
        exo3 = findViewById(R.id.exo3);
        exo4 = findViewById(R.id.exo4);
        exo5 = findViewById(R.id.exo5);
        exo6 = findViewById(R.id.exo6);
        exo7 = findViewById(R.id.exo7);
        exos = new Button[]{exo1, exo2 , exo3, exo4, exo5, exo6, exo7};

        exo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MainActivity.this, exo1.class);
                startActivity(i1);
            }
        });

        exo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this, exo2.class);
                startActivity(i2);
            }
        });

        exo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(MainActivity.this, exo3.class);
                startActivity(i3);
            }
        });

        exo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(MainActivity.this, exo4.class);
                startActivity(i4);
            }
        });

        exo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5 = new Intent(MainActivity.this, exo5.class);
                startActivity(i5);
            }
        });

        exo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i7 = new Intent(MainActivity.this, exo7.class);
                startActivity(i7);
            }
        });

    }


}