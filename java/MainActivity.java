package com.example.coronastatusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mFireBaseAuth; // FireBase 인증
    private DatabaseReference mDataBaseRef; // 실시간 데이터베이스
    private EditText  mEdtID , mEdtPw; // 회원가입 입력필드


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        mFireBaseAuth = FirebaseAuth.getInstance();
        mDataBaseRef = FirebaseDatabase.getInstance().getReference("coronaStatusApp");

        EditText Editid= (EditText)findViewById(R.id.enterId);
        EditText EditPW= (EditText)findViewById(R.id.enterPass);

        Button loginBt1 = (Button)findViewById(R.id.loginButton);
        loginBt1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                // 로그인 요청
                String strID = Editid.getText().toString();
                String strPwd =EditPW.getText().toString();

                mFireBaseAuth.signInWithEmailAndPassword(strID,strPwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful()) {
                            Intent intent = new Intent(MainActivity.this,MainPage.class);
                            startActivity(intent);
                            Log.d("dsdsd",strID);
                        }else {
                            Toast.makeText(MainActivity.this, "로그인 실패..!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
       });



        Button loginBt2 = (Button)findViewById(R.id.registerButton);
        loginBt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, register.class);
                startActivity(intent);
            }
        });

        Button loginBt3 = (Button)findViewById(R.id.find_Id_PassButton);
        loginBt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Search_ID_PW.class);
                startActivity(intent);
            }
        });
    }
}
