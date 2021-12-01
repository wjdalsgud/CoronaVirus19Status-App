package com.example.coronavirus19status_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import android.view.View;
import android.widget.EditText;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyyMMdd");
    final int CONN_TIME = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView dateText = (TextView) findViewById(R.id.dateText);
        TextView careText = (TextView) findViewById(R.id.careText);
        TextView deathText = (TextView) findViewById(R.id.deathText);
        TextView decideText = (TextView) findViewById(R.id.decideText);
        TextView examText = (TextView) findViewById(R.id.examText);
        TextView clearText = (TextView) findViewById(R.id.clearText);
        TextView accExamText = (TextView) findViewById(R.id.accExamText);
        TextView accExamCompText = (TextView) findViewById(R.id.accExamCompText);
        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new Thread() {
                        public void run() {
                            try {
                                String data = getHTML(); //데이터 불러오기

                                //날짜
                                int createStart = data.indexOf("<createDt>");
                                int createEnd = data.indexOf("</createDt>");
                                String createDt = data.substring(createStart,createEnd);
                                String createDtString = createDt.replace("<createDt>", "기준 날짜 = ");
                                dateText.setText(createDtString);

                                //치료중 인원
                                int careStart = data.indexOf("<careCnt>");
                                int careEnd = data.indexOf("</careCnt>");
                                String careCnt = data.substring(careStart,careEnd);
                                String careCntString = careCnt.replace("<careCnt>", "치료중 인원수 = ");
                                careText.setText(careCntString);

                                //사망자 인원
                                int deathStart = data.indexOf("<deathCnt>");
                                int deathEnd = data.indexOf("</deathCnt>");
                                String deathCnt = data.substring(deathStart,deathEnd);
                                String deathCntString = deathCnt.replace("<deathCnt>", "사망자 인원수 = ");
                                deathText.setText(deathCntString);

                                //확진자 인원
                                int decideStart = data.indexOf("<decideCnt>");
                                int decideEnd = data.indexOf("</decideCnt>");
                                String decideCnt = data.substring(decideStart,decideEnd);
                                String decideCntString = decideCnt.replace("<decideCnt>", "확진자 인원수 = ");
                                decideText.setText(decideCntString);

                                //검사 진행 인원
                                int examStart = data.indexOf("<examCnt>");
                                int examEnd = data.indexOf("</examCnt>");
                                String examCnt = data.substring(examStart,examEnd);
                                String examCntString = examCnt.replace("<examCnt>", "검사진행 인원수 = ");
                                examText.setText(examCntString);

                                //격리해제(완치자) 인원
                                int clearStart = data.indexOf("<clearCnt>");
                                int clearEnd = data.indexOf("</clearCnt>");
                                String clearCnt = data.substring(clearStart,clearEnd);
                                String clearCntString = clearCnt.replace("<clearCnt>", "격리해제(완치자) 인원수 = ");
                                clearText.setText(clearCntString);

                                //누적 검사 인원
                                int aEStart = data.indexOf("<accExamCnt>");
                                int aEEnd = data.indexOf("</accExamCnt>");
                                String aECnt = data.substring(aEStart,aEEnd);
                                String aECntString = aECnt.replace("<accExamCnt>", "누적 검사 수 = ");
                                accExamText.setText(aECntString);

                                //누적 검사 완료 인원
                                int aECStart = data.indexOf("<accExamCompCnt>");
                                int aECEnd = data.indexOf("</accExamCompCnt>");
                                String aECCnt = data.substring(aECStart,aECEnd);
                                String aECCntString = aECCnt.replace("<accExamCompCnt>", "누적 검사 완료 수 = ");
                                accExamCompText.setText(aECCntString);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private String getTime() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    private String getHTML() {
        String coronaHtml = "";

        HttpURLConnection con = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try{
            StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=BGYZ3GEcNWvV9fWuAwFKo9dMtPwYVng3hWqlYLq9dHcHp5DGZAXeoBQJhD5nRR%2B0XZW8EqPjwkxzm5ph6ZIwqA%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("BGYZ3GEcNWvV9fWuAwFKo9dMtPwYVng3hWqlYLq9dHcHp5DGZAXeoBQJhD5nRR+0XZW8EqPjwkxzm5ph6ZIwqA==", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(getTime(), "UTF-8")); /*검색할 생성일 범위의 시작*/
            urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(getTime(), "UTF-8")); /*검색할 생성일 범위의 종료*/
            URL url = new URL(urlBuilder.toString());
            con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(CONN_TIME);
            con.setReadTimeout(CONN_TIME);

            isr = new InputStreamReader(con.getInputStream());
            br = new BufferedReader(isr);

            String str = null;
            while ((str = br.readLine()) != null) {
                coronaHtml += str + "\n";
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(con != null){
                try{con.disconnect();}catch(Exception e){}
            }

            if(isr != null){
                try{isr.close();}catch(Exception e){}
            }

            if(br != null){
                try{br.close();}catch(Exception e){}
            }
        }
        return coronaHtml;
    }
}
