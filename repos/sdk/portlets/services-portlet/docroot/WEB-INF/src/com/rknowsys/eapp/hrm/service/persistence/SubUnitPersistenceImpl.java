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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.NoSuchSubUnitException;
import com.rknowsys.eapp.hrm.model.SubUnit;
import com.rknowsys.eapp.hrm.model.impl.SubUnitImpl;
import com.rknowsys.eapp.hrm.model.impl.SubUnitModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the SubUnit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see SubUnitPersistence
 * @see SubUnitUtil
 * @generated
 */
public class SubUnitPersistenceImpl extends BasePersistenceImpl<SubUnit>
	implements SubUnitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubUnitUtil} to access the SubUnit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubUnitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubUnitModelImpl.ENTITY_CACHE_ENABLED,
			SubUnitModelImpl.FINDER_CACHE_ENABLED, SubUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubUnitModelImpl.ENTITY_CACHE_ENABLED,
			SubUnitModelImpl.FINDER_CACHE_ENABLED, SubUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubUnitModelImpl.ENTITY_CACHE_ENABLED,
			SubUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SubUnitPersistenceImpl() {
		setModelClass(SubUnit.class);
	}

	/**
	 * Caches the SubUnit in the entity cache if it is enabled.
	 *
	 * @param subUnit the SubUnit
	 */
	@Override
	public void cacheResult(SubUnit subUnit) {
		EntityCacheUtil.putResult(SubUnitModelImpl.ENTITY_CACHE_ENABLED,
			SubUnitImpl.class, subUnit.getPrimaryKey(), subUnit);

		subUnit.resetOriginalValues();
	}

	/**
	 * Caches the SubUnits in the entity cache if it is enabled.
	 *
	 * @param subUnits the SubUnits
	 */
	@Override
	public void cacheResult(List<SubUnit> subUnits) {
		for (SubUnit subUnit : subUnits) {
			if (EntityCacheUtil.getResult(
						SubUnitModelImpl.ENTITY_CACHE_ENABLED,
						SubUnitImpl.class, subUnit.getPrimaryKey()) == null) {
				cacheResult(subUnit);
			}
			else {
				subUnit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all SubUnits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubUnitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubUnitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the SubUnit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubUnit subUnit) {
		EntityCacheUtil.removeResult(SubUnitModelImpl.ENTITY_CACHE_ENABLED,
			SubUnitImpl.class, subUnit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SubUnit> subUnits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SubUnit subUnit : subUnits) {
			EntityCacheUtil.removeResult(SubUnitModelImpl.ENTITY_CACHE_ENABLED,
				SubUnitImpl.class, subUnit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new SubUnit with the primary key. Does not add the SubUnit to the database.
	 *
	 * @param subUnitId the primary key for the new SubUnit
	 * @return the new SubUnit
	 */
	@Override
	public SubUnit create(long subUnitId) {
		SubUnit subUnit = new SubUnitImpl();

		subUnit.setNew(true);
		subUnit.setPrimaryKey(subUnitId);

		return subUnit;
	}

	/**
	 * Removes the SubUnit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subUnitId the primary key of the SubUnit
	 * @return the SubUnit that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchSubUnitException if a SubUnit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubUnit remove(long subUnitId)
		throws NoSuchSubUnitException, SystemException {
		return remove((Serializable)subUnitId);
	}

	/**
	 * Removes the SubUnit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the SubUnit
	 * @return the SubUnit that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchSubUnitException if a SubUnit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubUnit remove(Serializable primaryKey)
		throws NoSuchSubUnitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SubUnit subUnit = (SubUnit)session.get(SubUnitImpl.class, primaryKey);

			if (subUnit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubUnitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(subUnit);
		}
		catch (NoSuchSubUnitException nsee) {
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
	protected SubUnit removeImpl(SubUnit subUnit) throws SystemException {
		subUnit = toUnwrappedModel(subUnit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subUnit)) {
				subUnit = (SubUnit)session.get(SubUnitImpl.class,
						subUnit.getPrimaryKeyObj());
			}

			if (subUnit != null) {
				session.delete(subUnit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (subUnit != null) {
			clearCache(subUnit);
		}

		return subUnit;
	}

	@Override
	public SubUnit updateImpl(com.rknowsys.eapp.hrm.model.SubUnit subUnit)
		throws SystemException {
		subUnit = toUnwrappedModel(subUnit);

		boolean isNew = subUnit.isNew();

		Session session = null;

		try {
			session = openSession();

			if (subUnit.isNew()) {
				session.save(subUnit);

				subUnit.setNew(false);
			}
			else {
				session.merge(subUnit);
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

		EntityCacheUtil.putResult(SubUnitModelImpl.ENTITY_CACHE_ENABLED,
			SubUnitImpl.class, subUnit.getPrimaryKey(), subUnit);

		return subUnit;
	}

	protected SubUnit toUnwrappedModel(SubUnit subUnit) {
		if (subUnit instanceof SubUnitImpl) {
			return subUnit;
		}

		SubUnitImpl subUnitImpl = new SubUnitImpl();

		subUnitImpl.setNew(subUnit.isNew());
		subUnitImpl.setPrimaryKey(subUnit.getPrimaryKey());

		subUnitImpl.setSubUnitId(subUnit.getSubUnitId());
		subUnitImpl.setName(subUnit.getName());
		subUnitImpl.setDescription(subUnit.getDescription());
		subUnitImpl.setGroupId(subUnit.getGroupId());
		subUnitImpl.setCompanyId(subUnit.getCompanyId());
		subUnitImpl.setUserId(subUnit.getUserId());
		subUnitImpl.setCreateDate(subUnit.getCreateDate());
		subUnitImpl.setModifiedDate(subUnit.getModifiedDate());

		return subUnitImpl;
	}

	/**
	 * Returns the SubUnit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the SubUnit
	 * @return the SubUnit
	 * @throws com.rknowsys.eapp.hrm.NoSuchSubUnitException if a SubUnit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubUnit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubUnitException, SystemException {
		SubUnit subUnit = fetchByPrimaryKey(primaryKey);

		if (subUnit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubUnitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return subUnit;
	}

	/**
	 * Returns the SubUnit with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchSubUnitException} if it could not be found.
	 *
	 * @param subUnitId the primary key of the SubUnit
	 * @return the SubUnit
	 * @throws com.rknowsys.eapp.hrm.NoSuchSubUnitException if a SubUnit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubUnit findByPrimaryKey(long subUnitId)
		throws NoSuchSubUnitException, SystemException {
		return findByPrimaryKey((Serializable)subUnitId);
	}

	/**
	 * Returns the SubUnit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the SubUnit
	 * @return the SubUnit, or <code>null</code> if a SubUnit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubUnit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SubUnit subUnit = (SubUnit)EntityCacheUtil.getResult(SubUnitModelImpl.ENTITY_CACHE_ENABLED,
				SubUnitImpl.class, primaryKey);

		if (subUnit == _nullSubUnit) {
			return null;
		}

		if (subUnit == null) {
			Session session = null;

			try {
				session = openSession();

				subUnit = (SubUnit)session.get(SubUnitImpl.class, primaryKey);

				if (subUnit != null) {
					cacheResult(subUnit);
				}
				else {
					EntityCacheUtil.putResult(SubUnitModelImpl.ENTITY_CACHE_ENABLED,
						SubUnitImpl.class, primaryKey, _nullSubUnit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SubUnitModelImpl.ENTITY_CACHE_ENABLED,
					SubUnitImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return subUnit;
	}

	/**
	 * Returns the SubUnit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subUnitId the primary key of the SubUnit
	 * @return the SubUnit, or <code>null</code> if a SubUnit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubUnit fetchByPrimaryKey(long subUnitId) throws SystemException {
		return fetchByPrimaryKey((Serializable)subUnitId);
	}

	/**
	 * Returns all the SubUnits.
	 *
	 * @return the SubUnits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubUnit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the SubUnits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SubUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of SubUnits
	 * @param end the upper bound of the range of SubUnits (not inclusive)
	 * @return the range of SubUnits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubUnit> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the SubUnits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SubUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of SubUnits
	 * @param end the upper bound of the range of SubUnits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of SubUnits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubUnit> findAll(int start, int end,
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

		List<SubUnit> list = (List<SubUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBUNIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBUNIT;

				if (pagination) {
					sql = sql.concat(SubUnitModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SubUnit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubUnit>(list);
				}
				else {
					list = (List<SubUnit>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the SubUnits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SubUnit subUnit : findAll()) {
			remove(subUnit);
		}
	}

	/**
	 * Returns the number of SubUnits.
	 *
	 * @return the number of SubUnits
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

				Query q = session.createQuery(_SQL_COUNT_SUBUNIT);

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

	/**
	 * Initializes the SubUnit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.SubUnit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SubUnit>> listenersList = new ArrayList<ModelListener<SubUnit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SubUnit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubUnitImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBUNIT = "SELECT subUnit FROM SubUnit subUnit";
	private static final String _SQL_COUNT_SUBUNIT = "SELECT COUNT(subUnit) FROM SubUnit subUnit";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subUnit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SubUnit exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubUnitPersistenceImpl.class);
	private static SubUnit _nullSubUnit = new SubUnitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SubUnit> toCacheModel() {
				return _nullSubUnitCacheModel;
			}
		};

	private static CacheModel<SubUnit> _nullSubUnitCacheModel = new CacheModel<SubUnit>() {
			@Override
			public SubUnit toEntityModel() {
				return _nullSubUnit;
			}
		};
}