package com.vaishnavi.practice.servlet.model;

import lombok.*;

@Getter
@Setter
@ToString

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;

    public Student(int id, String firstName, String lastName, String gender, int age) {
    }

    public Student() {
        
    }

    public long getId() {
        return 0;
    }

    public String getFirstName() {
        return "";
    }

    public String getLastName() {
        return "";
    }

    public String getGender() {
        return "";
    }

    public int getAge() {
        return 0;
    }

    public void setId(int i) {
    }

    public void setFirstName(String firstName) {
    }

    public void setLastName(String lastName) {
    }

    public void setGender(String s) {
    }

    public void setAge(int i) {
    }
}
