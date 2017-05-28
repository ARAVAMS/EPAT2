package com.epat2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORG_SPACE")
public class OrganizationSpace {

	@Id
	@GeneratedValue
	@Column(name = "ORG_SPACE_ID")
	private Long orgSpaceId;

	@Column(name = "ORG_SPACE_NAME")
	private String orgSpaceName;

	@ManyToOne
	@JoinColumn(name = "ORG_DETAIL_ID", insertable = true, updatable = true)
	private OrganizationDetail orgDetail;

	public Long getOrgSpaceId() {
		return orgSpaceId;
	}

	public void setOrgSpaceId(Long orgSpaceId) {
		this.orgSpaceId = orgSpaceId;
	}

	public String getOrgSpaceName() {
		return orgSpaceName;
	}

	public void setOrgSpaceName(String orgSpaceName) {
		this.orgSpaceName = orgSpaceName;
	}

	public OrganizationDetail getOrgDetail() {
		return orgDetail;
	}

	public void setOrgDetail(OrganizationDetail orgDetail) {
		this.orgDetail = orgDetail;
	}

}
