package com.bryan.baseproject.bulk.util;

public enum FileType {

  XLSX(1, "Excel"),
  CSV(2, "Texto Plano");

  private final Integer id;
  private String name;

  FileType(Integer id, String name){
    this.id=id;
    this.name=name;
  }

}
