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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rknowsys
 * @generated
 */
public class EmploymentStatusSoap implements Serializable {
	public static EmploymentStatusSoap toSoapModel(EmploymentStatus model) {
		EmploymentStatusSoap soapModel = new EmploymentStatusSoap();

		soapModel.setEmploymentStatusId(model.getEmploymentStatusId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmploymentstatus(model.getEmploymentstatus());

		return soapModel;
	}

	public static EmploymentStatusSoap[] toSoapModels(EmploymentStatus[] models) {
		EmploymentStatusSoap[] soapModels = new EmploymentStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmploymentStatusSoap[][] toSoapModels(
		EmploymentStatus[][] models) {
		EmploymentStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmploymentStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmploymentStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmploymentStatusSoap[] toSoapModels(
		List<EmploymentStatus> models) {
		List<EmploymentStatusSoap> soapModels = new ArrayList<EmploymentStatusSoap>(models.size());

		for (EmploymentStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmploymentStatusSoap[soapModels.size()]);
	}

	public EmploymentStatusSoap() {
	}

	public long getPrimaryKey() {
		return _employmentStatusId;
	}

	public void setPrimaryKey(long pk) {
		setEmploymentStatusId(pk);
	}

	public long getEmploymentStatusId() {
		return _employmentStatusId;
	}

	public void setEmploymentStatusId(long employmentStatusId) {
		_employmentStatusId = employmentStatusId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getEmploymentstatus() {
		return _employmentstatus;
	}

	public void setEmploymentstatus(String employmentstatus) {
		_employmentstatus = employmentstatus;
	}

	private long _employmentStatusId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _employmentstatus;
}