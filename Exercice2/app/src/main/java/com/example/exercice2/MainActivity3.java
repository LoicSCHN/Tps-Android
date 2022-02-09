package com.example.exercice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView TextTel = findViewById(R.id.AffichageTel2);

        final Intent intent = getIntent();
        String tel = intent.getStringExtra(MainActivity.MESSAGE_TEL);

        TextTel.setText(tel);


        ((Button) findViewById(R.id.appeler))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent call = new Intent(Intent.ACTION_CALL);
                        call.setData(Uri.parse("tel:"+tel));
                        startActivity(call);
                    }
                });
    }
}