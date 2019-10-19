package com.example.myapplication.data;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {

    private String uid;
    private String name;
    private String major;
    private ArrayList<String> courses;
    private boolean studyAbroad;
    private String abroadCountry;
    private ArrayList<String> internship;
    private ArrayList<String> clubs;

    public User(
            String uid,
            String name,
            String major,
            ArrayList<String> courses,
            boolean studyAbroad,
            String abroadCountry,
            ArrayList<String> internship,
            ArrayList<String> clubs
    ){
        this.uid = uid;
        this.name = name;
        this.major = major;
        this.courses = courses;
        this.abroadCountry = abroadCountry;
        this.clubs = clubs;
        this.studyAbroad = studyAbroad;
        this.internship = internship;
    }

    public String getName(){
        return name;
    }
    public String getMajor(){
        return major;
    }
    public String getAbroadCountry(){
        return abroadCountry;
    }
    public ArrayList<String> getCourses(){
        return courses;
    }
    public ArrayList<String> getInternship(){
        return internship;
    }
    public boolean getStudyAborad(){
        return studyAbroad;
    }
    public ArrayList<String> getClubs(){
        return clubs;
    }
    public String getId(){
        return uid;
    }
}