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
public class JobTitleSoap implements Serializable {
	public static JobTitleSoap toSoapModel(JobTitle model) {
		JobTitleSoap soapModel = new JobTitleSoap();

		soapModel.setJobTitleId(model.getJobTitleId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setNotes(model.getNotes());
		soapModel.setSpecification(model.getSpecification());

		return soapModel;
	}

	public static JobTitleSoap[] toSoapModels(JobTitle[] models) {
		JobTitleSoap[] soapModels = new JobTitleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobTitleSoap[][] toSoapModels(JobTitle[][] models) {
		JobTitleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JobTitleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobTitleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobTitleSoap[] toSoapModels(List<JobTitle> models) {
		List<JobTitleSoap> soapModels = new ArrayList<JobTitleSoap>(models.size());

		for (JobTitle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobTitleSoap[soapModels.size()]);
	}

	public JobTitleSoap() {
	}

	public long getPrimaryKey() {
		return _jobTitleId;
	}

	public void setPrimaryKey(long pk) {
		setJobTitleId(pk);
	}

	public long getJobTitleId() {
		return _jobTitleId;
	}

	public void setJobTitleId(long jobTitleId) {
		_jobTitleId = jobTitleId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	public String getSpecification() {
		return _specification;
	}

	public void setSpecification(String specification) {
		_specification = specification;
	}

	private long _jobTitleId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _title;
	private String _description;
	private String _notes;
	private String _specification;
}