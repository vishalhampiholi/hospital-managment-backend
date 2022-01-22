package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patient_id")
    private long id;
    private String name;
    private String DateOfVisit;


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @OneToOne
    @JoinColumn(foreignKey=@ForeignKey(name="doctor_id"))
    private Doctor doctor;

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



    public String getDateOfVisit() {
        return DateOfVisit;
    }

    public void setDateOfVisit(String DateOfVisit) {
        this.DateOfVisit = DateOfVisit;
    }

}
