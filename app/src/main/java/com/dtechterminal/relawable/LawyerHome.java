package com.dtechterminal.relawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LawyerHome extends AppCompatActivity {
    TextView textName, textEmail,flag;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lawyer_home);
        mAuth = FirebaseAuth.getInstance();
        textName = findViewById(R.id.textView);
        textEmail = findViewById(R.id.textView2);
        FirebaseUser user = mAuth.getCurrentUser();
        textName.setText(user.getDisplayName());
        textEmail.setText(user.getEmail());
    }
}
