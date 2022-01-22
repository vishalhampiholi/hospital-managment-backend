package com.example.demo.daoImpl;

import com.example.demo.dao.PatientDao;
import com.example.demo.model.Patients;
import com.example.demo.repo.QueryGenerator;
import com.example.demo.rowmapper.PatientsRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PatientDaoImpl implements PatientDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    PatientsRowMapper patientsRowMapper;


    @Override
    public List<Patients> allPatients() {
        return namedParameterJdbcTemplate.query(QueryGenerator.getAllPatients(),patientsRowMapper);
    }

    @Override
    public Patients createPatient(Patients patient) {
        KeyHolder holder=new GeneratedKeyHolder();
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("name", patient.getName())
                .addValue("doctor", patient.getDoctor().getId())
                .addValue("DateOfVisit",patient.getDateOfVisit());

        System.out.println(parameter);
        namedParameterJdbcTemplate.update(QueryGenerator.insertPatients(), parameter, holder);
        patient.setId(holder.getKey().longValue());
        return patient;
    }

    @Override
    public Patients searchPatientsById(long id) {
        Map<String, Long> parameter = new HashMap<>();
        parameter.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(QueryGenerator.findPatientById(),parameter,patientsRowMapper);
    }
}
