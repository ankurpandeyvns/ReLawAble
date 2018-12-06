package com.dtechterminal.relawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClientHome extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseAuth mauth;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<PersonUtils> personUtilsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_home);
        mauth = FirebaseAuth.getInstance();
        FirebaseUser user = mauth.getCurrentUser();
        DatabaseReference myRef = database.getReference(user.getUid());
        TextView tv = findViewById(R.id.textView3);
        tv.setText("Welcome, "+user.getDisplayName());
        recyclerView = findViewById(R.id.recycleViewContainer);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        personUtilsList = new ArrayList<>();
        //Adding Data into ArrayList
        personUtilsList.add(new PersonUtils("Rakesh Kumar Sharma","Personal Injury-Defense, Real Estate",getApplicationContext().getResources().getDrawable(R.drawable.prof),4.5f));
        personUtilsList.add(new PersonUtils("Nikhil Arya","Contract, Creditors Rights, Criminal",getApplicationContext().getResources().getDrawable(R.drawable.logo),3f));
        personUtilsList.add(new PersonUtils("Sangita Bhayana","Civil Rights, Divorce, Domestic Relations",getApplicationContext().getResources().getDrawable(R.drawable.logo),3.5f));
        personUtilsList.add(new PersonUtils("Rajesh Kumar","Family Law, Indian Law, Insurance",getApplicationContext().getResources().getDrawable(R.drawable.logo),4f));
        personUtilsList.add(new PersonUtils("Vivek Singh","Child Custody and Succession",getApplicationContext().getResources().getDrawable(R.drawable.logo),3.5f));
        personUtilsList.add(new PersonUtils("Rakesh K.Sharma","Divorce/Domestic Relations, Education",getApplicationContext().getResources().getDrawable(R.drawable.logo),4f));
        personUtilsList.add(new PersonUtils("Satyapaul","Employment, Entertainment, Environmental",getApplicationContext().getResources().getDrawable(R.drawable.logo),5f));
        personUtilsList.add(new PersonUtils("Vivek Singh","Employment, Family Law, General Practice",getApplicationContext().getResources().getDrawable(R.drawable.logo),3f));
        personUtilsList.add(new PersonUtils("Sandhya Gupta","Construction, Consumer Law, Contract",getApplicationContext().getResources().getDrawable(R.drawable.logo),3f));
        personUtilsList.add(new PersonUtils("Suresh Chand"," Health Care Law, Indian Law, Insurance",getApplicationContext().getResources().getDrawable(R.drawable.logo),2f));
        mAdapter = new CustomRecyclerAdapter(this, personUtilsList);
        recyclerView.setAdapter(mAdapter);
    }
}
