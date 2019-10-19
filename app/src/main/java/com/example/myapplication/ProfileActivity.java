package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private  FirebaseAuth firebaseAuth;
    private Button logout;

    private  TextView textViewEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewEmail = (TextView) findViewById(R.id.userProfile);
        textViewEmail.setText("Welcome" + " " + user.getEmail());

        logout = (Button) findViewById(R.id.buttonLogout);

        logout.setOnClickListener(this);
    }

    public void onClick(View view){
        if(view == logout){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));

        }
    }
}
