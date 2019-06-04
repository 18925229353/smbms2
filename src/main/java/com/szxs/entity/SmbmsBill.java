package com.szxs.entity;


import java.util.Date;

/**
 * 商品实体类
 */
public class SmbmsBill {

  private Integer id;
  private String billCode;
  private String productName;
  private String productDesc;
  private String productUnit;
  private double productCount;
  private double totalPrice;
  private Integer isPayment;
  private Integer createdBy;
  private Date creationDate;
  private Integer modifyBy;
  private Date modifyDate;
  private Integer providerId;
  private SmbmsProvider smbmsProvider;//供应商


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getBillCode() {
    return billCode;
  }

  public void setBillCode(String billCode) {
    this.billCode = billCode;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }

  public String getProductUnit() {
    return productUnit;
  }

  public void setProductUnit(String productUnit) {
    this.productUnit = productUnit;
  }

  public double getProductCount() {
    return productCount;
  }

  public void setProductCount(double productCount) {
    this.productCount = productCount;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Integer getIsPayment() {
    return isPayment;
  }

  public void setIsPayment(Integer isPayment) {
    this.isPayment = isPayment;
  }

  public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Integer getModifyBy() {
    return modifyBy;
  }

  public void setModifyBy(Integer modifyBy) {
    this.modifyBy = modifyBy;
  }

  public Date getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }

  public Integer getProviderId() {
    return providerId;
  }

  public void setProviderId(Integer providerId) {
    this.providerId = providerId;
  }

  public SmbmsBill(Integer id, String billCode, String productName, String productDesc, String productUnit, double productCount, double totalPrice, Integer isPayment, Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate, Integer providerId, String proName, SmbmsProvider smbmsProvider) {
    this.id = id;
    this.billCode = billCode;
    this.productName = productName;
    this.productDesc = productDesc;
    this.productUnit = productUnit;
    this.productCount = productCount;
    this.totalPrice = totalPrice;
    this.isPayment = isPayment;
    this.createdBy = createdBy;
    this.creationDate = creationDate;
    this.modifyBy = modifyBy;
    this.modifyDate = modifyDate;
    this.providerId = providerId;
    this.smbmsProvider = smbmsProvider;
  }

  public SmbmsBill() {
  }

  @Override
  public String toString() {
    return "SmbmsBill{" +
            "id=" + id +
            ", billCode='" + billCode + '\'' +
            ", productName='" + productName + '\'' +
            ", productDesc='" + productDesc + '\'' +
            ", productUnit='" + productUnit + '\'' +
            ", productCount=" + productCount +
            ", totalPrice=" + totalPrice +
            ", isPayment=" + isPayment +
            ", createdBy=" + createdBy +
            ", creationDate=" + creationDate +
            ", modifyBy=" + modifyBy +
            ", modifyDate=" + modifyDate +
            ", providerId=" + providerId +
            ", smbmsProvider=" + smbmsProvider +
            '}';
  }

  public SmbmsBill(Integer id) {
    this.id = id;
  }

  public SmbmsProvider getSmbmsProvider() {
    return smbmsProvider;
  }

  public void setSmbmsProvider(SmbmsProvider smbmsProvider) {
    this.smbmsProvider = smbmsProvider;
  }
}
