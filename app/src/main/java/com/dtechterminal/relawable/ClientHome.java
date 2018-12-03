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
        personUtilsList.add(new PersonUtils("Todd Miller","Project Manager"));
        personUtilsList.add(new PersonUtils("Bradley Matthews","Senior Developer"));
        personUtilsList.add(new PersonUtils("Harley Gibson","Lead Developer"));
        personUtilsList.add(new PersonUtils("Gary Thompson","Lead Developer"));
        personUtilsList.add(new PersonUtils("Corey Williamson","UI/UX Developer"));
        personUtilsList.add(new PersonUtils("Samuel Jones","Front-End Developer"));
        personUtilsList.add(new PersonUtils("Michael Read","Backend Developer"));
        personUtilsList.add(new PersonUtils("Robert Phillips","Android Developer"));
        personUtilsList.add(new PersonUtils("Albert Stewart","Web Developer"));
        personUtilsList.add(new PersonUtils("Wayne Diaz","Junior Developer"));

        mAdapter = new CustomRecyclerAdapter(this, personUtilsList);

        recyclerView.setAdapter(mAdapter);
    }
}
