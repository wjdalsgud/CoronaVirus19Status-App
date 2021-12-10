package com.example.coronastatusapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vaccine_type extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccine_type);

        Button bt2= (Button)findViewById(R.id.Pfizer_Button);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), vaccine_explain.class);
                startActivity(intent);
            }
        });
        Button bt3= (Button)findViewById(R.id.Moderna_button);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), vaccine_explain1.class);
                startActivity(intent);
            }
        });

        Button bt4= (Button)findViewById(R.id.Janssen_button);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), vaccine_explain2.class);
                startActivity(intent);
            }
        });

        Button bt5= (Button)findViewById(R.id.Astrazeneca_button);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), vaccine_explain3.class);
                startActivity(intent);
            }
        });
    }
}
