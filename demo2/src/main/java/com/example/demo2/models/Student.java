package com.example.demo2.models;


public class Student {

    private int id;
    private String first_name;
    private int age;
    private String email;

    // Default constructor
    public Student() {
    }

    public Student(String first_name, int age,String email) {
        this.first_name = first_name;
        this.age = age;
        this.email = email;
    }
    public Student(int id,String first_name, int age,String email) {
        this.id = id;
        this.first_name = first_name;
        this.age = age;
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter methods for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter methods for first_name
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    // Getter and Setter methods for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
