package com.example.coronastatusapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class city extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city);

        Button seoul_button = (Button) findViewById(R.id.Seoul_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Seoul.class);
                startActivity(intent);
            }
        });
        Button busan_button = (Button) findViewById(R.id.Busan_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Busan.class);
                startActivity(intent);
            }
        });
        Button ulsan_button = (Button) findViewById(R.id.Ulsan_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Ulsan.class);
                startActivity(intent);
            }
        });
        Button chungcheongbuk_button = (Button) findViewById(R.id.Chungcheongbuk_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ChungCheongBuk.class);
                startActivity(intent);
            }
        });
        Button chungcheongnam_button = (Button) findViewById(R.id.Chungcheongnam_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Chungcheongnam.class);
                startActivity(intent);
            }
        });
        Button daegu_button = (Button) findViewById(R.id.Daegu_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Daegu.class);
                startActivity(intent);
            }
        });
        Button daejeon_button = (Button) findViewById(R.id.Daejeon_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Daejeon.class);
                startActivity(intent);
            }
        });
        Button gangwon_button = (Button) findViewById(R.id.Gangwon_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Gangwon.class);
                startActivity(intent);
            }
        });
        Button gwangju_button = (Button) findViewById(R.id.Gwangju_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Gwangju.class);
                startActivity(intent);
            }
        });
        Button gyeonggi_button = (Button) findViewById(R.id.Gyeonggi_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Gyeonggi.class);
                startActivity(intent);
            }
        });
        Button gyeongsangnam_button = (Button) findViewById(R.id.Gyeongsangnam_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Gyeongsangnam.class);
                startActivity(intent);
            }
        });
        Button gyeongsangbuk_button = (Button) findViewById(R.id.Gyeongsangbuk_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Gyeongsangbuk.class);
                startActivity(intent);
            }
        });
        Button incheon_button = (Button) findViewById(R.id.Incheon_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Incheon.class);
                startActivity(intent);
            }
        });
        Button jeju_button = (Button) findViewById(R.id.Jeju_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Jeju.class);
                startActivity(intent);
            }
        });
        Button jeollabuk_button = (Button) findViewById(R.id.Jeollabuk_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Jeollabuk.class);
                startActivity(intent);
            }
        });
        Button jeollanam_button = (Button) findViewById(R.id.Jeollanam_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Jeollanam.class);
                startActivity(intent);
            }
        });
        Button sejong_button = (Button) findViewById(R.id.Sejong_button);
        seoul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Sejong.class);
                startActivity(intent);
            }
        });
    }
}
