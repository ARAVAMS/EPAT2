package com.epat2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORG_GROUP_DETAILS")
public class OrganizationGroupDetail {

	@Id
	@GeneratedValue
	@Column(name = "ORG_GROUP_DETAIL_ID")
	private Long orgGroupDetailId;

	@ManyToOne
	@JoinColumn(name = "ORG_DETAIL_ID", insertable = true, updatable = true)
	private OrganizationDetail orgDetail;

	@Column(name = "ORG_GROUP_NAME")
	private String orgGroupName;
	
	@OneToMany(mappedBy="organizationGroupDetail",targetEntity=OrganizationUserRolesMapping.class ,fetch=FetchType.LAZY,cascade ={ CascadeType.ALL })
	private List<OrganizationUserRolesMapping> organizationUserRolesMappings;

	public Long getOrgGroupDetailId() {
		return orgGroupDetailId;
	}

	public void setOrgGroupDetailId(Long orgGroupDetailId) {
		this.orgGroupDetailId = orgGroupDetailId;
	}

	public OrganizationDetail getOrgDetail() {
		return orgDetail;
	}

	public void setOrgDetail(OrganizationDetail orgDetail) {
		this.orgDetail = orgDetail;
	}

	public String getOrgGroupName() {
		return orgGroupName;
	}

	public void setOrgGroupName(String orgGroupName) {
		this.orgGroupName = orgGroupName;
	}

}
