package com.bryan.baseproject.service.custom.validate;

import com.bryan.baseproject.model.Parameter;
import com.bryan.baseproject.model.dto.XLSXDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public enum ValidateParameterEnum {

    ID(0, "ID"){
        @Override
        public XLSXDTO validation(Cell cell, Parameter parameter){
            XLSXDTO<Integer> xlsxdto = new XLSXDTO<>();
            if(cell.getCellTypeEnum().equals(CellType.NUMERIC)){
                Double doubleValue = cell.getNumericCellValue();
                parameter.setId(doubleValue.intValue());
                xlsxdto.setValid(true);
            }else {
                xlsxdto.setValid(false);
                xlsxdto.setErrorMessage("NO ES NUMERICO");
            }
            return xlsxdto;
        }
    },
    MODULE(1, "MODULO") {
        @Override
        public XLSXDTO validation(Cell cell, Parameter parameter) {
            XLSXDTO<String> xlsxdto = new XLSXDTO<>();
            if(cell.getCellTypeEnum().equals(CellType.NUMERIC) || cell.getCellTypeEnum().equals(CellType.STRING)){
                parameter.setModule(cell.toString());
                xlsxdto.setValid(true);
            }else {
                xlsxdto.setValid(false);
                xlsxdto.setErrorMessage("NO ES NUMERICO");
            }
            return xlsxdto;
        }
    },
    LABEL(2, "ETIQUETA") {
        @Override
        public XLSXDTO validation(Cell cell, Parameter parameter) {
            XLSXDTO<String> xlsxdto = new XLSXDTO<>();
            if(cell.getCellTypeEnum().equals(CellType.NUMERIC) || cell.getCellTypeEnum().equals(CellType.STRING)){
                parameter.setLabel(cell.toString());
                xlsxdto.setValid(true);
            }else {
                xlsxdto.setValid(false);
                xlsxdto.setErrorMessage("NO ES NUMERICO");
            }
            return xlsxdto;
        }
    },
    VALUE1(3, "VALOR 1") {
        @Override
        public XLSXDTO validation(Cell cell, Parameter parameter) {
            XLSXDTO<String> xlsxdto = new XLSXDTO<>();
            if(cell.getCellTypeEnum().equals(CellType.NUMERIC) || cell.getCellTypeEnum().equals(CellType.STRING)){
                parameter.setValue1(cell.toString());
                xlsxdto.setValid(true);
            }else {
                xlsxdto.setValid(false);
                xlsxdto.setErrorMessage("NO ES NUMERICO");
            }
            return xlsxdto;
        }
    },
    VALUE2(4, "VALOR 2") {
        @Override
        public XLSXDTO validation(Cell cell, Parameter parameter) {
            XLSXDTO<String> xlsxdto = new XLSXDTO<>();
            if(cell.getCellTypeEnum().equals(CellType.NUMERIC) || cell.getCellTypeEnum().equals(CellType.STRING)){
                parameter.setValue2(cell.toString());
                xlsxdto.setValid(true);
            }else {
                xlsxdto.setValid(false);
                xlsxdto.setErrorMessage("NO ES NUMERICO");
            }
            return xlsxdto;
        }
    },
    VALUE3(5, "VALOR 3") {
        @Override
        public XLSXDTO validation(Cell cell, Parameter parameter) {
            XLSXDTO<String> xlsxdto = new XLSXDTO<>();
            if(cell.getCellTypeEnum().equals(CellType.NUMERIC) || cell.getCellTypeEnum().equals(CellType.STRING)){
                parameter.setValue3(cell.toString());
                xlsxdto.setValid(true);
            }else {
                xlsxdto.setValid(false);
                xlsxdto.setErrorMessage("NO ES NUMERICO");
            }
            return xlsxdto;
        }
    },
    ACTIVE(6, "ACTIVO") {
        @Override
        public XLSXDTO validation(Cell cell, Parameter parameter) {
            XLSXDTO<String> xlsxdto = new XLSXDTO<>();
            Boolean isInteger = isInteger(cell.toString());
            if(isInteger){
                Double doubleValue = new Double(cell.toString());
                Integer integerValue = doubleValue.intValue();
                if(integerValue==0 || integerValue==1){
                    parameter.setActive(integerValue.toString());
                    xlsxdto.setValid(true);
                }else{
                    xlsxdto.setErrorMessage("El numero debe ser 1 ó 0");
                }
            }else{
                xlsxdto.setErrorMessage("NO ES NUMERICO");
            }
            return xlsxdto;
        }
    };

    private final Integer position;
    private String name;

    ValidateParameterEnum(Integer position, String name){
        this.position=position;
        this.name=name;
    }

    public Integer getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public Boolean isInteger(String value){
        try{
            Double doubleValue = new Double(value);
            doubleValue.intValue();
        }catch(Exception e) {
            return false;
        }
        return true;
    }

    public abstract XLSXDTO validation(Cell cell, Parameter parameter);

}
