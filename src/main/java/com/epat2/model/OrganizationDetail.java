package com.epat2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.epat2.EPAT2Constants;
import com.epat2.util.EPAT2Util;

/*
 * use ctrl+shift+x/y to make caps and small
 */
@Entity
@Table(name = "ORG_DETAIL")
public class OrganizationDetail {

	@Id
	@GeneratedValue
	@Column(name = "ORG_DETAIL_ID")
	private Long orgDetailId;

	@Column(name = "ORG_NAME", nullable = false, length = 200)
	private String orgName;

	@Column(name = "ORG_ADDRESS1")
	private String orgAdd1;

	@Column(name = "ORG_ADDRESS2")
	private String orgAdd2;

	@OneToMany(mappedBy = "orgDetail", cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
	List<OrganizationGroupDetail> orgGroupDetails = new ArrayList<OrganizationGroupDetail>();

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

	public List<OrganizationGroupDetail> getOrgGroupDetails() {
		return orgGroupDetails;
	}

	public void setOrgGroupDetails(List<OrganizationGroupDetail> orgGroupDetails) {
		this.orgGroupDetails = orgGroupDetails;
	}

	
	
	public void addOrgGroupDetail(OrganizationGroupDetail organizationGroupDetail) {
		if (!EPAT2Util.isNotNullAndEmpty(orgGroupDetails)) {
			orgGroupDetails = new ArrayList<OrganizationGroupDetail>();
		}
		organizationGroupDetail.setOrgDetail(this);
		orgGroupDetails.add(organizationGroupDetail);
	}
}
