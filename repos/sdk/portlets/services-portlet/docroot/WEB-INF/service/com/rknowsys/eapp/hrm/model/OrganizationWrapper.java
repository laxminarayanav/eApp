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
 * This class is a wrapper for {@link Organization}.
 * </p>
 *
 * @author rknowsys
 * @see Organization
 * @generated
 */
public class OrganizationWrapper implements Organization,
	ModelWrapper<Organization> {
	public OrganizationWrapper(Organization organization) {
		_organization = organization;
	}

	@Override
	public Class<?> getModelClass() {
		return Organization.class;
	}

	@Override
	public String getModelClassName() {
		return Organization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("organizationId", getOrganizationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("organizationName", getOrganizationName());
		attributes.put("taxId", getTaxId());
		attributes.put("numberOfEmployees", getNumberOfEmployees());
		attributes.put("registrationNumber", getRegistrationNumber());
		attributes.put("phone", getPhone());
		attributes.put("fax", getFax());
		attributes.put("email", getEmail());
		attributes.put("addressStreet1", getAddressStreet1());
		attributes.put("addressStreet2", getAddressStreet2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("postalCode", getPostalCode());
		attributes.put("nationalityId", getNationalityId());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
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

		String organizationName = (String)attributes.get("organizationName");

		if (organizationName != null) {
			setOrganizationName(organizationName);
		}

		String taxId = (String)attributes.get("taxId");

		if (taxId != null) {
			setTaxId(taxId);
		}

		Integer numberOfEmployees = (Integer)attributes.get("numberOfEmployees");

		if (numberOfEmployees != null) {
			setNumberOfEmployees(numberOfEmployees);
		}

		String registrationNumber = (String)attributes.get("registrationNumber");

		if (registrationNumber != null) {
			setRegistrationNumber(registrationNumber);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String fax = (String)attributes.get("fax");

		if (fax != null) {
			setFax(fax);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String addressStreet1 = (String)attributes.get("addressStreet1");

		if (addressStreet1 != null) {
			setAddressStreet1(addressStreet1);
		}

		String addressStreet2 = (String)attributes.get("addressStreet2");

		if (addressStreet2 != null) {
			setAddressStreet2(addressStreet2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String postalCode = (String)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		Long nationalityId = (Long)attributes.get("nationalityId");

		if (nationalityId != null) {
			setNationalityId(nationalityId);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	/**
	* Returns the primary key of this organization.
	*
	* @return the primary key of this organization
	*/
	@Override
	public long getPrimaryKey() {
		return _organization.getPrimaryKey();
	}

	/**
	* Sets the primary key of this organization.
	*
	* @param primaryKey the primary key of this organization
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_organization.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the organization ID of this organization.
	*
	* @return the organization ID of this organization
	*/
	@Override
	public long getOrganizationId() {
		return _organization.getOrganizationId();
	}

	/**
	* Sets the organization ID of this organization.
	*
	* @param organizationId the organization ID of this organization
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_organization.setOrganizationId(organizationId);
	}

	/**
	* Returns the group ID of this organization.
	*
	* @return the group ID of this organization
	*/
	@Override
	public long getGroupId() {
		return _organization.getGroupId();
	}

	/**
	* Sets the group ID of this organization.
	*
	* @param groupId the group ID of this organization
	*/
	@Override
	public void setGroupId(long groupId) {
		_organization.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this organization.
	*
	* @return the company ID of this organization
	*/
	@Override
	public long getCompanyId() {
		return _organization.getCompanyId();
	}

	/**
	* Sets the company ID of this organization.
	*
	* @param companyId the company ID of this organization
	*/
	@Override
	public void setCompanyId(long companyId) {
		_organization.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this organization.
	*
	* @return the user ID of this organization
	*/
	@Override
	public long getUserId() {
		return _organization.getUserId();
	}

	/**
	* Sets the user ID of this organization.
	*
	* @param userId the user ID of this organization
	*/
	@Override
	public void setUserId(long userId) {
		_organization.setUserId(userId);
	}

	/**
	* Returns the user uuid of this organization.
	*
	* @return the user uuid of this organization
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organization.getUserUuid();
	}

	/**
	* Sets the user uuid of this organization.
	*
	* @param userUuid the user uuid of this organization
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_organization.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this organization.
	*
	* @return the create date of this organization
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _organization.getCreateDate();
	}

	/**
	* Sets the create date of this organization.
	*
	* @param createDate the create date of this organization
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_organization.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this organization.
	*
	* @return the modified date of this organization
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _organization.getModifiedDate();
	}

	/**
	* Sets the modified date of this organization.
	*
	* @param modifiedDate the modified date of this organization
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_organization.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the organization name of this organization.
	*
	* @return the organization name of this organization
	*/
	@Override
	public java.lang.String getOrganizationName() {
		return _organization.getOrganizationName();
	}

	/**
	* Sets the organization name of this organization.
	*
	* @param organizationName the organization name of this organization
	*/
	@Override
	public void setOrganizationName(java.lang.String organizationName) {
		_organization.setOrganizationName(organizationName);
	}

	/**
	* Returns the tax ID of this organization.
	*
	* @return the tax ID of this organization
	*/
	@Override
	public java.lang.String getTaxId() {
		return _organization.getTaxId();
	}

	/**
	* Sets the tax ID of this organization.
	*
	* @param taxId the tax ID of this organization
	*/
	@Override
	public void setTaxId(java.lang.String taxId) {
		_organization.setTaxId(taxId);
	}

	/**
	* Returns the number of employees of this organization.
	*
	* @return the number of employees of this organization
	*/
	@Override
	public int getNumberOfEmployees() {
		return _organization.getNumberOfEmployees();
	}

	/**
	* Sets the number of employees of this organization.
	*
	* @param numberOfEmployees the number of employees of this organization
	*/
	@Override
	public void setNumberOfEmployees(int numberOfEmployees) {
		_organization.setNumberOfEmployees(numberOfEmployees);
	}

	/**
	* Returns the registration number of this organization.
	*
	* @return the registration number of this organization
	*/
	@Override
	public java.lang.String getRegistrationNumber() {
		return _organization.getRegistrationNumber();
	}

	/**
	* Sets the registration number of this organization.
	*
	* @param registrationNumber the registration number of this organization
	*/
	@Override
	public void setRegistrationNumber(java.lang.String registrationNumber) {
		_organization.setRegistrationNumber(registrationNumber);
	}

	/**
	* Returns the phone of this organization.
	*
	* @return the phone of this organization
	*/
	@Override
	public java.lang.String getPhone() {
		return _organization.getPhone();
	}

	/**
	* Sets the phone of this organization.
	*
	* @param phone the phone of this organization
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_organization.setPhone(phone);
	}

	/**
	* Returns the fax of this organization.
	*
	* @return the fax of this organization
	*/
	@Override
	public java.lang.String getFax() {
		return _organization.getFax();
	}

	/**
	* Sets the fax of this organization.
	*
	* @param fax the fax of this organization
	*/
	@Override
	public void setFax(java.lang.String fax) {
		_organization.setFax(fax);
	}

	/**
	* Returns the email of this organization.
	*
	* @return the email of this organization
	*/
	@Override
	public java.lang.String getEmail() {
		return _organization.getEmail();
	}

	/**
	* Sets the email of this organization.
	*
	* @param email the email of this organization
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_organization.setEmail(email);
	}

	/**
	* Returns the address street1 of this organization.
	*
	* @return the address street1 of this organization
	*/
	@Override
	public java.lang.String getAddressStreet1() {
		return _organization.getAddressStreet1();
	}

	/**
	* Sets the address street1 of this organization.
	*
	* @param addressStreet1 the address street1 of this organization
	*/
	@Override
	public void setAddressStreet1(java.lang.String addressStreet1) {
		_organization.setAddressStreet1(addressStreet1);
	}

	/**
	* Returns the address street2 of this organization.
	*
	* @return the address street2 of this organization
	*/
	@Override
	public java.lang.String getAddressStreet2() {
		return _organization.getAddressStreet2();
	}

	/**
	* Sets the address street2 of this organization.
	*
	* @param addressStreet2 the address street2 of this organization
	*/
	@Override
	public void setAddressStreet2(java.lang.String addressStreet2) {
		_organization.setAddressStreet2(addressStreet2);
	}

	/**
	* Returns the city of this organization.
	*
	* @return the city of this organization
	*/
	@Override
	public java.lang.String getCity() {
		return _organization.getCity();
	}

	/**
	* Sets the city of this organization.
	*
	* @param city the city of this organization
	*/
	@Override
	public void setCity(java.lang.String city) {
		_organization.setCity(city);
	}

	/**
	* Returns the state of this organization.
	*
	* @return the state of this organization
	*/
	@Override
	public java.lang.String getState() {
		return _organization.getState();
	}

	/**
	* Sets the state of this organization.
	*
	* @param state the state of this organization
	*/
	@Override
	public void setState(java.lang.String state) {
		_organization.setState(state);
	}

	/**
	* Returns the postal code of this organization.
	*
	* @return the postal code of this organization
	*/
	@Override
	public java.lang.String getPostalCode() {
		return _organization.getPostalCode();
	}

	/**
	* Sets the postal code of this organization.
	*
	* @param postalCode the postal code of this organization
	*/
	@Override
	public void setPostalCode(java.lang.String postalCode) {
		_organization.setPostalCode(postalCode);
	}

	/**
	* Returns the nationality ID of this organization.
	*
	* @return the nationality ID of this organization
	*/
	@Override
	public long getNationalityId() {
		return _organization.getNationalityId();
	}

	/**
	* Sets the nationality ID of this organization.
	*
	* @param nationalityId the nationality ID of this organization
	*/
	@Override
	public void setNationalityId(long nationalityId) {
		_organization.setNationalityId(nationalityId);
	}

	/**
	* Returns the note of this organization.
	*
	* @return the note of this organization
	*/
	@Override
	public java.lang.String getNote() {
		return _organization.getNote();
	}

	/**
	* Sets the note of this organization.
	*
	* @param note the note of this organization
	*/
	@Override
	public void setNote(java.lang.String note) {
		_organization.setNote(note);
	}

	@Override
	public boolean isNew() {
		return _organization.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_organization.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _organization.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_organization.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _organization.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _organization.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_organization.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _organization.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_organization.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_organization.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_organization.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrganizationWrapper((Organization)_organization.clone());
	}

	@Override
	public int compareTo(Organization organization) {
		return _organization.compareTo(organization);
	}

	@Override
	public int hashCode() {
		return _organization.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Organization> toCacheModel() {
		return _organization.toCacheModel();
	}

	@Override
	public Organization toEscapedModel() {
		return new OrganizationWrapper(_organization.toEscapedModel());
	}

	@Override
	public Organization toUnescapedModel() {
		return new OrganizationWrapper(_organization.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _organization.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _organization.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_organization.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrganizationWrapper)) {
			return false;
		}

		OrganizationWrapper organizationWrapper = (OrganizationWrapper)obj;

		if (Validator.equals(_organization, organizationWrapper._organization)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Organization getWrappedOrganization() {
		return _organization;
	}

	@Override
	public Organization getWrappedModel() {
		return _organization;
	}

	@Override
	public void resetOriginalValues() {
		_organization.resetOriginalValues();
	}

	private Organization _organization;
}