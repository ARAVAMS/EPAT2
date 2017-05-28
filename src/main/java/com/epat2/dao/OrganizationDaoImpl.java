package com.epat2.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epat2.EmployeeForm;
import com.epat2.model.OrganizationDetail;
import com.epat2.util.EPAT2Util;

@Repository(value = "organizationDao")
public class OrganizationDaoImpl implements OrganizationDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveOrganization(OrganizationDetail organizationDetail) {
		sessionFactory.getCurrentSession().saveOrUpdate(organizationDetail);

	}

	@Override
	public boolean loginEmployee(EmployeeForm employeeForm) {
		String sql = "FROM EmployeeDetail e WHERE e.empEmail = '"
				+ employeeForm.getUserId() + "' and e.password ='"
				+ employeeForm.getPwd() + "' ";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		if (EPAT2Util.isNotNullAndEmpty(query.list())) {
			return true;
		}
		return false;
	}

}
