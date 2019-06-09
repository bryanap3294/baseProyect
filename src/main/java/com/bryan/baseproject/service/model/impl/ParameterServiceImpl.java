package com.bryan.baseproject.service.model.impl;

import com.bryan.baseproject.bulk.dto.GenericValidationDTO;
import com.bryan.baseproject.bulk.service.GenericValidationService;
import com.bryan.baseproject.model.Parameter;
import com.bryan.baseproject.model.dto.ParameterXLSXDTO;
import com.bryan.baseproject.repository.ParameterJDBCRepository;
import com.bryan.baseproject.repository.ParameterRepository;
import com.bryan.baseproject.service.custom.ValidateXLSXParameterService;
import com.bryan.baseproject.service.model.ParameterService;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    protected ParameterRepository parameterRepository;

    @Autowired
    protected ParameterJDBCRepository parameterJDBCRepository;

    @Autowired
    protected ValidateXLSXParameterService validateXLSXParameterService;

    protected GenericValidationService genericValidationService;

    @Override
    public List<Parameter> findAll() {
        return this.parameterRepository.findAll();
    }

    @Override
    public List<Parameter> parameterList() {
        return this.parameterJDBCRepository.parameterList();
    }

    @Override
    public Integer parameterSave(Parameter parameter) {
        return this.parameterJDBCRepository.parameterSave(parameter);
    }

    @Override
    public Object uploadXLSX(MultipartFile file) throws Exception{
        Workbook workbook=null;
        List<ParameterXLSXDTO> parameterXLSXDTOList = new ArrayList<>();
        List<Parameter> parameterList = new ArrayList<>();
        List<String> errorList = new ArrayList<>();
        try{
            InputStream in = file.getInputStream();
            workbook = new XSSFWorkbook(in);
            Sheet sheet = workbook.getSheetAt(0);
            Integer startRow=1;
            sheet.forEach(row -> {
                if(row.getRowNum()>=startRow){
                    ParameterXLSXDTO parameterXLSXDTO = this.validateXLSXParameterService.validateParameterXLSX(row);
                    parameterList.add(parameterXLSXDTO.getParameter());
                    errorList.addAll(parameterXLSXDTO.getMensajes());
                    parameterXLSXDTOList.add(parameterXLSXDTO);
                }
            });
            if(errorList.size()==0){
                this.parameterRepository.saveAll(parameterList);
                return true;
            }else{
                return errorList;
            }
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }finally {
            workbook.close();
        }
    }

    @Override
    public Object uploadCSV(MultipartFile file) throws Exception {

        List<List<String>> rowList = readCSV(file);
        List<Parameter> parameterList = new ArrayList<>();
        List<String> errorList = new ArrayList<>();
        for(List<String> row: rowList){
            if(rowList.indexOf(row)!=0){
                GenericValidationDTO<Parameter> genericValidationDTO = this.genericValidationService.validateRowCSV(row);
                parameterList.add(genericValidationDTO.getT());
                errorList.addAll(genericValidationDTO.getErrorList());
            }
        }
        return null;
    }

    public List<List<String>> readCSV(MultipartFile file) throws Exception{

        List<List<String>> records = new ArrayList<>();
        Scanner scanner = new Scanner(new InputStreamReader(file.getInputStream(),"ISO-8859-1"));
        while (scanner.hasNextLine()) {
            records.add(getRecordFromLine(scanner.nextLine()));
        }
        return records;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
