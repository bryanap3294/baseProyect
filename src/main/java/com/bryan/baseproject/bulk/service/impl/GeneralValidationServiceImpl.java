package com.bryan.baseproject.bulk.service.impl;

import com.bryan.baseproject.bulk.service.GeneralValidationService;
import org.springframework.stereotype.Component;

@Component
public class GeneralValidationServiceImpl implements GeneralValidationService {

  @Override
  public Boolean isIntegerCSV(String value) {
    return null;
  }

  @Override
  public Boolean isIntegerXLSX(String value) {
    return null;
  }

  @Override
  public Boolean isNull(String value) {
    return null;
  }
}
