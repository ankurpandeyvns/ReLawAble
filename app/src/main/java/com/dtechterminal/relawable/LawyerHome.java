package com.dtechterminal.relawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LawyerHome extends AppCompatActivity {
    TextView textName;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lawyer_home);
        mAuth = FirebaseAuth.getInstance();
        textName = findViewById(R.id.textView);
        FirebaseUser user = mAuth.getCurrentUser();
        String usernm=user.getDisplayName();
        textName.setText("Welcome ,"+usernm);
    }
}
