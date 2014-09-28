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
 * This class is a wrapper for {@link JobCategory}.
 * </p>
 *
 * @author rknowsys
 * @see JobCategory
 * @generated
 */
public class JobCategoryWrapper implements JobCategory,
	ModelWrapper<JobCategory> {
	public JobCategoryWrapper(JobCategory jobCategory) {
		_jobCategory = jobCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return JobCategory.class;
	}

	@Override
	public String getModelClassName() {
		return JobCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobCategoryId", getJobCategoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("jobcategory", getJobcategory());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobCategoryId = (Long)attributes.get("jobCategoryId");

		if (jobCategoryId != null) {
			setJobCategoryId(jobCategoryId);
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

		String jobcategory = (String)attributes.get("jobcategory");

		if (jobcategory != null) {
			setJobcategory(jobcategory);
		}
	}

	/**
	* Returns the primary key of this job category.
	*
	* @return the primary key of this job category
	*/
	@Override
	public long getPrimaryKey() {
		return _jobCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this job category.
	*
	* @param primaryKey the primary key of this job category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jobCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the job category ID of this job category.
	*
	* @return the job category ID of this job category
	*/
	@Override
	public long getJobCategoryId() {
		return _jobCategory.getJobCategoryId();
	}

	/**
	* Sets the job category ID of this job category.
	*
	* @param jobCategoryId the job category ID of this job category
	*/
	@Override
	public void setJobCategoryId(long jobCategoryId) {
		_jobCategory.setJobCategoryId(jobCategoryId);
	}

	/**
	* Returns the company ID of this job category.
	*
	* @return the company ID of this job category
	*/
	@Override
	public long getCompanyId() {
		return _jobCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this job category.
	*
	* @param companyId the company ID of this job category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_jobCategory.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this job category.
	*
	* @return the group ID of this job category
	*/
	@Override
	public long getGroupId() {
		return _jobCategory.getGroupId();
	}

	/**
	* Sets the group ID of this job category.
	*
	* @param groupId the group ID of this job category
	*/
	@Override
	public void setGroupId(long groupId) {
		_jobCategory.setGroupId(groupId);
	}

	/**
	* Returns the create date of this job category.
	*
	* @return the create date of this job category
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _jobCategory.getCreateDate();
	}

	/**
	* Sets the create date of this job category.
	*
	* @param createDate the create date of this job category
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_jobCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this job category.
	*
	* @return the modified date of this job category
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _jobCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this job category.
	*
	* @param modifiedDate the modified date of this job category
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_jobCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this job category.
	*
	* @return the user ID of this job category
	*/
	@Override
	public long getUserId() {
		return _jobCategory.getUserId();
	}

	/**
	* Sets the user ID of this job category.
	*
	* @param userId the user ID of this job category
	*/
	@Override
	public void setUserId(long userId) {
		_jobCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this job category.
	*
	* @return the user uuid of this job category
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this job category.
	*
	* @param userUuid the user uuid of this job category
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_jobCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the jobcategory of this job category.
	*
	* @return the jobcategory of this job category
	*/
	@Override
	public java.lang.String getJobcategory() {
		return _jobCategory.getJobcategory();
	}

	/**
	* Sets the jobcategory of this job category.
	*
	* @param jobcategory the jobcategory of this job category
	*/
	@Override
	public void setJobcategory(java.lang.String jobcategory) {
		_jobCategory.setJobcategory(jobcategory);
	}

	@Override
	public boolean isNew() {
		return _jobCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jobCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jobCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jobCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jobCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jobCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jobCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jobCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jobCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jobCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jobCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JobCategoryWrapper((JobCategory)_jobCategory.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.JobCategory jobCategory) {
		return _jobCategory.compareTo(jobCategory);
	}

	@Override
	public int hashCode() {
		return _jobCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.JobCategory> toCacheModel() {
		return _jobCategory.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.JobCategory toEscapedModel() {
		return new JobCategoryWrapper(_jobCategory.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.JobCategory toUnescapedModel() {
		return new JobCategoryWrapper(_jobCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jobCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jobCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobCategoryWrapper)) {
			return false;
		}

		JobCategoryWrapper jobCategoryWrapper = (JobCategoryWrapper)obj;

		if (Validator.equals(_jobCategory, jobCategoryWrapper._jobCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public JobCategory getWrappedJobCategory() {
		return _jobCategory;
	}

	@Override
	public JobCategory getWrappedModel() {
		return _jobCategory;
	}

	@Override
	public void resetOriginalValues() {
		_jobCategory.resetOriginalValues();
	}

	private JobCategory _jobCategory;
}