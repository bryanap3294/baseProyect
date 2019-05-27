package com.bryan.baseproject.model.dto;

import com.bryan.baseproject.model.Parameter;

import java.util.List;

public class ParameterXLSXDTO {

    private Parameter parameter;
    private List<String> mensajes;

    public Parameter getParameter() {
      return parameter;
    }

    public void setParameter(Parameter parameter) {
      this.parameter = parameter;
    }

    public List<String> getMensajes() {
      return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
      this.mensajes = mensajes;
    }
}
