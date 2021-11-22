package com.example.corona19app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class vaccine extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccine);


        Button bt3 = (Button)findViewById(R.id.button2);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), residual_vaccine.class);
                startActivity(intent);
            }
        });
        Button bt2= (Button)findViewById(R.id.button);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), vaccine_type.class);
                startActivity(intent);
            }
        });

    }
}
