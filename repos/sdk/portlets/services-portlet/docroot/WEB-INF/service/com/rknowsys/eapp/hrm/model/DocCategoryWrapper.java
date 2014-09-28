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
 * This class is a wrapper for {@link DocCategory}.
 * </p>
 *
 * @author rknowsys
 * @see DocCategory
 * @generated
 */
public class DocCategoryWrapper implements DocCategory,
	ModelWrapper<DocCategory> {
	public DocCategoryWrapper(DocCategory docCategory) {
		_docCategory = docCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return DocCategory.class;
	}

	@Override
	public String getModelClassName() {
		return DocCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("docCategoryId", getDocCategoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("docName", getDocName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long docCategoryId = (Long)attributes.get("docCategoryId");

		if (docCategoryId != null) {
			setDocCategoryId(docCategoryId);
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

		String docName = (String)attributes.get("docName");

		if (docName != null) {
			setDocName(docName);
		}
	}

	/**
	* Returns the primary key of this doc category.
	*
	* @return the primary key of this doc category
	*/
	@Override
	public long getPrimaryKey() {
		return _docCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this doc category.
	*
	* @param primaryKey the primary key of this doc category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_docCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the doc category ID of this doc category.
	*
	* @return the doc category ID of this doc category
	*/
	@Override
	public long getDocCategoryId() {
		return _docCategory.getDocCategoryId();
	}

	/**
	* Sets the doc category ID of this doc category.
	*
	* @param docCategoryId the doc category ID of this doc category
	*/
	@Override
	public void setDocCategoryId(long docCategoryId) {
		_docCategory.setDocCategoryId(docCategoryId);
	}

	/**
	* Returns the company ID of this doc category.
	*
	* @return the company ID of this doc category
	*/
	@Override
	public long getCompanyId() {
		return _docCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this doc category.
	*
	* @param companyId the company ID of this doc category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_docCategory.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this doc category.
	*
	* @return the group ID of this doc category
	*/
	@Override
	public long getGroupId() {
		return _docCategory.getGroupId();
	}

	/**
	* Sets the group ID of this doc category.
	*
	* @param groupId the group ID of this doc category
	*/
	@Override
	public void setGroupId(long groupId) {
		_docCategory.setGroupId(groupId);
	}

	/**
	* Returns the create date of this doc category.
	*
	* @return the create date of this doc category
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _docCategory.getCreateDate();
	}

	/**
	* Sets the create date of this doc category.
	*
	* @param createDate the create date of this doc category
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_docCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this doc category.
	*
	* @return the modified date of this doc category
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _docCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this doc category.
	*
	* @param modifiedDate the modified date of this doc category
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_docCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this doc category.
	*
	* @return the user ID of this doc category
	*/
	@Override
	public long getUserId() {
		return _docCategory.getUserId();
	}

	/**
	* Sets the user ID of this doc category.
	*
	* @param userId the user ID of this doc category
	*/
	@Override
	public void setUserId(long userId) {
		_docCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this doc category.
	*
	* @return the user uuid of this doc category
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _docCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this doc category.
	*
	* @param userUuid the user uuid of this doc category
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_docCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the doc name of this doc category.
	*
	* @return the doc name of this doc category
	*/
	@Override
	public java.lang.String getDocName() {
		return _docCategory.getDocName();
	}

	/**
	* Sets the doc name of this doc category.
	*
	* @param docName the doc name of this doc category
	*/
	@Override
	public void setDocName(java.lang.String docName) {
		_docCategory.setDocName(docName);
	}

	@Override
	public boolean isNew() {
		return _docCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_docCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _docCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_docCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _docCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _docCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_docCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _docCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_docCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_docCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_docCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DocCategoryWrapper((DocCategory)_docCategory.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.DocCategory docCategory) {
		return _docCategory.compareTo(docCategory);
	}

	@Override
	public int hashCode() {
		return _docCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.DocCategory> toCacheModel() {
		return _docCategory.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.DocCategory toEscapedModel() {
		return new DocCategoryWrapper(_docCategory.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.DocCategory toUnescapedModel() {
		return new DocCategoryWrapper(_docCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _docCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _docCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_docCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocCategoryWrapper)) {
			return false;
		}

		DocCategoryWrapper docCategoryWrapper = (DocCategoryWrapper)obj;

		if (Validator.equals(_docCategory, docCategoryWrapper._docCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DocCategory getWrappedDocCategory() {
		return _docCategory;
	}

	@Override
	public DocCategory getWrappedModel() {
		return _docCategory;
	}

	@Override
	public void resetOriginalValues() {
		_docCategory.resetOriginalValues();
	}

	private DocCategory _docCategory;
}