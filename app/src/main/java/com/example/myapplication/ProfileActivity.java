package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.data.User;


public class ProfileActivity extends AppCompatActivity{


    User user;
    private Button edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        processExtraData();

        user = (User) getIntent().getSerializableExtra("USER");

        edit = (Button) findViewById(R.id.editProfile);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
        processExtraData();
    }

    private void processExtraData(){
        User user = (User) getIntent().getSerializableExtra("USER");

//        TextView majorField = findViewById(R.id.profileMajor);
//        majorField.setText(user.getMajor());

        TextView studyField = findViewById(R.id.profileStudyAbroad);
        if (user.getStudyAborad()) {
            studyField.setText(user.getAbroadCountry());
        } else {
            studyField.setText("no");
        }

        TextView nameField = findViewById(R.id.userName);
        nameField.setText(user.Name());

    }
}
