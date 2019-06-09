package com.bryan.baseproject.bulk.service.impl;

import com.bryan.baseproject.bulk.dto.GenericValidationDTO;
import com.bryan.baseproject.bulk.dto.ValidationDTO;
import com.bryan.baseproject.bulk.service.GenericValidationService;
import com.bryan.baseproject.bulk.strategy.CustomerCampaignValidationStrategy;
import com.bryan.baseproject.model.CustomerCampaign;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.List;

public class CustomerCampaignValidationServiceImpl implements GenericValidationService<CustomerCampaign> {

  @Override
  public GenericValidationDTO<CustomerCampaign> validateRowXLSX(Row row) {
    return null;
  }

  @Override
  public GenericValidationDTO<CustomerCampaign> validateRowCSV(List<String> row) {

    List<String> errorList= new ArrayList<>();
    GenericValidationDTO genericValidationDTO = new GenericValidationDTO();
    CustomerCampaign customerCampaign = new CustomerCampaign();
    for(CustomerCampaignValidationStrategy col: CustomerCampaignValidationStrategy.values()){
      String value = row.get(col.getPosition());
      ValidationDTO validationDTO = col.validate(value, customerCampaign, true);
      if(!validationDTO.getValid()){
        errorList.add(validationDTO.getErrorMessage());
      }
    }
    genericValidationDTO.setT(customerCampaign);
    genericValidationDTO.setErrorList(errorList);
    return genericValidationDTO;
  }
}
