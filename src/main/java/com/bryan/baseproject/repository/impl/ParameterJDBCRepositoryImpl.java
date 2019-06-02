package com.bryan.baseproject.repository.impl;

import com.bryan.baseproject.model.Parameter;
import com.bryan.baseproject.repository.ParameterJDBCRepository;
import com.bryan.baseproject.repository.procedure.ParameterListProcedure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ParameterJDBCRepositoryImpl implements ParameterJDBCRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParameterJDBCRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ParameterListProcedure parameterListProcedure;

    @PostConstruct
    private void setUp() {
        parameterListProcedure = new ParameterListProcedure(jdbcTemplate);
    }

    @Override
    public List<Parameter> findAll() {
        Map<String, Object> procedureParam = new HashMap<>();
        Map<String, Object> procedureResult = parameterListProcedure.execute(procedureParam);

        return (List<Parameter>) procedureResult.get(ParameterListProcedure.OUT_PARAMETER);
    }
}
