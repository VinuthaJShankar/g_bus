package com.example.g_bus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminActivity extends AppCompatActivity {

    EditText etMail,etPassword;
    FirebaseAuth fAuth;
    Button loginBtn;
    Button UserBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        etMail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);
        loginBtn = findViewById(R.id.button);
        UserBtn = findViewById(R.id.user);
        fAuth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Password = etPassword.getText().toString();
                String Mail = etMail.getText().toString();


                if(TextUtils.isEmpty(Mail)){
                    etMail.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(Password)){
                    etPassword.setError("password is required");
                    return;
                }

                if (Password.length()<6){
                    etPassword.setError("password must be more than 6");
                }



                // Authenticate the user

                fAuth.signInWithEmailAndPassword(Mail,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(AdminActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),AdashboardActivity.class));
                        }
                        else{
                            Toast.makeText(AdminActivity.this, "Error!! Create Admin Id "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });

            }
        });

        UserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CreateAdminActivity.class));
            }
        });

    }



}
