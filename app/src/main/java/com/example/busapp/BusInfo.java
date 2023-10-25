package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BusInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_info);
        Button buttonPage1 = findViewById(R.id.bus1);
        Button buttonPage3 = findViewById(R.id.bus3);
        Button buttonPage4 = findViewById(R.id.bus4);
        Button buttonPage5 = findViewById(R.id.bus5);
        Button buttonPage6 = findViewById(R.id.bus6);
        Button buttonPage7 = findViewById(R.id.bus7);
        Button buttonPage10= findViewById(R.id.bus10);
        Button buttonPage8 = findViewById(R.id.nextin);
        Button buttonPag9 = findViewById(R.id.bus9);

        buttonPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusInfo.this, Busno1.class);
                startActivity(intent);
            }
        });

        buttonPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusInfo.this, Busno3.class);
                startActivity(intent);
            }
        });

        buttonPage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusInfo.this, Busno4.class);
                startActivity(intent);
            }
        });

        buttonPage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusInfo.this, Busno5.class);
                startActivity(intent);
            }
        });

        buttonPage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusInfo.this, Busno6.class);
                startActivity(intent);
            }
        });

        buttonPage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusInfo.this, Busno7.class);
                startActivity(intent);
            }
        });
        buttonPag9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusInfo.this, Busno9.class);
                startActivity(intent);
            }
        });
        buttonPage10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusInfo.this, Bus10.class);
                startActivity(intent);
            }
        });

        buttonPage8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusInfo.this, Businfo2.class);
                startActivity(intent);
            }
        });

    }
}