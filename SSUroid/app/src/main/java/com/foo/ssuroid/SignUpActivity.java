package com.foo.ssuroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity<mAuth> extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextRePassword;
    private Button buttonJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //firebase 인스턴스 초기화
        mAuth = FirebaseAuth.getInstance();

        //입력폼과 버튼 객체 생성
        editTextEmail = (EditText) findViewById(R.id.signUpEmail);
        editTextPassword = (EditText) findViewById(R.id.signUpPassword);
        editTextRePassword = (EditText) findViewById(R.id.signUpRePassword);
        buttonJoin = (Button) findViewById(R.id.btn_join);

        //버튼 클릭 리스너 설정
        buttonJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser(editTextEmail.getText().toString(), editTextPassword.getText().toString(), editTextRePassword.getText().toString());
                startLoginActivity();
            }

        });
    }

    private void startLoginActivity() {
        Intent intent=new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    //파이어베이스 유저 객체 생성
    private void createUser(String email, String password, String passwordCheck) {
        if (email.length() > 0 && password.length() > 0 && passwordCheck.length() > 0) {
            if (passwordCheck.equals(password)) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(SignUpActivity.this, "회원가입에 성공하였습니다.", Toast.LENGTH_LONG).show();
                                } else {
                                    if(task.getException()!=null){
                                        Toast.makeText(SignUpActivity.this, task.getException().toString(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                        });
            } else {
                Toast.makeText(SignUpActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(SignUpActivity.this, "이메일 또는 비밀번호를 입력해주세요.", Toast.LENGTH_LONG).show();
        }
    }
}
