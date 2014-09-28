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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.NoSuchJobTitleException;
import com.rknowsys.eapp.hrm.model.JobTitle;
import com.rknowsys.eapp.hrm.model.impl.JobTitleImpl;
import com.rknowsys.eapp.hrm.model.impl.JobTitleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the job title service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see JobTitlePersistence
 * @see JobTitleUtil
 * @generated
 */
public class JobTitlePersistenceImpl extends BasePersistenceImpl<JobTitle>
	implements JobTitlePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JobTitleUtil} to access the job title persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JobTitleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleModelImpl.FINDER_CACHE_ENABLED, JobTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleModelImpl.FINDER_CACHE_ENABLED, JobTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleModelImpl.FINDER_CACHE_ENABLED, JobTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleModelImpl.FINDER_CACHE_ENABLED, JobTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			JobTitleModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the job titles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobTitle> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job titles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of job titles
	 * @param end the upper bound of the range of job titles (not inclusive)
	 * @return the range of matching job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobTitle> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job titles where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of job titles
	 * @param end the upper bound of the range of job titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobTitle> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<JobTitle> list = (List<JobTitle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JobTitle jobTitle : list) {
				if ((groupId != jobTitle.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_JOBTITLE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobTitleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<JobTitle>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobTitle>(list);
				}
				else {
					list = (List<JobTitle>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first job title in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job title
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitleException if a matching job title could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchJobTitleException, SystemException {
		JobTitle jobTitle = fetchByGroupId_First(groupId, orderByComparator);

		if (jobTitle != null) {
			return jobTitle;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobTitleException(msg.toString());
	}

	/**
	 * Returns the first job title in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job title, or <code>null</code> if a matching job title could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<JobTitle> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job title in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job title
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitleException if a matching job title could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchJobTitleException, SystemException {
		JobTitle jobTitle = fetchByGroupId_Last(groupId, orderByComparator);

		if (jobTitle != null) {
			return jobTitle;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobTitleException(msg.toString());
	}

	/**
	 * Returns the last job title in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job title, or <code>null</code> if a matching job title could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<JobTitle> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job titles before and after the current job title in the ordered set where groupId = &#63;.
	 *
	 * @param jobTitleId the primary key of the current job title
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job title
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitleException if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle[] findByGroupId_PrevAndNext(long jobTitleId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchJobTitleException, SystemException {
		JobTitle jobTitle = findByPrimaryKey(jobTitleId);

		Session session = null;

		try {
			session = openSession();

			JobTitle[] array = new JobTitleImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, jobTitle, groupId,
					orderByComparator, true);

			array[1] = jobTitle;

			array[2] = getByGroupId_PrevAndNext(session, jobTitle, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobTitle getByGroupId_PrevAndNext(Session session,
		JobTitle jobTitle, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBTITLE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(JobTitleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobTitle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobTitle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job titles where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (JobTitle jobTitle : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(jobTitle);
		}
	}

	/**
	 * Returns the number of job titles where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOBTITLE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "jobTitle.groupId = ?";

	public JobTitlePersistenceImpl() {
		setModelClass(JobTitle.class);
	}

	/**
	 * Caches the job title in the entity cache if it is enabled.
	 *
	 * @param jobTitle the job title
	 */
	@Override
	public void cacheResult(JobTitle jobTitle) {
		EntityCacheUtil.putResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleImpl.class, jobTitle.getPrimaryKey(), jobTitle);

		jobTitle.resetOriginalValues();
	}

	/**
	 * Caches the job titles in the entity cache if it is enabled.
	 *
	 * @param jobTitles the job titles
	 */
	@Override
	public void cacheResult(List<JobTitle> jobTitles) {
		for (JobTitle jobTitle : jobTitles) {
			if (EntityCacheUtil.getResult(
						JobTitleModelImpl.ENTITY_CACHE_ENABLED,
						JobTitleImpl.class, jobTitle.getPrimaryKey()) == null) {
				cacheResult(jobTitle);
			}
			else {
				jobTitle.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all job titles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JobTitleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JobTitleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job title.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobTitle jobTitle) {
		EntityCacheUtil.removeResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleImpl.class, jobTitle.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<JobTitle> jobTitles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JobTitle jobTitle : jobTitles) {
			EntityCacheUtil.removeResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
				JobTitleImpl.class, jobTitle.getPrimaryKey());
		}
	}

	/**
	 * Creates a new job title with the primary key. Does not add the job title to the database.
	 *
	 * @param jobTitleId the primary key for the new job title
	 * @return the new job title
	 */
	@Override
	public JobTitle create(long jobTitleId) {
		JobTitle jobTitle = new JobTitleImpl();

		jobTitle.setNew(true);
		jobTitle.setPrimaryKey(jobTitleId);

		return jobTitle;
	}

	/**
	 * Removes the job title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobTitleId the primary key of the job title
	 * @return the job title that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitleException if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle remove(long jobTitleId)
		throws NoSuchJobTitleException, SystemException {
		return remove((Serializable)jobTitleId);
	}

	/**
	 * Removes the job title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job title
	 * @return the job title that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitleException if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle remove(Serializable primaryKey)
		throws NoSuchJobTitleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JobTitle jobTitle = (JobTitle)session.get(JobTitleImpl.class,
					primaryKey);

			if (jobTitle == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobTitleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jobTitle);
		}
		catch (NoSuchJobTitleException nsee) {
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
	protected JobTitle removeImpl(JobTitle jobTitle) throws SystemException {
		jobTitle = toUnwrappedModel(jobTitle);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobTitle)) {
				jobTitle = (JobTitle)session.get(JobTitleImpl.class,
						jobTitle.getPrimaryKeyObj());
			}

			if (jobTitle != null) {
				session.delete(jobTitle);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jobTitle != null) {
			clearCache(jobTitle);
		}

		return jobTitle;
	}

	@Override
	public JobTitle updateImpl(com.rknowsys.eapp.hrm.model.JobTitle jobTitle)
		throws SystemException {
		jobTitle = toUnwrappedModel(jobTitle);

		boolean isNew = jobTitle.isNew();

		JobTitleModelImpl jobTitleModelImpl = (JobTitleModelImpl)jobTitle;

		Session session = null;

		try {
			session = openSession();

			if (jobTitle.isNew()) {
				session.save(jobTitle);

				jobTitle.setNew(false);
			}
			else {
				session.merge(jobTitle);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JobTitleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((jobTitleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobTitleModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { jobTitleModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleImpl.class, jobTitle.getPrimaryKey(), jobTitle);

		return jobTitle;
	}

	protected JobTitle toUnwrappedModel(JobTitle jobTitle) {
		if (jobTitle instanceof JobTitleImpl) {
			return jobTitle;
		}

		JobTitleImpl jobTitleImpl = new JobTitleImpl();

		jobTitleImpl.setNew(jobTitle.isNew());
		jobTitleImpl.setPrimaryKey(jobTitle.getPrimaryKey());

		jobTitleImpl.setJobTitleId(jobTitle.getJobTitleId());
		jobTitleImpl.setCompanyId(jobTitle.getCompanyId());
		jobTitleImpl.setGroupId(jobTitle.getGroupId());
		jobTitleImpl.setCreateDate(jobTitle.getCreateDate());
		jobTitleImpl.setModifiedDate(jobTitle.getModifiedDate());
		jobTitleImpl.setUserId(jobTitle.getUserId());
		jobTitleImpl.setTitle(jobTitle.getTitle());
		jobTitleImpl.setDescription(jobTitle.getDescription());
		jobTitleImpl.setNotes(jobTitle.getNotes());
		jobTitleImpl.setSpecification(jobTitle.getSpecification());

		return jobTitleImpl;
	}

	/**
	 * Returns the job title with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the job title
	 * @return the job title
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitleException if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobTitleException, SystemException {
		JobTitle jobTitle = fetchByPrimaryKey(primaryKey);

		if (jobTitle == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobTitleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jobTitle;
	}

	/**
	 * Returns the job title with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchJobTitleException} if it could not be found.
	 *
	 * @param jobTitleId the primary key of the job title
	 * @return the job title
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitleException if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle findByPrimaryKey(long jobTitleId)
		throws NoSuchJobTitleException, SystemException {
		return findByPrimaryKey((Serializable)jobTitleId);
	}

	/**
	 * Returns the job title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job title
	 * @return the job title, or <code>null</code> if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		JobTitle jobTitle = (JobTitle)EntityCacheUtil.getResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
				JobTitleImpl.class, primaryKey);

		if (jobTitle == _nullJobTitle) {
			return null;
		}

		if (jobTitle == null) {
			Session session = null;

			try {
				session = openSession();

				jobTitle = (JobTitle)session.get(JobTitleImpl.class, primaryKey);

				if (jobTitle != null) {
					cacheResult(jobTitle);
				}
				else {
					EntityCacheUtil.putResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
						JobTitleImpl.class, primaryKey, _nullJobTitle);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
					JobTitleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jobTitle;
	}

	/**
	 * Returns the job title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobTitleId the primary key of the job title
	 * @return the job title, or <code>null</code> if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle fetchByPrimaryKey(long jobTitleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)jobTitleId);
	}

	/**
	 * Returns all the job titles.
	 *
	 * @return the job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobTitle> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job titles
	 * @param end the upper bound of the range of job titles (not inclusive)
	 * @return the range of job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobTitle> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job titles
	 * @param end the upper bound of the range of job titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobTitle> findAll(int start, int end,
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

		List<JobTitle> list = (List<JobTitle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JOBTITLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOBTITLE;

				if (pagination) {
					sql = sql.concat(JobTitleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JobTitle>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobTitle>(list);
				}
				else {
					list = (List<JobTitle>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the job titles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (JobTitle jobTitle : findAll()) {
			remove(jobTitle);
		}
	}

	/**
	 * Returns the number of job titles.
	 *
	 * @return the number of job titles
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

				Query q = session.createQuery(_SQL_COUNT_JOBTITLE);

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
	 * Initializes the job title persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.JobTitle")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JobTitle>> listenersList = new ArrayList<ModelListener<JobTitle>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JobTitle>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JobTitleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JOBTITLE = "SELECT jobTitle FROM JobTitle jobTitle";
	private static final String _SQL_SELECT_JOBTITLE_WHERE = "SELECT jobTitle FROM JobTitle jobTitle WHERE ";
	private static final String _SQL_COUNT_JOBTITLE = "SELECT COUNT(jobTitle) FROM JobTitle jobTitle";
	private static final String _SQL_COUNT_JOBTITLE_WHERE = "SELECT COUNT(jobTitle) FROM JobTitle jobTitle WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jobTitle.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JobTitle exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JobTitle exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JobTitlePersistenceImpl.class);
	private static JobTitle _nullJobTitle = new JobTitleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JobTitle> toCacheModel() {
				return _nullJobTitleCacheModel;
			}
		};

	private static CacheModel<JobTitle> _nullJobTitleCacheModel = new CacheModel<JobTitle>() {
			@Override
			public JobTitle toEntityModel() {
				return _nullJobTitle;
			}
		};
}