package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class exo1 extends AppCompatActivity {
    TextView titreExo;
    String exo;

    private SensorManager sensorManager;
    List<Sensor> sensorsList;
    ListView listSensor;
    LinearLayout layout;
    ArrayAdapter<Sensor> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exo1);

        titreExo = new TextView(this);
        final Intent intent = getIntent();

        titreExo.setText("Exercice 1");
        titreExo.setPadding(10,10,10,10);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorsList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(titreExo);
        listSensor = new ListView(this);
        layout.addView(listSensor);

        setContentView(layout);


        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuffer sensorDesc = new StringBuffer();

        for (Sensor sensor : sensors) {
            sensorDesc.append("New sensor detected : \r\n");
            sensorDesc.append("\tName: " + sensor.getName() + "\r\n");
            sensorDesc.append("\tType: " + sensor.getType() + "\r\n");
            sensorDesc.append("Version: " + sensor.getVersion() + "\r\n");
            sensorDesc.append("Resolution (in the sensor unit): " +
                    sensor.getResolution() + "\r\n");
            sensorDesc.append("Power in mA used by this sensor while in use" +
                    sensor.getPower() +"\r\n");
            sensorDesc.append("Vendor: " + sensor.getVendor() + "\r\n");
            sensorDesc.append("Maximum range of the sensor in the sensor's unit." +
                    sensor.getMaximumRange() + "\r\n");
            sensorDesc.append("Minimum delay allowed between two events in microsecond " + " or zero if this sensor only returns a value when the data it's measuring changes " +
                    sensor.getMinDelay() + "\r\n");
        }


        arrayAdapter = new ArrayAdapter<Sensor>(this, R.layout.list_sensor,R.id.sensor_txt , sensors);
        listSensor.setAdapter(arrayAdapter);
    }
}