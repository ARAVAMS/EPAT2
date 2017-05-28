package com.epat2;

import java.util.List;

import com.epat2.EmployeeForm;

public class OrganizationForm {

	private Long orgDetailId = null;
	private String orgName = null;
	private String orgAdd1 = null;
	private String orgAdd2 = null;
	List<OrganizationGroupForm> organizationGroupForms = null;
	EmployeeForm employeeForm ; 

	public Long getOrgDetailId() {
		return orgDetailId;
	}

	public void setOrgDetailId(Long orgDetailId) {
		this.orgDetailId = orgDetailId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgAdd1() {
		return orgAdd1;
	}

	public void setOrgAdd1(String orgAdd1) {
		this.orgAdd1 = orgAdd1;
	}

	public String getOrgAdd2() {
		return orgAdd2;
	}

	public void setOrgAdd2(String orgAdd2) {
		this.orgAdd2 = orgAdd2;
	}

	public List<OrganizationGroupForm> getOrganizationGroupForms() {
		return organizationGroupForms;
	}

	public void setOrganizationGroupForms(
			List<OrganizationGroupForm> organizationGroupForms) {
		this.organizationGroupForms = organizationGroupForms;
	}

	public EmployeeForm getEmployeeForm() {
		return employeeForm;
	}

	public void setEmployeeForm(EmployeeForm employeeForm) {
		this.employeeForm = employeeForm;
	}

	

}
