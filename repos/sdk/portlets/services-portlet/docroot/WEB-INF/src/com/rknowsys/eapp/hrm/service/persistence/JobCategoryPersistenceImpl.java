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

import com.rknowsys.eapp.hrm.NoSuchJobCategoryException;
import com.rknowsys.eapp.hrm.model.JobCategory;
import com.rknowsys.eapp.hrm.model.impl.JobCategoryImpl;
import com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the job category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see JobCategoryPersistence
 * @see JobCategoryUtil
 * @generated
 */
public class JobCategoryPersistenceImpl extends BasePersistenceImpl<JobCategory>
	implements JobCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JobCategoryUtil} to access the job category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JobCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
			JobCategoryModelImpl.FINDER_CACHE_ENABLED, JobCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
			JobCategoryModelImpl.FINDER_CACHE_ENABLED, JobCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
			JobCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
			JobCategoryModelImpl.FINDER_CACHE_ENABLED, JobCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
			JobCategoryModelImpl.FINDER_CACHE_ENABLED, JobCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			JobCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
			JobCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the job categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching job categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobCategory> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of job categories
	 * @param end the upper bound of the range of job categories (not inclusive)
	 * @return the range of matching job categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobCategory> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of job categories
	 * @param end the upper bound of the range of job categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobCategory> findByGroupId(long groupId, int start, int end,
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

		List<JobCategory> list = (List<JobCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JobCategory jobCategory : list) {
				if ((groupId != jobCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_JOBCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<JobCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobCategory>(list);
				}
				else {
					list = (List<JobCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first job category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job category
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a matching job category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobCategory findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchJobCategoryException, SystemException {
		JobCategory jobCategory = fetchByGroupId_First(groupId,
				orderByComparator);

		if (jobCategory != null) {
			return jobCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobCategoryException(msg.toString());
	}

	/**
	 * Returns the first job category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job category, or <code>null</code> if a matching job category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobCategory fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<JobCategory> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job category
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a matching job category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobCategory findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchJobCategoryException, SystemException {
		JobCategory jobCategory = fetchByGroupId_Last(groupId, orderByComparator);

		if (jobCategory != null) {
			return jobCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobCategoryException(msg.toString());
	}

	/**
	 * Returns the last job category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job category, or <code>null</code> if a matching job category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobCategory fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<JobCategory> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job categories before and after the current job category in the ordered set where groupId = &#63;.
	 *
	 * @param jobCategoryId the primary key of the current job category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job category
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a job category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobCategory[] findByGroupId_PrevAndNext(long jobCategoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchJobCategoryException, SystemException {
		JobCategory jobCategory = findByPrimaryKey(jobCategoryId);

		Session session = null;

		try {
			session = openSession();

			JobCategory[] array = new JobCategoryImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, jobCategory, groupId,
					orderByComparator, true);

			array[1] = jobCategory;

			array[2] = getByGroupId_PrevAndNext(session, jobCategory, groupId,
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

	protected JobCategory getByGroupId_PrevAndNext(Session session,
		JobCategory jobCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBCATEGORY_WHERE);

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
			query.append(JobCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (JobCategory jobCategory : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(jobCategory);
		}
	}

	/**
	 * Returns the number of job categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching job categories
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

			query.append(_SQL_COUNT_JOBCATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "jobCategory.groupId = ?";

	public JobCategoryPersistenceImpl() {
		setModelClass(JobCategory.class);
	}

	/**
	 * Caches the job category in the entity cache if it is enabled.
	 *
	 * @param jobCategory the job category
	 */
	@Override
	public void cacheResult(JobCategory jobCategory) {
		EntityCacheUtil.putResult(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
			JobCategoryImpl.class, jobCategory.getPrimaryKey(), jobCategory);

		jobCategory.resetOriginalValues();
	}

	/**
	 * Caches the job categories in the entity cache if it is enabled.
	 *
	 * @param jobCategories the job categories
	 */
	@Override
	public void cacheResult(List<JobCategory> jobCategories) {
		for (JobCategory jobCategory : jobCategories) {
			if (EntityCacheUtil.getResult(
						JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
						JobCategoryImpl.class, jobCategory.getPrimaryKey()) == null) {
				cacheResult(jobCategory);
			}
			else {
				jobCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all job categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JobCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JobCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobCategory jobCategory) {
		EntityCacheUtil.removeResult(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
			JobCategoryImpl.class, jobCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<JobCategory> jobCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JobCategory jobCategory : jobCategories) {
			EntityCacheUtil.removeResult(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
				JobCategoryImpl.class, jobCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new job category with the primary key. Does not add the job category to the database.
	 *
	 * @param jobCategoryId the primary key for the new job category
	 * @return the new job category
	 */
	@Override
	public JobCategory create(long jobCategoryId) {
		JobCategory jobCategory = new JobCategoryImpl();

		jobCategory.setNew(true);
		jobCategory.setPrimaryKey(jobCategoryId);

		return jobCategory;
	}

	/**
	 * Removes the job category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobCategoryId the primary key of the job category
	 * @return the job category that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a job category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobCategory remove(long jobCategoryId)
		throws NoSuchJobCategoryException, SystemException {
		return remove((Serializable)jobCategoryId);
	}

	/**
	 * Removes the job category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job category
	 * @return the job category that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a job category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobCategory remove(Serializable primaryKey)
		throws NoSuchJobCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JobCategory jobCategory = (JobCategory)session.get(JobCategoryImpl.class,
					primaryKey);

			if (jobCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jobCategory);
		}
		catch (NoSuchJobCategoryException nsee) {
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
	protected JobCategory removeImpl(JobCategory jobCategory)
		throws SystemException {
		jobCategory = toUnwrappedModel(jobCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobCategory)) {
				jobCategory = (JobCategory)session.get(JobCategoryImpl.class,
						jobCategory.getPrimaryKeyObj());
			}

			if (jobCategory != null) {
				session.delete(jobCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jobCategory != null) {
			clearCache(jobCategory);
		}

		return jobCategory;
	}

	@Override
	public JobCategory updateImpl(
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws SystemException {
		jobCategory = toUnwrappedModel(jobCategory);

		boolean isNew = jobCategory.isNew();

		JobCategoryModelImpl jobCategoryModelImpl = (JobCategoryModelImpl)jobCategory;

		Session session = null;

		try {
			session = openSession();

			if (jobCategory.isNew()) {
				session.save(jobCategory);

				jobCategory.setNew(false);
			}
			else {
				session.merge(jobCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JobCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((jobCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobCategoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { jobCategoryModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
			JobCategoryImpl.class, jobCategory.getPrimaryKey(), jobCategory);

		return jobCategory;
	}

	protected JobCategory toUnwrappedModel(JobCategory jobCategory) {
		if (jobCategory instanceof JobCategoryImpl) {
			return jobCategory;
		}

		JobCategoryImpl jobCategoryImpl = new JobCategoryImpl();

		jobCategoryImpl.setNew(jobCategory.isNew());
		jobCategoryImpl.setPrimaryKey(jobCategory.getPrimaryKey());

		jobCategoryImpl.setJobCategoryId(jobCategory.getJobCategoryId());
		jobCategoryImpl.setCompanyId(jobCategory.getCompanyId());
		jobCategoryImpl.setGroupId(jobCategory.getGroupId());
		jobCategoryImpl.setCreateDate(jobCategory.getCreateDate());
		jobCategoryImpl.setModifiedDate(jobCategory.getModifiedDate());
		jobCategoryImpl.setUserId(jobCategory.getUserId());
		jobCategoryImpl.setJobcategory(jobCategory.getJobcategory());

		return jobCategoryImpl;
	}

	/**
	 * Returns the job category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the job category
	 * @return the job category
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a job category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobCategoryException, SystemException {
		JobCategory jobCategory = fetchByPrimaryKey(primaryKey);

		if (jobCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jobCategory;
	}

	/**
	 * Returns the job category with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchJobCategoryException} if it could not be found.
	 *
	 * @param jobCategoryId the primary key of the job category
	 * @return the job category
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobCategoryException if a job category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobCategory findByPrimaryKey(long jobCategoryId)
		throws NoSuchJobCategoryException, SystemException {
		return findByPrimaryKey((Serializable)jobCategoryId);
	}

	/**
	 * Returns the job category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job category
	 * @return the job category, or <code>null</code> if a job category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		JobCategory jobCategory = (JobCategory)EntityCacheUtil.getResult(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
				JobCategoryImpl.class, primaryKey);

		if (jobCategory == _nullJobCategory) {
			return null;
		}

		if (jobCategory == null) {
			Session session = null;

			try {
				session = openSession();

				jobCategory = (JobCategory)session.get(JobCategoryImpl.class,
						primaryKey);

				if (jobCategory != null) {
					cacheResult(jobCategory);
				}
				else {
					EntityCacheUtil.putResult(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
						JobCategoryImpl.class, primaryKey, _nullJobCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JobCategoryModelImpl.ENTITY_CACHE_ENABLED,
					JobCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jobCategory;
	}

	/**
	 * Returns the job category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobCategoryId the primary key of the job category
	 * @return the job category, or <code>null</code> if a job category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobCategory fetchByPrimaryKey(long jobCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)jobCategoryId);
	}

	/**
	 * Returns all the job categories.
	 *
	 * @return the job categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job categories
	 * @param end the upper bound of the range of job categories (not inclusive)
	 * @return the range of job categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job categories
	 * @param end the upper bound of the range of job categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobCategory> findAll(int start, int end,
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

		List<JobCategory> list = (List<JobCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JOBCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOBCATEGORY;

				if (pagination) {
					sql = sql.concat(JobCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JobCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobCategory>(list);
				}
				else {
					list = (List<JobCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the job categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (JobCategory jobCategory : findAll()) {
			remove(jobCategory);
		}
	}

	/**
	 * Returns the number of job categories.
	 *
	 * @return the number of job categories
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

				Query q = session.createQuery(_SQL_COUNT_JOBCATEGORY);

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
	 * Initializes the job category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.JobCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JobCategory>> listenersList = new ArrayList<ModelListener<JobCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JobCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JobCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JOBCATEGORY = "SELECT jobCategory FROM JobCategory jobCategory";
	private static final String _SQL_SELECT_JOBCATEGORY_WHERE = "SELECT jobCategory FROM JobCategory jobCategory WHERE ";
	private static final String _SQL_COUNT_JOBCATEGORY = "SELECT COUNT(jobCategory) FROM JobCategory jobCategory";
	private static final String _SQL_COUNT_JOBCATEGORY_WHERE = "SELECT COUNT(jobCategory) FROM JobCategory jobCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jobCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JobCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JobCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JobCategoryPersistenceImpl.class);
	private static JobCategory _nullJobCategory = new JobCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JobCategory> toCacheModel() {
				return _nullJobCategoryCacheModel;
			}
		};

	private static CacheModel<JobCategory> _nullJobCategoryCacheModel = new CacheModel<JobCategory>() {
			@Override
			public JobCategory toEntityModel() {
				return _nullJobCategory;
			}
		};
}