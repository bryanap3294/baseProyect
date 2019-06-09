package com.bryan.baseproject.bulk.dto;

import java.util.List;

public class GenericValidationDTO<T> {

  private T t;
  private List<String> errorList;

  public T getT() {
    return t;
  }

  public void setT(T t) {
    this.t = t;
  }

  public List<String> getErrorList() {
    return errorList;
  }

  public void setErrorList(List<String> errorList) {
    this.errorList = errorList;
  }
}
