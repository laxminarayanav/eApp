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
import com.rknowsys.eapp.hrm.service.OrganizationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class OrganizationClp extends BaseModelImpl<Organization>
	implements Organization {
	public OrganizationClp() {
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
	public long getPrimaryKey() {
		return _organizationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOrganizationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _organizationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_organizationRemoteModel, organizationId);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_organizationRemoteModel, groupId);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_organizationRemoteModel, companyId);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_organizationRemoteModel, userId);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_organizationRemoteModel, createDate);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_organizationRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrganizationName() {
		return _organizationName;
	}

	@Override
	public void setOrganizationName(String organizationName) {
		_organizationName = organizationName;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationName",
						String.class);

				method.invoke(_organizationRemoteModel, organizationName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTaxId() {
		return _taxId;
	}

	@Override
	public void setTaxId(String taxId) {
		_taxId = taxId;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxId", String.class);

				method.invoke(_organizationRemoteModel, taxId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumberOfEmployees() {
		return _numberOfEmployees;
	}

	@Override
	public void setNumberOfEmployees(int numberOfEmployees) {
		_numberOfEmployees = numberOfEmployees;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberOfEmployees",
						int.class);

				method.invoke(_organizationRemoteModel, numberOfEmployees);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegistrationNumber() {
		return _registrationNumber;
	}

	@Override
	public void setRegistrationNumber(String registrationNumber) {
		_registrationNumber = registrationNumber;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setRegistrationNumber",
						String.class);

				method.invoke(_organizationRemoteModel, registrationNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhone() {
		return _phone;
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setPhone", String.class);

				method.invoke(_organizationRemoteModel, phone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFax() {
		return _fax;
	}

	@Override
	public void setFax(String fax) {
		_fax = fax;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setFax", String.class);

				method.invoke(_organizationRemoteModel, fax);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_organizationRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddressStreet1() {
		return _addressStreet1;
	}

	@Override
	public void setAddressStreet1(String addressStreet1) {
		_addressStreet1 = addressStreet1;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressStreet1",
						String.class);

				method.invoke(_organizationRemoteModel, addressStreet1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddressStreet2() {
		return _addressStreet2;
	}

	@Override
	public void setAddressStreet2(String addressStreet2) {
		_addressStreet2 = addressStreet2;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressStreet2",
						String.class);

				method.invoke(_organizationRemoteModel, addressStreet2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_organizationRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getState() {
		return _state;
	}

	@Override
	public void setState(String state) {
		_state = state;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setState", String.class);

				method.invoke(_organizationRemoteModel, state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostalCode() {
		return _postalCode;
	}

	@Override
	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setPostalCode", String.class);

				method.invoke(_organizationRemoteModel, postalCode);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setNationalityId", long.class);

				method.invoke(_organizationRemoteModel, nationalityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_organizationRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOrganizationRemoteModel() {
		return _organizationRemoteModel;
	}

	public void setOrganizationRemoteModel(BaseModel<?> organizationRemoteModel) {
		_organizationRemoteModel = organizationRemoteModel;
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

		Class<?> remoteModelClass = _organizationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_organizationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OrganizationLocalServiceUtil.addOrganization(this);
		}
		else {
			OrganizationLocalServiceUtil.updateOrganization(this);
		}
	}

	@Override
	public Organization toEscapedModel() {
		return (Organization)ProxyUtil.newProxyInstance(Organization.class.getClassLoader(),
			new Class[] { Organization.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrganizationClp clone = new OrganizationClp();

		clone.setOrganizationId(getOrganizationId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setOrganizationName(getOrganizationName());
		clone.setTaxId(getTaxId());
		clone.setNumberOfEmployees(getNumberOfEmployees());
		clone.setRegistrationNumber(getRegistrationNumber());
		clone.setPhone(getPhone());
		clone.setFax(getFax());
		clone.setEmail(getEmail());
		clone.setAddressStreet1(getAddressStreet1());
		clone.setAddressStreet2(getAddressStreet2());
		clone.setCity(getCity());
		clone.setState(getState());
		clone.setPostalCode(getPostalCode());
		clone.setNationalityId(getNationalityId());
		clone.setNote(getNote());

		return clone;
	}

	@Override
	public int compareTo(Organization organization) {
		long primaryKey = organization.getPrimaryKey();

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

		if (!(obj instanceof OrganizationClp)) {
			return false;
		}

		OrganizationClp organization = (OrganizationClp)obj;

		long primaryKey = organization.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{organizationId=");
		sb.append(getOrganizationId());
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
		sb.append(", organizationName=");
		sb.append(getOrganizationName());
		sb.append(", taxId=");
		sb.append(getTaxId());
		sb.append(", numberOfEmployees=");
		sb.append(getNumberOfEmployees());
		sb.append(", registrationNumber=");
		sb.append(getRegistrationNumber());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", fax=");
		sb.append(getFax());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", addressStreet1=");
		sb.append(getAddressStreet1());
		sb.append(", addressStreet2=");
		sb.append(getAddressStreet2());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", postalCode=");
		sb.append(getPostalCode());
		sb.append(", nationalityId=");
		sb.append(getNationalityId());
		sb.append(", note=");
		sb.append(getNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.Organization");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
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
			"<column><column-name>organizationName</column-name><column-value><![CDATA[");
		sb.append(getOrganizationName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxId</column-name><column-value><![CDATA[");
		sb.append(getTaxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfEmployees</column-name><column-value><![CDATA[");
		sb.append(getNumberOfEmployees());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registrationNumber</column-name><column-value><![CDATA[");
		sb.append(getRegistrationNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fax</column-name><column-value><![CDATA[");
		sb.append(getFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addressStreet1</column-name><column-value><![CDATA[");
		sb.append(getAddressStreet1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addressStreet2</column-name><column-value><![CDATA[");
		sb.append(getAddressStreet2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postalCode</column-name><column-value><![CDATA[");
		sb.append(getPostalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationalityId</column-name><column-value><![CDATA[");
		sb.append(getNationalityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _organizationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _organizationName;
	private String _taxId;
	private int _numberOfEmployees;
	private String _registrationNumber;
	private String _phone;
	private String _fax;
	private String _email;
	private String _addressStreet1;
	private String _addressStreet2;
	private String _city;
	private String _state;
	private String _postalCode;
	private long _nationalityId;
	private String _note;
	private BaseModel<?> _organizationRemoteModel;
}