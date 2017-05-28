package com.epat2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.epat2.EmployeeForm;
import com.epat2.OrganizationForm;
import com.epat2.dao.OrganizationDao;
import com.epat2.model.OrganizationDetail;

@Service(value = "organizationservice")
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDao organizationDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrganization(OrganizationForm organizationForm) {
		OrganizationDetail organizationDetail = new OrganizationDetail();
		organizationDetail.setOrgName(organizationForm.getOrgName());
		organizationDetail.setOrgAdd1(organizationForm.getOrgAdd1());
		organizationDetail.setOrgAdd2(organizationForm.getOrgAdd2());
		organizationDao.saveOrganization(organizationDetail);		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public boolean loginEmployee(EmployeeForm employeeForm) {
		return organizationDao.loginEmployee(employeeForm);
	}

}
