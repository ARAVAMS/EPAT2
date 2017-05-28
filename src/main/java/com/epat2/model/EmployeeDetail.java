package com.epat2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_DETAIL")
public class EmployeeDetail {

	@Id
	@GeneratedValue
	@Column(name = "EMP_ID")
	private Long organizationGroupId;

	@Column(name = "EMP_EMAIL")
	private String empEmail;

	@Column(name = "EMP_FIRST_NAME")
	private String empFirstName;

	@Column(name = "EMP_MIDDLE_NAME")
	private String empMiddleName;

	@Column(name = "EMP_LAST_NAME")
	private String empLastName;

	@Column(name = "ORG_ID")
	private String organizationId;

	@Column(name = "EMP_SPACE")
	private String empSpace;

	@Column(name = "PASSWORD")
	private String password;

	public Long getOrganizationGroupId() {
		return organizationGroupId;
	}

	public void setOrganizationGroupId(Long organizationGroupId) {
		this.organizationGroupId = organizationGroupId;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpMiddleName() {
		return empMiddleName;
	}

	public void setEmpMiddleName(String empMiddleName) {
		this.empMiddleName = empMiddleName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getEmpSpace() {
		return empSpace;
	}

	public void setEmpSpace(String empSpace) {
		this.empSpace = empSpace;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
