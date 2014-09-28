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
public class NewsSoap implements Serializable {
	public static NewsSoap toSoapModel(News model) {
		NewsSoap soapModel = new NewsSoap();

		soapModel.setNewsId(model.getNewsId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setTopic(model.getTopic());
		soapModel.setDescription(model.getDescription());
		soapModel.setPublishTo(model.getPublishTo());
		soapModel.setPublishDate(model.getPublishDate());

		return soapModel;
	}

	public static NewsSoap[] toSoapModels(News[] models) {
		NewsSoap[] soapModels = new NewsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NewsSoap[][] toSoapModels(News[][] models) {
		NewsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NewsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NewsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NewsSoap[] toSoapModels(List<News> models) {
		List<NewsSoap> soapModels = new ArrayList<NewsSoap>(models.size());

		for (News model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NewsSoap[soapModels.size()]);
	}

	public NewsSoap() {
	}

	public long getPrimaryKey() {
		return _newsId;
	}

	public void setPrimaryKey(long pk) {
		setNewsId(pk);
	}

	public long getNewsId() {
		return _newsId;
	}

	public void setNewsId(long newsId) {
		_newsId = newsId;
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

	public String getTopic() {
		return _topic;
	}

	public void setTopic(String topic) {
		_topic = topic;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getPublishTo() {
		return _publishTo;
	}

	public void setPublishTo(String publishTo) {
		_publishTo = publishTo;
	}

	public Date getPublishDate() {
		return _publishDate;
	}

	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;
	}

	private long _newsId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _topic;
	private String _description;
	private String _publishTo;
	private Date _publishDate;
}