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

import com.rknowsys.eapp.hrm.model.EmploymentStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmploymentStatus in entity cache.
 *
 * @author rknowsys
 * @see EmploymentStatus
 * @generated
 */
public class EmploymentStatusCacheModel implements CacheModel<EmploymentStatus>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{employmentStatusId=");
		sb.append(employmentStatusId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", employmentstatus=");
		sb.append(employmentstatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmploymentStatus toEntityModel() {
		EmploymentStatusImpl employmentStatusImpl = new EmploymentStatusImpl();

		employmentStatusImpl.setEmploymentStatusId(employmentStatusId);
		employmentStatusImpl.setGroupId(groupId);
		employmentStatusImpl.setCompanyId(companyId);
		employmentStatusImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			employmentStatusImpl.setCreateDate(null);
		}
		else {
			employmentStatusImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employmentStatusImpl.setModifiedDate(null);
		}
		else {
			employmentStatusImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (employmentstatus == null) {
			employmentStatusImpl.setEmploymentstatus(StringPool.BLANK);
		}
		else {
			employmentStatusImpl.setEmploymentstatus(employmentstatus);
		}

		employmentStatusImpl.resetOriginalValues();

		return employmentStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employmentStatusId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		employmentstatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(employmentStatusId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (employmentstatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employmentstatus);
		}
	}

	public long employmentStatusId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String employmentstatus;
}