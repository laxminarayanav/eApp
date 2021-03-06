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
 * The base model interface for the NewsAttachments service. Represents a row in the &quot;news_attachments&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rknowsys.eapp.hrm.model.impl.NewsAttachmentsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rknowsys.eapp.hrm.model.impl.NewsAttachmentsImpl}.
 * </p>
 *
 * @author rknowsys
 * @see NewsAttachments
 * @see com.rknowsys.eapp.hrm.model.impl.NewsAttachmentsImpl
 * @see com.rknowsys.eapp.hrm.model.impl.NewsAttachmentsModelImpl
 * @generated
 */
public interface NewsAttachmentsModel extends BaseModel<NewsAttachments> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a news attachments model instance should use the {@link NewsAttachments} interface instead.
	 */

	/**
	 * Returns the primary key of this news attachments.
	 *
	 * @return the primary key of this news attachments
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this news attachments.
	 *
	 * @param primaryKey the primary key of this news attachments
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the news attachment ID of this news attachments.
	 *
	 * @return the news attachment ID of this news attachments
	 */
	public long getNewsAttachmentId();

	/**
	 * Sets the news attachment ID of this news attachments.
	 *
	 * @param newsAttachmentId the news attachment ID of this news attachments
	 */
	public void setNewsAttachmentId(long newsAttachmentId);

	/**
	 * Returns the company ID of this news attachments.
	 *
	 * @return the company ID of this news attachments
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this news attachments.
	 *
	 * @param companyId the company ID of this news attachments
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this news attachments.
	 *
	 * @return the group ID of this news attachments
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this news attachments.
	 *
	 * @param groupId the group ID of this news attachments
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create date of this news attachments.
	 *
	 * @return the create date of this news attachments
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this news attachments.
	 *
	 * @param createDate the create date of this news attachments
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this news attachments.
	 *
	 * @return the modified date of this news attachments
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this news attachments.
	 *
	 * @param modifiedDate the modified date of this news attachments
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user ID of this news attachments.
	 *
	 * @return the user ID of this news attachments
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this news attachments.
	 *
	 * @param userId the user ID of this news attachments
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this news attachments.
	 *
	 * @return the user uuid of this news attachments
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this news attachments.
	 *
	 * @param userUuid the user uuid of this news attachments
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the attachment type ID of this news attachments.
	 *
	 * @return the attachment type ID of this news attachments
	 */
	public long getAttachmentTypeId();

	/**
	 * Sets the attachment type ID of this news attachments.
	 *
	 * @param attachmentTypeId the attachment type ID of this news attachments
	 */
	public void setAttachmentTypeId(long attachmentTypeId);

	/**
	 * Returns the news ID of this news attachments.
	 *
	 * @return the news ID of this news attachments
	 */
	public long getNewsId();

	/**
	 * Sets the news ID of this news attachments.
	 *
	 * @param newsId the news ID of this news attachments
	 */
	public void setNewsId(long newsId);

	/**
	 * Returns the description of this news attachments.
	 *
	 * @return the description of this news attachments
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this news attachments.
	 *
	 * @param description the description of this news attachments
	 */
	public void setDescription(String description);

	/**
	 * Returns the uuid of this news attachments.
	 *
	 * @return the uuid of this news attachments
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this news attachments.
	 *
	 * @param uuid the uuid of this news attachments
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the file name of this news attachments.
	 *
	 * @return the file name of this news attachments
	 */
	@AutoEscape
	public String getFileName();

	/**
	 * Sets the file name of this news attachments.
	 *
	 * @param fileName the file name of this news attachments
	 */
	public void setFileName(String fileName);

	/**
	 * Returns the file size of this news attachments.
	 *
	 * @return the file size of this news attachments
	 */
	public long getFileSize();

	/**
	 * Sets the file size of this news attachments.
	 *
	 * @param fileSize the file size of this news attachments
	 */
	public void setFileSize(long fileSize);

	/**
	 * Returns the file type of this news attachments.
	 *
	 * @return the file type of this news attachments
	 */
	@AutoEscape
	public String getFileType();

	/**
	 * Sets the file type of this news attachments.
	 *
	 * @param fileType the file type of this news attachments
	 */
	public void setFileType(String fileType);

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
	public int compareTo(NewsAttachments newsAttachments);

	@Override
	public int hashCode();

	@Override
	public CacheModel<NewsAttachments> toCacheModel();

	@Override
	public NewsAttachments toEscapedModel();

	@Override
	public NewsAttachments toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}