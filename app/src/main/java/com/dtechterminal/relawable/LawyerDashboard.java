package com.dtechterminal.relawable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class LawyerDashboard extends AppCompatActivity {
    TextView name,spec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lawyer_dashboard);
        Intent LD = getIntent();
        Bundle NB = LD.getExtras();
        name = findViewById(R.id.lawname);
        name.setText(NB.getString("Name"));
        spec = findViewById(R.id.textView7);
        spec.setText(NB.getString("Spec"));
        RatingBar ratingBar = findViewById(R.id.ratingBar2);
        ratingBar.setRating(NB.getFloat("Rating"));
    }
}
