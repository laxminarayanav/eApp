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

import com.rknowsys.eapp.hrm.model.Nationality;

/**
 * The persistence interface for the Nationality service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see NationalityPersistenceImpl
 * @see NationalityUtil
 * @generated
 */
public interface NationalityPersistence extends BasePersistence<Nationality> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NationalityUtil} to access the Nationality persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the Nationality in the entity cache if it is enabled.
	*
	* @param nationality the Nationality
	*/
	public void cacheResult(com.rknowsys.eapp.hrm.model.Nationality nationality);

	/**
	* Caches the Nationalities in the entity cache if it is enabled.
	*
	* @param nationalities the Nationalities
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.Nationality> nationalities);

	/**
	* Creates a new Nationality with the primary key. Does not add the Nationality to the database.
	*
	* @param nationalityId the primary key for the new Nationality
	* @return the new Nationality
	*/
	public com.rknowsys.eapp.hrm.model.Nationality create(long nationalityId);

	/**
	* Removes the Nationality with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param nationalityId the primary key of the Nationality
	* @return the Nationality that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchNationalityException if a Nationality with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Nationality remove(long nationalityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchNationalityException;

	public com.rknowsys.eapp.hrm.model.Nationality updateImpl(
		com.rknowsys.eapp.hrm.model.Nationality nationality)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Nationality with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchNationalityException} if it could not be found.
	*
	* @param nationalityId the primary key of the Nationality
	* @return the Nationality
	* @throws com.rknowsys.eapp.hrm.NoSuchNationalityException if a Nationality with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Nationality findByPrimaryKey(
		long nationalityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchNationalityException;

	/**
	* Returns the Nationality with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param nationalityId the primary key of the Nationality
	* @return the Nationality, or <code>null</code> if a Nationality with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Nationality fetchByPrimaryKey(
		long nationalityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Nationalities.
	*
	* @return the Nationalities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Nationality> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Nationalities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.NationalityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Nationalities
	* @param end the upper bound of the range of Nationalities (not inclusive)
	* @return the range of Nationalities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Nationality> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Nationalities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.NationalityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Nationalities
	* @param end the upper bound of the range of Nationalities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Nationalities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Nationality> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Nationalities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Nationalities.
	*
	* @return the number of Nationalities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}