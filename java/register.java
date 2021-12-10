package com.example.coronastatusapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.PipedReader;


public class register extends AppCompatActivity {

//    private FirebaseAuth mFireBaseAuth; // FireBase 인증
//
//    private DatabaseReference mDataBaseRef; // 실시간 데이터베이스
//    private EditText mEdtName, mEdtPhone, mEdtBitrh, mEdtID, mEdtPw; // 회원가입 입력필드
//    private Button mBtnRegister;

    private EditText email_join;
    private EditText Pwd_join;
    private EditText name_join;
    private  Button register_Button;

    FirebaseAuth firebaseAuth;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        name_join = (EditText) findViewById(R.id.register_Name);
        email_join = (EditText)findViewById(R.id.register_ID);
        Pwd_join = (EditText) findViewById(R.id.register_Pass);
        register_Button = (Button)findViewById(R.id.register_Button);

        firebaseAuth = FirebaseAuth.getInstance();
        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = email_join.getText().toString().trim();
                final  String pwd = Pwd_join.getText().toString().trim();
                final  String name = name_join.getText().toString().trim();
                firebaseAuth.createUserWithEmailAndPassword(email ,pwd).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {

                            FirebaseDatabase.getInstance().getReference("coronaStatusApp").child("UserAccount")
                                    .child(firebaseAuth.getInstance().getCurrentUser().getUid()).setValue(name).
                                    addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            //    progressbar GONE
//                                            signUp_progress.setVisibility(View.GONE);
                                            FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                                            UserAccount account = new UserAccount();

                                            account.setIdToken(firebaseUser.getUid());
                                            account.setEmailID(firebaseUser.getEmail());
                                            account.setPassword(pwd);
                                            account.setName(name);
databaseReference.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
                                            Toast.makeText(register.this , "Successful Registered", Toast.LENGTH_SHORT).show();


                                            Intent intent = new Intent(register.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                        } else {
                            Toast.makeText(register.this , "등록 에러",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });
            }
        });
    }}
