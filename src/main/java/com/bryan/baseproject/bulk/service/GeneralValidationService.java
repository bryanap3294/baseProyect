package com.bryan.baseproject.bulk.service;

import org.springframework.stereotype.Service;

@Service
public interface GeneralValidationService {

  Boolean isIntegerCSV(String value);
  Boolean isIntegerXLSX(String value);
  Boolean isNull(String value);

}
