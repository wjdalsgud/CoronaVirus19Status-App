package com.example.coronastatusapp;


import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corona_main);



        Button loginBt4 = (Button) findViewById(R.id.social_distancing_button);
        loginBt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), social_distancing.class);
                startActivity(intent);
            }
        });

        Button vaccinebutton1 = (Button) findViewById(R.id.vaccine_button);
        vaccinebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), vaccine.class);
                startActivity(intent);
            }
        });

        Button button4 = (Button) findViewById(R.id.corona_state_button);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), corona_state.class);
                startActivity(intent);
            }
        });
    }
}
