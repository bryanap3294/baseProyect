package com.bryan.baseproject.repository.impl;

import com.bryan.baseproject.model.Parameter;
import com.bryan.baseproject.repository.ParameterJDBCRepository;
import com.bryan.baseproject.repository.procedure.ParameterListProcedure;
import com.bryan.baseproject.repository.procedure.ParameterSaveProcedure;
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
    private ParameterSaveProcedure parameterSaveProcedure;

    @PostConstruct
    private void setUp() {
        parameterListProcedure = new ParameterListProcedure(jdbcTemplate);
        parameterSaveProcedure = new ParameterSaveProcedure(jdbcTemplate);
    }

    @Override
    public List<Parameter> parameterList() {
        Map<String, Object> procedureParam = new HashMap<>();
        Map<String, Object> procedureResult = parameterListProcedure.execute(procedureParam);

        return (List<Parameter>) procedureResult.get(ParameterListProcedure.OUT_PARAMETER);
    }

    @Override
    public Integer parameterSave(Parameter parameter) {
        Map<String, Object> procedureParam = new HashMap<>();
        procedureParam.put(parameterSaveProcedure.IN_ID, parameter.getId());
        procedureParam.put(parameterSaveProcedure.IN_MODULE, parameter.getModule());
        procedureParam.put(parameterSaveProcedure.IN_LABEL, parameter.getLabel());
        procedureParam.put(parameterSaveProcedure.IN_VALUE1, parameter.getValue1());
        procedureParam.put(parameterSaveProcedure.IN_VALUE2, parameter.getValue2());
        procedureParam.put(parameterSaveProcedure.IN_VALUE3, parameter.getValue3());
        procedureParam.put(parameterSaveProcedure.IN_ACTIVE, parameter.getActive());

        Map<String, Object> procedureResult = parameterSaveProcedure.execute(procedureParam);
        return (Integer)procedureResult.get(ParameterSaveProcedure.OUT_TOTAL_RECORDS);
    }
}
