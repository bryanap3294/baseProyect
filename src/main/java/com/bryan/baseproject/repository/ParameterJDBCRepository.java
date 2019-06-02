package com.bryan.baseproject.repository;

import com.bryan.baseproject.model.Parameter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterJDBCRepository {

    List<Parameter> findAll();

}
