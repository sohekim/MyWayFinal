package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener{
    FirebaseFirestore db;

    private Button buttonSave;

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextMajor;
    private EditText editTextClasses;
    private EditText editTextInternships;
    private EditText editTextClubs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        buttonSave = (Button) findViewById(R.id.saveProfile);

        editTextName = (EditText) findViewById(R.id.editName);
        editTextEmail = (EditText) findViewById(R.id.editEmail);
        editTextClasses=(EditText) findViewById(R.id.editClasses);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextMajor = (EditText) findViewById(R.id.editMajor);
        editTextInternships = (EditText) findViewById(R.id.editInternship);
        editTextClubs = (EditText) findViewById(R.id.editClubs);

        buttonSave.setOnClickListener(this);

        db = FirebaseFirestore.getInstance();


    }
    public void onClick(View view){
        if(view == buttonSave){
            addUserDataToFirebase();
        }

    }
    private void addUserDataToFirebase() {

        //Random random = new Random();


            String emailEdit = editTextEmail.getText().toString().trim();
            if(emailEdit.isEmpty()) {
                emailEdit = " ";
            }
            String passwordEdit = editTextPassword.getText().toString().trim();
            if(passwordEdit.isEmpty()){
               passwordEdit = " ";
            }
            String nameEdit = editTextName.getText().toString().trim();
            if(nameEdit.isEmpty()){
                nameEdit = " ";
            }
            String majorEdit = editTextMajor.getText().toString().trim();
            if(majorEdit.isEmpty()) {
                majorEdit = " ";
            }
            String classEdit = editTextClasses.getText().toString().trim();
            if(classEdit.isEmpty()){
                classEdit=" ";
            }
            String internshipEdit = editTextInternships.getText().toString().trim();
            if(internshipEdit.isEmpty()){
                internshipEdit=" ";
            }
            String clubEdit = editTextClubs.getText().toString().trim();
            if (clubEdit.isEmpty()){
                clubEdit=" ";
            }

            DocumentReference ref = db.collection("users").document();

            Map<String, Object> classes = new HashMap<>();
            ArrayList<String> mClasses = new ArrayList<>();
            mClasses.add(classEdit);

            Map<String, Object> internships = new HashMap<>();
            ArrayList<String> mInternship = new ArrayList<>();
            mInternship.add(internshipEdit);

            Map<String, Object> clubs = new HashMap<>();
            ArrayList<String> mClub = new ArrayList<>();
            mClub.add(clubEdit);


            Map<String, Object> majors = new HashMap<>();
            ArrayList<String> mMajor = new ArrayList<>();
            mClub.add(majorEdit);


            majors.put("majors", mMajor);
            classes.put("classes", mClasses);
            clubs.put("clubs", mClub);
            internships.put("internships", mInternship);

            Map<String, Object> dataMap = new HashMap<>();

            dataMap.put("name", nameEdit);
            dataMap.put("password", passwordEdit);
            dataMap.put("email", emailEdit);


            //dataMap.put("status", "try status"+random.nextInt(50));

            //study abroad
            //dataMap.put("studyAbroad", true);
            //dataMap.put("abroadCountries", "Hungary");


            ref.set(dataMap);
            ref.collection("courses").document().set(classes);
            ref.collection("internships").document().set(internships);
            ref.collection("clubs").document().set(clubs);
            ref.collection("majors").document().set(majors);

            ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            Log.d("SUCCESS", "DocumentSnapshot data: " + document.getData());
                        } else {
                            Log.d("FAIL1", "No such document");
                        }
                    } else {
                        Log.d("FAIL2", "get failed with ", task.getException());
                    }
                }
            });

    }
}
