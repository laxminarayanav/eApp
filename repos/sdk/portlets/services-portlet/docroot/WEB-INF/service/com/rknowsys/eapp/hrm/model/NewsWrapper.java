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
 * This class is a wrapper for {@link News}.
 * </p>
 *
 * @author rknowsys
 * @see News
 * @generated
 */
public class NewsWrapper implements News, ModelWrapper<News> {
	public NewsWrapper(News news) {
		_news = news;
	}

	@Override
	public Class<?> getModelClass() {
		return News.class;
	}

	@Override
	public String getModelClassName() {
		return News.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("newsId", getNewsId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("topic", getTopic());
		attributes.put("description", getDescription());
		attributes.put("publishTo", getPublishTo());
		attributes.put("publishDate", getPublishDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long newsId = (Long)attributes.get("newsId");

		if (newsId != null) {
			setNewsId(newsId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String topic = (String)attributes.get("topic");

		if (topic != null) {
			setTopic(topic);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String publishTo = (String)attributes.get("publishTo");

		if (publishTo != null) {
			setPublishTo(publishTo);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}
	}

	/**
	* Returns the primary key of this news.
	*
	* @return the primary key of this news
	*/
	@Override
	public long getPrimaryKey() {
		return _news.getPrimaryKey();
	}

	/**
	* Sets the primary key of this news.
	*
	* @param primaryKey the primary key of this news
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_news.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the news ID of this news.
	*
	* @return the news ID of this news
	*/
	@Override
	public long getNewsId() {
		return _news.getNewsId();
	}

	/**
	* Sets the news ID of this news.
	*
	* @param newsId the news ID of this news
	*/
	@Override
	public void setNewsId(long newsId) {
		_news.setNewsId(newsId);
	}

	/**
	* Returns the company ID of this news.
	*
	* @return the company ID of this news
	*/
	@Override
	public long getCompanyId() {
		return _news.getCompanyId();
	}

	/**
	* Sets the company ID of this news.
	*
	* @param companyId the company ID of this news
	*/
	@Override
	public void setCompanyId(long companyId) {
		_news.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this news.
	*
	* @return the group ID of this news
	*/
	@Override
	public long getGroupId() {
		return _news.getGroupId();
	}

	/**
	* Sets the group ID of this news.
	*
	* @param groupId the group ID of this news
	*/
	@Override
	public void setGroupId(long groupId) {
		_news.setGroupId(groupId);
	}

	/**
	* Returns the create date of this news.
	*
	* @return the create date of this news
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _news.getCreateDate();
	}

	/**
	* Sets the create date of this news.
	*
	* @param createDate the create date of this news
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_news.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this news.
	*
	* @return the modified date of this news
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _news.getModifiedDate();
	}

	/**
	* Sets the modified date of this news.
	*
	* @param modifiedDate the modified date of this news
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_news.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this news.
	*
	* @return the user ID of this news
	*/
	@Override
	public long getUserId() {
		return _news.getUserId();
	}

	/**
	* Sets the user ID of this news.
	*
	* @param userId the user ID of this news
	*/
	@Override
	public void setUserId(long userId) {
		_news.setUserId(userId);
	}

	/**
	* Returns the user uuid of this news.
	*
	* @return the user uuid of this news
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _news.getUserUuid();
	}

	/**
	* Sets the user uuid of this news.
	*
	* @param userUuid the user uuid of this news
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_news.setUserUuid(userUuid);
	}

	/**
	* Returns the topic of this news.
	*
	* @return the topic of this news
	*/
	@Override
	public java.lang.String getTopic() {
		return _news.getTopic();
	}

	/**
	* Sets the topic of this news.
	*
	* @param topic the topic of this news
	*/
	@Override
	public void setTopic(java.lang.String topic) {
		_news.setTopic(topic);
	}

	/**
	* Returns the description of this news.
	*
	* @return the description of this news
	*/
	@Override
	public java.lang.String getDescription() {
		return _news.getDescription();
	}

	/**
	* Sets the description of this news.
	*
	* @param description the description of this news
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_news.setDescription(description);
	}

	/**
	* Returns the publish to of this news.
	*
	* @return the publish to of this news
	*/
	@Override
	public java.lang.String getPublishTo() {
		return _news.getPublishTo();
	}

	/**
	* Sets the publish to of this news.
	*
	* @param publishTo the publish to of this news
	*/
	@Override
	public void setPublishTo(java.lang.String publishTo) {
		_news.setPublishTo(publishTo);
	}

	/**
	* Returns the publish date of this news.
	*
	* @return the publish date of this news
	*/
	@Override
	public java.util.Date getPublishDate() {
		return _news.getPublishDate();
	}

	/**
	* Sets the publish date of this news.
	*
	* @param publishDate the publish date of this news
	*/
	@Override
	public void setPublishDate(java.util.Date publishDate) {
		_news.setPublishDate(publishDate);
	}

	@Override
	public boolean isNew() {
		return _news.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_news.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _news.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_news.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _news.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _news.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_news.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _news.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_news.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_news.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_news.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NewsWrapper((News)_news.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.News news) {
		return _news.compareTo(news);
	}

	@Override
	public int hashCode() {
		return _news.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.News> toCacheModel() {
		return _news.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.News toEscapedModel() {
		return new NewsWrapper(_news.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.News toUnescapedModel() {
		return new NewsWrapper(_news.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _news.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _news.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_news.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NewsWrapper)) {
			return false;
		}

		NewsWrapper newsWrapper = (NewsWrapper)obj;

		if (Validator.equals(_news, newsWrapper._news)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public News getWrappedNews() {
		return _news;
	}

	@Override
	public News getWrappedModel() {
		return _news;
	}

	@Override
	public void resetOriginalValues() {
		_news.resetOriginalValues();
	}

	private News _news;
}