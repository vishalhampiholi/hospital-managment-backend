package com.example.demo.daoImpl;

import com.example.demo.dao.DoctorDao;
import com.example.demo.model.Doctor;
import com.example.demo.repo.QueryGenerator;
import com.example.demo.rowmapper.DoctorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DoctorDaoImpl implements DoctorDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    DoctorRowMapper doctorRowMapper;


    @Override
    public List<Doctor> allDoctors() {
        return namedParameterJdbcTemplate.query(QueryGenerator.getAllDoctors(),doctorRowMapper);
    }

    @Override
    public Doctor searchDoctorById(long id) {
        Map<String, Long> parameter = new HashMap<>();
        parameter.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(QueryGenerator.findDocById(),parameter,doctorRowMapper);
    }
}
