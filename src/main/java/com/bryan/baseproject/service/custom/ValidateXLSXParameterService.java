package com.bryan.baseproject.service.custom;

import com.bryan.baseproject.model.dto.ParameterXLSXDTO;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

@Service
public interface ValidateXLSXParameterService {

    ParameterXLSXDTO validateParameterXLSX(Row row);

}
