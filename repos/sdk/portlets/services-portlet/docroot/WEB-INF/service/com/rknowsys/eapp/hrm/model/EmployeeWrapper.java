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
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author rknowsys
 * @see Employee
 * @generated
 */
public class EmployeeWrapper implements Employee, ModelWrapper<Employee> {
	public EmployeeWrapper(Employee employee) {
		_employee = employee;
	}

	@Override
	public Class<?> getModelClass() {
		return Employee.class;
	}

	@Override
	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeId", getEmployeeId());
		attributes.put("contactDetailsId", getContactDetailsId());
		attributes.put("jobId", getJobId());
		attributes.put("shiftId", getShiftId());
		attributes.put("licenseId", getLicenseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("middleName", getMiddleName());
		attributes.put("gender", getGender());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("nationalityId", getNationalityId());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("otherId", getOtherId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long contactDetailsId = (Long)attributes.get("contactDetailsId");

		if (contactDetailsId != null) {
			setContactDetailsId(contactDetailsId);
		}

		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		Long shiftId = (Long)attributes.get("shiftId");

		if (shiftId != null) {
			setShiftId(shiftId);
		}

		Long licenseId = (Long)attributes.get("licenseId");

		if (licenseId != null) {
			setLicenseId(licenseId);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Integer maritalStatus = (Integer)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Long nationalityId = (Long)attributes.get("nationalityId");

		if (nationalityId != null) {
			setNationalityId(nationalityId);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		String otherId = (String)attributes.get("otherId");

		if (otherId != null) {
			setOtherId(otherId);
		}
	}

	/**
	* Returns the primary key of this Employee.
	*
	* @return the primary key of this Employee
	*/
	@Override
	public long getPrimaryKey() {
		return _employee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Employee.
	*
	* @param primaryKey the primary key of this Employee
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the employee ID of this Employee.
	*
	* @return the employee ID of this Employee
	*/
	@Override
	public long getEmployeeId() {
		return _employee.getEmployeeId();
	}

	/**
	* Sets the employee ID of this Employee.
	*
	* @param employeeId the employee ID of this Employee
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_employee.setEmployeeId(employeeId);
	}

	/**
	* Returns the contact details ID of this Employee.
	*
	* @return the contact details ID of this Employee
	*/
	@Override
	public long getContactDetailsId() {
		return _employee.getContactDetailsId();
	}

	/**
	* Sets the contact details ID of this Employee.
	*
	* @param contactDetailsId the contact details ID of this Employee
	*/
	@Override
	public void setContactDetailsId(long contactDetailsId) {
		_employee.setContactDetailsId(contactDetailsId);
	}

	/**
	* Returns the job ID of this Employee.
	*
	* @return the job ID of this Employee
	*/
	@Override
	public long getJobId() {
		return _employee.getJobId();
	}

	/**
	* Sets the job ID of this Employee.
	*
	* @param jobId the job ID of this Employee
	*/
	@Override
	public void setJobId(long jobId) {
		_employee.setJobId(jobId);
	}

	/**
	* Returns the shift ID of this Employee.
	*
	* @return the shift ID of this Employee
	*/
	@Override
	public long getShiftId() {
		return _employee.getShiftId();
	}

	/**
	* Sets the shift ID of this Employee.
	*
	* @param shiftId the shift ID of this Employee
	*/
	@Override
	public void setShiftId(long shiftId) {
		_employee.setShiftId(shiftId);
	}

	/**
	* Returns the license ID of this Employee.
	*
	* @return the license ID of this Employee
	*/
	@Override
	public long getLicenseId() {
		return _employee.getLicenseId();
	}

	/**
	* Sets the license ID of this Employee.
	*
	* @param licenseId the license ID of this Employee
	*/
	@Override
	public void setLicenseId(long licenseId) {
		_employee.setLicenseId(licenseId);
	}

	/**
	* Returns the group ID of this Employee.
	*
	* @return the group ID of this Employee
	*/
	@Override
	public long getGroupId() {
		return _employee.getGroupId();
	}

	/**
	* Sets the group ID of this Employee.
	*
	* @param groupId the group ID of this Employee
	*/
	@Override
	public void setGroupId(long groupId) {
		_employee.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this Employee.
	*
	* @return the company ID of this Employee
	*/
	@Override
	public long getCompanyId() {
		return _employee.getCompanyId();
	}

	/**
	* Sets the company ID of this Employee.
	*
	* @param companyId the company ID of this Employee
	*/
	@Override
	public void setCompanyId(long companyId) {
		_employee.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this Employee.
	*
	* @return the user ID of this Employee
	*/
	@Override
	public long getUserId() {
		return _employee.getUserId();
	}

	/**
	* Sets the user ID of this Employee.
	*
	* @param userId the user ID of this Employee
	*/
	@Override
	public void setUserId(long userId) {
		_employee.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Employee.
	*
	* @return the user uuid of this Employee
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employee.getUserUuid();
	}

	/**
	* Sets the user uuid of this Employee.
	*
	* @param userUuid the user uuid of this Employee
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_employee.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this Employee.
	*
	* @return the create date of this Employee
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _employee.getCreateDate();
	}

	/**
	* Sets the create date of this Employee.
	*
	* @param createDate the create date of this Employee
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_employee.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this Employee.
	*
	* @return the modified date of this Employee
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _employee.getModifiedDate();
	}

	/**
	* Sets the modified date of this Employee.
	*
	* @param modifiedDate the modified date of this Employee
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_employee.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the first name of this Employee.
	*
	* @return the first name of this Employee
	*/
	@Override
	public java.lang.String getFirstName() {
		return _employee.getFirstName();
	}

	/**
	* Sets the first name of this Employee.
	*
	* @param firstName the first name of this Employee
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_employee.setFirstName(firstName);
	}

	/**
	* Returns the last name of this Employee.
	*
	* @return the last name of this Employee
	*/
	@Override
	public java.lang.String getLastName() {
		return _employee.getLastName();
	}

	/**
	* Sets the last name of this Employee.
	*
	* @param lastName the last name of this Employee
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_employee.setLastName(lastName);
	}

	/**
	* Returns the middle name of this Employee.
	*
	* @return the middle name of this Employee
	*/
	@Override
	public java.lang.String getMiddleName() {
		return _employee.getMiddleName();
	}

	/**
	* Sets the middle name of this Employee.
	*
	* @param middleName the middle name of this Employee
	*/
	@Override
	public void setMiddleName(java.lang.String middleName) {
		_employee.setMiddleName(middleName);
	}

	/**
	* Returns the gender of this Employee.
	*
	* @return the gender of this Employee
	*/
	@Override
	public int getGender() {
		return _employee.getGender();
	}

	/**
	* Sets the gender of this Employee.
	*
	* @param gender the gender of this Employee
	*/
	@Override
	public void setGender(int gender) {
		_employee.setGender(gender);
	}

	/**
	* Returns the marital status of this Employee.
	*
	* @return the marital status of this Employee
	*/
	@Override
	public int getMaritalStatus() {
		return _employee.getMaritalStatus();
	}

	/**
	* Sets the marital status of this Employee.
	*
	* @param maritalStatus the marital status of this Employee
	*/
	@Override
	public void setMaritalStatus(int maritalStatus) {
		_employee.setMaritalStatus(maritalStatus);
	}

	/**
	* Returns the nationality ID of this Employee.
	*
	* @return the nationality ID of this Employee
	*/
	@Override
	public long getNationalityId() {
		return _employee.getNationalityId();
	}

	/**
	* Sets the nationality ID of this Employee.
	*
	* @param nationalityId the nationality ID of this Employee
	*/
	@Override
	public void setNationalityId(long nationalityId) {
		_employee.setNationalityId(nationalityId);
	}

	/**
	* Returns the date of birth of this Employee.
	*
	* @return the date of birth of this Employee
	*/
	@Override
	public java.util.Date getDateOfBirth() {
		return _employee.getDateOfBirth();
	}

	/**
	* Sets the date of birth of this Employee.
	*
	* @param dateOfBirth the date of birth of this Employee
	*/
	@Override
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		_employee.setDateOfBirth(dateOfBirth);
	}

	/**
	* Returns the other ID of this Employee.
	*
	* @return the other ID of this Employee
	*/
	@Override
	public java.lang.String getOtherId() {
		return _employee.getOtherId();
	}

	/**
	* Sets the other ID of this Employee.
	*
	* @param otherId the other ID of this Employee
	*/
	@Override
	public void setOtherId(java.lang.String otherId) {
		_employee.setOtherId(otherId);
	}

	@Override
	public boolean isNew() {
		return _employee.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_employee.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _employee.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employee.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _employee.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _employee.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_employee.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _employee.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_employee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_employee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_employee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmployeeWrapper((Employee)_employee.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Employee employee) {
		return _employee.compareTo(employee);
	}

	@Override
	public int hashCode() {
		return _employee.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Employee> toCacheModel() {
		return _employee.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Employee toEscapedModel() {
		return new EmployeeWrapper(_employee.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Employee toUnescapedModel() {
		return new EmployeeWrapper(_employee.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _employee.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _employee.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_employee.persist();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.ContactDetails getContactDetails()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employee.getContactDetails();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.License getLicense()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employee.getLicense();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Job getJob()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employee.getJob();
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Attachment> getAttachments()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employee.getAttachments();
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Dependent> getDependents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employee.getDependents();
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> getSalaryComponents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employee.getSalaryComponents();
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> getEmergencyContacts()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employee.getEmergencyContacts();
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> getImmigrationDocuments()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employee.getImmigrationDocuments();
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Education> getEducations()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employee.getEducations();
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Language> getLanguages()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employee.getLanguages();
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Skill> getSkills()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employee.getSkills();
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Membership> getMemberships()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employee.getMemberships();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeWrapper)) {
			return false;
		}

		EmployeeWrapper employeeWrapper = (EmployeeWrapper)obj;

		if (Validator.equals(_employee, employeeWrapper._employee)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Employee getWrappedEmployee() {
		return _employee;
	}

	@Override
	public Employee getWrappedModel() {
		return _employee;
	}

	@Override
	public void resetOriginalValues() {
		_employee.resetOriginalValues();
	}

	private Employee _employee;
}