package com.bryan.baseproject.bulk.strategy;

import com.bryan.baseproject.bulk.dto.ValidationDTO;
import com.bryan.baseproject.bulk.service.GeneralValidationService;
import com.bryan.baseproject.bulk.util.FileType;
import com.bryan.baseproject.model.CustomerCampaign;
import org.springframework.beans.factory.annotation.Autowired;

public enum CustomerCampaignValidationStrategy implements ValidationStrategy<CustomerCampaign> {

  TYPEACTION(0, "TIPO DE ACCION"){
    @Override
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required, FileType fileType){
      ValidationDTO validationDTO = new ValidationDTO();
      if(generalValidationService.isNull(value)){
        if(required){
          validationDTO.setValid(false);
          validationDTO.setErrorMessage("ES NULO");
          return validationDTO;
        }else{
          validationDTO.setValid(true);
          return validationDTO;
        }
      }else{
        switch (value){
          case "0":
            validationDTO.setValid(true);
            break;
          case "1":
            validationDTO.setValid(true);
            break;
          default:
            validationDTO.setValid(false);
            validationDTO.setErrorMessage("VALOR INCORRECTO");
            break;
        }
      }
      return validationDTO;
    }
  },
  ID(1, "ID") {
    @Override
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required, FileType fileType){
      ValidationDTO validationDTO = new ValidationDTO();
      if(generalValidationService.isNull(value)){
        if(required){
          validationDTO.setValid(false);
          validationDTO.setErrorMessage("ES NULO");
          return validationDTO;
        }else{
          validationDTO.setValid(true);
          return validationDTO;
        }
      }else{
        if(generalValidationService.isIntegerCSV(value)){
          Double doubleValue = new Double(value);
          validationDTO.setValid(true);
          customerCampaign.setId(doubleValue.intValue());
        }else{
          validationDTO.setValid(false);
          validationDTO.setErrorMessage("No es Integer");
        }
      }
      return validationDTO;
    }
  },
  DOCUMENTTYPE(2, "TIPO DE DOCUMENTO") {
    @Override
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required, FileType fileType){
      ValidationDTO validationDTO = new ValidationDTO();
      if(generalValidationService.isNull(value)){
        if(required){
          validationDTO.setValid(false);
          validationDTO.setErrorMessage("ES NULO");
          return validationDTO;
        }else{
          validationDTO.setValid(true);
          return validationDTO;
        }
      }else{
        switch (value){
          case "1":
            validationDTO.setValid(true);
            customerCampaign.setId(new Integer(value));
            break;
          case "2":
            validationDTO.setValid(true);
            customerCampaign.setId(new Integer(value));
            break;
          case "3":
            validationDTO.setValid(true);
            customerCampaign.setId(new Integer(value));
            break;
          default:
            validationDTO.setValid(false);
            validationDTO.setErrorMessage("VALOR INCORRECTO");
            break;
        }
      }
      return validationDTO;
    }
  },
  DOCUMENTNUMBER(3, "NUMERO DE DOCUMENTO") {
    @Override
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required, FileType fileType){
      ValidationDTO validationDTO = new ValidationDTO();
      if(customerCampaign.getId()!=null){
        if(generalValidationService.isNull(value)){
          if(required){
            validationDTO.setValid(false);
            validationDTO.setErrorMessage("ES NULO");
            return validationDTO;
          }else{
            validationDTO.setValid(true);
            return validationDTO;
          }
        }else{
          validationDTO = validateLength(customerCampaign.getId(), value, customerCampaign);
        }
      }else{
        validationDTO.setValid(false);
        validationDTO.setErrorMessage("Campo Tipo doc errado");
      }
      return validationDTO;
    }

    public ValidationDTO validateLength(Integer docType, String value, CustomerCampaign customerCampaign){
      ValidationDTO validationDTO = new ValidationDTO();
      validationDTO.setValid(true);
      switch (docType){
        case 1:
          if(value.trim().length()!=8){
            validationDTO.setValid(false);
            validationDTO.setErrorMessage("Cantidad de caracteres invalidos");
          }
          break;
        case 2:
          if(value.trim().length()!=12){
            validationDTO.setValid(false);
            validationDTO.setErrorMessage("Cantidad de caracteres invalidos");
          }
          break;
        case 3:
          if(value.trim().length()!=12){
            validationDTO.setValid(false);
            validationDTO.setErrorMessage("Cantidad de caracteres invalidos");
          }
          break;
        default:
          validationDTO.setValid(false);
          validationDTO.setErrorMessage("Cantidad de Tipo de doc invalido");
          break;
      }
      if(validationDTO.getValid()){
        customerCampaign.setDocNumber(value);
      }
      return validationDTO;
    }
  },
  CAMPAIGN(4, "CAMPAÑA") {
    @Override
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required, FileType fileType){
      ValidationDTO validationDTO = new ValidationDTO();

      return null;
    }
  };

  private final Integer position;
  private String name;

  @Autowired
  protected GeneralValidationService generalValidationService;

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
