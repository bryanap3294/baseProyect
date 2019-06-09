package com.bryan.baseproject.bulk.strategy;

import com.bryan.baseproject.bulk.dto.ValidationDTO;

public interface ValidationStrategy<T> {

  ValidationDTO validate(String value,T t,Boolean required);

}
