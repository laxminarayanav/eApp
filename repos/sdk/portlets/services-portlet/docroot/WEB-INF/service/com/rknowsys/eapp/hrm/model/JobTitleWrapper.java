/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rknowsys.eapp.hrm.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link JobTitle}.
 * </p>
 *
 * @author rknowsys
 * @see JobTitle
 * @generated
 */
public class JobTitleWrapper implements JobTitle, ModelWrapper<JobTitle> {
	public JobTitleWrapper(JobTitle jobTitle) {
		_jobTitle = jobTitle;
	}

	@Override
	public Class<?> getModelClass() {
		return JobTitle.class;
	}

	@Override
	public String getModelClassName() {
		return JobTitle.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobTitleId", getJobTitleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("notes", getNotes());
		attributes.put("specification", getSpecification());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobTitleId = (Long)attributes.get("jobTitleId");

		if (jobTitleId != null) {
			setJobTitleId(jobTitleId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}

		String specification = (String)attributes.get("specification");

		if (specification != null) {
			setSpecification(specification);
		}
	}

	/**
	* Returns the primary key of this job title.
	*
	* @return the primary key of this job title
	*/
	@Override
	public long getPrimaryKey() {
		return _jobTitle.getPrimaryKey();
	}

	/**
	* Sets the primary key of this job title.
	*
	* @param primaryKey the primary key of this job title
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jobTitle.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the job title ID of this job title.
	*
	* @return the job title ID of this job title
	*/
	@Override
	public long getJobTitleId() {
		return _jobTitle.getJobTitleId();
	}

	/**
	* Sets the job title ID of this job title.
	*
	* @param jobTitleId the job title ID of this job title
	*/
	@Override
	public void setJobTitleId(long jobTitleId) {
		_jobTitle.setJobTitleId(jobTitleId);
	}

	/**
	* Returns the company ID of this job title.
	*
	* @return the company ID of this job title
	*/
	@Override
	public long getCompanyId() {
		return _jobTitle.getCompanyId();
	}

	/**
	* Sets the company ID of this job title.
	*
	* @param companyId the company ID of this job title
	*/
	@Override
	public void setCompanyId(long companyId) {
		_jobTitle.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this job title.
	*
	* @return the group ID of this job title
	*/
	@Override
	public long getGroupId() {
		return _jobTitle.getGroupId();
	}

	/**
	* Sets the group ID of this job title.
	*
	* @param groupId the group ID of this job title
	*/
	@Override
	public void setGroupId(long groupId) {
		_jobTitle.setGroupId(groupId);
	}

	/**
	* Returns the create date of this job title.
	*
	* @return the create date of this job title
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _jobTitle.getCreateDate();
	}

	/**
	* Sets the create date of this job title.
	*
	* @param createDate the create date of this job title
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_jobTitle.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this job title.
	*
	* @return the modified date of this job title
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _jobTitle.getModifiedDate();
	}

	/**
	* Sets the modified date of this job title.
	*
	* @param modifiedDate the modified date of this job title
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_jobTitle.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this job title.
	*
	* @return the user ID of this job title
	*/
	@Override
	public long getUserId() {
		return _jobTitle.getUserId();
	}

	/**
	* Sets the user ID of this job title.
	*
	* @param userId the user ID of this job title
	*/
	@Override
	public void setUserId(long userId) {
		_jobTitle.setUserId(userId);
	}

	/**
	* Returns the user uuid of this job title.
	*
	* @return the user uuid of this job title
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitle.getUserUuid();
	}

	/**
	* Sets the user uuid of this job title.
	*
	* @param userUuid the user uuid of this job title
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_jobTitle.setUserUuid(userUuid);
	}

	/**
	* Returns the title of this job title.
	*
	* @return the title of this job title
	*/
	@Override
	public java.lang.String getTitle() {
		return _jobTitle.getTitle();
	}

	/**
	* Sets the title of this job title.
	*
	* @param title the title of this job title
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_jobTitle.setTitle(title);
	}

	/**
	* Returns the description of this job title.
	*
	* @return the description of this job title
	*/
	@Override
	public java.lang.String getDescription() {
		return _jobTitle.getDescription();
	}

	/**
	* Sets the description of this job title.
	*
	* @param description the description of this job title
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_jobTitle.setDescription(description);
	}

	/**
	* Returns the notes of this job title.
	*
	* @return the notes of this job title
	*/
	@Override
	public java.lang.String getNotes() {
		return _jobTitle.getNotes();
	}

	/**
	* Sets the notes of this job title.
	*
	* @param notes the notes of this job title
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_jobTitle.setNotes(notes);
	}

	/**
	* Returns the specification of this job title.
	*
	* @return the specification of this job title
	*/
	@Override
	public java.lang.String getSpecification() {
		return _jobTitle.getSpecification();
	}

	/**
	* Sets the specification of this job title.
	*
	* @param specification the specification of this job title
	*/
	@Override
	public void setSpecification(java.lang.String specification) {
		_jobTitle.setSpecification(specification);
	}

	@Override
	public boolean isNew() {
		return _jobTitle.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jobTitle.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jobTitle.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jobTitle.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jobTitle.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jobTitle.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jobTitle.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jobTitle.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jobTitle.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jobTitle.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jobTitle.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JobTitleWrapper((JobTitle)_jobTitle.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.JobTitle jobTitle) {
		return _jobTitle.compareTo(jobTitle);
	}

	@Override
	public int hashCode() {
		return _jobTitle.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.JobTitle> toCacheModel() {
		return _jobTitle.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.JobTitle toEscapedModel() {
		return new JobTitleWrapper(_jobTitle.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.JobTitle toUnescapedModel() {
		return new JobTitleWrapper(_jobTitle.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jobTitle.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jobTitle.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobTitle.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobTitleWrapper)) {
			return false;
		}

		JobTitleWrapper jobTitleWrapper = (JobTitleWrapper)obj;

		if (Validator.equals(_jobTitle, jobTitleWrapper._jobTitle)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public JobTitle getWrappedJobTitle() {
		return _jobTitle;
	}

	@Override
	public JobTitle getWrappedModel() {
		return _jobTitle;
	}

	@Override
	public void resetOriginalValues() {
		_jobTitle.resetOriginalValues();
	}

	private JobTitle _jobTitle;
}