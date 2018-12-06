package com.dtechterminal.relawable;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseAuth mauth;
    EditText nm,loc,pn;
    private Button btnChoose, btnUpload;
    private ImageView imageView;
    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 71;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mauth = FirebaseAuth.getInstance();
        FirebaseUser user = mauth.getCurrentUser();
        nm = findViewById(R.id.NAME);
        if(!(user.getDisplayName()==null)) nm.setText(user.getDisplayName());
    }
    public void proceedfn(View view){
        RadioGroup rg = findViewById(R.id.radioGroup);
        int selectedid = rg.getCheckedRadioButtonId();
        mauth = FirebaseAuth.getInstance();
        FirebaseUser user = mauth.getCurrentUser();
        DatabaseReference myRef = database.getReference(user.getUid());
        nm = findViewById(R.id.NAME);
        loc = findViewById(R.id.Locality);
        pn = findViewById(R.id.Phone);
        if(pn.getText().toString().isEmpty() || nm.getText().toString().isEmpty() || loc.getText().toString().isEmpty() || pn.getText().toString().length()!=10)
            Toast.makeText(this, "Fill up the form completely before proceeding.", Toast.LENGTH_SHORT).show();
        else {
            myRef.child("Name").setValue(nm.getText().toString());
            myRef.child("Locality").setValue(loc.getText().toString());
            myRef.child("Phone").setValue(Long.parseLong(pn.getText().toString()));
            if (selectedid == 2131296368) {
                DatabaseReference Lawyers = database.getReference("Lawyers");
                Lawyers.child(user.getUid()).setValue("0");
                myRef.child("CORLAW").setValue(1);
                startActivity(new Intent(getBaseContext(), LawyerHome.class));
            } else {
                DatabaseReference Clients = database.getReference("Clients");
                Clients.child(user.getUid()).setValue("0");
                myRef.child("CORLAW").setValue(0);
                startActivity(new Intent(getBaseContext(), ClientHome.class));
            }
        }
    }
    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
}
