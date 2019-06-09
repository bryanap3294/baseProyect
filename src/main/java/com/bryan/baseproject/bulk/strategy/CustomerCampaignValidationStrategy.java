package com.bryan.baseproject.bulk.strategy;

import com.bryan.baseproject.bulk.dto.ValidationDTO;
import com.bryan.baseproject.bulk.service.GeneralValidationService;
import com.bryan.baseproject.bulk.util.FileType;
import com.bryan.baseproject.model.CustomerCampaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public enum CustomerCampaignValidationStrategy implements ValidationStrategy<CustomerCampaign> {

  TYPEACTION(0, "TIPO DE ACCION"){
    @Override
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required, FileType fileType,  List<Integer> campaignId){
      ValidationDTO validationDTO = new ValidationDTO();
      if(this.isNull(value)){
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
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required, FileType fileType, List<Integer> campaignId){
      ValidationDTO validationDTO = new ValidationDTO();
      if(isNull(value)){
        if(required){
          validationDTO.setValid(false);
          validationDTO.setErrorMessage("ES NULO");
          return validationDTO;
        }else{
          validationDTO.setValid(true);
          return validationDTO;
        }
      }else{
        if(isIntegerCSV(value)){
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
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required, FileType fileType, List<Integer> campaignId){
      ValidationDTO validationDTO = new ValidationDTO();
      if(isNull(value)){
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
            customerCampaign.setDocType(value);
            break;
          case "2":
            validationDTO.setValid(true);
            customerCampaign.setDocType(value);
            break;
          case "3":
            validationDTO.setValid(true);
            customerCampaign.setDocType(value);
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
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required, FileType fileType, List<Integer> campaignId){
      ValidationDTO validationDTO = new ValidationDTO();
      if(customerCampaign.getId()!=null){
        if(isNull(value)){
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
    public ValidationDTO validate(String value, CustomerCampaign customerCampaign, Boolean required, FileType fileType, List<Integer> campaignId){
      ValidationDTO validationDTO = new ValidationDTO();
      List<Integer> idCampaign = new ArrayList<>();
      List<Integer> idNotExistList = new ArrayList<>();
      List<String> idBadFormatList = new ArrayList<>();
      if(this.isNull(value)){
        if(required){
          validationDTO.setValid(false);
          validationDTO.setErrorMessage("ES NULO");
          return validationDTO;
        }else{
          validationDTO.setValid(true);
          return validationDTO;
        }
      }else{
        String[] idArray = value.split("\\|");
        for (String id : idArray){
          if(this.isIntegerCSV(id)){
            if(campaignId.indexOf(new Integer(id))==-1){
              idNotExistList.add(new Integer(id));
            }else{
              idCampaign.add(new Integer(id));
            }
          }else{
            idBadFormatList.add(id);
          }
        }
        if(idNotExistList.size()==0 && idBadFormatList.size()==0){
          validationDTO.setValid(true);
          customerCampaign.setCampaignIdList(campaignId);
        }else{
          validationDTO.setValid(false);
          validationDTO.setErrorMessage("Las campañas: "+idBadFormatList.toString()+" estan en mal formato, y "
            +idNotExistList.toString()+" no existen");
        }
      }
      return validationDTO;
    }
  };

  private final Integer position;
  private String name;

  public Boolean isNull(String value) {
    if(value==null || value.trim().equals("")){
      return true;
    }else{
      return false;
    }
  }

  public Boolean isIntegerCSV(String value) {
    try{
      Double doubleValue = new Double(value);
      doubleValue.intValue();
    }catch(Exception e) {
      return false;
    }
    return true;
  }

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
