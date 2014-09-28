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

import com.rknowsys.eapp.hrm.model.Organization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Organization in entity cache.
 *
 * @author rknowsys
 * @see Organization
 * @generated
 */
public class OrganizationCacheModel implements CacheModel<Organization>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{organizationId=");
		sb.append(organizationId);
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
		sb.append(", organizationName=");
		sb.append(organizationName);
		sb.append(", taxId=");
		sb.append(taxId);
		sb.append(", numberOfEmployees=");
		sb.append(numberOfEmployees);
		sb.append(", registrationNumber=");
		sb.append(registrationNumber);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", email=");
		sb.append(email);
		sb.append(", addressStreet1=");
		sb.append(addressStreet1);
		sb.append(", addressStreet2=");
		sb.append(addressStreet2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append(", nationalityId=");
		sb.append(nationalityId);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Organization toEntityModel() {
		OrganizationImpl organizationImpl = new OrganizationImpl();

		organizationImpl.setOrganizationId(organizationId);
		organizationImpl.setGroupId(groupId);
		organizationImpl.setCompanyId(companyId);
		organizationImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			organizationImpl.setCreateDate(null);
		}
		else {
			organizationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			organizationImpl.setModifiedDate(null);
		}
		else {
			organizationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (organizationName == null) {
			organizationImpl.setOrganizationName(StringPool.BLANK);
		}
		else {
			organizationImpl.setOrganizationName(organizationName);
		}

		if (taxId == null) {
			organizationImpl.setTaxId(StringPool.BLANK);
		}
		else {
			organizationImpl.setTaxId(taxId);
		}

		organizationImpl.setNumberOfEmployees(numberOfEmployees);

		if (registrationNumber == null) {
			organizationImpl.setRegistrationNumber(StringPool.BLANK);
		}
		else {
			organizationImpl.setRegistrationNumber(registrationNumber);
		}

		if (phone == null) {
			organizationImpl.setPhone(StringPool.BLANK);
		}
		else {
			organizationImpl.setPhone(phone);
		}

		if (fax == null) {
			organizationImpl.setFax(StringPool.BLANK);
		}
		else {
			organizationImpl.setFax(fax);
		}

		if (email == null) {
			organizationImpl.setEmail(StringPool.BLANK);
		}
		else {
			organizationImpl.setEmail(email);
		}

		if (addressStreet1 == null) {
			organizationImpl.setAddressStreet1(StringPool.BLANK);
		}
		else {
			organizationImpl.setAddressStreet1(addressStreet1);
		}

		if (addressStreet2 == null) {
			organizationImpl.setAddressStreet2(StringPool.BLANK);
		}
		else {
			organizationImpl.setAddressStreet2(addressStreet2);
		}

		if (city == null) {
			organizationImpl.setCity(StringPool.BLANK);
		}
		else {
			organizationImpl.setCity(city);
		}

		if (state == null) {
			organizationImpl.setState(StringPool.BLANK);
		}
		else {
			organizationImpl.setState(state);
		}

		if (postalCode == null) {
			organizationImpl.setPostalCode(StringPool.BLANK);
		}
		else {
			organizationImpl.setPostalCode(postalCode);
		}

		organizationImpl.setNationalityId(nationalityId);

		if (note == null) {
			organizationImpl.setNote(StringPool.BLANK);
		}
		else {
			organizationImpl.setNote(note);
		}

		organizationImpl.resetOriginalValues();

		return organizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		organizationId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		organizationName = objectInput.readUTF();
		taxId = objectInput.readUTF();
		numberOfEmployees = objectInput.readInt();
		registrationNumber = objectInput.readUTF();
		phone = objectInput.readUTF();
		fax = objectInput.readUTF();
		email = objectInput.readUTF();
		addressStreet1 = objectInput.readUTF();
		addressStreet2 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		postalCode = objectInput.readUTF();
		nationalityId = objectInput.readLong();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(organizationId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (organizationName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(organizationName);
		}

		if (taxId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taxId);
		}

		objectOutput.writeInt(numberOfEmployees);

		if (registrationNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(registrationNumber);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (fax == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fax);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (addressStreet1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(addressStreet1);
		}

		if (addressStreet2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(addressStreet2);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (postalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postalCode);
		}

		objectOutput.writeLong(nationalityId);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public long organizationId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String organizationName;
	public String taxId;
	public int numberOfEmployees;
	public String registrationNumber;
	public String phone;
	public String fax;
	public String email;
	public String addressStreet1;
	public String addressStreet2;
	public String city;
	public String state;
	public String postalCode;
	public long nationalityId;
	public String note;
}