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

import com.rknowsys.eapp.hrm.NoSuchInterviewException;
import com.rknowsys.eapp.hrm.model.Interview;
import com.rknowsys.eapp.hrm.model.impl.InterviewImpl;
import com.rknowsys.eapp.hrm.model.impl.InterviewModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the interview service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see InterviewPersistence
 * @see InterviewUtil
 * @generated
 */
public class InterviewPersistenceImpl extends BasePersistenceImpl<Interview>
	implements InterviewPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InterviewUtil} to access the interview persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InterviewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, InterviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, InterviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, InterviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, InterviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			InterviewModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the interviews where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching interviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Interview> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the interviews where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.InterviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of interviews
	 * @param end the upper bound of the range of interviews (not inclusive)
	 * @return the range of matching interviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Interview> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the interviews where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.InterviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of interviews
	 * @param end the upper bound of the range of interviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching interviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Interview> findByGroupId(long groupId, int start, int end,
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

		List<Interview> list = (List<Interview>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Interview interview : list) {
				if ((groupId != interview.getGroupId())) {
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

			query.append(_SQL_SELECT_INTERVIEW_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InterviewModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Interview>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Interview>(list);
				}
				else {
					list = (List<Interview>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first interview in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview
	 * @throws com.rknowsys.eapp.hrm.NoSuchInterviewException if a matching interview could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInterviewException, SystemException {
		Interview interview = fetchByGroupId_First(groupId, orderByComparator);

		if (interview != null) {
			return interview;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInterviewException(msg.toString());
	}

	/**
	 * Returns the first interview in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview, or <code>null</code> if a matching interview could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Interview> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last interview in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview
	 * @throws com.rknowsys.eapp.hrm.NoSuchInterviewException if a matching interview could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchInterviewException, SystemException {
		Interview interview = fetchByGroupId_Last(groupId, orderByComparator);

		if (interview != null) {
			return interview;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInterviewException(msg.toString());
	}

	/**
	 * Returns the last interview in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview, or <code>null</code> if a matching interview could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Interview> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the interviews before and after the current interview in the ordered set where groupId = &#63;.
	 *
	 * @param interviewId the primary key of the current interview
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interview
	 * @throws com.rknowsys.eapp.hrm.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview[] findByGroupId_PrevAndNext(long interviewId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchInterviewException, SystemException {
		Interview interview = findByPrimaryKey(interviewId);

		Session session = null;

		try {
			session = openSession();

			Interview[] array = new InterviewImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, interview, groupId,
					orderByComparator, true);

			array[1] = interview;

			array[2] = getByGroupId_PrevAndNext(session, interview, groupId,
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

	protected Interview getByGroupId_PrevAndNext(Session session,
		Interview interview, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INTERVIEW_WHERE);

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
			query.append(InterviewModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(interview);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Interview> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the interviews where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Interview interview : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(interview);
		}
	}

	/**
	 * Returns the number of interviews where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching interviews
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

			query.append(_SQL_COUNT_INTERVIEW_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "interview.groupId = ?";

	public InterviewPersistenceImpl() {
		setModelClass(Interview.class);
	}

	/**
	 * Caches the interview in the entity cache if it is enabled.
	 *
	 * @param interview the interview
	 */
	@Override
	public void cacheResult(Interview interview) {
		EntityCacheUtil.putResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewImpl.class, interview.getPrimaryKey(), interview);

		interview.resetOriginalValues();
	}

	/**
	 * Caches the interviews in the entity cache if it is enabled.
	 *
	 * @param interviews the interviews
	 */
	@Override
	public void cacheResult(List<Interview> interviews) {
		for (Interview interview : interviews) {
			if (EntityCacheUtil.getResult(
						InterviewModelImpl.ENTITY_CACHE_ENABLED,
						InterviewImpl.class, interview.getPrimaryKey()) == null) {
				cacheResult(interview);
			}
			else {
				interview.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all interviews.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InterviewImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InterviewImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the interview.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Interview interview) {
		EntityCacheUtil.removeResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewImpl.class, interview.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Interview> interviews) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Interview interview : interviews) {
			EntityCacheUtil.removeResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
				InterviewImpl.class, interview.getPrimaryKey());
		}
	}

	/**
	 * Creates a new interview with the primary key. Does not add the interview to the database.
	 *
	 * @param interviewId the primary key for the new interview
	 * @return the new interview
	 */
	@Override
	public Interview create(long interviewId) {
		Interview interview = new InterviewImpl();

		interview.setNew(true);
		interview.setPrimaryKey(interviewId);

		return interview;
	}

	/**
	 * Removes the interview with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interviewId the primary key of the interview
	 * @return the interview that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview remove(long interviewId)
		throws NoSuchInterviewException, SystemException {
		return remove((Serializable)interviewId);
	}

	/**
	 * Removes the interview with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the interview
	 * @return the interview that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview remove(Serializable primaryKey)
		throws NoSuchInterviewException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Interview interview = (Interview)session.get(InterviewImpl.class,
					primaryKey);

			if (interview == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInterviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(interview);
		}
		catch (NoSuchInterviewException nsee) {
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
	protected Interview removeImpl(Interview interview)
		throws SystemException {
		interview = toUnwrappedModel(interview);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(interview)) {
				interview = (Interview)session.get(InterviewImpl.class,
						interview.getPrimaryKeyObj());
			}

			if (interview != null) {
				session.delete(interview);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (interview != null) {
			clearCache(interview);
		}

		return interview;
	}

	@Override
	public Interview updateImpl(com.rknowsys.eapp.hrm.model.Interview interview)
		throws SystemException {
		interview = toUnwrappedModel(interview);

		boolean isNew = interview.isNew();

		InterviewModelImpl interviewModelImpl = (InterviewModelImpl)interview;

		Session session = null;

		try {
			session = openSession();

			if (interview.isNew()) {
				session.save(interview);

				interview.setNew(false);
			}
			else {
				session.merge(interview);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !InterviewModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((interviewModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						interviewModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { interviewModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewImpl.class, interview.getPrimaryKey(), interview);

		return interview;
	}

	protected Interview toUnwrappedModel(Interview interview) {
		if (interview instanceof InterviewImpl) {
			return interview;
		}

		InterviewImpl interviewImpl = new InterviewImpl();

		interviewImpl.setNew(interview.isNew());
		interviewImpl.setPrimaryKey(interview.getPrimaryKey());

		interviewImpl.setInterviewId(interview.getInterviewId());
		interviewImpl.setCompanyId(interview.getCompanyId());
		interviewImpl.setGroupId(interview.getGroupId());
		interviewImpl.setCreateDate(interview.getCreateDate());
		interviewImpl.setModifiedDate(interview.getModifiedDate());
		interviewImpl.setUserId(interview.getUserId());
		interviewImpl.setName(interview.getName());

		return interviewImpl;
	}

	/**
	 * Returns the interview with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview
	 * @return the interview
	 * @throws com.rknowsys.eapp.hrm.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInterviewException, SystemException {
		Interview interview = fetchByPrimaryKey(primaryKey);

		if (interview == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInterviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return interview;
	}

	/**
	 * Returns the interview with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchInterviewException} if it could not be found.
	 *
	 * @param interviewId the primary key of the interview
	 * @return the interview
	 * @throws com.rknowsys.eapp.hrm.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview findByPrimaryKey(long interviewId)
		throws NoSuchInterviewException, SystemException {
		return findByPrimaryKey((Serializable)interviewId);
	}

	/**
	 * Returns the interview with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview
	 * @return the interview, or <code>null</code> if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Interview interview = (Interview)EntityCacheUtil.getResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
				InterviewImpl.class, primaryKey);

		if (interview == _nullInterview) {
			return null;
		}

		if (interview == null) {
			Session session = null;

			try {
				session = openSession();

				interview = (Interview)session.get(InterviewImpl.class,
						primaryKey);

				if (interview != null) {
					cacheResult(interview);
				}
				else {
					EntityCacheUtil.putResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
						InterviewImpl.class, primaryKey, _nullInterview);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
					InterviewImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return interview;
	}

	/**
	 * Returns the interview with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param interviewId the primary key of the interview
	 * @return the interview, or <code>null</code> if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview fetchByPrimaryKey(long interviewId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)interviewId);
	}

	/**
	 * Returns all the interviews.
	 *
	 * @return the interviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Interview> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the interviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.InterviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of interviews
	 * @param end the upper bound of the range of interviews (not inclusive)
	 * @return the range of interviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Interview> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the interviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.InterviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of interviews
	 * @param end the upper bound of the range of interviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of interviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Interview> findAll(int start, int end,
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

		List<Interview> list = (List<Interview>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INTERVIEW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INTERVIEW;

				if (pagination) {
					sql = sql.concat(InterviewModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Interview>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Interview>(list);
				}
				else {
					list = (List<Interview>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the interviews from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Interview interview : findAll()) {
			remove(interview);
		}
	}

	/**
	 * Returns the number of interviews.
	 *
	 * @return the number of interviews
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

				Query q = session.createQuery(_SQL_COUNT_INTERVIEW);

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
	 * Initializes the interview persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Interview")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Interview>> listenersList = new ArrayList<ModelListener<Interview>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Interview>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InterviewImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INTERVIEW = "SELECT interview FROM Interview interview";
	private static final String _SQL_SELECT_INTERVIEW_WHERE = "SELECT interview FROM Interview interview WHERE ";
	private static final String _SQL_COUNT_INTERVIEW = "SELECT COUNT(interview) FROM Interview interview";
	private static final String _SQL_COUNT_INTERVIEW_WHERE = "SELECT COUNT(interview) FROM Interview interview WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "interview.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Interview exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Interview exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InterviewPersistenceImpl.class);
	private static Interview _nullInterview = new InterviewImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Interview> toCacheModel() {
				return _nullInterviewCacheModel;
			}
		};

	private static CacheModel<Interview> _nullInterviewCacheModel = new CacheModel<Interview>() {
			@Override
			public Interview toEntityModel() {
				return _nullInterview;
			}
		};
}