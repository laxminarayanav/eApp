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

package com.rknowsys.eapp.hrm.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rknowsys.eapp.hrm.model.News;
import com.rknowsys.eapp.hrm.model.NewsModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the News service. Represents a row in the &quot;news&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rknowsys.eapp.hrm.model.NewsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NewsImpl}.
 * </p>
 *
 * @author rknowsys
 * @see NewsImpl
 * @see com.rknowsys.eapp.hrm.model.News
 * @see com.rknowsys.eapp.hrm.model.NewsModel
 * @generated
 */
public class NewsModelImpl extends BaseModelImpl<News> implements NewsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a news model instance should use the {@link com.rknowsys.eapp.hrm.model.News} interface instead.
	 */
	public static final String TABLE_NAME = "news";
	public static final Object[][] TABLE_COLUMNS = {
			{ "newsId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "userId", Types.BIGINT },
			{ "topic", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "publishTo", Types.VARCHAR },
			{ "publishDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table news (newsId LONG not null primary key,companyId LONG,groupId LONG,createDate DATE null,modifiedDate DATE null,userId LONG,topic VARCHAR(75) null,description VARCHAR(75) null,publishTo VARCHAR(75) null,publishDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table news";
	public static final String ORDER_BY_JPQL = " ORDER BY news.newsId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY news.newsId ASC";
	public static final String DATA_SOURCE = "hrmDataSource";
	public static final String SESSION_FACTORY = "hrmSessionFactory";
	public static final String TX_MANAGER = "hrmTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rknowsys.eapp.hrm.model.News"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rknowsys.eapp.hrm.model.News"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rknowsys.eapp.hrm.model.News"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long NEWSID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rknowsys.eapp.hrm.model.News"));

	public NewsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _newsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNewsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _newsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getNewsId() {
		return _newsId;
	}

	@Override
	public void setNewsId(long newsId) {
		_newsId = newsId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
	public String getTopic() {
		if (_topic == null) {
			return StringPool.BLANK;
		}
		else {
			return _topic;
		}
	}

	@Override
	public void setTopic(String topic) {
		_topic = topic;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public String getPublishTo() {
		if (_publishTo == null) {
			return StringPool.BLANK;
		}
		else {
			return _publishTo;
		}
	}

	@Override
	public void setPublishTo(String publishTo) {
		_publishTo = publishTo;
	}

	@Override
	public Date getPublishDate() {
		return _publishDate;
	}

	@Override
	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			News.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public News toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (News)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		NewsImpl newsImpl = new NewsImpl();

		newsImpl.setNewsId(getNewsId());
		newsImpl.setCompanyId(getCompanyId());
		newsImpl.setGroupId(getGroupId());
		newsImpl.setCreateDate(getCreateDate());
		newsImpl.setModifiedDate(getModifiedDate());
		newsImpl.setUserId(getUserId());
		newsImpl.setTopic(getTopic());
		newsImpl.setDescription(getDescription());
		newsImpl.setPublishTo(getPublishTo());
		newsImpl.setPublishDate(getPublishDate());

		newsImpl.resetOriginalValues();

		return newsImpl;
	}

	@Override
	public int compareTo(News news) {
		long primaryKey = news.getPrimaryKey();

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

		if (!(obj instanceof News)) {
			return false;
		}

		News news = (News)obj;

		long primaryKey = news.getPrimaryKey();

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
	public void resetOriginalValues() {
		NewsModelImpl newsModelImpl = this;

		newsModelImpl._originalGroupId = newsModelImpl._groupId;

		newsModelImpl._setOriginalGroupId = false;

		newsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<News> toCacheModel() {
		NewsCacheModel newsCacheModel = new NewsCacheModel();

		newsCacheModel.newsId = getNewsId();

		newsCacheModel.companyId = getCompanyId();

		newsCacheModel.groupId = getGroupId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			newsCacheModel.createDate = createDate.getTime();
		}
		else {
			newsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			newsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			newsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		newsCacheModel.userId = getUserId();

		newsCacheModel.topic = getTopic();

		String topic = newsCacheModel.topic;

		if ((topic != null) && (topic.length() == 0)) {
			newsCacheModel.topic = null;
		}

		newsCacheModel.description = getDescription();

		String description = newsCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			newsCacheModel.description = null;
		}

		newsCacheModel.publishTo = getPublishTo();

		String publishTo = newsCacheModel.publishTo;

		if ((publishTo != null) && (publishTo.length() == 0)) {
			newsCacheModel.publishTo = null;
		}

		Date publishDate = getPublishDate();

		if (publishDate != null) {
			newsCacheModel.publishDate = publishDate.getTime();
		}
		else {
			newsCacheModel.publishDate = Long.MIN_VALUE;
		}

		return newsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{newsId=");
		sb.append(getNewsId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", topic=");
		sb.append(getTopic());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", publishTo=");
		sb.append(getPublishTo());
		sb.append(", publishDate=");
		sb.append(getPublishDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.News");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>newsId</column-name><column-value><![CDATA[");
		sb.append(getNewsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>topic</column-name><column-value><![CDATA[");
		sb.append(getTopic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishTo</column-name><column-value><![CDATA[");
		sb.append(getPublishTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishDate</column-name><column-value><![CDATA[");
		sb.append(getPublishDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = News.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { News.class };
	private long _newsId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private String _topic;
	private String _description;
	private String _publishTo;
	private Date _publishDate;
	private long _columnBitmask;
	private News _escapedModel;
}