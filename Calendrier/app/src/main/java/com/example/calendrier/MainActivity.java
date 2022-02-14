package com.example.calendrier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Evenement[] voyages;
    Evenement[] voy;
    ArrayList<Evenement> VoyageList;
    ArrayAdapter<Evenement> arrayAdapter;
    //Essayer de faire avec une message box comme début du tp


    CalendarView cal;
    TextView text;
    String day;
    Button addEvent;
    public final static String MESSAGE_JOUR = "message_jour";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createEvent();
        cal = findViewById(R.id.calendarView);

        //J'affiche le jour sélectionné dans le calendrier
        text = findViewById(R.id.textTest);
        Calendar calendrier = Calendar.getInstance( );  // date du jour
        text.setText (text.getText().toString()+" " +calendrier.get(Calendar.DAY_OF_MONTH) + "/" +(calendrier.get(Calendar.MONTH)+1) + "/" + calendrier.get(Calendar.YEAR));
        day = calendrier.get(Calendar.DAY_OF_MONTH) + "/" +(calendrier.get(Calendar.MONTH)+1) + "/" + calendrier.get(Calendar.YEAR);

        addEvent = findViewById(R.id.addEventButton);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this, MainActivity2.class);
                i1.putExtra(MESSAGE_JOUR, day);
                startActivity(i1);
            }
        });

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                //Je change l'affichage du jour selectionné
                text.setText("Evenement(s) du : "+ i2 + "/"+ (i1+1) + "/" + i);
                day = i2 + "/"+ (i1+1) + "/" + i;
            }
        });




    }


    public void  createEvent(){
        //Evenement e1 = new Evenement("Faire les courses", )
    }
}