package com.example.g_bus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnStudentClicked(View v){
        Toast.makeText(this, "Hello Student!", Toast.LENGTH_LONG).show();
        Intent i=new Intent(this, SecondActivity.class);
        startActivity(i);
    }

    public void btnAdminClicked(View v){
        Toast.makeText(this, "Hello Admin!", Toast.LENGTH_LONG).show();
        Intent i=new Intent(this, AdminActivity.class);
        startActivity(i);
    }






}