package com.example.demo.rowmapper;

import com.example.demo.daoImpl.DoctorDaoImpl;
import com.example.demo.model.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PatientsRowMapper implements RowMapper<Patients> {
    @Autowired
    DoctorDaoImpl doctorDao;

    @Override
    public Patients mapRow(ResultSet rs, int rowNum) throws SQLException {
        Patients pat=new Patients();
        pat.setId(rs.getLong("patient_id"));
        pat.setName(rs.getString("name"));
        //set doctor here
        pat.setDoctor(doctorDao.searchDoctorById(rs.getLong("doctor_doctor_id")));
        pat.setDateOfVisit(rs.getString("date_of_visit"));
        return pat;
    }
}
