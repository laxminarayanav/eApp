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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Workshift service. Represents a row in the &quot;workshift&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rknowsys.eapp.hrm.model.impl.WorkshiftImpl}.
 * </p>
 *
 * @author rknowsys
 * @see Workshift
 * @see com.rknowsys.eapp.hrm.model.impl.WorkshiftImpl
 * @see com.rknowsys.eapp.hrm.model.impl.WorkshiftModelImpl
 * @generated
 */
public interface WorkshiftModel extends BaseModel<Workshift> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a workshift model instance should use the {@link Workshift} interface instead.
	 */

	/**
	 * Returns the primary key of this workshift.
	 *
	 * @return the primary key of this workshift
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this workshift.
	 *
	 * @param primaryKey the primary key of this workshift
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the shift ID of this workshift.
	 *
	 * @return the shift ID of this workshift
	 */
	public long getShiftId();

	/**
	 * Sets the shift ID of this workshift.
	 *
	 * @param shiftId the shift ID of this workshift
	 */
	public void setShiftId(long shiftId);

	/**
	 * Returns the company ID of this workshift.
	 *
	 * @return the company ID of this workshift
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this workshift.
	 *
	 * @param companyId the company ID of this workshift
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this workshift.
	 *
	 * @return the group ID of this workshift
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this workshift.
	 *
	 * @param groupId the group ID of this workshift
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create date of this workshift.
	 *
	 * @return the create date of this workshift
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this workshift.
	 *
	 * @param createDate the create date of this workshift
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this workshift.
	 *
	 * @return the modified date of this workshift
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this workshift.
	 *
	 * @param modifiedDate the modified date of this workshift
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user ID of this workshift.
	 *
	 * @return the user ID of this workshift
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this workshift.
	 *
	 * @param userId the user ID of this workshift
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this workshift.
	 *
	 * @return the user uuid of this workshift
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this workshift.
	 *
	 * @param userUuid the user uuid of this workshift
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the workshift name of this workshift.
	 *
	 * @return the workshift name of this workshift
	 */
	@AutoEscape
	public String getWorkshiftName();

	/**
	 * Sets the workshift name of this workshift.
	 *
	 * @param workshiftName the workshift name of this workshift
	 */
	public void setWorkshiftName(String workshiftName);

	/**
	 * Returns the from work hours of this workshift.
	 *
	 * @return the from work hours of this workshift
	 */
	public Date getFromWorkHours();

	/**
	 * Sets the from work hours of this workshift.
	 *
	 * @param fromWorkHours the from work hours of this workshift
	 */
	public void setFromWorkHours(Date fromWorkHours);

	/**
	 * Returns the to work hours of this workshift.
	 *
	 * @return the to work hours of this workshift
	 */
	public Date getToWorkHours();

	/**
	 * Sets the to work hours of this workshift.
	 *
	 * @param toWorkHours the to work hours of this workshift
	 */
	public void setToWorkHours(Date toWorkHours);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Workshift workshift);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Workshift> toCacheModel();

	@Override
	public Workshift toEscapedModel();

	@Override
	public Workshift toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}