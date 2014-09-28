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

import com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException;
import com.rknowsys.eapp.hrm.model.EmploymentStatus;
import com.rknowsys.eapp.hrm.model.impl.EmploymentStatusImpl;
import com.rknowsys.eapp.hrm.model.impl.EmploymentStatusModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the employment status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmploymentStatusPersistence
 * @see EmploymentStatusUtil
 * @generated
 */
public class EmploymentStatusPersistenceImpl extends BasePersistenceImpl<EmploymentStatus>
	implements EmploymentStatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmploymentStatusUtil} to access the employment status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmploymentStatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmploymentStatusModelImpl.ENTITY_CACHE_ENABLED,
			EmploymentStatusModelImpl.FINDER_CACHE_ENABLED,
			EmploymentStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmploymentStatusModelImpl.ENTITY_CACHE_ENABLED,
			EmploymentStatusModelImpl.FINDER_CACHE_ENABLED,
			EmploymentStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmploymentStatusModelImpl.ENTITY_CACHE_ENABLED,
			EmploymentStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmploymentStatusPersistenceImpl() {
		setModelClass(EmploymentStatus.class);
	}

	/**
	 * Caches the employment status in the entity cache if it is enabled.
	 *
	 * @param employmentStatus the employment status
	 */
	@Override
	public void cacheResult(EmploymentStatus employmentStatus) {
		EntityCacheUtil.putResult(EmploymentStatusModelImpl.ENTITY_CACHE_ENABLED,
			EmploymentStatusImpl.class, employmentStatus.getPrimaryKey(),
			employmentStatus);

		employmentStatus.resetOriginalValues();
	}

	/**
	 * Caches the employment statuses in the entity cache if it is enabled.
	 *
	 * @param employmentStatuses the employment statuses
	 */
	@Override
	public void cacheResult(List<EmploymentStatus> employmentStatuses) {
		for (EmploymentStatus employmentStatus : employmentStatuses) {
			if (EntityCacheUtil.getResult(
						EmploymentStatusModelImpl.ENTITY_CACHE_ENABLED,
						EmploymentStatusImpl.class,
						employmentStatus.getPrimaryKey()) == null) {
				cacheResult(employmentStatus);
			}
			else {
				employmentStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all employment statuses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmploymentStatusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmploymentStatusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employment status.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmploymentStatus employmentStatus) {
		EntityCacheUtil.removeResult(EmploymentStatusModelImpl.ENTITY_CACHE_ENABLED,
			EmploymentStatusImpl.class, employmentStatus.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmploymentStatus> employmentStatuses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmploymentStatus employmentStatus : employmentStatuses) {
			EntityCacheUtil.removeResult(EmploymentStatusModelImpl.ENTITY_CACHE_ENABLED,
				EmploymentStatusImpl.class, employmentStatus.getPrimaryKey());
		}
	}

	/**
	 * Creates a new employment status with the primary key. Does not add the employment status to the database.
	 *
	 * @param employmentStatusId the primary key for the new employment status
	 * @return the new employment status
	 */
	@Override
	public EmploymentStatus create(long employmentStatusId) {
		EmploymentStatus employmentStatus = new EmploymentStatusImpl();

		employmentStatus.setNew(true);
		employmentStatus.setPrimaryKey(employmentStatusId);

		return employmentStatus;
	}

	/**
	 * Removes the employment status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employmentStatusId the primary key of the employment status
	 * @return the employment status that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException if a employment status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmploymentStatus remove(long employmentStatusId)
		throws NoSuchEmploymentStatusException, SystemException {
		return remove((Serializable)employmentStatusId);
	}

	/**
	 * Removes the employment status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employment status
	 * @return the employment status that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException if a employment status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmploymentStatus remove(Serializable primaryKey)
		throws NoSuchEmploymentStatusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmploymentStatus employmentStatus = (EmploymentStatus)session.get(EmploymentStatusImpl.class,
					primaryKey);

			if (employmentStatus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmploymentStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(employmentStatus);
		}
		catch (NoSuchEmploymentStatusException nsee) {
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
	protected EmploymentStatus removeImpl(EmploymentStatus employmentStatus)
		throws SystemException {
		employmentStatus = toUnwrappedModel(employmentStatus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employmentStatus)) {
				employmentStatus = (EmploymentStatus)session.get(EmploymentStatusImpl.class,
						employmentStatus.getPrimaryKeyObj());
			}

			if (employmentStatus != null) {
				session.delete(employmentStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (employmentStatus != null) {
			clearCache(employmentStatus);
		}

		return employmentStatus;
	}

	@Override
	public EmploymentStatus updateImpl(
		com.rknowsys.eapp.hrm.model.EmploymentStatus employmentStatus)
		throws SystemException {
		employmentStatus = toUnwrappedModel(employmentStatus);

		boolean isNew = employmentStatus.isNew();

		Session session = null;

		try {
			session = openSession();

			if (employmentStatus.isNew()) {
				session.save(employmentStatus);

				employmentStatus.setNew(false);
			}
			else {
				session.merge(employmentStatus);
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

		EntityCacheUtil.putResult(EmploymentStatusModelImpl.ENTITY_CACHE_ENABLED,
			EmploymentStatusImpl.class, employmentStatus.getPrimaryKey(),
			employmentStatus);

		return employmentStatus;
	}

	protected EmploymentStatus toUnwrappedModel(
		EmploymentStatus employmentStatus) {
		if (employmentStatus instanceof EmploymentStatusImpl) {
			return employmentStatus;
		}

		EmploymentStatusImpl employmentStatusImpl = new EmploymentStatusImpl();

		employmentStatusImpl.setNew(employmentStatus.isNew());
		employmentStatusImpl.setPrimaryKey(employmentStatus.getPrimaryKey());

		employmentStatusImpl.setEmploymentStatusId(employmentStatus.getEmploymentStatusId());
		employmentStatusImpl.setGroupId(employmentStatus.getGroupId());
		employmentStatusImpl.setCompanyId(employmentStatus.getCompanyId());
		employmentStatusImpl.setUserId(employmentStatus.getUserId());
		employmentStatusImpl.setCreateDate(employmentStatus.getCreateDate());
		employmentStatusImpl.setModifiedDate(employmentStatus.getModifiedDate());
		employmentStatusImpl.setEmploymentstatus(employmentStatus.getEmploymentstatus());

		return employmentStatusImpl;
	}

	/**
	 * Returns the employment status with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the employment status
	 * @return the employment status
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException if a employment status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmploymentStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmploymentStatusException, SystemException {
		EmploymentStatus employmentStatus = fetchByPrimaryKey(primaryKey);

		if (employmentStatus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmploymentStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return employmentStatus;
	}

	/**
	 * Returns the employment status with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException} if it could not be found.
	 *
	 * @param employmentStatusId the primary key of the employment status
	 * @return the employment status
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException if a employment status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmploymentStatus findByPrimaryKey(long employmentStatusId)
		throws NoSuchEmploymentStatusException, SystemException {
		return findByPrimaryKey((Serializable)employmentStatusId);
	}

	/**
	 * Returns the employment status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employment status
	 * @return the employment status, or <code>null</code> if a employment status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmploymentStatus fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmploymentStatus employmentStatus = (EmploymentStatus)EntityCacheUtil.getResult(EmploymentStatusModelImpl.ENTITY_CACHE_ENABLED,
				EmploymentStatusImpl.class, primaryKey);

		if (employmentStatus == _nullEmploymentStatus) {
			return null;
		}

		if (employmentStatus == null) {
			Session session = null;

			try {
				session = openSession();

				employmentStatus = (EmploymentStatus)session.get(EmploymentStatusImpl.class,
						primaryKey);

				if (employmentStatus != null) {
					cacheResult(employmentStatus);
				}
				else {
					EntityCacheUtil.putResult(EmploymentStatusModelImpl.ENTITY_CACHE_ENABLED,
						EmploymentStatusImpl.class, primaryKey,
						_nullEmploymentStatus);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmploymentStatusModelImpl.ENTITY_CACHE_ENABLED,
					EmploymentStatusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return employmentStatus;
	}

	/**
	 * Returns the employment status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employmentStatusId the primary key of the employment status
	 * @return the employment status, or <code>null</code> if a employment status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmploymentStatus fetchByPrimaryKey(long employmentStatusId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)employmentStatusId);
	}

	/**
	 * Returns all the employment statuses.
	 *
	 * @return the employment statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmploymentStatus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employment statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmploymentStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employment statuses
	 * @param end the upper bound of the range of employment statuses (not inclusive)
	 * @return the range of employment statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmploymentStatus> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employment statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmploymentStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employment statuses
	 * @param end the upper bound of the range of employment statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employment statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmploymentStatus> findAll(int start, int end,
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

		List<EmploymentStatus> list = (List<EmploymentStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPLOYMENTSTATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYMENTSTATUS;

				if (pagination) {
					sql = sql.concat(EmploymentStatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmploymentStatus>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmploymentStatus>(list);
				}
				else {
					list = (List<EmploymentStatus>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the employment statuses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmploymentStatus employmentStatus : findAll()) {
			remove(employmentStatus);
		}
	}

	/**
	 * Returns the number of employment statuses.
	 *
	 * @return the number of employment statuses
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

				Query q = session.createQuery(_SQL_COUNT_EMPLOYMENTSTATUS);

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
	 * Initializes the employment status persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmploymentStatus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmploymentStatus>> listenersList = new ArrayList<ModelListener<EmploymentStatus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmploymentStatus>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmploymentStatusImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPLOYMENTSTATUS = "SELECT employmentStatus FROM EmploymentStatus employmentStatus";
	private static final String _SQL_COUNT_EMPLOYMENTSTATUS = "SELECT COUNT(employmentStatus) FROM EmploymentStatus employmentStatus";
	private static final String _ORDER_BY_ENTITY_ALIAS = "employmentStatus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmploymentStatus exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmploymentStatusPersistenceImpl.class);
	private static EmploymentStatus _nullEmploymentStatus = new EmploymentStatusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmploymentStatus> toCacheModel() {
				return _nullEmploymentStatusCacheModel;
			}
		};

	private static CacheModel<EmploymentStatus> _nullEmploymentStatusCacheModel = new CacheModel<EmploymentStatus>() {
			@Override
			public EmploymentStatus toEntityModel() {
				return _nullEmploymentStatus;
			}
		};
}