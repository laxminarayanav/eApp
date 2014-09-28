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

import com.rknowsys.eapp.hrm.model.SubUnit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SubUnit in entity cache.
 *
 * @author rknowsys
 * @see SubUnit
 * @generated
 */
public class SubUnitCacheModel implements CacheModel<SubUnit>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{subUnitId=");
		sb.append(subUnitId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SubUnit toEntityModel() {
		SubUnitImpl subUnitImpl = new SubUnitImpl();

		subUnitImpl.setSubUnitId(subUnitId);

		if (name == null) {
			subUnitImpl.setName(StringPool.BLANK);
		}
		else {
			subUnitImpl.setName(name);
		}

		if (description == null) {
			subUnitImpl.setDescription(StringPool.BLANK);
		}
		else {
			subUnitImpl.setDescription(description);
		}

		subUnitImpl.setGroupId(groupId);
		subUnitImpl.setCompanyId(companyId);
		subUnitImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			subUnitImpl.setCreateDate(null);
		}
		else {
			subUnitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subUnitImpl.setModifiedDate(null);
		}
		else {
			subUnitImpl.setModifiedDate(new Date(modifiedDate));
		}

		subUnitImpl.resetOriginalValues();

		return subUnitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		subUnitId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(subUnitId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long subUnitId;
	public String name;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
}