package com.bryan.baseproject.bulk.service.impl;

import com.bryan.baseproject.bulk.service.GeneralValidationService;
import org.springframework.stereotype.Component;

@Component
public class GeneralValidationServiceImpl implements GeneralValidationService {

  @Override
  public Boolean isIntegerCSV(String value) {
    try{
      Double doubleValue = new Double(value);
      doubleValue.intValue();
    }catch(Exception e) {
      return false;
    }
    return true;
  }

  @Override
  public Boolean isIntegerXLSX(String value) {
    return null;
  }

  @Override
  public Boolean isNull(String value) {
    if(value==null || value.trim().equals("")){
      return true;
    }else{
      return false;
    }
  }
}
