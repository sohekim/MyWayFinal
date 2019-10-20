package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.data.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {


    User user;
    private Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user = (User) getIntent().getSerializableExtra("USER");

        edit = (Button) findViewById(R.id.editProfile);

        edit.setOnClickListener(this);
        //TextView nameField = findViewById(R.id.userProfile);
        //nameField.setText(user.getName());
    }


    @Override
    public void onClick(View v) {
        if(v == edit){
            Intent i = new Intent(ProfileActivity.this,EditProfileActivity.class);
            startActivity(i);
        }
    }
}
