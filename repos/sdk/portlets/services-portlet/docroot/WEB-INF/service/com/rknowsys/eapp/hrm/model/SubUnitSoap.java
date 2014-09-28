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
public class SubUnitSoap implements Serializable {
	public static SubUnitSoap toSoapModel(SubUnit model) {
		SubUnitSoap soapModel = new SubUnitSoap();

		soapModel.setSubUnitId(model.getSubUnitId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SubUnitSoap[] toSoapModels(SubUnit[] models) {
		SubUnitSoap[] soapModels = new SubUnitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubUnitSoap[][] toSoapModels(SubUnit[][] models) {
		SubUnitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubUnitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubUnitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubUnitSoap[] toSoapModels(List<SubUnit> models) {
		List<SubUnitSoap> soapModels = new ArrayList<SubUnitSoap>(models.size());

		for (SubUnit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubUnitSoap[soapModels.size()]);
	}

	public SubUnitSoap() {
	}

	public long getPrimaryKey() {
		return _subUnitId;
	}

	public void setPrimaryKey(long pk) {
		setSubUnitId(pk);
	}

	public long getSubUnitId() {
		return _subUnitId;
	}

	public void setSubUnitId(long subUnitId) {
		_subUnitId = subUnitId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	private long _subUnitId;
	private String _name;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
}