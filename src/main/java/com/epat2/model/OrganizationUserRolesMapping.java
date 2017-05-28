package com.epat2.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORG_USER_ROLE_MAPPING")
public class OrganizationUserRolesMapping {

	@Id
	@GeneratedValue
	@Column(name = "ORG_USER_ROLE_ID")
	private Long orgUserRoleId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ORG_DETAIL_ID", insertable = true, updatable = true)
	private OrganizationGroupDetail organizationGroupDetail;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ROLE_ID", insertable = true, updatable = true)
	private UserRole userRole;

	public Long getOrgUserRoleId() {
		return orgUserRoleId;
	}

	public void setOrgUserRoleId(Long orgUserRoleId) {
		this.orgUserRoleId = orgUserRoleId;
	}

	public OrganizationGroupDetail getOrganizationGroupDetail() {
		return organizationGroupDetail;
	}

	public void setOrganizationGroupDetail(OrganizationGroupDetail organizationGroupDetail) {
		this.organizationGroupDetail = organizationGroupDetail;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

}
