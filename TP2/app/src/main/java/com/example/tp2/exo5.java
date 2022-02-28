package com.example.tp2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;

public class exo5 extends AppCompatActivity {

    boolean on = false;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            CameraManager mCameraManager;
            String mCameraId = null;


            mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

            try {
                mCameraId = mCameraManager.getCameraIdList()[0];
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }


            String finalMCameraId = mCameraId;
            SensorEventListener listener = new SensorEventListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onSensorChanged(SensorEvent event) {
                    float xValue = event.values[0];
                    float yValue = event.values[1];
                    float zValue = event.values[2];
                    if (Math.abs(xValue) > 15 | Math.abs(zValue) > 15| Math.abs(yValue) >15 ) {
                        if(on){
                            try {
                                mCameraManager.setTorchMode(finalMCameraId, false);
                                on = false;
                            } catch (CameraAccessException e) {
                                e.printStackTrace();
                            }
                        }else{
                            try {
                                mCameraManager.setTorchMode(finalMCameraId, true);
                                on = true;
                            } catch (CameraAccessException e) {
                                e.printStackTrace();
                            }
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