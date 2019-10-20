package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import android.view.View;
import android.widget.Button;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FeedActivity extends AppCompatActivity {

    private BottomNavigationView mNavigationView;
    private Button buttonQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        buttonQuestion = findViewById(R.id.bQ);

        buttonQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAsk();
            }
        });

        mNavigationView = findViewById(R.id.navigationView);

        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent = getIntent();

                // mDrawer.closeDrawer(GravityCompat.START);
                switch (menuItem.getItemId()) {
                    case R.id.navigation_explore: {
                        intent.setClass(FeedActivity.this, ExploreActivity.class);
                        startActivity(intent);
                    }
                    break;
                    case R.id.navigation_feed: {

                    }
                    break;
                    case R.id.userPage: {
                        intent.setClass(FeedActivity.this, EditProfileActivity.class);
                        startActivity(intent);
                    }
                    break;

                }
                return true;
            }
        });


    }

    public void moveToAsk() {
        Intent intent = new Intent (this, Ask.class);
        startActivity(intent);

    }
}
