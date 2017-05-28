package com.epat2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

	@Id
	@GeneratedValue
	@Column(name = "USER_ROLE_ID")
	private Long userRoleId;

	@Column(name = "USER_ROLE_CODE", nullable = false, length = 200)
	private String userRoleCode;

	@Column(name = "USER_ROLE_NAME")
	private String userRoleName;

	@Column(name = "USER_ROLE_DESC")
	private String userRoleDesc;

	@OneToMany(mappedBy = "userRole", targetEntity = OrganizationUserRolesMapping.class, fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<OrganizationUserRolesMapping> organizationUserRolesMappings;

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleCode() {
		return userRoleCode;
	}

	public void setUserRoleCode(String userRoleCode) {
		this.userRoleCode = userRoleCode;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public String getUserRoleDesc() {
		return userRoleDesc;
	}

	public void setUserRoleDesc(String userRoleDesc) {
		this.userRoleDesc = userRoleDesc;
	}

}
