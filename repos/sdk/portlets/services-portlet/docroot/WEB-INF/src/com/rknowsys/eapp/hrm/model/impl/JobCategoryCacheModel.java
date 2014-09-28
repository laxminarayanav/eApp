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

import com.rknowsys.eapp.hrm.model.JobCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JobCategory in entity cache.
 *
 * @author rknowsys
 * @see JobCategory
 * @generated
 */
public class JobCategoryCacheModel implements CacheModel<JobCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{jobCategoryId=");
		sb.append(jobCategoryId);
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
		sb.append(", jobcategory=");
		sb.append(jobcategory);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JobCategory toEntityModel() {
		JobCategoryImpl jobCategoryImpl = new JobCategoryImpl();

		jobCategoryImpl.setJobCategoryId(jobCategoryId);
		jobCategoryImpl.setCompanyId(companyId);
		jobCategoryImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			jobCategoryImpl.setCreateDate(null);
		}
		else {
			jobCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobCategoryImpl.setModifiedDate(null);
		}
		else {
			jobCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		jobCategoryImpl.setUserId(userId);

		if (jobcategory == null) {
			jobCategoryImpl.setJobcategory(StringPool.BLANK);
		}
		else {
			jobCategoryImpl.setJobcategory(jobcategory);
		}

		jobCategoryImpl.resetOriginalValues();

		return jobCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobCategoryId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		jobcategory = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jobCategoryId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (jobcategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobcategory);
		}
	}

	public long jobCategoryId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String jobcategory;
}