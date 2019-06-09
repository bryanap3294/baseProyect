package com.bryan.baseproject.bulk.strategy;

import com.bryan.baseproject.bulk.dto.ValidationDTO;
import com.bryan.baseproject.bulk.util.FileType;

import java.util.List;

public interface ValidationStrategy<T> {

  ValidationDTO validate(String value, T t, Boolean required, FileType fileType, List<Integer> campaignId);

}
