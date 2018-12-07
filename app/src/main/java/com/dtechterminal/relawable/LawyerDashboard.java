package com.dtechterminal.relawable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LawyerDashboard extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseAuth mauth;
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
    public void setAppoint(View view){
        DatabaseReference myRef = database.getReference("XVFaWGdyyAQrwuGGlfEWrTryDNj2");
        mauth = FirebaseAuth.getInstance();
        FirebaseUser user = mauth.getCurrentUser();
        myRef.child("Appointment:").setValue(user.getUid());
        Toast.makeText(this, "Appointment Set!!", Toast.LENGTH_SHORT).show();
    }
}
