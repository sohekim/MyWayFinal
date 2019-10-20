package com.example.myapplication.data;


import com.google.firebase.firestore.DocumentReference;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class User implements Serializable{

    private String uid;

    private String name;
    private String major;
    private String email;

    private DocumentReference courses;

    private DocumentReference internships;
    private DocumentReference clubs;



    public User(
            String uid,
            String name,
            String email,
            String major,
            DocumentReference courses,
            DocumentReference internships,
            DocumentReference clubs
    )

    {
        this.uid = uid;
        this.name = name;
        this.major = major;
        this.courses = courses;
        //this.abroadCountry = abroadCountry;
        this.clubs = clubs;
       // this.studyAbroad = studyAbroad;
        this.internships = internships;

        this.email =email;
    }

    public String getId(){
        return uid;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getMajor(){
        return major;
    }


  // public String getAbroadCountry(){
  //      return abroadCountry;
  //  }
    public DocumentReference getCourses(){
        return courses;
    }
    public DocumentReference getInternship(){
        return internships;
    }

   // public boolean getStudyAborad(){
   //     return studyAbroad;}
    public DocumentReference getClubs(){
        return clubs;
    }


}