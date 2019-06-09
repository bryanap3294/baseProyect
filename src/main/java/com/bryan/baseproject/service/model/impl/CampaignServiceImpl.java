package com.bryan.baseproject.service.model.impl;

import com.bryan.baseproject.model.Campaign;
import com.bryan.baseproject.repository.CampaignRepository;
import com.bryan.baseproject.service.model.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CampaignServiceImpl implements CampaignService {

  @Autowired
  protected CampaignRepository campaignRepository;

  @Override
  public List<Campaign> findAll() {
    return this.campaignRepository.findAll();
  }

  @Override
  public List<Integer> finAllId() {
    List<Campaign> campaignList = this.campaignRepository.findAll();
    List<Integer> campaignListId = new ArrayList<>();
    for(Campaign campaign: campaignList){
      campaignListId.add(campaign.getId());
    }
    return campaignListId;
  }
}
