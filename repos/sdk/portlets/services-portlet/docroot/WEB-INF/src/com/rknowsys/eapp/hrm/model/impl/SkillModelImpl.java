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

import com.rknowsys.eapp.hrm.model.Skill;
import com.rknowsys.eapp.hrm.model.SkillModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Skill service. Represents a row in the &quot;skill&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rknowsys.eapp.hrm.model.SkillModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SkillImpl}.
 * </p>
 *
 * @author rknowsys
 * @see SkillImpl
 * @see com.rknowsys.eapp.hrm.model.Skill
 * @see com.rknowsys.eapp.hrm.model.SkillModel
 * @generated
 */
public class SkillModelImpl extends BaseModelImpl<Skill> implements SkillModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a skill model instance should use the {@link com.rknowsys.eapp.hrm.model.Skill} interface instead.
	 */
	public static final String TABLE_NAME = "skill";
	public static final Object[][] TABLE_COLUMNS = {
			{ "skillId", Types.BIGINT },
			{ "employeeId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "userId", Types.BIGINT },
			{ "skillName", Types.VARCHAR },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table skill (skillId LONG not null primary key,employeeId LONG,companyId LONG,groupId LONG,createDate DATE null,modifiedDate DATE null,userId LONG,skillName VARCHAR(75) null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table skill";
	public static final String ORDER_BY_JPQL = " ORDER BY skill.skillId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY skill.skillId ASC";
	public static final String DATA_SOURCE = "hrmDataSource";
	public static final String SESSION_FACTORY = "hrmSessionFactory";
	public static final String TX_MANAGER = "hrmTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rknowsys.eapp.hrm.model.Skill"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rknowsys.eapp.hrm.model.Skill"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rknowsys.eapp.hrm.model.Skill"),
			true);
	public static long EMPLOYEEID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long SKILLID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rknowsys.eapp.hrm.model.Skill"));

	public SkillModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _skillId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSkillId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _skillId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Skill.class;
	}

	@Override
	public String getModelClassName() {
		return Skill.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("skillId", getSkillId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("skillName", getSkillName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long skillId = (Long)attributes.get("skillId");

		if (skillId != null) {
			setSkillId(skillId);
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

		String skillName = (String)attributes.get("skillName");

		if (skillName != null) {
			setSkillName(skillName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getSkillId() {
		return _skillId;
	}

	@Override
	public void setSkillId(long skillId) {
		_columnBitmask |= SKILLID_COLUMN_BITMASK;

		if (!_setOriginalSkillId) {
			_setOriginalSkillId = true;

			_originalSkillId = _skillId;
		}

		_skillId = skillId;
	}

	public long getOriginalSkillId() {
		return _originalSkillId;
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
	public String getSkillName() {
		if (_skillName == null) {
			return StringPool.BLANK;
		}
		else {
			return _skillName;
		}
	}

	@Override
	public void setSkillName(String skillName) {
		_skillName = skillName;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Skill.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Skill toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Skill)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SkillImpl skillImpl = new SkillImpl();

		skillImpl.setSkillId(getSkillId());
		skillImpl.setEmployeeId(getEmployeeId());
		skillImpl.setCompanyId(getCompanyId());
		skillImpl.setGroupId(getGroupId());
		skillImpl.setCreateDate(getCreateDate());
		skillImpl.setModifiedDate(getModifiedDate());
		skillImpl.setUserId(getUserId());
		skillImpl.setSkillName(getSkillName());
		skillImpl.setDescription(getDescription());

		skillImpl.resetOriginalValues();

		return skillImpl;
	}

	@Override
	public int compareTo(Skill skill) {
		long primaryKey = skill.getPrimaryKey();

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

		if (!(obj instanceof Skill)) {
			return false;
		}

		Skill skill = (Skill)obj;

		long primaryKey = skill.getPrimaryKey();

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
		SkillModelImpl skillModelImpl = this;

		skillModelImpl._originalSkillId = skillModelImpl._skillId;

		skillModelImpl._setOriginalSkillId = false;

		skillModelImpl._originalEmployeeId = skillModelImpl._employeeId;

		skillModelImpl._setOriginalEmployeeId = false;

		skillModelImpl._originalGroupId = skillModelImpl._groupId;

		skillModelImpl._setOriginalGroupId = false;

		skillModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Skill> toCacheModel() {
		SkillCacheModel skillCacheModel = new SkillCacheModel();

		skillCacheModel.skillId = getSkillId();

		skillCacheModel.employeeId = getEmployeeId();

		skillCacheModel.companyId = getCompanyId();

		skillCacheModel.groupId = getGroupId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			skillCacheModel.createDate = createDate.getTime();
		}
		else {
			skillCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			skillCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			skillCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		skillCacheModel.userId = getUserId();

		skillCacheModel.skillName = getSkillName();

		String skillName = skillCacheModel.skillName;

		if ((skillName != null) && (skillName.length() == 0)) {
			skillCacheModel.skillName = null;
		}

		skillCacheModel.description = getDescription();

		String description = skillCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			skillCacheModel.description = null;
		}

		return skillCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{skillId=");
		sb.append(getSkillId());
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
		sb.append(", skillName=");
		sb.append(getSkillName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.Skill");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>skillId</column-name><column-value><![CDATA[");
		sb.append(getSkillId());
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
			"<column><column-name>skillName</column-name><column-value><![CDATA[");
		sb.append(getSkillName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Skill.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Skill.class };
	private long _skillId;
	private long _originalSkillId;
	private boolean _setOriginalSkillId;
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
	private String _skillName;
	private String _description;
	private long _columnBitmask;
	private Skill _escapedModel;
}