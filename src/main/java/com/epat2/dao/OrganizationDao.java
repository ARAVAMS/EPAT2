package com.epat2.dao;

import com.epat2.EmployeeForm;
import com.epat2.model.OrganizationDetail;

public interface OrganizationDao {
	void saveOrganization(OrganizationDetail organizationDetail);
	boolean loginEmployee(EmployeeForm  employeeForm);

}
