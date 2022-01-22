package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private long id;
    private String name;
    private int age;
    private String specialisedField;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialisedField() {
        return specialisedField;
    }

    public void setSpecialisedField(String specialisedField) {
        this.specialisedField = specialisedField;
    }






}
