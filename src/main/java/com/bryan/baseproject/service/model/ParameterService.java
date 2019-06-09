package com.bryan.baseproject.service.model;

import com.bryan.baseproject.model.Parameter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ParameterService {

    List<Parameter> findAll();
    List<Parameter> parameterList();
    Integer parameterSave(Parameter parameter);
    Object uploadXLSX(MultipartFile file) throws Exception;
    Object uploadCSV(MultipartFile file) throws Exception;
}
