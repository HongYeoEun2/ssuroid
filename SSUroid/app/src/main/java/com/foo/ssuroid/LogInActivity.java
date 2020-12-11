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

public class LogInActivity<mAuth> extends AppCompatActivity implements View.OnClickListener {
    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonLog;
    Button buttonSign;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mAuth = FirebaseAuth.getInstance();
        editTextEmail = (EditText) findViewById(R.id.loginEditID);
        editTextPassword = (EditText) findViewById(R.id.loginEditpassword);
        buttonLog = (Button) findViewById(R.id.login_btn);
        buttonSign = (Button) findViewById(R.id.signup_btn);

        buttonLog.setOnClickListener(this);
        buttonSign.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    //firebase userLogin method
    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.length() > 0 && password.length() > 0) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(LogInActivity.this, "로그인에 성공하였습니다.", Toast.LENGTH_LONG).show();
                                startSetInfoActivity();
                            } else {
                                if (task.getException() != null) {
                                    Toast.makeText(LogInActivity.this, task.getException().toString(), Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    });

        } else {
            Toast.makeText(LogInActivity.this, "이메일 또는 비밀번호를 입력해주세요.", Toast.LENGTH_LONG).show();
        }
    }

    private void startSetInfoActivity() {
        Intent intent = new Intent(this, SetInfoActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                userLogin();
                break;
            case R.id.signup_btn:
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }
}


