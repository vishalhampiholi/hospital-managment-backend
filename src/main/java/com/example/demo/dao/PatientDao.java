package com.example.demo.dao;

import com.example.demo.model.Patients;

import java.util.List;

public interface PatientDao {
    public List<Patients> allPatients();
    public Patients createPatient(Patients patient);
    public Patients searchPatientsById(long id);

}
