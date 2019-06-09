package com.bryan.baseproject.service.model;

import com.bryan.baseproject.model.Campaign;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CampaignService {

  List<Campaign> findAll();
  List<Integer> finAllId();

}
