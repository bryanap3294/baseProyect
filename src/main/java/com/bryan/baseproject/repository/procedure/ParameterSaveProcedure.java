package com.bryan.baseproject.repository.procedure;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

public class ParameterSaveProcedure extends BaseProcedure {

    public static final String PROCEDURE_NAME = "USP_PARAMETER_SAVE";

    public static final String IN_ID = "id";
    public static final String IN_MODULE = "module";
    public static final String IN_LABEL = "label";
    public static final String IN_VALUE1= "value1";
    public static final String IN_VALUE2= "value2";
    public static final String IN_VALUE3= "value3";
    public static final String IN_ACTIVE= "active";
    public static final String OUT_TOTAL_RECORDS = "totalRecords";

    public ParameterSaveProcedure(final JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    protected void init() {
        getSimpleJdbcCall()
                .withProcedureName(PROCEDURE_NAME)
                    .declareParameters(new SqlParameter(IN_ID, Types.INTEGER))
                .declareParameters(new SqlParameter(IN_MODULE, Types.VARCHAR))
                .declareParameters(new SqlParameter(IN_LABEL, Types.VARCHAR))
                .declareParameters(new SqlParameter(IN_VALUE1, Types.VARCHAR))
                .declareParameters(new SqlParameter(IN_VALUE2, Types.VARCHAR))
                .declareParameters(new SqlParameter(IN_VALUE3, Types.VARCHAR))
                .declareParameters(new SqlParameter(IN_ACTIVE, Types.VARCHAR));
    }

}
