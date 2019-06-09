package com.bryan.baseproject.bulk.service;

import com.bryan.baseproject.bulk.dto.GenericValidationDTO;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenericValidationService<T> {

  GenericValidationDTO<T> validateRowXLSX(Row row);
  GenericValidationDTO<T> validateRowCSV(List<String> row);
}
