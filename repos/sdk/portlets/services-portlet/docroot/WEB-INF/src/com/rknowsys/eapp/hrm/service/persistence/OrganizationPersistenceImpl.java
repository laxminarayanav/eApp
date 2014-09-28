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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.NoSuchOrganizationException;
import com.rknowsys.eapp.hrm.model.Organization;
import com.rknowsys.eapp.hrm.model.impl.OrganizationImpl;
import com.rknowsys.eapp.hrm.model.impl.OrganizationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the organization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see OrganizationPersistence
 * @see OrganizationUtil
 * @generated
 */
public class OrganizationPersistenceImpl extends BasePersistenceImpl<Organization>
	implements OrganizationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrganizationUtil} to access the organization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrganizationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OrganizationPersistenceImpl() {
		setModelClass(Organization.class);
	}

	/**
	 * Caches the organization in the entity cache if it is enabled.
	 *
	 * @param organization the organization
	 */
	@Override
	public void cacheResult(Organization organization) {
		EntityCacheUtil.putResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationImpl.class, organization.getPrimaryKey(), organization);

		organization.resetOriginalValues();
	}

	/**
	 * Caches the organizations in the entity cache if it is enabled.
	 *
	 * @param organizations the organizations
	 */
	@Override
	public void cacheResult(List<Organization> organizations) {
		for (Organization organization : organizations) {
			if (EntityCacheUtil.getResult(
						OrganizationModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationImpl.class, organization.getPrimaryKey()) == null) {
				cacheResult(organization);
			}
			else {
				organization.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all organizations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrganizationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrganizationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organization.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Organization organization) {
		EntityCacheUtil.removeResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationImpl.class, organization.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Organization> organizations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Organization organization : organizations) {
			EntityCacheUtil.removeResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationImpl.class, organization.getPrimaryKey());
		}
	}

	/**
	 * Creates a new organization with the primary key. Does not add the organization to the database.
	 *
	 * @param organizationId the primary key for the new organization
	 * @return the new organization
	 */
	@Override
	public Organization create(long organizationId) {
		Organization organization = new OrganizationImpl();

		organization.setNew(true);
		organization.setPrimaryKey(organizationId);

		return organization;
	}

	/**
	 * Removes the organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationId the primary key of the organization
	 * @return the organization that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization remove(long organizationId)
		throws NoSuchOrganizationException, SystemException {
		return remove((Serializable)organizationId);
	}

	/**
	 * Removes the organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organization
	 * @return the organization that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization remove(Serializable primaryKey)
		throws NoSuchOrganizationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Organization organization = (Organization)session.get(OrganizationImpl.class,
					primaryKey);

			if (organization == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(organization);
		}
		catch (NoSuchOrganizationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Organization removeImpl(Organization organization)
		throws SystemException {
		organization = toUnwrappedModel(organization);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organization)) {
				organization = (Organization)session.get(OrganizationImpl.class,
						organization.getPrimaryKeyObj());
			}

			if (organization != null) {
				session.delete(organization);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (organization != null) {
			clearCache(organization);
		}

		return organization;
	}

	@Override
	public Organization updateImpl(
		com.rknowsys.eapp.hrm.model.Organization organization)
		throws SystemException {
		organization = toUnwrappedModel(organization);

		boolean isNew = organization.isNew();

		Session session = null;

		try {
			session = openSession();

			if (organization.isNew()) {
				session.save(organization);

				organization.setNew(false);
			}
			else {
				session.merge(organization);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationImpl.class, organization.getPrimaryKey(), organization);

		return organization;
	}

	protected Organization toUnwrappedModel(Organization organization) {
		if (organization instanceof OrganizationImpl) {
			return organization;
		}

		OrganizationImpl organizationImpl = new OrganizationImpl();

		organizationImpl.setNew(organization.isNew());
		organizationImpl.setPrimaryKey(organization.getPrimaryKey());

		organizationImpl.setOrganizationId(organization.getOrganizationId());
		organizationImpl.setGroupId(organization.getGroupId());
		organizationImpl.setCompanyId(organization.getCompanyId());
		organizationImpl.setUserId(organization.getUserId());
		organizationImpl.setCreateDate(organization.getCreateDate());
		organizationImpl.setModifiedDate(organization.getModifiedDate());
		organizationImpl.setOrganizationName(organization.getOrganizationName());
		organizationImpl.setTaxId(organization.getTaxId());
		organizationImpl.setNumberOfEmployees(organization.getNumberOfEmployees());
		organizationImpl.setRegistrationNumber(organization.getRegistrationNumber());
		organizationImpl.setPhone(organization.getPhone());
		organizationImpl.setFax(organization.getFax());
		organizationImpl.setEmail(organization.getEmail());
		organizationImpl.setAddressStreet1(organization.getAddressStreet1());
		organizationImpl.setAddressStreet2(organization.getAddressStreet2());
		organizationImpl.setCity(organization.getCity());
		organizationImpl.setState(organization.getState());
		organizationImpl.setPostalCode(organization.getPostalCode());
		organizationImpl.setNationalityId(organization.getNationalityId());
		organizationImpl.setNote(organization.getNote());

		return organizationImpl;
	}

	/**
	 * Returns the organization with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization
	 * @return the organization
	 * @throws com.rknowsys.eapp.hrm.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByPrimaryKey(primaryKey);

		if (organization == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return organization;
	}

	/**
	 * Returns the organization with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchOrganizationException} if it could not be found.
	 *
	 * @param organizationId the primary key of the organization
	 * @return the organization
	 * @throws com.rknowsys.eapp.hrm.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByPrimaryKey(long organizationId)
		throws NoSuchOrganizationException, SystemException {
		return findByPrimaryKey((Serializable)organizationId);
	}

	/**
	 * Returns the organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization
	 * @return the organization, or <code>null</code> if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Organization organization = (Organization)EntityCacheUtil.getResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationImpl.class, primaryKey);

		if (organization == _nullOrganization) {
			return null;
		}

		if (organization == null) {
			Session session = null;

			try {
				session = openSession();

				organization = (Organization)session.get(OrganizationImpl.class,
						primaryKey);

				if (organization != null) {
					cacheResult(organization);
				}
				else {
					EntityCacheUtil.putResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationImpl.class, primaryKey, _nullOrganization);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
					OrganizationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return organization;
	}

	/**
	 * Returns the organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationId the primary key of the organization
	 * @return the organization, or <code>null</code> if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByPrimaryKey(long organizationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)organizationId);
	}

	/**
	 * Returns all the organizations.
	 *
	 * @return the organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @return the range of organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORGANIZATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATION;

				if (pagination) {
					sql = sql.concat(OrganizationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Organization>(list);
				}
				else {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the organizations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Organization organization : findAll()) {
			remove(organization);
		}
	}

	/**
	 * Returns the number of organizations.
	 *
	 * @return the number of organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ORGANIZATION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the organization persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Organization")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Organization>> listenersList = new ArrayList<ModelListener<Organization>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Organization>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(OrganizationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORGANIZATION = "SELECT organization FROM Organization organization";
	private static final String _SQL_COUNT_ORGANIZATION = "SELECT COUNT(organization) FROM Organization organization";
	private static final String _ORDER_BY_ENTITY_ALIAS = "organization.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Organization exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrganizationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
	private static Organization _nullOrganization = new OrganizationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Organization> toCacheModel() {
				return _nullOrganizationCacheModel;
			}
		};

	private static CacheModel<Organization> _nullOrganizationCacheModel = new CacheModel<Organization>() {
			@Override
			public Organization toEntityModel() {
				return _nullOrganization;
			}
		};
}