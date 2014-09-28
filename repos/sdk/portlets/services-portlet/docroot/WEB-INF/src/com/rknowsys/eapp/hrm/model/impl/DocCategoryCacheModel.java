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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rknowsys.eapp.hrm.model.DocCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DocCategory in entity cache.
 *
 * @author rknowsys
 * @see DocCategory
 * @generated
 */
public class DocCategoryCacheModel implements CacheModel<DocCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{docCategoryId=");
		sb.append(docCategoryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", docName=");
		sb.append(docName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DocCategory toEntityModel() {
		DocCategoryImpl docCategoryImpl = new DocCategoryImpl();

		docCategoryImpl.setDocCategoryId(docCategoryId);
		docCategoryImpl.setCompanyId(companyId);
		docCategoryImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			docCategoryImpl.setCreateDate(null);
		}
		else {
			docCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			docCategoryImpl.setModifiedDate(null);
		}
		else {
			docCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		docCategoryImpl.setUserId(userId);

		if (docName == null) {
			docCategoryImpl.setDocName(StringPool.BLANK);
		}
		else {
			docCategoryImpl.setDocName(docName);
		}

		docCategoryImpl.resetOriginalValues();

		return docCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		docCategoryId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		docName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(docCategoryId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (docName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(docName);
		}
	}

	public long docCategoryId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String docName;
}