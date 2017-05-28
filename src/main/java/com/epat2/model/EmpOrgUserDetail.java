package com.epat2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_ORG_USER_ROLE")
public class EmpOrgUserDetail {

	@Id
	@GeneratedValue
	@Column(name = "EMP_ORG_USER_ROLE_ID")
	private Long empOrgUserRoleId;

	@ManyToOne
	@JoinColumn(name = "EMP_ID", insertable = true, updatable = true)
	private EmployeeDetail employeeDetail;

	@ManyToOne
	@JoinColumn(name = "ORG_USER_ROLE_ID", insertable = true, updatable = true)
	private OrganizationUserRolesMapping orgUserRolesMapping;

	@ManyToOne
	@JoinColumn(name = "ORG_GROUP_PROJECT_ID", insertable = true, updatable = true)
	private OrganizationGroupProjectDetail orgGroupProDetail;

	public Long getEmpOrgUserRoleId() {
		return empOrgUserRoleId;
	}

	public void setEmpOrgUserRoleId(Long empOrgUserRoleId) {
		this.empOrgUserRoleId = empOrgUserRoleId;
	}

	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}

	public OrganizationUserRolesMapping getOrgUserRolesMapping() {
		return orgUserRolesMapping;
	}

	public void setOrgUserRolesMapping(OrganizationUserRolesMapping orgUserRolesMapping) {
		this.orgUserRolesMapping = orgUserRolesMapping;
	}

	public OrganizationGroupProjectDetail getOrgGroupProDetail() {
		return orgGroupProDetail;
	}

	public void setOrgGroupProDetail(OrganizationGroupProjectDetail orgGroupProDetail) {
		this.orgGroupProDetail = orgGroupProDetail;
	}

}
