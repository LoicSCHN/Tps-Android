package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class exo4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo4);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

        TextView textView = findViewById(R.id.direction);



        SensorEventListener listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float xValue = event.values[0];
                float zValue = event.values[2];
                if(Math.abs(xValue)>0.1 | Math.abs(zValue)> 0.1) {
                    if(Math.abs(zValue) > Math.abs(xValue)){
                        if (zValue > 0)
                            textView.setText("haut");
                        else
                            textView.setText("bas");

                    }else if(Math.abs(xValue) > Math.abs(zValue)){
                        if (xValue > 0)
                            textView.setText("droite");
                        else
                            textView.setText("gauche");

                    }

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }

        };
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }
}