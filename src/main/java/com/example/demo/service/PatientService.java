package com.example.demo.service;

import com.example.demo.dao.PatientDao;
import com.example.demo.model.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientDao patientDao;


    List<Patients> listPatients;

    public List<Patients> showAllPatients(){
        listPatients=patientDao.allPatients();
        return listPatients;
    }

    public Patients searchPatientById(long id) {
        return patientDao.searchPatientsById(id);
    }

    public Patients createPatient(Patients patient) {
        return patientDao.createPatient(patient);
    }
}
