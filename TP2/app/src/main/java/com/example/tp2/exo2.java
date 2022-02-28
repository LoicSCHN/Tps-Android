package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class exo2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo2);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        TextView capteur1 = findViewById(R.id.capteur1);
        TextView capteur2 = findViewById(R.id.capteur2);
        TextView capteur3 = findViewById(R.id.capteur3);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_HEART_BEAT) != null){
            capteur1.setText("le Capteur de fréquence cardiaque est présent");
            capteur1.setBackgroundColor(Color.GREEN);

        }else{
            capteur1.setText("le Capteur de fréquence cardiaque n'est pas présent");
            capteur1.setBackgroundColor(Color.RED);

        }

        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            capteur2.setText("le Capteur d'accélération est présent");
            capteur2.setBackgroundColor(Color.GREEN);

        }else{
            capteur2.setText("le Capteur d'accélération n'est pas présent");
            capteur2.setBackgroundColor(Color.RED);

        }

        if(sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY) != null){
            capteur3.setText("le Capteur de gravité est présent");
            capteur3.setBackgroundColor(Color.GREEN);

        }else{
            capteur3.setText("le Capteur de gravité n'est pas présent");
            capteur3.setBackgroundColor(Color.RED);

        }
    }
}