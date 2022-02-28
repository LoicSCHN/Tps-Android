package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class exo3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo3);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);


        ConstraintLayout constraintLayout = findViewById(R.id.layoutApp);



        SensorEventListener listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float xValue = Math.abs(event.values[0]);
                float yValue = Math.abs(event.values[1]);
                float zValue = Math.abs(event.values[2]);

                if(xValue< 0.5 | yValue< 0.5| zValue< 0.5){
                    constraintLayout.setBackgroundColor(Color.GREEN);
                }else if(xValue < 2 | yValue< 2| zValue< 2){
                    constraintLayout.setBackgroundColor(Color.WHITE);
                }else if(xValue > 2 | yValue> 2| zValue> 2){
                    constraintLayout.setBackgroundColor(Color.RED);

                }


            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }

        };
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }
}