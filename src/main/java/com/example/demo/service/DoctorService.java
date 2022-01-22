package com.example.demo.service;

import com.example.demo.daoImpl.DoctorDaoImpl;
import com.example.demo.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorDaoImpl doctorDao;

    List<Doctor> listDoctors;


    public List<Doctor> showAllDoctors(){
        listDoctors=doctorDao.allDoctors();
        return listDoctors;
    }

    public Doctor searchDoctorById(long id) {
        return doctorDao.searchDoctorById(id);
    }

}
