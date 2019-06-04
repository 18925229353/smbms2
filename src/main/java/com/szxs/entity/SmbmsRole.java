package com.szxs.entity;


import com.alibaba.fastjson.annotation.JSONField;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * 角色实体类
 */
@XmlRootElement
public class SmbmsRole {

  private Integer id;
  private String roleCode;
  private String roleName;
  private Integer createdBy;
  @JSONField(format = "yyyy-MM-dd")
  private Date creationDate;
  private Integer modifyBy;
  private Date modifyDate;
  private List<Smbms_User> smbms_userList;//一个角色对应多个用户

  public List<Smbms_User> getSmbms_userList() {
    return smbms_userList;
  }

  public void setSmbms_userList(List<Smbms_User> smbms_userList) {
    this.smbms_userList = smbms_userList;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRoleCode() {
    return roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
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

  @Override
  public String toString() {
    return "SmbmsRole{" +
            "id=" + id +
            ", roleCode='" + roleCode + '\'' +
            ", roleName='" + roleName + '\'' +
            ", createdBy=" + createdBy +
            ", creationDate=" + creationDate +
            ", modifyBy=" + modifyBy +
            ", modifyDate=" + modifyDate +
            '}';
  }
}
