package com.bryan.baseproject.bulk.dto;

public class ValidationDTO {

  private Boolean isValid = false;
  private String errorMessage;

  public Boolean getValid() {
    return isValid;
  }

  public void setValid(Boolean valid) {
    isValid = valid;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
