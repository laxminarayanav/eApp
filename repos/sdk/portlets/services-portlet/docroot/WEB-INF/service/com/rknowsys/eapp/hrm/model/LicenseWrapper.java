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
 * This class is a wrapper for {@link License}.
 * </p>
 *
 * @author rknowsys
 * @see License
 * @generated
 */
public class LicenseWrapper implements License, ModelWrapper<License> {
	public LicenseWrapper(License license) {
		_license = license;
	}

	@Override
	public Class<?> getModelClass() {
		return License.class;
	}

	@Override
	public String getModelClassName() {
		return License.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("licenseId", getLicenseId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("licenseName", getLicenseName());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("licenseNumber", getLicenseNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long licenseId = (Long)attributes.get("licenseId");

		if (licenseId != null) {
			setLicenseId(licenseId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
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

		String licenseName = (String)attributes.get("licenseName");

		if (licenseName != null) {
			setLicenseName(licenseName);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		String licenseNumber = (String)attributes.get("licenseNumber");

		if (licenseNumber != null) {
			setLicenseNumber(licenseNumber);
		}
	}

	/**
	* Returns the primary key of this license.
	*
	* @return the primary key of this license
	*/
	@Override
	public long getPrimaryKey() {
		return _license.getPrimaryKey();
	}

	/**
	* Sets the primary key of this license.
	*
	* @param primaryKey the primary key of this license
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_license.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the license ID of this license.
	*
	* @return the license ID of this license
	*/
	@Override
	public long getLicenseId() {
		return _license.getLicenseId();
	}

	/**
	* Sets the license ID of this license.
	*
	* @param licenseId the license ID of this license
	*/
	@Override
	public void setLicenseId(long licenseId) {
		_license.setLicenseId(licenseId);
	}

	/**
	* Returns the employee ID of this license.
	*
	* @return the employee ID of this license
	*/
	@Override
	public long getEmployeeId() {
		return _license.getEmployeeId();
	}

	/**
	* Sets the employee ID of this license.
	*
	* @param employeeId the employee ID of this license
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_license.setEmployeeId(employeeId);
	}

	/**
	* Returns the company ID of this license.
	*
	* @return the company ID of this license
	*/
	@Override
	public long getCompanyId() {
		return _license.getCompanyId();
	}

	/**
	* Sets the company ID of this license.
	*
	* @param companyId the company ID of this license
	*/
	@Override
	public void setCompanyId(long companyId) {
		_license.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this license.
	*
	* @return the group ID of this license
	*/
	@Override
	public long getGroupId() {
		return _license.getGroupId();
	}

	/**
	* Sets the group ID of this license.
	*
	* @param groupId the group ID of this license
	*/
	@Override
	public void setGroupId(long groupId) {
		_license.setGroupId(groupId);
	}

	/**
	* Returns the create date of this license.
	*
	* @return the create date of this license
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _license.getCreateDate();
	}

	/**
	* Sets the create date of this license.
	*
	* @param createDate the create date of this license
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_license.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this license.
	*
	* @return the modified date of this license
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _license.getModifiedDate();
	}

	/**
	* Sets the modified date of this license.
	*
	* @param modifiedDate the modified date of this license
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_license.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this license.
	*
	* @return the user ID of this license
	*/
	@Override
	public long getUserId() {
		return _license.getUserId();
	}

	/**
	* Sets the user ID of this license.
	*
	* @param userId the user ID of this license
	*/
	@Override
	public void setUserId(long userId) {
		_license.setUserId(userId);
	}

	/**
	* Returns the user uuid of this license.
	*
	* @return the user uuid of this license
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _license.getUserUuid();
	}

	/**
	* Sets the user uuid of this license.
	*
	* @param userUuid the user uuid of this license
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_license.setUserUuid(userUuid);
	}

	/**
	* Returns the license name of this license.
	*
	* @return the license name of this license
	*/
	@Override
	public java.lang.String getLicenseName() {
		return _license.getLicenseName();
	}

	/**
	* Sets the license name of this license.
	*
	* @param licenseName the license name of this license
	*/
	@Override
	public void setLicenseName(java.lang.String licenseName) {
		_license.setLicenseName(licenseName);
	}

	/**
	* Returns the expiry date of this license.
	*
	* @return the expiry date of this license
	*/
	@Override
	public java.util.Date getExpiryDate() {
		return _license.getExpiryDate();
	}

	/**
	* Sets the expiry date of this license.
	*
	* @param expiryDate the expiry date of this license
	*/
	@Override
	public void setExpiryDate(java.util.Date expiryDate) {
		_license.setExpiryDate(expiryDate);
	}

	/**
	* Returns the license number of this license.
	*
	* @return the license number of this license
	*/
	@Override
	public java.lang.String getLicenseNumber() {
		return _license.getLicenseNumber();
	}

	/**
	* Sets the license number of this license.
	*
	* @param licenseNumber the license number of this license
	*/
	@Override
	public void setLicenseNumber(java.lang.String licenseNumber) {
		_license.setLicenseNumber(licenseNumber);
	}

	@Override
	public boolean isNew() {
		return _license.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_license.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _license.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_license.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _license.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _license.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_license.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _license.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_license.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_license.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_license.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LicenseWrapper((License)_license.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.License license) {
		return _license.compareTo(license);
	}

	@Override
	public int hashCode() {
		return _license.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.License> toCacheModel() {
		return _license.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.License toEscapedModel() {
		return new LicenseWrapper(_license.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.License toUnescapedModel() {
		return new LicenseWrapper(_license.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _license.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _license.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_license.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LicenseWrapper)) {
			return false;
		}

		LicenseWrapper licenseWrapper = (LicenseWrapper)obj;

		if (Validator.equals(_license, licenseWrapper._license)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public License getWrappedLicense() {
		return _license;
	}

	@Override
	public License getWrappedModel() {
		return _license;
	}

	@Override
	public void resetOriginalValues() {
		_license.resetOriginalValues();
	}

	private License _license;
}