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
 * This class is a wrapper for {@link EmploymentStatus}.
 * </p>
 *
 * @author rknowsys
 * @see EmploymentStatus
 * @generated
 */
public class EmploymentStatusWrapper implements EmploymentStatus,
	ModelWrapper<EmploymentStatus> {
	public EmploymentStatusWrapper(EmploymentStatus employmentStatus) {
		_employmentStatus = employmentStatus;
	}

	@Override
	public Class<?> getModelClass() {
		return EmploymentStatus.class;
	}

	@Override
	public String getModelClassName() {
		return EmploymentStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employmentStatusId", getEmploymentStatusId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employmentstatus", getEmploymentstatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employmentStatusId = (Long)attributes.get("employmentStatusId");

		if (employmentStatusId != null) {
			setEmploymentStatusId(employmentStatusId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String employmentstatus = (String)attributes.get("employmentstatus");

		if (employmentstatus != null) {
			setEmploymentstatus(employmentstatus);
		}
	}

	/**
	* Returns the primary key of this employment status.
	*
	* @return the primary key of this employment status
	*/
	@Override
	public long getPrimaryKey() {
		return _employmentStatus.getPrimaryKey();
	}

	/**
	* Sets the primary key of this employment status.
	*
	* @param primaryKey the primary key of this employment status
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employmentStatus.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the employment status ID of this employment status.
	*
	* @return the employment status ID of this employment status
	*/
	@Override
	public long getEmploymentStatusId() {
		return _employmentStatus.getEmploymentStatusId();
	}

	/**
	* Sets the employment status ID of this employment status.
	*
	* @param employmentStatusId the employment status ID of this employment status
	*/
	@Override
	public void setEmploymentStatusId(long employmentStatusId) {
		_employmentStatus.setEmploymentStatusId(employmentStatusId);
	}

	/**
	* Returns the group ID of this employment status.
	*
	* @return the group ID of this employment status
	*/
	@Override
	public long getGroupId() {
		return _employmentStatus.getGroupId();
	}

	/**
	* Sets the group ID of this employment status.
	*
	* @param groupId the group ID of this employment status
	*/
	@Override
	public void setGroupId(long groupId) {
		_employmentStatus.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this employment status.
	*
	* @return the company ID of this employment status
	*/
	@Override
	public long getCompanyId() {
		return _employmentStatus.getCompanyId();
	}

	/**
	* Sets the company ID of this employment status.
	*
	* @param companyId the company ID of this employment status
	*/
	@Override
	public void setCompanyId(long companyId) {
		_employmentStatus.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this employment status.
	*
	* @return the user ID of this employment status
	*/
	@Override
	public long getUserId() {
		return _employmentStatus.getUserId();
	}

	/**
	* Sets the user ID of this employment status.
	*
	* @param userId the user ID of this employment status
	*/
	@Override
	public void setUserId(long userId) {
		_employmentStatus.setUserId(userId);
	}

	/**
	* Returns the user uuid of this employment status.
	*
	* @return the user uuid of this employment status
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employmentStatus.getUserUuid();
	}

	/**
	* Sets the user uuid of this employment status.
	*
	* @param userUuid the user uuid of this employment status
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_employmentStatus.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this employment status.
	*
	* @return the create date of this employment status
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _employmentStatus.getCreateDate();
	}

	/**
	* Sets the create date of this employment status.
	*
	* @param createDate the create date of this employment status
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_employmentStatus.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this employment status.
	*
	* @return the modified date of this employment status
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _employmentStatus.getModifiedDate();
	}

	/**
	* Sets the modified date of this employment status.
	*
	* @param modifiedDate the modified date of this employment status
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_employmentStatus.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the employmentstatus of this employment status.
	*
	* @return the employmentstatus of this employment status
	*/
	@Override
	public java.lang.String getEmploymentstatus() {
		return _employmentStatus.getEmploymentstatus();
	}

	/**
	* Sets the employmentstatus of this employment status.
	*
	* @param employmentstatus the employmentstatus of this employment status
	*/
	@Override
	public void setEmploymentstatus(java.lang.String employmentstatus) {
		_employmentStatus.setEmploymentstatus(employmentstatus);
	}

	@Override
	public boolean isNew() {
		return _employmentStatus.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_employmentStatus.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _employmentStatus.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employmentStatus.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _employmentStatus.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _employmentStatus.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_employmentStatus.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _employmentStatus.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_employmentStatus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_employmentStatus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_employmentStatus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmploymentStatusWrapper((EmploymentStatus)_employmentStatus.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus) {
		return _employmentStatus.compareTo(employmentStatus);
	}

	@Override
	public int hashCode() {
		return _employmentStatus.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmploymentStatus> toCacheModel() {
		return _employmentStatus.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmploymentStatus toEscapedModel() {
		return new EmploymentStatusWrapper(_employmentStatus.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmploymentStatus toUnescapedModel() {
		return new EmploymentStatusWrapper(_employmentStatus.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _employmentStatus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _employmentStatus.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_employmentStatus.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmploymentStatusWrapper)) {
			return false;
		}

		EmploymentStatusWrapper employmentStatusWrapper = (EmploymentStatusWrapper)obj;

		if (Validator.equals(_employmentStatus,
					employmentStatusWrapper._employmentStatus)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmploymentStatus getWrappedEmploymentStatus() {
		return _employmentStatus;
	}

	@Override
	public EmploymentStatus getWrappedModel() {
		return _employmentStatus;
	}

	@Override
	public void resetOriginalValues() {
		_employmentStatus.resetOriginalValues();
	}

	private EmploymentStatus _employmentStatus;
}