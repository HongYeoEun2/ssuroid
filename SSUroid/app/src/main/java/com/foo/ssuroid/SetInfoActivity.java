package com.foo.ssuroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class SetInfoActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText editTextDepartment;
    private EditText editTextName;
    private EditText editTextStudentID;
    private EditText editTextAddress;
    private EditText editTextPhone;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_info);

        mAuth = FirebaseAuth.getInstance();
        editTextDepartment = (EditText) findViewById(R.id.setDepartment);
        editTextName = (EditText) findViewById(R.id.setName);
        editTextStudentID = (EditText) findViewById(R.id.setStudentID);
        editTextAddress = (EditText) findViewById(R.id.setAddress);
        editTextPhone = (EditText) findViewById(R.id.setPhone);
        buttonSave = (Button) findViewById(R.id.btn_save);

        //버튼 클릭 리스너 설정
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent i = new Intent(SetInfoActivity.this, SearchAddress.class);
                //  startActivityForResult(i, SEARCH_ADDRESS_ACTIVITY);
                profileUpdate();
            }

        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    private void profileUpdate() {
        String department = editTextDepartment.getText().toString();
        String name = editTextName.getText().toString();
        String studentID = editTextStudentID.getText().toString();
        String address = editTextAddress.getText().toString();
        String phoneNumber = editTextPhone.getText().toString();

        if (department.length() > 0 && name.length() > 0 && studentID.length() > 7 && address.length() > 0 && phoneNumber.length() > 8) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            MemberInfo memberInfo = new MemberInfo(department, name, studentID, address, phoneNumber);

            if (user != null) {
                db.collection("users").document(user.getUid())
                        .set(memberInfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(SetInfoActivity.this, "회원 정보 등록에 성공하였습니다.", Toast.LENGTH_LONG).show();
                                startMainActivity();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(SetInfoActivity.this, "회원 정보 등록에 실패하였습니다.", Toast.LENGTH_LONG).show();
                            }
                        });

            }
        } else {
            Toast.makeText(SetInfoActivity.this, "회원 정보 등록를 입력해주세요.", Toast.LENGTH_LONG).show();
        }
    }

    private void startMainActivity() {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

