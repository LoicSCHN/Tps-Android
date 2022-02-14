package com.example.exercice3javainterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    EditText name, lastName, age, phone, skills;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        name = new EditText(this);
        name.setHint("name");
        lastName = new EditText(this);
        lastName.setHint("lastName");
        age = new EditText(this);
        age.setHint("age");
        phone = new EditText(this);
        phone.setHint("phone");
        skills = new EditText(this);
        skills.setHint("skills");

        Button bouton = new Button(this);
        bouton.setText("OK");

        layout.addView(name);
        layout.addView(lastName);
        layout.addView(age);
        layout.addView(phone);
        layout.addView(skills);
        layout.addView(bouton);

        setContentView(layout);

    }
}