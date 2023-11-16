package com.example.g_bus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAdminActivity extends AppCompatActivity {

    EditText etName, etMail, etPassword;
    FirebaseAuth fAuth;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_admin);
        etName = findViewById(R.id.etName);

        etMail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);

        fAuth = FirebaseAuth.getInstance();
    }

    public void btnLoginClicked (View v)
    {

        EditText etName = findViewById(R.id.etName);
        EditText etUsn = findViewById(R.id.etUsn);
        EditText etMail = findViewById(R.id.etMail);
        String Name = etName.getText().toString();
        String Mail = etMail.getText().toString();
        String Password = etPassword.getText().toString();

        if (TextUtils.isEmpty(Name)) {
            etName.setError("Name is required");
            return;
        }

        if (TextUtils.isEmpty(Mail)) {
            etMail.setError("Email is required");
            return;
        }

        if (TextUtils.isEmpty(Password)) {
            etPassword.setError("password is required");
            return;
        }

        if (Password.length() < 6) {
            etPassword.setError("password must be more than 6");
        }


        //registration the user name to firebase

        fAuth.createUserWithEmailAndPassword(Mail,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CreateAdminActivity.this, "Admin created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), AdashboardActivity.class));
                } else {
                    Toast.makeText(CreateAdminActivity.this, "Error!! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
