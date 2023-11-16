package com.example.g_bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView profile,apply_pass, dow_pass, details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        profile = (CardView) findViewById(R.id.P1);
        apply_pass = (CardView) findViewById(R.id.P2);
        dow_pass = (CardView) findViewById(R.id.P3);
        details = (CardView) findViewById(R.id.P4);

        profile.setOnClickListener(this);
        apply_pass.setOnClickListener(this);
        dow_pass.setOnClickListener(this);
        details.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        Intent i;

        if (view.getId() == R.id.P1) {
            i = new Intent(this, ProfileActivity.class);
            startActivity(i);
        } else if (view.getId() == R.id.P2) {
            i = new Intent(this, ApplypassActivity.class);
            startActivity(i);
        } else if (view.getId() == R.id.P3) {
            i = new Intent(this, DowpassActivity.class);
            startActivity(i);
        } else if (view.getId() == R.id.P4) {
            i = new Intent(this, DetailsActivity.class);
            startActivity(i);
        }
    }
}
