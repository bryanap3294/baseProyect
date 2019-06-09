package com.bryan.baseproject.model;

import java.util.List;

public class CustomerCampaign {

  private Integer id;
  private String docType;
  private String docNumber;
  private List<Integer> campaignIdList;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDocType() {
    return docType;
  }

  public void setDocType(String docType) {
    this.docType = docType;
  }

  public String getDocNumber() {
    return docNumber;
  }

  public void setDocNumber(String docNumber) {
    this.docNumber = docNumber;
  }

  public List<Integer> getCampaignIdList() {
    return campaignIdList;
  }

  public void setCampaignIdList(List<Integer> campaignIdList) {
    this.campaignIdList = campaignIdList;
  }

  @Override
  public String toString() {
    return "CustomerCampaign{" +
      "id=" + id +
      ", docType='" + docType + '\'' +
      ", docNumber='" + docNumber + '\'' +
      ", campaignIdList=" + campaignIdList +
      '}';
  }
}
