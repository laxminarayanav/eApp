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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rknowsys.eapp.hrm.service.ClpSerializer;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmployeeClp extends BaseModelImpl<Employee> implements Employee {
	public EmployeeClp() {
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
	public long getPrimaryKey() {
		return _employeeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_employeeRemoteModel, employeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactDetailsId() {
		return _contactDetailsId;
	}

	@Override
	public void setContactDetailsId(long contactDetailsId) {
		_contactDetailsId = contactDetailsId;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setContactDetailsId",
						long.class);

				method.invoke(_employeeRemoteModel, contactDetailsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobId() {
		return _jobId;
	}

	@Override
	public void setJobId(long jobId) {
		_jobId = jobId;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setJobId", long.class);

				method.invoke(_employeeRemoteModel, jobId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getShiftId() {
		return _shiftId;
	}

	@Override
	public void setShiftId(long shiftId) {
		_shiftId = shiftId;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setShiftId", long.class);

				method.invoke(_employeeRemoteModel, shiftId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLicenseId() {
		return _licenseId;
	}

	@Override
	public void setLicenseId(long licenseId) {
		_licenseId = licenseId;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setLicenseId", long.class);

				method.invoke(_employeeRemoteModel, licenseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_employeeRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_employeeRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_employeeRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_employeeRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_employeeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_employeeRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_employeeRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMiddleName() {
		return _middleName;
	}

	@Override
	public void setMiddleName(String middleName) {
		_middleName = middleName;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setMiddleName", String.class);

				method.invoke(_employeeRemoteModel, middleName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGender() {
		return _gender;
	}

	@Override
	public void setGender(int gender) {
		_gender = gender;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", int.class);

				method.invoke(_employeeRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMaritalStatus() {
		return _maritalStatus;
	}

	@Override
	public void setMaritalStatus(int maritalStatus) {
		_maritalStatus = maritalStatus;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setMaritalStatus", int.class);

				method.invoke(_employeeRemoteModel, maritalStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNationalityId() {
		return _nationalityId;
	}

	@Override
	public void setNationalityId(long nationalityId) {
		_nationalityId = nationalityId;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setNationalityId", long.class);

				method.invoke(_employeeRemoteModel, nationalityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setDateOfBirth", Date.class);

				method.invoke(_employeeRemoteModel, dateOfBirth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOtherId() {
		return _otherId;
	}

	@Override
	public void setOtherId(String otherId) {
		_otherId = otherId;

		if (_employeeRemoteModel != null) {
			try {
				Class<?> clazz = _employeeRemoteModel.getClass();

				Method method = clazz.getMethod("setOtherId", String.class);

				method.invoke(_employeeRemoteModel, otherId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Job getJob() {
		try {
			String methodName = "getJob";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.rknowsys.eapp.hrm.model.Job returnObj = (com.rknowsys.eapp.hrm.model.Job)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.rknowsys.eapp.hrm.model.ContactDetails getContactDetails() {
		try {
			String methodName = "getContactDetails";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.rknowsys.eapp.hrm.model.ContactDetails returnObj = (com.rknowsys.eapp.hrm.model.ContactDetails)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Membership> getMemberships() {
		try {
			String methodName = "getMemberships";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.rknowsys.eapp.hrm.model.Membership> returnObj = (java.util.List<com.rknowsys.eapp.hrm.model.Membership>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> getEmergencyContacts() {
		try {
			String methodName = "getEmergencyContacts";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> returnObj =
				(java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> getImmigrationDocuments() {
		try {
			String methodName = "getImmigrationDocuments";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> returnObj =
				(java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Language> getLanguages() {
		try {
			String methodName = "getLanguages";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.rknowsys.eapp.hrm.model.Language> returnObj = (java.util.List<com.rknowsys.eapp.hrm.model.Language>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.rknowsys.eapp.hrm.model.License getLicense() {
		try {
			String methodName = "getLicense";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.rknowsys.eapp.hrm.model.License returnObj = (com.rknowsys.eapp.hrm.model.License)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Education> getEducations() {
		try {
			String methodName = "getEducations";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.rknowsys.eapp.hrm.model.Education> returnObj = (java.util.List<com.rknowsys.eapp.hrm.model.Education>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Skill> getSkills() {
		try {
			String methodName = "getSkills";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.rknowsys.eapp.hrm.model.Skill> returnObj = (java.util.List<com.rknowsys.eapp.hrm.model.Skill>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> getSalaryComponents() {
		try {
			String methodName = "getSalaryComponents";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent> returnObj =
				(java.util.List<com.rknowsys.eapp.hrm.model.SalaryComponent>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Dependent> getDependents() {
		try {
			String methodName = "getDependents";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.rknowsys.eapp.hrm.model.Dependent> returnObj = (java.util.List<com.rknowsys.eapp.hrm.model.Dependent>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.Attachment> getAttachments() {
		try {
			String methodName = "getAttachments";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.rknowsys.eapp.hrm.model.Attachment> returnObj = (java.util.List<com.rknowsys.eapp.hrm.model.Attachment>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getEmployeeRemoteModel() {
		return _employeeRemoteModel;
	}

	public void setEmployeeRemoteModel(BaseModel<?> employeeRemoteModel) {
		_employeeRemoteModel = employeeRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _employeeRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_employeeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmployeeLocalServiceUtil.addEmployee(this);
		}
		else {
			EmployeeLocalServiceUtil.updateEmployee(this);
		}
	}

	@Override
	public Employee toEscapedModel() {
		return (Employee)ProxyUtil.newProxyInstance(Employee.class.getClassLoader(),
			new Class[] { Employee.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmployeeClp clone = new EmployeeClp();

		clone.setEmployeeId(getEmployeeId());
		clone.setContactDetailsId(getContactDetailsId());
		clone.setJobId(getJobId());
		clone.setShiftId(getShiftId());
		clone.setLicenseId(getLicenseId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setMiddleName(getMiddleName());
		clone.setGender(getGender());
		clone.setMaritalStatus(getMaritalStatus());
		clone.setNationalityId(getNationalityId());
		clone.setDateOfBirth(getDateOfBirth());
		clone.setOtherId(getOtherId());

		return clone;
	}

	@Override
	public int compareTo(Employee employee) {
		long primaryKey = employee.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeClp)) {
			return false;
		}

		EmployeeClp employee = (EmployeeClp)obj;

		long primaryKey = employee.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{employeeId=");
		sb.append(getEmployeeId());
		sb.append(", contactDetailsId=");
		sb.append(getContactDetailsId());
		sb.append(", jobId=");
		sb.append(getJobId());
		sb.append(", shiftId=");
		sb.append(getShiftId());
		sb.append(", licenseId=");
		sb.append(getLicenseId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", middleName=");
		sb.append(getMiddleName());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", maritalStatus=");
		sb.append(getMaritalStatus());
		sb.append(", nationalityId=");
		sb.append(getNationalityId());
		sb.append(", dateOfBirth=");
		sb.append(getDateOfBirth());
		sb.append(", otherId=");
		sb.append(getOtherId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.Employee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactDetailsId</column-name><column-value><![CDATA[");
		sb.append(getContactDetailsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobId</column-name><column-value><![CDATA[");
		sb.append(getJobId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shiftId</column-name><column-value><![CDATA[");
		sb.append(getShiftId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>licenseId</column-name><column-value><![CDATA[");
		sb.append(getLicenseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>middleName</column-name><column-value><![CDATA[");
		sb.append(getMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maritalStatus</column-name><column-value><![CDATA[");
		sb.append(getMaritalStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationalityId</column-name><column-value><![CDATA[");
		sb.append(getNationalityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfBirth</column-name><column-value><![CDATA[");
		sb.append(getDateOfBirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otherId</column-name><column-value><![CDATA[");
		sb.append(getOtherId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _employeeId;
	private long _contactDetailsId;
	private long _jobId;
	private long _shiftId;
	private long _licenseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _middleName;
	private int _gender;
	private int _maritalStatus;
	private long _nationalityId;
	private Date _dateOfBirth;
	private String _otherId;
	private BaseModel<?> _employeeRemoteModel;
}