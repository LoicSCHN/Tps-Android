package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Exos extends AppCompatActivity {
    TextView titreExo;
    String exo;

    TextView capteur1;
    TextView capteur2;
    TextView capteur3;

    private SensorManager sensorManager;
    List<Sensor> sensorsList;
    ListView listSensor;
    LinearLayout layout;
    ArrayAdapter<Sensor> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exos);


        titreExo = new TextView(this);
        final Intent intent = getIntent();
        //exo = intent.getStringExtra(MainActivity.MESSAGE_EXO);
        titreExo.setText("Exercice 1");
        titreExo.setPadding(10,10,10,10);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorsList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(titreExo);

        switch (exo.toString()){
            case "Exercice 1":
                exO1();
                break;
            case "Exercice 2":
                exO2();
                break;
            case "Exercice 3":
                exO3();
                break;
            case "Exercice 4":
                exO4();
                break;
            case "Exercice 5":
                exO5();
                break;
            case "Exercice 6":
                exO6();
                break;
            case "Exercice 7":
                exO7();
                break;
        }

    }

    private void exO1() {
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
    private void exO2() {

         capteur1 = new TextView(this);
         capteur2 = new TextView(this);
         capteur3 = new TextView(this);

        layout.addView(capteur1);
        layout.addView(capteur2);
        layout.addView(capteur2);
        setContentView(layout);

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
    private void exO3() {
        setContentView(layout);
    }
    private void exO4() {
        setContentView(layout);
    }
    private void exO5() {
        setContentView(layout);
    }
    private void exO6() {
        setContentView(layout);
    }
    private void exO7() {
        setContentView(layout);
    }
}