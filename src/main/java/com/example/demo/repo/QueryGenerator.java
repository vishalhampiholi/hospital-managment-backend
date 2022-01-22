package com.example.demo.repo;

import com.example.demo.dao.PatientDao;

public class QueryGenerator {

    public static String getAllDoctors(){
        return "SELECT * FROM PROJECT.Doctor";
    }


    public static String findDocById(){
        return "select * from PROJECT.Doctor where doctor_id = :id";
    }

    //PATIENTS QUERY
    public static String getAllPatients(){
        return "select * from PROJECT.Patients";
    }

    public static String insertPatients(){
        return "insert into PROJECT.Patients(date_of_visit,name,doctor_doctor_id) values(:DateOfVisit,:name,:doctor)";
    }

    public static String findPatientById(){
        return "select * from PROJECT.Patients where patient_id = :id";
    }
}
