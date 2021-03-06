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
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EmpAttachment service. Represents a row in the &quot;emp_attachment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rknowsys.eapp.hrm.model.impl.EmpAttachmentImpl}.
 * </p>
 *
 * @author rknowsys
 * @see EmpAttachment
 * @see com.rknowsys.eapp.hrm.model.impl.EmpAttachmentImpl
 * @see com.rknowsys.eapp.hrm.model.impl.EmpAttachmentModelImpl
 * @generated
 */
public interface EmpAttachmentModel extends BaseModel<EmpAttachment>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a EmpAttachment model instance should use the {@link EmpAttachment} interface instead.
	 */

	/**
	 * Returns the primary key of this EmpAttachment.
	 *
	 * @return the primary key of this EmpAttachment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this EmpAttachment.
	 *
	 * @param primaryKey the primary key of this EmpAttachment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the emp attachment ID of this EmpAttachment.
	 *
	 * @return the emp attachment ID of this EmpAttachment
	 */
	public long getEmpAttachmentId();

	/**
	 * Sets the emp attachment ID of this EmpAttachment.
	 *
	 * @param empAttachmentId the emp attachment ID of this EmpAttachment
	 */
	public void setEmpAttachmentId(long empAttachmentId);

	/**
	 * Returns the employee ID of this EmpAttachment.
	 *
	 * @return the employee ID of this EmpAttachment
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this EmpAttachment.
	 *
	 * @param employeeId the employee ID of this EmpAttachment
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the group ID of this EmpAttachment.
	 *
	 * @return the group ID of this EmpAttachment
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this EmpAttachment.
	 *
	 * @param groupId the group ID of this EmpAttachment
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this EmpAttachment.
	 *
	 * @return the company ID of this EmpAttachment
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this EmpAttachment.
	 *
	 * @param companyId the company ID of this EmpAttachment
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this EmpAttachment.
	 *
	 * @return the user ID of this EmpAttachment
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this EmpAttachment.
	 *
	 * @param userId the user ID of this EmpAttachment
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this EmpAttachment.
	 *
	 * @return the user uuid of this EmpAttachment
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this EmpAttachment.
	 *
	 * @param userUuid the user uuid of this EmpAttachment
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this EmpAttachment.
	 *
	 * @return the create date of this EmpAttachment
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this EmpAttachment.
	 *
	 * @param createDate the create date of this EmpAttachment
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this EmpAttachment.
	 *
	 * @return the modified date of this EmpAttachment
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this EmpAttachment.
	 *
	 * @param modifiedDate the modified date of this EmpAttachment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the attachment type ID of this EmpAttachment.
	 *
	 * @return the attachment type ID of this EmpAttachment
	 */
	public long getAttachmentTypeId();

	/**
	 * Sets the attachment type ID of this EmpAttachment.
	 *
	 * @param attachmentTypeId the attachment type ID of this EmpAttachment
	 */
	public void setAttachmentTypeId(long attachmentTypeId);

	/**
	 * Returns the uuid of this EmpAttachment.
	 *
	 * @return the uuid of this EmpAttachment
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this EmpAttachment.
	 *
	 * @param uuid the uuid of this EmpAttachment
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the related to of this EmpAttachment.
	 *
	 * @return the related to of this EmpAttachment
	 */
	@AutoEscape
	public String getRelatedTo();

	/**
	 * Sets the related to of this EmpAttachment.
	 *
	 * @param relatedTo the related to of this EmpAttachment
	 */
	public void setRelatedTo(String relatedTo);

	/**
	 * Returns the user name of this EmpAttachment.
	 *
	 * @return the user name of this EmpAttachment
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this EmpAttachment.
	 *
	 * @param userName the user name of this EmpAttachment
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the file name of this EmpAttachment.
	 *
	 * @return the file name of this EmpAttachment
	 */
	@AutoEscape
	public String getFileName();

	/**
	 * Sets the file name of this EmpAttachment.
	 *
	 * @param fileName the file name of this EmpAttachment
	 */
	public void setFileName(String fileName);

	/**
	 * Returns the file size of this EmpAttachment.
	 *
	 * @return the file size of this EmpAttachment
	 */
	public long getFileSize();

	/**
	 * Sets the file size of this EmpAttachment.
	 *
	 * @param fileSize the file size of this EmpAttachment
	 */
	public void setFileSize(long fileSize);

	/**
	 * Returns the file type of this EmpAttachment.
	 *
	 * @return the file type of this EmpAttachment
	 */
	@AutoEscape
	public String getFileType();

	/**
	 * Sets the file type of this EmpAttachment.
	 *
	 * @param fileType the file type of this EmpAttachment
	 */
	public void setFileType(String fileType);

	/**
	 * Returns the comment of this EmpAttachment.
	 *
	 * @return the comment of this EmpAttachment
	 */
	@AutoEscape
	public String getComment();

	/**
	 * Sets the comment of this EmpAttachment.
	 *
	 * @param comment the comment of this EmpAttachment
	 */
	public void setComment(String comment);

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
	public int compareTo(EmpAttachment empAttachment);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EmpAttachment> toCacheModel();

	@Override
	public EmpAttachment toEscapedModel();

	@Override
	public EmpAttachment toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}