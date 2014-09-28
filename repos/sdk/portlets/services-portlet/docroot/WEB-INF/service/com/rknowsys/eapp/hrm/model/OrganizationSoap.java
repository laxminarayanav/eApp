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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rknowsys
 * @generated
 */
public class OrganizationSoap implements Serializable {
	public static OrganizationSoap toSoapModel(Organization model) {
		OrganizationSoap soapModel = new OrganizationSoap();

		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOrganizationName(model.getOrganizationName());
		soapModel.setTaxId(model.getTaxId());
		soapModel.setNumberOfEmployees(model.getNumberOfEmployees());
		soapModel.setRegistrationNumber(model.getRegistrationNumber());
		soapModel.setPhone(model.getPhone());
		soapModel.setFax(model.getFax());
		soapModel.setEmail(model.getEmail());
		soapModel.setAddressStreet1(model.getAddressStreet1());
		soapModel.setAddressStreet2(model.getAddressStreet2());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setPostalCode(model.getPostalCode());
		soapModel.setNationalityId(model.getNationalityId());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static OrganizationSoap[] toSoapModels(Organization[] models) {
		OrganizationSoap[] soapModels = new OrganizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationSoap[][] toSoapModels(Organization[][] models) {
		OrganizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrganizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationSoap[] toSoapModels(List<Organization> models) {
		List<OrganizationSoap> soapModels = new ArrayList<OrganizationSoap>(models.size());

		for (Organization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrganizationSoap[soapModels.size()]);
	}

	public OrganizationSoap() {
	}

	public long getPrimaryKey() {
		return _organizationId;
	}

	public void setPrimaryKey(long pk) {
		setOrganizationId(pk);
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getOrganizationName() {
		return _organizationName;
	}

	public void setOrganizationName(String organizationName) {
		_organizationName = organizationName;
	}

	public String getTaxId() {
		return _taxId;
	}

	public void setTaxId(String taxId) {
		_taxId = taxId;
	}

	public int getNumberOfEmployees() {
		return _numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		_numberOfEmployees = numberOfEmployees;
	}

	public String getRegistrationNumber() {
		return _registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		_registrationNumber = registrationNumber;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getAddressStreet1() {
		return _addressStreet1;
	}

	public void setAddressStreet1(String addressStreet1) {
		_addressStreet1 = addressStreet1;
	}

	public String getAddressStreet2() {
		return _addressStreet2;
	}

	public void setAddressStreet2(String addressStreet2) {
		_addressStreet2 = addressStreet2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public long getNationalityId() {
		return _nationalityId;
	}

	public void setNationalityId(long nationalityId) {
		_nationalityId = nationalityId;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private long _organizationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _organizationName;
	private String _taxId;
	private int _numberOfEmployees;
	private String _registrationNumber;
	private String _phone;
	private String _fax;
	private String _email;
	private String _addressStreet1;
	private String _addressStreet2;
	private String _city;
	private String _state;
	private String _postalCode;
	private long _nationalityId;
	private String _note;
}