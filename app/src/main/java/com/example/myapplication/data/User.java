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
   // private boolean studyAbroad;
   // private String abroadCountry;
    private DocumentReference internship;
    private DocumentReference clubs;

    public User(
            String email,

            String uid,
            String name,
            String major,
            DocumentReference courses,
            //boolean studyAbroad,
           // String abroadCountry,
            DocumentReference internship,
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
        this.internship = internship;
        this.email =email;
    }

    public String getName(){
        return name;
    }
    public String getMajor(){
        return major;
    }
    public String getEmail(){
        return email;
    }

   // public String getAbroadCountry(){
   //     return abroadCountry;
   // }
    public DocumentReference getCourses(){
        return courses;
    }
    public DocumentReference getInternship(){
        return internship;
    }

    //public boolean getStudyAborad(){
      //  return studyAbroad;
    //}
    public DocumentReference getClubs(){
        return clubs;
    }
    public String getId(){
        return uid;
    }

}