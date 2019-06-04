package com.szxs.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.Date;

/**
 * 用户实体类
 */

public class Smbms_User {

  private Integer id;
  private String userCode;
  private String userName;
  private String userPassword;
  private Integer gender;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthday;
  private String phone;
  private String address;
  private Integer userRole;
  private Integer createdBy;
  private Date creationDate;
  private Integer modifyBy;
  private Date modifyDate;
  private SmbmsRole smbmsRole;//角色对象
  private Integer age;
  private String userImg;

  public String getUserImg() {
    return userImg;
  }

  public void setUserImg(String userImg) {
    this.userImg = userImg;
  }

  public Integer getAge() {
    //计算年龄
    Date currDate = new Date();
    Long time = (currDate.getTime()-birthday.getTime()) / 31536000000L;
    return time.intValue();
  }

  public Smbms_User(Integer id) {
    this.id = id;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public SmbmsRole getSmbmsRole() {
    return smbmsRole;
  }

  public void setSmbmsRole(SmbmsRole smbmsRole) {
    this.smbmsRole = smbmsRole;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getUserRole() {
    return userRole;
  }

  public void setUserRole(Integer userRole) {
    this.userRole = userRole;
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

  public Smbms_User(String userCode, String userName, String userPassword, Integer gender, Date birthday, String phone, String address, Integer userRole, Integer createdBy, Date creationDate) {
    this.userCode = userCode;
    this.userName = userName;
    this.userPassword = userPassword;
    this.gender = gender;
    this.birthday = birthday;
    this.phone = phone;
    this.address = address;
    this.userRole = userRole;
    this.createdBy = createdBy;
    this.creationDate = creationDate;
  }

  @Override
  public String toString() {
    return "Smbms_User{" +
            "id=" + id +
            ", userCode='" + userCode + '\'' +
            ", userName='" + userName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", gender=" + gender +
            ", birthday=" + birthday +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", userRole=" + userRole +
            ", createdBy=" + createdBy +
            ", creationDate=" + creationDate +
            ", modifyBy=" + modifyBy +
            ", modifyDate=" + modifyDate +
            ", smbmsRole=" + smbmsRole +
            '}';
  }

  public Smbms_User() {
  }

  public Smbms_User(String userCode, String userPassword) {
    this.userCode = userCode;
    this.userPassword = userPassword;
  }
}
