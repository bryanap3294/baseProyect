package com.bryan.baseproject.service.custom.impl;

import com.bryan.baseproject.model.Parameter;
import com.bryan.baseproject.model.dto.ParameterXLSXDTO;
import com.bryan.baseproject.model.dto.XLSXDTO;
import com.bryan.baseproject.service.custom.ValidateXLSXParameterService;
import com.bryan.baseproject.service.custom.validate.ValidateParameterEnum;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class ValidateXLSXParameterServiceImpl implements ValidateXLSXParameterService {

    @Override
    public ParameterXLSXDTO validateParameterXLSX(Row row) {
        List<String> errorList= new ArrayList<>();
        ParameterXLSXDTO parameterXLSXDTO = new ParameterXLSXDTO();
        Parameter parameter = new Parameter();
        Stream.of(ValidateParameterEnum.values()).forEach(field -> {
            Cell cell = row.getCell(field.getPosition());
            XLSXDTO<String> xlsxdto = field.validation(cell, parameter);
            if(!xlsxdto.getValid()){
                errorList.add(xlsxdto.getErrorMessage());
            }
        });
        parameterXLSXDTO.setParameter(parameter);
        parameterXLSXDTO.setMensajes(errorList);
      return parameterXLSXDTO;
    }
}
