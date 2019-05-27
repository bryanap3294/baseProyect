package com.bryan.baseproject.service.model.impl;

import com.bryan.baseproject.model.Parameter;
import com.bryan.baseproject.model.dto.ParameterXLSXDTO;
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
import java.util.ArrayList;
import java.util.List;

@Component
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    protected ParameterRepository parameterRepository;

    @Autowired
    protected ValidateXLSXParameterService validateXLSXParameterService;

    @Override
    public List<Parameter> findAll() {
        return this.parameterRepository.findAll();
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
}
