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
import com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmploymentStatusClp extends BaseModelImpl<EmploymentStatus>
	implements EmploymentStatus {
	public EmploymentStatusClp() {
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
	public long getPrimaryKey() {
		return _employmentStatusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmploymentStatusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employmentStatusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEmploymentStatusId() {
		return _employmentStatusId;
	}

	@Override
	public void setEmploymentStatusId(long employmentStatusId) {
		_employmentStatusId = employmentStatusId;

		if (_employmentStatusRemoteModel != null) {
			try {
				Class<?> clazz = _employmentStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setEmploymentStatusId",
						long.class);

				method.invoke(_employmentStatusRemoteModel, employmentStatusId);
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

		if (_employmentStatusRemoteModel != null) {
			try {
				Class<?> clazz = _employmentStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_employmentStatusRemoteModel, groupId);
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

		if (_employmentStatusRemoteModel != null) {
			try {
				Class<?> clazz = _employmentStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_employmentStatusRemoteModel, companyId);
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

		if (_employmentStatusRemoteModel != null) {
			try {
				Class<?> clazz = _employmentStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_employmentStatusRemoteModel, userId);
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

		if (_employmentStatusRemoteModel != null) {
			try {
				Class<?> clazz = _employmentStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_employmentStatusRemoteModel, createDate);
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

		if (_employmentStatusRemoteModel != null) {
			try {
				Class<?> clazz = _employmentStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_employmentStatusRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmploymentstatus() {
		return _employmentstatus;
	}

	@Override
	public void setEmploymentstatus(String employmentstatus) {
		_employmentstatus = employmentstatus;

		if (_employmentStatusRemoteModel != null) {
			try {
				Class<?> clazz = _employmentStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setEmploymentstatus",
						String.class);

				method.invoke(_employmentStatusRemoteModel, employmentstatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmploymentStatusRemoteModel() {
		return _employmentStatusRemoteModel;
	}

	public void setEmploymentStatusRemoteModel(
		BaseModel<?> employmentStatusRemoteModel) {
		_employmentStatusRemoteModel = employmentStatusRemoteModel;
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

		Class<?> remoteModelClass = _employmentStatusRemoteModel.getClass();

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

		Object returnValue = method.invoke(_employmentStatusRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmploymentStatusLocalServiceUtil.addEmploymentStatus(this);
		}
		else {
			EmploymentStatusLocalServiceUtil.updateEmploymentStatus(this);
		}
	}

	@Override
	public EmploymentStatus toEscapedModel() {
		return (EmploymentStatus)ProxyUtil.newProxyInstance(EmploymentStatus.class.getClassLoader(),
			new Class[] { EmploymentStatus.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmploymentStatusClp clone = new EmploymentStatusClp();

		clone.setEmploymentStatusId(getEmploymentStatusId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEmploymentstatus(getEmploymentstatus());

		return clone;
	}

	@Override
	public int compareTo(EmploymentStatus employmentStatus) {
		long primaryKey = employmentStatus.getPrimaryKey();

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

		if (!(obj instanceof EmploymentStatusClp)) {
			return false;
		}

		EmploymentStatusClp employmentStatus = (EmploymentStatusClp)obj;

		long primaryKey = employmentStatus.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{employmentStatusId=");
		sb.append(getEmploymentStatusId());
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
		sb.append(", employmentstatus=");
		sb.append(getEmploymentstatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmploymentStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>employmentStatusId</column-name><column-value><![CDATA[");
		sb.append(getEmploymentStatusId());
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
			"<column><column-name>employmentstatus</column-name><column-value><![CDATA[");
		sb.append(getEmploymentstatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _employmentStatusId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _employmentstatus;
	private BaseModel<?> _employmentStatusRemoteModel;
}