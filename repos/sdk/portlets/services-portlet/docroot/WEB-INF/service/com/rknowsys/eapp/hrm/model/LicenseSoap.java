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
public class LicenseSoap implements Serializable {
	public static LicenseSoap toSoapModel(License model) {
		LicenseSoap soapModel = new LicenseSoap();

		soapModel.setLicenseId(model.getLicenseId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setLicenseName(model.getLicenseName());
		soapModel.setExpiryDate(model.getExpiryDate());
		soapModel.setLicenseNumber(model.getLicenseNumber());

		return soapModel;
	}

	public static LicenseSoap[] toSoapModels(License[] models) {
		LicenseSoap[] soapModels = new LicenseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LicenseSoap[][] toSoapModels(License[][] models) {
		LicenseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LicenseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LicenseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LicenseSoap[] toSoapModels(List<License> models) {
		List<LicenseSoap> soapModels = new ArrayList<LicenseSoap>(models.size());

		for (License model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LicenseSoap[soapModels.size()]);
	}

	public LicenseSoap() {
	}

	public long getPrimaryKey() {
		return _licenseId;
	}

	public void setPrimaryKey(long pk) {
		setLicenseId(pk);
	}

	public long getLicenseId() {
		return _licenseId;
	}

	public void setLicenseId(long licenseId) {
		_licenseId = licenseId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getLicenseName() {
		return _licenseName;
	}

	public void setLicenseName(String licenseName) {
		_licenseName = licenseName;
	}

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	public String getLicenseNumber() {
		return _licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		_licenseNumber = licenseNumber;
	}

	private long _licenseId;
	private long _employeeId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _licenseName;
	private Date _expiryDate;
	private String _licenseNumber;
}