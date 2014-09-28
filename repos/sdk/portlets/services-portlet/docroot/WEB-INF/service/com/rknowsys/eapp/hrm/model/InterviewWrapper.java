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
 * This class is a wrapper for {@link Interview}.
 * </p>
 *
 * @author rknowsys
 * @see Interview
 * @generated
 */
public class InterviewWrapper implements Interview, ModelWrapper<Interview> {
	public InterviewWrapper(Interview interview) {
		_interview = interview;
	}

	@Override
	public Class<?> getModelClass() {
		return Interview.class;
	}

	@Override
	public String getModelClassName() {
		return Interview.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("interviewId", getInterviewId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long interviewId = (Long)attributes.get("interviewId");

		if (interviewId != null) {
			setInterviewId(interviewId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this interview.
	*
	* @return the primary key of this interview
	*/
	@Override
	public long getPrimaryKey() {
		return _interview.getPrimaryKey();
	}

	/**
	* Sets the primary key of this interview.
	*
	* @param primaryKey the primary key of this interview
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_interview.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the interview ID of this interview.
	*
	* @return the interview ID of this interview
	*/
	@Override
	public long getInterviewId() {
		return _interview.getInterviewId();
	}

	/**
	* Sets the interview ID of this interview.
	*
	* @param interviewId the interview ID of this interview
	*/
	@Override
	public void setInterviewId(long interviewId) {
		_interview.setInterviewId(interviewId);
	}

	/**
	* Returns the company ID of this interview.
	*
	* @return the company ID of this interview
	*/
	@Override
	public long getCompanyId() {
		return _interview.getCompanyId();
	}

	/**
	* Sets the company ID of this interview.
	*
	* @param companyId the company ID of this interview
	*/
	@Override
	public void setCompanyId(long companyId) {
		_interview.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this interview.
	*
	* @return the group ID of this interview
	*/
	@Override
	public long getGroupId() {
		return _interview.getGroupId();
	}

	/**
	* Sets the group ID of this interview.
	*
	* @param groupId the group ID of this interview
	*/
	@Override
	public void setGroupId(long groupId) {
		_interview.setGroupId(groupId);
	}

	/**
	* Returns the create date of this interview.
	*
	* @return the create date of this interview
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _interview.getCreateDate();
	}

	/**
	* Sets the create date of this interview.
	*
	* @param createDate the create date of this interview
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_interview.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this interview.
	*
	* @return the modified date of this interview
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _interview.getModifiedDate();
	}

	/**
	* Sets the modified date of this interview.
	*
	* @param modifiedDate the modified date of this interview
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_interview.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this interview.
	*
	* @return the user ID of this interview
	*/
	@Override
	public long getUserId() {
		return _interview.getUserId();
	}

	/**
	* Sets the user ID of this interview.
	*
	* @param userId the user ID of this interview
	*/
	@Override
	public void setUserId(long userId) {
		_interview.setUserId(userId);
	}

	/**
	* Returns the user uuid of this interview.
	*
	* @return the user uuid of this interview
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interview.getUserUuid();
	}

	/**
	* Sets the user uuid of this interview.
	*
	* @param userUuid the user uuid of this interview
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_interview.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this interview.
	*
	* @return the name of this interview
	*/
	@Override
	public java.lang.String getName() {
		return _interview.getName();
	}

	/**
	* Sets the name of this interview.
	*
	* @param name the name of this interview
	*/
	@Override
	public void setName(java.lang.String name) {
		_interview.setName(name);
	}

	@Override
	public boolean isNew() {
		return _interview.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_interview.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _interview.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_interview.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _interview.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _interview.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_interview.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _interview.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_interview.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_interview.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_interview.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InterviewWrapper((Interview)_interview.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Interview interview) {
		return _interview.compareTo(interview);
	}

	@Override
	public int hashCode() {
		return _interview.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Interview> toCacheModel() {
		return _interview.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Interview toEscapedModel() {
		return new InterviewWrapper(_interview.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Interview toUnescapedModel() {
		return new InterviewWrapper(_interview.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _interview.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _interview.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_interview.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InterviewWrapper)) {
			return false;
		}

		InterviewWrapper interviewWrapper = (InterviewWrapper)obj;

		if (Validator.equals(_interview, interviewWrapper._interview)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Interview getWrappedInterview() {
		return _interview;
	}

	@Override
	public Interview getWrappedModel() {
		return _interview;
	}

	@Override
	public void resetOriginalValues() {
		_interview.resetOriginalValues();
	}

	private Interview _interview;
}