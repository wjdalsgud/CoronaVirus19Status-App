package com.example.corona19app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corona_main);

        Button loginBt4 = (Button)findViewById(R.id.socialbutton);
        loginBt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), social_distancing.class);
                startActivity(intent);
            }
        });

        Button vaccinebutton = (Button)findViewById(R.id.vaccinebutton);
        vaccinebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), vaccine.class);
                startActivity(intent);
            }
        });

        Button button4 = (Button)findViewById(R.id.button5);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), corona_state.class);
                startActivity(intent);
            }
        });
    }
