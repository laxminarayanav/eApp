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

import com.rknowsys.eapp.hrm.model.Employee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author rknowsys
 * @see Employee
 * @generated
 */
public class EmployeeCacheModel implements CacheModel<Employee>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{employeeId=");
		sb.append(employeeId);
		sb.append(", contactDetailsId=");
		sb.append(contactDetailsId);
		sb.append(", jobId=");
		sb.append(jobId);
		sb.append(", shiftId=");
		sb.append(shiftId);
		sb.append(", licenseId=");
		sb.append(licenseId);
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
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", nationalityId=");
		sb.append(nationalityId);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", otherId=");
		sb.append(otherId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEmployeeId(employeeId);
		employeeImpl.setContactDetailsId(contactDetailsId);
		employeeImpl.setJobId(jobId);
		employeeImpl.setShiftId(shiftId);
		employeeImpl.setLicenseId(licenseId);
		employeeImpl.setGroupId(groupId);
		employeeImpl.setCompanyId(companyId);
		employeeImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			employeeImpl.setCreateDate(null);
		}
		else {
			employeeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeImpl.setModifiedDate(null);
		}
		else {
			employeeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			employeeImpl.setFirstName(StringPool.BLANK);
		}
		else {
			employeeImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			employeeImpl.setLastName(StringPool.BLANK);
		}
		else {
			employeeImpl.setLastName(lastName);
		}

		if (middleName == null) {
			employeeImpl.setMiddleName(StringPool.BLANK);
		}
		else {
			employeeImpl.setMiddleName(middleName);
		}

		employeeImpl.setGender(gender);
		employeeImpl.setMaritalStatus(maritalStatus);
		employeeImpl.setNationalityId(nationalityId);

		if (dateOfBirth == Long.MIN_VALUE) {
			employeeImpl.setDateOfBirth(null);
		}
		else {
			employeeImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (otherId == null) {
			employeeImpl.setOtherId(StringPool.BLANK);
		}
		else {
			employeeImpl.setOtherId(otherId);
		}

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeId = objectInput.readLong();
		contactDetailsId = objectInput.readLong();
		jobId = objectInput.readLong();
		shiftId = objectInput.readLong();
		licenseId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		middleName = objectInput.readUTF();
		gender = objectInput.readInt();
		maritalStatus = objectInput.readInt();
		nationalityId = objectInput.readLong();
		dateOfBirth = objectInput.readLong();
		otherId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(contactDetailsId);
		objectOutput.writeLong(jobId);
		objectOutput.writeLong(shiftId);
		objectOutput.writeLong(licenseId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (middleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(middleName);
		}

		objectOutput.writeInt(gender);
		objectOutput.writeInt(maritalStatus);
		objectOutput.writeLong(nationalityId);
		objectOutput.writeLong(dateOfBirth);

		if (otherId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(otherId);
		}
	}

	public long employeeId;
	public long contactDetailsId;
	public long jobId;
	public long shiftId;
	public long licenseId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String middleName;
	public int gender;
	public int maritalStatus;
	public long nationalityId;
	public long dateOfBirth;
	public String otherId;
}