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

import com.rknowsys.eapp.hrm.model.Nationality;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Nationality in entity cache.
 *
 * @author rknowsys
 * @see Nationality
 * @generated
 */
public class NationalityCacheModel implements CacheModel<Nationality>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{nationalityId=");
		sb.append(nationalityId);
		sb.append(", employeeId=");
		sb.append(employeeId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Nationality toEntityModel() {
		NationalityImpl nationalityImpl = new NationalityImpl();

		nationalityImpl.setNationalityId(nationalityId);
		nationalityImpl.setEmployeeId(employeeId);
		nationalityImpl.setGroupId(groupId);
		nationalityImpl.setCompanyId(companyId);
		nationalityImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			nationalityImpl.setCreateDate(null);
		}
		else {
			nationalityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			nationalityImpl.setModifiedDate(null);
		}
		else {
			nationalityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			nationalityImpl.setName(StringPool.BLANK);
		}
		else {
			nationalityImpl.setName(name);
		}

		nationalityImpl.resetOriginalValues();

		return nationalityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		nationalityId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(nationalityId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long nationalityId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
}