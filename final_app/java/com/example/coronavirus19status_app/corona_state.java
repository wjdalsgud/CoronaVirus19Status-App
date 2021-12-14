package com.example.coronavirus19status_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class corona_state extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corona_state); //코로나 현황 화면 

        String pas = "";
        int creatStart;
        int creatEnd;
//MainActivty에서 파싱한 코로나 API 정보값을 해당 텍스트에 출력 
        TextView Accumulated_confirmed_API = (TextView) findViewById(R.id.Accumulated_confirmed_API);
        pas = ((MainActivity)MainActivity.mContext).getAccumulated_confirmed_API();
        Accumulated_confirmed_API.setText(pas);
//MainActivty에서 파싱한 코로나 API 정보값을 해당 텍스트에 출력 
        TextView Accumulated_exam_API = (TextView) findViewById(R.id.Accumulated_exam_API);
        Accumulated_exam_API.setText(((MainActivity)MainActivity.mContext).getAccumulated_exam_API());
//MainActivty에서 파싱한 코로나 API 정보값을 해당 텍스트에 출력 
        TextView daily_confirmed_API = (TextView) findViewById(R.id.daily_confirmed_API);
        daily_confirmed_API.setText(((MainActivity)MainActivity.mContext).getDaily_confirmed_API());
//MainActivty에서 파싱한 코로나 API 정보값을 해당 텍스트에 출력 
        TextView daily_exam_API = (TextView) findViewById(R.id.daily_exam_API);
        daily_exam_API.setText(((MainActivity)MainActivity.mContext).getDaily_exam_API());
//MainActivty에서 파싱한 코로나 API 정보값을 해당 텍스트에 출력 
        TextView Accumulated_isolation_API = (TextView) findViewById(R.id.Accumulated_isolation_API);
        Accumulated_isolation_API.setText(((MainActivity)MainActivity.mContext).getAccumulated_isolation_string());
//MainActivty에서 파싱한 코로나 API 정보값을 해당 텍스트에 출력 
        TextView Accumulated_dead_API = (TextView) findViewById(R.id.Accumulated_dead_API);
        Accumulated_dead_API.setText(((MainActivity)MainActivity.mContext).getAccumulated_dead_API());
//MainActivty에서 파싱한 코로나 API 정보값을 해당 텍스트에 출력 
        TextView daily_isolation_API = (TextView) findViewById(R.id.daily_isolation_API);
        daily_isolation_API.setText(((MainActivity)MainActivity.mContext).getDaily_accumulated_isolation_string());
//MainActivty에서 파싱한 코로나 API 정보값을 해당 텍스트에 출력 
        TextView daily_dead_API = (TextView) findViewById(R.id.daily_dead_API);
        daily_dead_API.setText(((MainActivity)MainActivity.mContext).getDaily_dead_API());

        BottomNavigationView bottom_menu = findViewById(R.id.bottom_menu);
        bottom_menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {// 하단 메뉴 바 동작 기능
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
                        return true;
                }
                return false;
            }
        });

    }
}
