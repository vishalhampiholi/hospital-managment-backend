package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="patient_id")
    private long id;
    private String name;
    private String visitedDoc;
    private Date DateOfVisit;

    @OneToOne
    @JoinColumn(foreignKey=@ForeignKey(name="Doctor_id"))
    private Doctor doctor;
}
