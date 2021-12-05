package com.example.coronastatusapp;


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


public class register extends AppCompatActivity {

    private FirebaseAuth mFireBaseAuth; // FireBase 인증

    private DatabaseReference mDataBaseRef; // 실시간 데이터베이스
    private EditText mEdtName,mEdtPhone, mEdtBitrh, mEdtID , mEdtPw; // 회원가입 입력필드
    private Button mBtnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mFireBaseAuth = FirebaseAuth.getInstance();
        mDataBaseRef = FirebaseDatabase.getInstance().getReference("coronaStatusApp");

        mEdtID = findViewById(R.id.editTextTextPersonName4);
        mEdtPw = findViewById(R.id.editTextTextPassword);
        mBtnRegister =findViewById(R.id.Registerbutton);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 회원가입 처리 시작
                String strID = mEdtID.getText().toString();
                String strPwd = mEdtPw.getText().toString();

                //FireBaseAuth 진행
                mFireBaseAuth.createUserWithEmailAndPassword(strID,strPwd).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseuser = mFireBaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseuser.getUid());
                            account.setEmailID(firebaseuser.getEmail());
                            account.setPassword(strPwd);

                            // setValue : dataBase에 insert 삽입
                            mDataBaseRef.child("UserAccount").child(firebaseuser.getUid()).setValue(account);

                            Toast.makeText(register.this, "회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(register.this, "회원가입에 실패하셨습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
