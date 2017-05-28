package com.epat2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORG_GROUP_PROJECT_DETAIL")
public class OrganizationGroupProjectDetail {

	@Id
	@GeneratedValue
	@Column(name = "ORG_GROUP_PROJECT_ID")
	private Long orgGroupProjectId;

	@Column(name = "ORG_GROUP_PROJECT_NAME")
	private String orgGroupProjectName;

	@ManyToOne
	@JoinColumn(name = "ORG_DETAIL_ID", insertable = true, updatable = true)
	private OrganizationDetail orgDetail;

	@ManyToOne
	@JoinColumn(name = "ORG_GROUP_DETAIL_ID", insertable = true, updatable = true)
	private OrganizationGroupDetail organizationGroupDetail;

	public Long getOrgGroupProjectId() {
		return orgGroupProjectId;
	}

	public void setOrgGroupProjectId(Long orgGroupProjectId) {
		this.orgGroupProjectId = orgGroupProjectId;
	}

	public String getOrgGroupProjectName() {
		return orgGroupProjectName;
	}

	public void setOrgGroupProjectName(String orgGroupProjectName) {
		this.orgGroupProjectName = orgGroupProjectName;
	}

	public OrganizationDetail getOrgDetail() {
		return orgDetail;
	}

	public void setOrgDetail(OrganizationDetail orgDetail) {
		this.orgDetail = orgDetail;
	}

	public OrganizationGroupDetail getOrganizationGroupDetail() {
		return organizationGroupDetail;
	}

	public void setOrganizationGroupDetail(OrganizationGroupDetail organizationGroupDetail) {
		this.organizationGroupDetail = organizationGroupDetail;
	}

}
