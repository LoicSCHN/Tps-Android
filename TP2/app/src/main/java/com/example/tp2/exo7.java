package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class exo7 extends AppCompatActivity {
    LocationManager locationManager = null;
    TextView Tfournisseur;
    TextView Tlocalisation;
    TextView Tcoordonnees;
    TextView Tautres;
    TextView Tgps;

    private String fournisseur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo7);
        Tfournisseur = findViewById(R.id.fournisseur);
        Tlocalisation = findViewById(R.id.localisation);
        Tcoordonnees = findViewById(R.id.coordonees);
        Tautres = findViewById(R.id.autres);
        Tgps = findViewById(R.id.gps);

        if(locationManager == null)
        {
            locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            Criteria criteres = new Criteria();

            // la précision  : (ACCURACY_FINE pour une haute précision ou ACCURACY_COARSE pour une moins bonne précision)
            criteres.setAccuracy(Criteria.ACCURACY_FINE);

            // l'altitude
            criteres.setAltitudeRequired(true);

            // la direction
            criteres.setBearingRequired(true);

            // la vitesse
            criteres.setSpeedRequired(true);

            // la consommation d'énergie demandée
            criteres.setCostAllowed(true);
            criteres.setPowerRequirement(Criteria.POWER_HIGH);

            fournisseur = locationManager.getBestProvider(criteres, true);
            //Log.d("GPS", "fournisseur : " + fournisseur);
            Tfournisseur.setText("fournisseur : " + fournisseur);
        }

        if(fournisseur != null)
        {
            // dernière position connue
            @SuppressLint("MissingPermission") Location localisation = locationManager.getLastKnownLocation(fournisseur);
            Tlocalisation.setText("localisation : " + localisation.toString());
            //Log.d("GPS", "localisation : " + localisation.toString());
            String coordonnees = String.format("Latitude : %f - Longitude : %f\n", localisation.getLatitude(), localisation.getLongitude());
            Tcoordonnees.setText("coordonnees : " + coordonnees);
            //Log.d("GPS", "coordonnees : " + coordonnees);
            String autres = String.format("Vitesse : %f - Altitude : %f - Cap : %f\n", localisation.getSpeed(), localisation.getAltitude(), localisation.getBearing());
            Tautres.setText(autres);
            //Log.d("GPS", autres);
            //String timestamp = String.format("Timestamp : %d\n", localisation.getTime());
            //Log.d("GPS", "timestamp : " + timestamp);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date(localisation.getTime());
            Tgps.setText(sdf.format(date));
            //Log.d("GPS", sdf.format(date));
        }
    }
}