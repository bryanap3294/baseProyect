package com.bryan.baseproject.bulk.strategy;

import com.bryan.baseproject.bulk.dto.ValidationDTO;
import com.bryan.baseproject.model.Parameter;

public enum ValidateParameterStrategy {//implements ValidationStrategy<Parameter> {

  ID(0, "ID"){
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  MODULE(1, "MODULO") {
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  LABEL(2, "ETIQUETA") {
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  VALUE1(3, "VALOR 1") {
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  VALUE2(4, "VALOR 2") {
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  VALUE3(5, "VALOR 3") {
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  ACTIVE(6, "ACTIVO") {
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  };

  private final Integer position;
  private String name;

  ValidateParameterStrategy(Integer position, String name){
    this.position=position;
    this.name=name;
  }

}
