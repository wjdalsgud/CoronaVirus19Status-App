package com.example.coronavirus19status_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class vaccine_type extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccine_type); //백신 종류 화면 출력
// 화이자 버튼 클릭시 화이자 화면으로 이동
        Button pfizer= (Button)findViewById(R.id.Pfizer_Button);
        pfizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), vaccine_explain.class);
                startActivity(intent);
            }
        });
        //모더나 버튼 클릭시 모더나 화면으로 이동
        Button moderna= (Button)findViewById(R.id.Moderna_button);
        moderna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), vaccine_explain1.class);
                startActivity(intent);
            }
        });
//얀센 버튼 클릭시 얀센 화면으로 이동
        Button janssen= (Button)findViewById(R.id.Janssen_button);
        janssen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), vaccine_explain2.class);
                startActivity(intent);
            }
        });
//아스트라제네카 버튼 클릭 시 아스트라제네카 화면으로 이동
        Button astra= (Button)findViewById(R.id.Astrazeneca_button);
        astra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), vaccine_explain3.class);
                startActivity(intent);
            }
        });
//하단 메뉴바 동작 기능
        BottomNavigationView bottom_menu = findViewById(R.id.bottom_menu);
        bottom_menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.first_Tab:
                        onBackPressed();
                        return true;
                    case R.id.second_Tab:
                        intent = new Intent(getApplicationContext(), MainPage.class);
                        startActivity(intent);
                        return true;
                    case R.id.third_Tab:
                        intent = new Intent(getApplicationContext(), city.class);
                        startActivity(intent);
                        return true;
                    case R.id.fourth_Tab:
                        intent = new Intent(getApplicationContext(), vaccine.class);
                        startActivity(intent);
                        return true;
                    case R.id.fifth_Tab:
                        intent = new Intent(getApplicationContext(), corona_state.class);
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });
    }
}
