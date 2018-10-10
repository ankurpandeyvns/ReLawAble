package com.dtechterminal.relawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseAuth mauth;
    EditText nm,loc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mauth = FirebaseAuth.getInstance();
        FirebaseUser user = mauth.getCurrentUser();
        DatabaseReference myRef = database.getReference(user.getUid());
        nm = findViewById(R.id.NAME);
        if(!(user.getDisplayName()==null)) nm.setText(user.getDisplayName());
    }
    public void proceedfn(View view){
        mauth = FirebaseAuth.getInstance();
        FirebaseUser user = mauth.getCurrentUser();
        DatabaseReference myRef = database.getReference(user.getUid());
        nm = findViewById(R.id.NAME);
        loc = findViewById(R.id.Locality);
        EditText pn = findViewById(R.id.Phone);
        if(pn.getText().toString().isEmpty() || nm.getText().toString().isEmpty() || loc.getText().toString().isEmpty())
            Toast.makeText(this, "Fill up the form completely before proceeding.", Toast.LENGTH_SHORT).show();
        else {
            myRef.child("Name").setValue(nm.getText().toString());
            myRef.child("Locality").setValue(loc.getText().toString());
            myRef.child("Phone").setValue(Long.parseLong(pn.getText().toString()));
        }
    }
}
