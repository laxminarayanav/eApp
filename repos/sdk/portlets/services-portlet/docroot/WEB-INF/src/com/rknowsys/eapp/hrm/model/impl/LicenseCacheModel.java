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

import com.rknowsys.eapp.hrm.model.License;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing License in entity cache.
 *
 * @author rknowsys
 * @see License
 * @generated
 */
public class LicenseCacheModel implements CacheModel<License>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{licenseId=");
		sb.append(licenseId);
		sb.append(", employeeId=");
		sb.append(employeeId);
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
		sb.append(", licenseName=");
		sb.append(licenseName);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append(", licenseNumber=");
		sb.append(licenseNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public License toEntityModel() {
		LicenseImpl licenseImpl = new LicenseImpl();

		licenseImpl.setLicenseId(licenseId);
		licenseImpl.setEmployeeId(employeeId);
		licenseImpl.setCompanyId(companyId);
		licenseImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			licenseImpl.setCreateDate(null);
		}
		else {
			licenseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			licenseImpl.setModifiedDate(null);
		}
		else {
			licenseImpl.setModifiedDate(new Date(modifiedDate));
		}

		licenseImpl.setUserId(userId);

		if (licenseName == null) {
			licenseImpl.setLicenseName(StringPool.BLANK);
		}
		else {
			licenseImpl.setLicenseName(licenseName);
		}

		if (expiryDate == Long.MIN_VALUE) {
			licenseImpl.setExpiryDate(null);
		}
		else {
			licenseImpl.setExpiryDate(new Date(expiryDate));
		}

		if (licenseNumber == null) {
			licenseImpl.setLicenseNumber(StringPool.BLANK);
		}
		else {
			licenseImpl.setLicenseNumber(licenseNumber);
		}

		licenseImpl.resetOriginalValues();

		return licenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		licenseId = objectInput.readLong();
		employeeId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		licenseName = objectInput.readUTF();
		expiryDate = objectInput.readLong();
		licenseNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(licenseId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (licenseName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(licenseName);
		}

		objectOutput.writeLong(expiryDate);

		if (licenseNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(licenseNumber);
		}
	}

	public long licenseId;
	public long employeeId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String licenseName;
	public long expiryDate;
	public String licenseNumber;
}