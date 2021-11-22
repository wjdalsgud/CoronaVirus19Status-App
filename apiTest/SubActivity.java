package com.example.corona;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

public class SubActivity extends Activity {
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Intent intent = getIntent();
                String keyword = intent.getStringExtra("keyword");
                String str = getMolRu(keyword);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView searchResult2 = (TextView) findViewById(R.id.searchResult2);
                        searchResult2.setText(str);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });thread.start();
}
