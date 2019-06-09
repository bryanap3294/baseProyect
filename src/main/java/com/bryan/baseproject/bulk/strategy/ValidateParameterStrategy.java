package com.bryan.baseproject.bulk.strategy;

import com.bryan.baseproject.bulk.dto.ValidationDTO;
import com.bryan.baseproject.model.Parameter;

public enum ValidateParameterStrategy implements ValidationStrategy<Parameter> {

  ID(0, "ID"){
    @Override
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  MODULE(1, "MODULO") {
    @Override
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  LABEL(2, "ETIQUETA") {
    @Override
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  VALUE1(3, "VALOR 1") {
    @Override
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  VALUE2(4, "VALOR 2") {
    @Override
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  VALUE3(5, "VALOR 3") {
    @Override
    public ValidationDTO validate(String value, Parameter parameter,Boolean required){
      ValidationDTO validationDTO = new ValidationDTO();
      return null;
    }
  },
  ACTIVE(6, "ACTIVO") {
    @Override
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
