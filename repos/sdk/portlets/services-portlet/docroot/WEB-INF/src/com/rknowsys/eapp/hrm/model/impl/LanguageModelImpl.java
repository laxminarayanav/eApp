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

import com.rknowsys.eapp.hrm.model.Language;
import com.rknowsys.eapp.hrm.model.LanguageModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Language service. Represents a row in the &quot;language&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rknowsys.eapp.hrm.model.LanguageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LanguageImpl}.
 * </p>
 *
 * @author rknowsys
 * @see LanguageImpl
 * @see com.rknowsys.eapp.hrm.model.Language
 * @see com.rknowsys.eapp.hrm.model.LanguageModel
 * @generated
 */
public class LanguageModelImpl extends BaseModelImpl<Language>
	implements LanguageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a language model instance should use the {@link com.rknowsys.eapp.hrm.model.Language} interface instead.
	 */
	public static final String TABLE_NAME = "language";
	public static final Object[][] TABLE_COLUMNS = {
			{ "languageId", Types.BIGINT },
			{ "employeeId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "userId", Types.BIGINT },
			{ "languageName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table language (languageId LONG not null primary key,employeeId LONG,companyId LONG,groupId LONG,createDate DATE null,modifiedDate DATE null,userId LONG,languageName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table language";
	public static final String ORDER_BY_JPQL = " ORDER BY language.languageId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY language.languageId ASC";
	public static final String DATA_SOURCE = "hrmDataSource";
	public static final String SESSION_FACTORY = "hrmSessionFactory";
	public static final String TX_MANAGER = "hrmTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rknowsys.eapp.hrm.model.Language"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rknowsys.eapp.hrm.model.Language"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rknowsys.eapp.hrm.model.Language"),
			true);
	public static long EMPLOYEEID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long LANGUAGEID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rknowsys.eapp.hrm.model.Language"));

	public LanguageModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _languageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLanguageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _languageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Language.class;
	}

	@Override
	public String getModelClassName() {
		return Language.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("languageId", getLanguageId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("languageName", getLanguageName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long languageId = (Long)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
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

		String languageName = (String)attributes.get("languageName");

		if (languageName != null) {
			setLanguageName(languageName);
		}
	}

	@Override
	public long getLanguageId() {
		return _languageId;
	}

	@Override
	public void setLanguageId(long languageId) {
		_columnBitmask |= LANGUAGEID_COLUMN_BITMASK;

		if (!_setOriginalLanguageId) {
			_setOriginalLanguageId = true;

			_originalLanguageId = _languageId;
		}

		_languageId = languageId;
	}

	public long getOriginalLanguageId() {
		return _originalLanguageId;
	}

	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_columnBitmask |= EMPLOYEEID_COLUMN_BITMASK;

		if (!_setOriginalEmployeeId) {
			_setOriginalEmployeeId = true;

			_originalEmployeeId = _employeeId;
		}

		_employeeId = employeeId;
	}

	public long getOriginalEmployeeId() {
		return _originalEmployeeId;
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
	public String getLanguageName() {
		if (_languageName == null) {
			return StringPool.BLANK;
		}
		else {
			return _languageName;
		}
	}

	@Override
	public void setLanguageName(String languageName) {
		_languageName = languageName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Language.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Language toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Language)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LanguageImpl languageImpl = new LanguageImpl();

		languageImpl.setLanguageId(getLanguageId());
		languageImpl.setEmployeeId(getEmployeeId());
		languageImpl.setCompanyId(getCompanyId());
		languageImpl.setGroupId(getGroupId());
		languageImpl.setCreateDate(getCreateDate());
		languageImpl.setModifiedDate(getModifiedDate());
		languageImpl.setUserId(getUserId());
		languageImpl.setLanguageName(getLanguageName());

		languageImpl.resetOriginalValues();

		return languageImpl;
	}

	@Override
	public int compareTo(Language language) {
		long primaryKey = language.getPrimaryKey();

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

		if (!(obj instanceof Language)) {
			return false;
		}

		Language language = (Language)obj;

		long primaryKey = language.getPrimaryKey();

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
		LanguageModelImpl languageModelImpl = this;

		languageModelImpl._originalLanguageId = languageModelImpl._languageId;

		languageModelImpl._setOriginalLanguageId = false;

		languageModelImpl._originalEmployeeId = languageModelImpl._employeeId;

		languageModelImpl._setOriginalEmployeeId = false;

		languageModelImpl._originalGroupId = languageModelImpl._groupId;

		languageModelImpl._setOriginalGroupId = false;

		languageModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Language> toCacheModel() {
		LanguageCacheModel languageCacheModel = new LanguageCacheModel();

		languageCacheModel.languageId = getLanguageId();

		languageCacheModel.employeeId = getEmployeeId();

		languageCacheModel.companyId = getCompanyId();

		languageCacheModel.groupId = getGroupId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			languageCacheModel.createDate = createDate.getTime();
		}
		else {
			languageCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			languageCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			languageCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		languageCacheModel.userId = getUserId();

		languageCacheModel.languageName = getLanguageName();

		String languageName = languageCacheModel.languageName;

		if ((languageName != null) && (languageName.length() == 0)) {
			languageCacheModel.languageName = null;
		}

		return languageCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{languageId=");
		sb.append(getLanguageId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
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
		sb.append(", languageName=");
		sb.append(getLanguageName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.Language");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
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
			"<column><column-name>languageName</column-name><column-value><![CDATA[");
		sb.append(getLanguageName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Language.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Language.class
		};
	private long _languageId;
	private long _originalLanguageId;
	private boolean _setOriginalLanguageId;
	private long _employeeId;
	private long _originalEmployeeId;
	private boolean _setOriginalEmployeeId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private String _languageName;
	private long _columnBitmask;
	private Language _escapedModel;
}