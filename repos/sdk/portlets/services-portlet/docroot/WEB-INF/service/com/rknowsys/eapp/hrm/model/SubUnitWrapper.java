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
 * This class is a wrapper for {@link SubUnit}.
 * </p>
 *
 * @author rknowsys
 * @see SubUnit
 * @generated
 */
public class SubUnitWrapper implements SubUnit, ModelWrapper<SubUnit> {
	public SubUnitWrapper(SubUnit subUnit) {
		_subUnit = subUnit;
	}

	@Override
	public Class<?> getModelClass() {
		return SubUnit.class;
	}

	@Override
	public String getModelClassName() {
		return SubUnit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subUnitId", getSubUnitId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subUnitId = (Long)attributes.get("subUnitId");

		if (subUnitId != null) {
			setSubUnitId(subUnitId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	}

	/**
	* Returns the primary key of this SubUnit.
	*
	* @return the primary key of this SubUnit
	*/
	@Override
	public long getPrimaryKey() {
		return _subUnit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this SubUnit.
	*
	* @param primaryKey the primary key of this SubUnit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_subUnit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sub unit ID of this SubUnit.
	*
	* @return the sub unit ID of this SubUnit
	*/
	@Override
	public long getSubUnitId() {
		return _subUnit.getSubUnitId();
	}

	/**
	* Sets the sub unit ID of this SubUnit.
	*
	* @param subUnitId the sub unit ID of this SubUnit
	*/
	@Override
	public void setSubUnitId(long subUnitId) {
		_subUnit.setSubUnitId(subUnitId);
	}

	/**
	* Returns the name of this SubUnit.
	*
	* @return the name of this SubUnit
	*/
	@Override
	public java.lang.String getName() {
		return _subUnit.getName();
	}

	/**
	* Sets the name of this SubUnit.
	*
	* @param name the name of this SubUnit
	*/
	@Override
	public void setName(java.lang.String name) {
		_subUnit.setName(name);
	}

	/**
	* Returns the description of this SubUnit.
	*
	* @return the description of this SubUnit
	*/
	@Override
	public java.lang.String getDescription() {
		return _subUnit.getDescription();
	}

	/**
	* Sets the description of this SubUnit.
	*
	* @param description the description of this SubUnit
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_subUnit.setDescription(description);
	}

	/**
	* Returns the group ID of this SubUnit.
	*
	* @return the group ID of this SubUnit
	*/
	@Override
	public long getGroupId() {
		return _subUnit.getGroupId();
	}

	/**
	* Sets the group ID of this SubUnit.
	*
	* @param groupId the group ID of this SubUnit
	*/
	@Override
	public void setGroupId(long groupId) {
		_subUnit.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this SubUnit.
	*
	* @return the company ID of this SubUnit
	*/
	@Override
	public long getCompanyId() {
		return _subUnit.getCompanyId();
	}

	/**
	* Sets the company ID of this SubUnit.
	*
	* @param companyId the company ID of this SubUnit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_subUnit.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this SubUnit.
	*
	* @return the user ID of this SubUnit
	*/
	@Override
	public long getUserId() {
		return _subUnit.getUserId();
	}

	/**
	* Sets the user ID of this SubUnit.
	*
	* @param userId the user ID of this SubUnit
	*/
	@Override
	public void setUserId(long userId) {
		_subUnit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this SubUnit.
	*
	* @return the user uuid of this SubUnit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subUnit.getUserUuid();
	}

	/**
	* Sets the user uuid of this SubUnit.
	*
	* @param userUuid the user uuid of this SubUnit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_subUnit.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this SubUnit.
	*
	* @return the create date of this SubUnit
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _subUnit.getCreateDate();
	}

	/**
	* Sets the create date of this SubUnit.
	*
	* @param createDate the create date of this SubUnit
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_subUnit.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this SubUnit.
	*
	* @return the modified date of this SubUnit
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _subUnit.getModifiedDate();
	}

	/**
	* Sets the modified date of this SubUnit.
	*
	* @param modifiedDate the modified date of this SubUnit
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_subUnit.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _subUnit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_subUnit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _subUnit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_subUnit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _subUnit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _subUnit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_subUnit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _subUnit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_subUnit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_subUnit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_subUnit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubUnitWrapper((SubUnit)_subUnit.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.SubUnit subUnit) {
		return _subUnit.compareTo(subUnit);
	}

	@Override
	public int hashCode() {
		return _subUnit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.SubUnit> toCacheModel() {
		return _subUnit.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.SubUnit toEscapedModel() {
		return new SubUnitWrapper(_subUnit.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.SubUnit toUnescapedModel() {
		return new SubUnitWrapper(_subUnit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _subUnit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _subUnit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_subUnit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubUnitWrapper)) {
			return false;
		}

		SubUnitWrapper subUnitWrapper = (SubUnitWrapper)obj;

		if (Validator.equals(_subUnit, subUnitWrapper._subUnit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SubUnit getWrappedSubUnit() {
		return _subUnit;
	}

	@Override
	public SubUnit getWrappedModel() {
		return _subUnit;
	}

	@Override
	public void resetOriginalValues() {
		_subUnit.resetOriginalValues();
	}

	private SubUnit _subUnit;
}