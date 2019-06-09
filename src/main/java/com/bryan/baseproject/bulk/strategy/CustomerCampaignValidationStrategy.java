package com.bryan.baseproject.bulk.strategy;

import com.bryan.baseproject.bulk.dto.ValidationDTO;
import com.bryan.baseproject.model.CustomerCampaign;

public enum CustomerCampaignValidationStrategy implements ValidationStrategy<CustomerCampaign> {

  TYPEACTION(0, "TIPO DE ACCION"){
    @Override
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required){

      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  ID(1, "ID") {
    @Override
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  DOCUMENTTYPE(2, "TIPO DE DOCUMENTO") {
    @Override
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  DOCUMENTNUMBER(3, "NUMERO DE DOCUMENTO") {
    @Override
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  CAMPAIGN(4, "CAMPAÑA") {
    @Override
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  };

  private final Integer position;
  private String name;

  CustomerCampaignValidationStrategy(Integer position, String name){
    this.position=position;
    this.name=name;
  }

  public Integer getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
