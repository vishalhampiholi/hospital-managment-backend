package com.example.demo.dao;

import com.example.demo.model.Doctor;

import java.util.List;

public interface DoctorDao {
    public List<Doctor> allDoctors();
    public Doctor searchDoctorById(long id);
}
