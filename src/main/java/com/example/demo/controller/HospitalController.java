package com.example.demo.controller;

import com.example.demo.model.Doctor;
import com.example.demo.model.Patients;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class HospitalController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;


    @RequestMapping(value="/patients/addPatient",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addPatient(@RequestBody Patients patient) throws Exception{
        System.out.println(patient.getDateOfVisit());
        System.out.println(patient.getName());
       patientService.createPatient(patient);
    }

    @RequestMapping("/patients")
    List<Patients> showAllPatients(){
        List<Patients> listAllPatients= new ArrayList<Patients>();
        listAllPatients=patientService.showAllPatients();
        return listAllPatients;
    }

    @RequestMapping("/doctors")
    List<Doctor> showAllDoctors(){
        List<Doctor> listAllDoctors= new ArrayList<>();
        listAllDoctors=doctorService.showAllDoctors();
        return listAllDoctors;
    }






}
