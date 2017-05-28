package com.epat2.service;

import com.epat2.EmployeeForm;
import com.epat2.OrganizationForm;

public interface OrganizationService {
	
	void saveOrganization(OrganizationForm organizationForm);
	boolean loginEmployee(EmployeeForm  employeeForm);

}
