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

package com.rknowsys.eapp.hrm.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rknowsys.eapp.hrm.model.ContactDetails;

/**
 * The persistence interface for the contact details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see ContactDetailsPersistenceImpl
 * @see ContactDetailsUtil
 * @generated
 */
public interface ContactDetailsPersistence extends BasePersistence<ContactDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactDetailsUtil} to access the contact details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the contact details in the entity cache if it is enabled.
	*
	* @param contactDetails the contact details
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.ContactDetails contactDetails);

	/**
	* Caches the contact detailses in the entity cache if it is enabled.
	*
	* @param contactDetailses the contact detailses
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.ContactDetails> contactDetailses);

	/**
	* Creates a new contact details with the primary key. Does not add the contact details to the database.
	*
	* @param id the primary key for the new contact details
	* @return the new contact details
	*/
	public com.rknowsys.eapp.hrm.model.ContactDetails create(long id);

	/**
	* Removes the contact details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the contact details
	* @return the contact details that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchContactDetailsException if a contact details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ContactDetails remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchContactDetailsException;

	public com.rknowsys.eapp.hrm.model.ContactDetails updateImpl(
		com.rknowsys.eapp.hrm.model.ContactDetails contactDetails)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact details with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchContactDetailsException} if it could not be found.
	*
	* @param id the primary key of the contact details
	* @return the contact details
	* @throws com.rknowsys.eapp.hrm.NoSuchContactDetailsException if a contact details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ContactDetails findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchContactDetailsException;

	/**
	* Returns the contact details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the contact details
	* @return the contact details, or <code>null</code> if a contact details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.ContactDetails fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact detailses.
	*
	* @return the contact detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.ContactDetails> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact detailses
	* @param end the upper bound of the range of contact detailses (not inclusive)
	* @return the range of contact detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.ContactDetails> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contact detailses
	* @param end the upper bound of the range of contact detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contact detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.ContactDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact detailses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact detailses.
	*
	* @return the number of contact detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}