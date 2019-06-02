package com.bryan.baseproject.repository.procedure;

import com.bryan.baseproject.model.Parameter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlReturnResultSet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParameterListProcedure extends BaseProcedure {

    public static final String PROCEDURE_NAME = "USP_PARAMETER_LIST";

    public static final String OUT_PARAMETER = "OUT_PARAMETER";

    public ParameterListProcedure(final JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    protected void init() {
        getSimpleJdbcCall()
                .withProcedureName(PROCEDURE_NAME)
                .declareParameters(new SqlReturnResultSet(OUT_PARAMETER, new GetCampaignRowMapper()));
    }

    private class GetCampaignRowMapper implements RowMapper<Parameter> {

        @Override
        public Parameter mapRow(ResultSet resultSet, int i) throws SQLException {

            Parameter parameter = new Parameter();
            parameter.setId(resultSet.getInt("id"));
            parameter.setModule(resultSet.getString("module"));
            parameter.setLabel(resultSet.getString("label"));
            parameter.setValue1(resultSet.getString("value1"));
            parameter.setValue2(resultSet.getString("value2"));
            parameter.setValue3(resultSet.getString("value3"));
            parameter.setActive(resultSet.getString("active"));

            return parameter;
        }
    }

}
