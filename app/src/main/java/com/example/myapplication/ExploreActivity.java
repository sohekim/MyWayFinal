package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.adapterAndView.RecyclerViewAdapter;
import com.example.myapplication.data.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ExploreActivity extends AppCompatActivity {

    FirebaseFirestore db;
    RecyclerView mRecyclerView;
    ArrayList<User> profileArrayList;
    RecyclerViewAdapter adapter;

    private BottomNavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        profileArrayList = new ArrayList<>();

        setUpRecyclerView();
        setUpFirebase();
        addUserDataToFirebase();
        loadData();
        mNavigationView = findViewById(R.id.navigationView);

        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Intent intent = getIntent();

                    // mDrawer.closeDrawer(GravityCompat.START);
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_explore: {

                        }
                        break;
                        case R.id.navigation_feed: {
                            intent.setClass(ExploreActivity.this, FeedActivity.class);
                            startActivity(intent);
                        }
                        break;
                        case R.id.userPage: {
                            intent.setClass(ExploreActivity.this, EditProfileActivity.class);
                            startActivity(intent);
                        }
                        break;

                    }
                    return true;
                }
        });
    }


    private void loadData(){
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(DocumentSnapshot querySnapshot: task.getResult()){
                            User user = new User(

                                    querySnapshot.getId(),
                                    querySnapshot.getString("name"),
                                    querySnapshot.getString("major"),
                                    querySnapshot.getDocumentReference("courses"),
                                    querySnapshot.getDocumentReference("internships"),
                                    querySnapshot.getDocumentReference("clubs"));


                            profileArrayList.add(user);
                        }
                        adapter = new RecyclerViewAdapter(ExploreActivity.this, profileArrayList);
                        mRecyclerView.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ExploreActivity.this, "Problem", Toast.LENGTH_SHORT).show();
                        Log.w("Problem", e.getMessage());
                    }
                });
    }

    private void addUserDataToFirebase(){

            Random random = new Random();

            DocumentReference ref = db.collection("users").document();

            Map<String, Object> classes = new HashMap<>();

            ArrayList<String> mClasses = new ArrayList<>();
            mClasses.add("Data Structures");
            mClasses.add("Algo");
            mClasses.add("Tango");

            Map<String, Object> internship = new HashMap<>();

            ArrayList<String> mInternship = new ArrayList<>();
            mInternship.add("Agoda");

            Map<String, Object> club = new HashMap<>();

            ArrayList<String> mClub = new ArrayList<>();
            mClub.add("CS Society");

            classes.put("classes", mClasses);
            club.put("clubs", mClub);
            internship.put("internships", mInternship);

            Map<String, Object> dataMap = new HashMap<>();

            dataMap.put("name", random.nextInt()+"");
            dataMap.put("major", "Computer Science");
            //dataMap.put("studyAbroad", true);
            //dataMap.put("abroadCountries", "Hungary");


            ref.set(dataMap);
            ref.collection("courses").document().set(classes);
            ref.collection("internships").document().set(internship);
            ref.collection("clubs").document().set(club);

    }

    private void setUpFirebase(){
        db = FirebaseFirestore.getInstance();
    }

    private void setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.myRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
