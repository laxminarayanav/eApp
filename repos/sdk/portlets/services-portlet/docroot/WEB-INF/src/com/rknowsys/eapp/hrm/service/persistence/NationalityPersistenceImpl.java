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

import com.rknowsys.eapp.hrm.NoSuchNationalityException;
import com.rknowsys.eapp.hrm.model.Nationality;
import com.rknowsys.eapp.hrm.model.impl.NationalityImpl;
import com.rknowsys.eapp.hrm.model.impl.NationalityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the Nationality service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see NationalityPersistence
 * @see NationalityUtil
 * @generated
 */
public class NationalityPersistenceImpl extends BasePersistenceImpl<Nationality>
	implements NationalityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NationalityUtil} to access the Nationality persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NationalityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NationalityModelImpl.ENTITY_CACHE_ENABLED,
			NationalityModelImpl.FINDER_CACHE_ENABLED, NationalityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NationalityModelImpl.ENTITY_CACHE_ENABLED,
			NationalityModelImpl.FINDER_CACHE_ENABLED, NationalityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NationalityModelImpl.ENTITY_CACHE_ENABLED,
			NationalityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public NationalityPersistenceImpl() {
		setModelClass(Nationality.class);
	}

	/**
	 * Caches the Nationality in the entity cache if it is enabled.
	 *
	 * @param nationality the Nationality
	 */
	@Override
	public void cacheResult(Nationality nationality) {
		EntityCacheUtil.putResult(NationalityModelImpl.ENTITY_CACHE_ENABLED,
			NationalityImpl.class, nationality.getPrimaryKey(), nationality);

		nationality.resetOriginalValues();
	}

	/**
	 * Caches the Nationalities in the entity cache if it is enabled.
	 *
	 * @param nationalities the Nationalities
	 */
	@Override
	public void cacheResult(List<Nationality> nationalities) {
		for (Nationality nationality : nationalities) {
			if (EntityCacheUtil.getResult(
						NationalityModelImpl.ENTITY_CACHE_ENABLED,
						NationalityImpl.class, nationality.getPrimaryKey()) == null) {
				cacheResult(nationality);
			}
			else {
				nationality.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Nationalities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NationalityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NationalityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Nationality.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Nationality nationality) {
		EntityCacheUtil.removeResult(NationalityModelImpl.ENTITY_CACHE_ENABLED,
			NationalityImpl.class, nationality.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Nationality> nationalities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Nationality nationality : nationalities) {
			EntityCacheUtil.removeResult(NationalityModelImpl.ENTITY_CACHE_ENABLED,
				NationalityImpl.class, nationality.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Nationality with the primary key. Does not add the Nationality to the database.
	 *
	 * @param nationalityId the primary key for the new Nationality
	 * @return the new Nationality
	 */
	@Override
	public Nationality create(long nationalityId) {
		Nationality nationality = new NationalityImpl();

		nationality.setNew(true);
		nationality.setPrimaryKey(nationalityId);

		return nationality;
	}

	/**
	 * Removes the Nationality with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nationalityId the primary key of the Nationality
	 * @return the Nationality that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchNationalityException if a Nationality with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Nationality remove(long nationalityId)
		throws NoSuchNationalityException, SystemException {
		return remove((Serializable)nationalityId);
	}

	/**
	 * Removes the Nationality with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Nationality
	 * @return the Nationality that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchNationalityException if a Nationality with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Nationality remove(Serializable primaryKey)
		throws NoSuchNationalityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Nationality nationality = (Nationality)session.get(NationalityImpl.class,
					primaryKey);

			if (nationality == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNationalityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(nationality);
		}
		catch (NoSuchNationalityException nsee) {
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
	protected Nationality removeImpl(Nationality nationality)
		throws SystemException {
		nationality = toUnwrappedModel(nationality);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(nationality)) {
				nationality = (Nationality)session.get(NationalityImpl.class,
						nationality.getPrimaryKeyObj());
			}

			if (nationality != null) {
				session.delete(nationality);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (nationality != null) {
			clearCache(nationality);
		}

		return nationality;
	}

	@Override
	public Nationality updateImpl(
		com.rknowsys.eapp.hrm.model.Nationality nationality)
		throws SystemException {
		nationality = toUnwrappedModel(nationality);

		boolean isNew = nationality.isNew();

		Session session = null;

		try {
			session = openSession();

			if (nationality.isNew()) {
				session.save(nationality);

				nationality.setNew(false);
			}
			else {
				session.merge(nationality);
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

		EntityCacheUtil.putResult(NationalityModelImpl.ENTITY_CACHE_ENABLED,
			NationalityImpl.class, nationality.getPrimaryKey(), nationality);

		return nationality;
	}

	protected Nationality toUnwrappedModel(Nationality nationality) {
		if (nationality instanceof NationalityImpl) {
			return nationality;
		}

		NationalityImpl nationalityImpl = new NationalityImpl();

		nationalityImpl.setNew(nationality.isNew());
		nationalityImpl.setPrimaryKey(nationality.getPrimaryKey());

		nationalityImpl.setNationalityId(nationality.getNationalityId());
		nationalityImpl.setEmployeeId(nationality.getEmployeeId());
		nationalityImpl.setGroupId(nationality.getGroupId());
		nationalityImpl.setCompanyId(nationality.getCompanyId());
		nationalityImpl.setUserId(nationality.getUserId());
		nationalityImpl.setCreateDate(nationality.getCreateDate());
		nationalityImpl.setModifiedDate(nationality.getModifiedDate());
		nationalityImpl.setName(nationality.getName());

		return nationalityImpl;
	}

	/**
	 * Returns the Nationality with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Nationality
	 * @return the Nationality
	 * @throws com.rknowsys.eapp.hrm.NoSuchNationalityException if a Nationality with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Nationality findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNationalityException, SystemException {
		Nationality nationality = fetchByPrimaryKey(primaryKey);

		if (nationality == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNationalityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return nationality;
	}

	/**
	 * Returns the Nationality with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchNationalityException} if it could not be found.
	 *
	 * @param nationalityId the primary key of the Nationality
	 * @return the Nationality
	 * @throws com.rknowsys.eapp.hrm.NoSuchNationalityException if a Nationality with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Nationality findByPrimaryKey(long nationalityId)
		throws NoSuchNationalityException, SystemException {
		return findByPrimaryKey((Serializable)nationalityId);
	}

	/**
	 * Returns the Nationality with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Nationality
	 * @return the Nationality, or <code>null</code> if a Nationality with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Nationality fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Nationality nationality = (Nationality)EntityCacheUtil.getResult(NationalityModelImpl.ENTITY_CACHE_ENABLED,
				NationalityImpl.class, primaryKey);

		if (nationality == _nullNationality) {
			return null;
		}

		if (nationality == null) {
			Session session = null;

			try {
				session = openSession();

				nationality = (Nationality)session.get(NationalityImpl.class,
						primaryKey);

				if (nationality != null) {
					cacheResult(nationality);
				}
				else {
					EntityCacheUtil.putResult(NationalityModelImpl.ENTITY_CACHE_ENABLED,
						NationalityImpl.class, primaryKey, _nullNationality);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NationalityModelImpl.ENTITY_CACHE_ENABLED,
					NationalityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return nationality;
	}

	/**
	 * Returns the Nationality with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param nationalityId the primary key of the Nationality
	 * @return the Nationality, or <code>null</code> if a Nationality with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Nationality fetchByPrimaryKey(long nationalityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)nationalityId);
	}

	/**
	 * Returns all the Nationalities.
	 *
	 * @return the Nationalities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Nationality> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Nationality> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Nationality> findAll(int start, int end,
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

		List<Nationality> list = (List<Nationality>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NATIONALITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NATIONALITY;

				if (pagination) {
					sql = sql.concat(NationalityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Nationality>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Nationality>(list);
				}
				else {
					list = (List<Nationality>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the Nationalities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Nationality nationality : findAll()) {
			remove(nationality);
		}
	}

	/**
	 * Returns the number of Nationalities.
	 *
	 * @return the number of Nationalities
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

				Query q = session.createQuery(_SQL_COUNT_NATIONALITY);

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
	 * Initializes the Nationality persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Nationality")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Nationality>> listenersList = new ArrayList<ModelListener<Nationality>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Nationality>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NationalityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NATIONALITY = "SELECT nationality FROM Nationality nationality";
	private static final String _SQL_COUNT_NATIONALITY = "SELECT COUNT(nationality) FROM Nationality nationality";
	private static final String _ORDER_BY_ENTITY_ALIAS = "nationality.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Nationality exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NationalityPersistenceImpl.class);
	private static Nationality _nullNationality = new NationalityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Nationality> toCacheModel() {
				return _nullNationalityCacheModel;
			}
		};

	private static CacheModel<Nationality> _nullNationalityCacheModel = new CacheModel<Nationality>() {
			@Override
			public Nationality toEntityModel() {
				return _nullNationality;
			}
		};
}