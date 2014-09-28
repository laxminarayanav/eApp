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

import com.rknowsys.eapp.hrm.model.ImmigrationDocument;
import com.rknowsys.eapp.hrm.model.ImmigrationDocumentModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ImmigrationDocument service. Represents a row in the &quot;immigration_document&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rknowsys.eapp.hrm.model.ImmigrationDocumentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ImmigrationDocumentImpl}.
 * </p>
 *
 * @author rknowsys
 * @see ImmigrationDocumentImpl
 * @see com.rknowsys.eapp.hrm.model.ImmigrationDocument
 * @see com.rknowsys.eapp.hrm.model.ImmigrationDocumentModel
 * @generated
 */
public class ImmigrationDocumentModelImpl extends BaseModelImpl<ImmigrationDocument>
	implements ImmigrationDocumentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ImmigrationDocument model instance should use the {@link com.rknowsys.eapp.hrm.model.ImmigrationDocument} interface instead.
	 */
	public static final String TABLE_NAME = "immigration_document";
	public static final Object[][] TABLE_COLUMNS = {
			{ "immigrationDocumentId", Types.BIGINT },
			{ "employeeId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "userId", Types.BIGINT },
			{ "docTopic", Types.VARCHAR },
			{ "docCategory", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "publishTo", Types.VARCHAR },
			{ "publishDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table immigration_document (immigrationDocumentId LONG not null primary key,employeeId LONG,companyId LONG,groupId LONG,createDate DATE null,modifiedDate DATE null,userId LONG,docTopic VARCHAR(75) null,docCategory VARCHAR(75) null,description VARCHAR(75) null,publishTo VARCHAR(75) null,publishDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table immigration_document";
	public static final String ORDER_BY_JPQL = " ORDER BY immigrationDocument.immigrationDocumentId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY immigration_document.immigrationDocumentId ASC";
	public static final String DATA_SOURCE = "hrmDataSource";
	public static final String SESSION_FACTORY = "hrmSessionFactory";
	public static final String TX_MANAGER = "hrmTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rknowsys.eapp.hrm.model.ImmigrationDocument"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rknowsys.eapp.hrm.model.ImmigrationDocument"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rknowsys.eapp.hrm.model.ImmigrationDocument"),
			true);
	public static long EMPLOYEEID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long IMMIGRATIONDOCUMENTID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rknowsys.eapp.hrm.model.ImmigrationDocument"));

	public ImmigrationDocumentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _immigrationDocumentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setImmigrationDocumentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _immigrationDocumentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ImmigrationDocument.class;
	}

	@Override
	public String getModelClassName() {
		return ImmigrationDocument.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("immigrationDocumentId", getImmigrationDocumentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("docTopic", getDocTopic());
		attributes.put("docCategory", getDocCategory());
		attributes.put("description", getDescription());
		attributes.put("publishTo", getPublishTo());
		attributes.put("publishDate", getPublishDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long immigrationDocumentId = (Long)attributes.get(
				"immigrationDocumentId");

		if (immigrationDocumentId != null) {
			setImmigrationDocumentId(immigrationDocumentId);
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

		String docTopic = (String)attributes.get("docTopic");

		if (docTopic != null) {
			setDocTopic(docTopic);
		}

		String docCategory = (String)attributes.get("docCategory");

		if (docCategory != null) {
			setDocCategory(docCategory);
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
	public long getImmigrationDocumentId() {
		return _immigrationDocumentId;
	}

	@Override
	public void setImmigrationDocumentId(long immigrationDocumentId) {
		_columnBitmask |= IMMIGRATIONDOCUMENTID_COLUMN_BITMASK;

		if (!_setOriginalImmigrationDocumentId) {
			_setOriginalImmigrationDocumentId = true;

			_originalImmigrationDocumentId = _immigrationDocumentId;
		}

		_immigrationDocumentId = immigrationDocumentId;
	}

	public long getOriginalImmigrationDocumentId() {
		return _originalImmigrationDocumentId;
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
	public String getDocTopic() {
		if (_docTopic == null) {
			return StringPool.BLANK;
		}
		else {
			return _docTopic;
		}
	}

	@Override
	public void setDocTopic(String docTopic) {
		_docTopic = docTopic;
	}

	@Override
	public String getDocCategory() {
		if (_docCategory == null) {
			return StringPool.BLANK;
		}
		else {
			return _docCategory;
		}
	}

	@Override
	public void setDocCategory(String docCategory) {
		_docCategory = docCategory;
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
			ImmigrationDocument.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ImmigrationDocument toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ImmigrationDocument)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ImmigrationDocumentImpl immigrationDocumentImpl = new ImmigrationDocumentImpl();

		immigrationDocumentImpl.setImmigrationDocumentId(getImmigrationDocumentId());
		immigrationDocumentImpl.setEmployeeId(getEmployeeId());
		immigrationDocumentImpl.setCompanyId(getCompanyId());
		immigrationDocumentImpl.setGroupId(getGroupId());
		immigrationDocumentImpl.setCreateDate(getCreateDate());
		immigrationDocumentImpl.setModifiedDate(getModifiedDate());
		immigrationDocumentImpl.setUserId(getUserId());
		immigrationDocumentImpl.setDocTopic(getDocTopic());
		immigrationDocumentImpl.setDocCategory(getDocCategory());
		immigrationDocumentImpl.setDescription(getDescription());
		immigrationDocumentImpl.setPublishTo(getPublishTo());
		immigrationDocumentImpl.setPublishDate(getPublishDate());

		immigrationDocumentImpl.resetOriginalValues();

		return immigrationDocumentImpl;
	}

	@Override
	public int compareTo(ImmigrationDocument immigrationDocument) {
		long primaryKey = immigrationDocument.getPrimaryKey();

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

		if (!(obj instanceof ImmigrationDocument)) {
			return false;
		}

		ImmigrationDocument immigrationDocument = (ImmigrationDocument)obj;

		long primaryKey = immigrationDocument.getPrimaryKey();

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
		ImmigrationDocumentModelImpl immigrationDocumentModelImpl = this;

		immigrationDocumentModelImpl._originalImmigrationDocumentId = immigrationDocumentModelImpl._immigrationDocumentId;

		immigrationDocumentModelImpl._setOriginalImmigrationDocumentId = false;

		immigrationDocumentModelImpl._originalEmployeeId = immigrationDocumentModelImpl._employeeId;

		immigrationDocumentModelImpl._setOriginalEmployeeId = false;

		immigrationDocumentModelImpl._originalGroupId = immigrationDocumentModelImpl._groupId;

		immigrationDocumentModelImpl._setOriginalGroupId = false;

		immigrationDocumentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ImmigrationDocument> toCacheModel() {
		ImmigrationDocumentCacheModel immigrationDocumentCacheModel = new ImmigrationDocumentCacheModel();

		immigrationDocumentCacheModel.immigrationDocumentId = getImmigrationDocumentId();

		immigrationDocumentCacheModel.employeeId = getEmployeeId();

		immigrationDocumentCacheModel.companyId = getCompanyId();

		immigrationDocumentCacheModel.groupId = getGroupId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			immigrationDocumentCacheModel.createDate = createDate.getTime();
		}
		else {
			immigrationDocumentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			immigrationDocumentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			immigrationDocumentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		immigrationDocumentCacheModel.userId = getUserId();

		immigrationDocumentCacheModel.docTopic = getDocTopic();

		String docTopic = immigrationDocumentCacheModel.docTopic;

		if ((docTopic != null) && (docTopic.length() == 0)) {
			immigrationDocumentCacheModel.docTopic = null;
		}

		immigrationDocumentCacheModel.docCategory = getDocCategory();

		String docCategory = immigrationDocumentCacheModel.docCategory;

		if ((docCategory != null) && (docCategory.length() == 0)) {
			immigrationDocumentCacheModel.docCategory = null;
		}

		immigrationDocumentCacheModel.description = getDescription();

		String description = immigrationDocumentCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			immigrationDocumentCacheModel.description = null;
		}

		immigrationDocumentCacheModel.publishTo = getPublishTo();

		String publishTo = immigrationDocumentCacheModel.publishTo;

		if ((publishTo != null) && (publishTo.length() == 0)) {
			immigrationDocumentCacheModel.publishTo = null;
		}

		Date publishDate = getPublishDate();

		if (publishDate != null) {
			immigrationDocumentCacheModel.publishDate = publishDate.getTime();
		}
		else {
			immigrationDocumentCacheModel.publishDate = Long.MIN_VALUE;
		}

		return immigrationDocumentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{immigrationDocumentId=");
		sb.append(getImmigrationDocumentId());
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
		sb.append(", docTopic=");
		sb.append(getDocTopic());
		sb.append(", docCategory=");
		sb.append(getDocCategory());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.ImmigrationDocument");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>immigrationDocumentId</column-name><column-value><![CDATA[");
		sb.append(getImmigrationDocumentId());
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
			"<column><column-name>docTopic</column-name><column-value><![CDATA[");
		sb.append(getDocTopic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>docCategory</column-name><column-value><![CDATA[");
		sb.append(getDocCategory());
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

	private static ClassLoader _classLoader = ImmigrationDocument.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ImmigrationDocument.class
		};
	private long _immigrationDocumentId;
	private long _originalImmigrationDocumentId;
	private boolean _setOriginalImmigrationDocumentId;
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
	private String _docTopic;
	private String _docCategory;
	private String _description;
	private String _publishTo;
	private Date _publishDate;
	private long _columnBitmask;
	private ImmigrationDocument _escapedModel;
}