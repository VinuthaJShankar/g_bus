package com.example.g_bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdashboardActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView profile,approve_pass, update_details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adashboard);

        profile = (CardView) findViewById(R.id.A1);
        approve_pass = (CardView) findViewById(R.id.A2);
        update_details = (CardView) findViewById(R.id.A3);

        profile.setOnClickListener(this);
        approve_pass.setOnClickListener(this);
        update_details.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        if (view.getId() == R.id.A1) {
            i = new Intent(this, AdminProfileActivity.class);
            startActivity(i);
        } else if (view.getId() == R.id.A2) {
            i = new Intent(this, ApprovePassActivity.class);
            startActivity(i);
        } else if (view.getId() == R.id.A3) {
            i = new Intent(this, UpdateDetailsActivity.class);
            startActivity(i);
        }
    }




}