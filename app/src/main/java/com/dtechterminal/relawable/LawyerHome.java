package com.dtechterminal.relawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class LawyerHome extends AppCompatActivity {
    TextView textName;
    FirebaseAuth mAuth;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<PersonUtils> personUtilsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lawyer_home);
        mAuth = FirebaseAuth.getInstance();
        textName = findViewById(R.id.textView);
        FirebaseUser user = mAuth.getCurrentUser();
        String usernm=user.getDisplayName();
        textName.setText("Welcome, "+usernm);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        personUtilsList = new ArrayList<>();
        //Adding Data into ArrayList
        personUtilsList.add(new PersonUtils("Ankur Pandey","Ph.8565062300",getApplicationContext().getResources().getDrawable(R.drawable.prof),4f));
        mAdapter = new CustomRecyclerAdapter(this, personUtilsList);
        recyclerView.setAdapter(mAdapter);
    }
}
