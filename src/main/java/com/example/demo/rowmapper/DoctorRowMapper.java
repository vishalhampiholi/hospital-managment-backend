package com.example.demo.rowmapper;

import com.example.demo.model.Doctor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DoctorRowMapper implements RowMapper<Doctor> {
    @Override
    public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Doctor doc = new Doctor();
        doc.setId(rs.getLong("doctor_id"));
        doc.setName(rs.getString("name"));
        doc.setAge(rs.getInt("age"));
        doc.setSpecialisedField(rs.getString("specialised_field"));
        return doc;
    }
}
