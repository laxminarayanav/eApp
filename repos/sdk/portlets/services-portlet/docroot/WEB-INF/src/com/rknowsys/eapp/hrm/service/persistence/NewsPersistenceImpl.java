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

import com.rknowsys.eapp.hrm.NoSuchNewsException;
import com.rknowsys.eapp.hrm.model.News;
import com.rknowsys.eapp.hrm.model.impl.NewsImpl;
import com.rknowsys.eapp.hrm.model.impl.NewsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the news service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see NewsPersistence
 * @see NewsUtil
 * @generated
 */
public class NewsPersistenceImpl extends BasePersistenceImpl<News>
	implements NewsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NewsUtil} to access the news persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NewsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
			NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
			NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
			NewsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
			NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
			NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			NewsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
			NewsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the newses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching newses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<News> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.NewsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of newses
	 * @param end the upper bound of the range of newses (not inclusive)
	 * @return the range of matching newses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<News> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the newses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.NewsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of newses
	 * @param end the upper bound of the range of newses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<News> findByGroupId(long groupId, int start, int end,
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

		List<News> list = (List<News>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (News news : list) {
				if ((groupId != news.getGroupId())) {
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

			query.append(_SQL_SELECT_NEWS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NewsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<News>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<News>(list);
				}
				else {
					list = (List<News>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first news in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news
	 * @throws com.rknowsys.eapp.hrm.NoSuchNewsException if a matching news could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public News findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchNewsException, SystemException {
		News news = fetchByGroupId_First(groupId, orderByComparator);

		if (news != null) {
			return news;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNewsException(msg.toString());
	}

	/**
	 * Returns the first news in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news, or <code>null</code> if a matching news could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public News fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<News> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last news in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news
	 * @throws com.rknowsys.eapp.hrm.NoSuchNewsException if a matching news could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public News findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchNewsException, SystemException {
		News news = fetchByGroupId_Last(groupId, orderByComparator);

		if (news != null) {
			return news;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNewsException(msg.toString());
	}

	/**
	 * Returns the last news in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news, or <code>null</code> if a matching news could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public News fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<News> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the newses before and after the current news in the ordered set where groupId = &#63;.
	 *
	 * @param newsId the primary key of the current news
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news
	 * @throws com.rknowsys.eapp.hrm.NoSuchNewsException if a news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public News[] findByGroupId_PrevAndNext(long newsId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchNewsException, SystemException {
		News news = findByPrimaryKey(newsId);

		Session session = null;

		try {
			session = openSession();

			News[] array = new NewsImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, news, groupId,
					orderByComparator, true);

			array[1] = news;

			array[2] = getByGroupId_PrevAndNext(session, news, groupId,
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

	protected News getByGroupId_PrevAndNext(Session session, News news,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NEWS_WHERE);

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
			query.append(NewsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(news);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<News> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the newses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (News news : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(news);
		}
	}

	/**
	 * Returns the number of newses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching newses
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

			query.append(_SQL_COUNT_NEWS_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "news.groupId = ?";

	public NewsPersistenceImpl() {
		setModelClass(News.class);
	}

	/**
	 * Caches the news in the entity cache if it is enabled.
	 *
	 * @param news the news
	 */
	@Override
	public void cacheResult(News news) {
		EntityCacheUtil.putResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
			NewsImpl.class, news.getPrimaryKey(), news);

		news.resetOriginalValues();
	}

	/**
	 * Caches the newses in the entity cache if it is enabled.
	 *
	 * @param newses the newses
	 */
	@Override
	public void cacheResult(List<News> newses) {
		for (News news : newses) {
			if (EntityCacheUtil.getResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
						NewsImpl.class, news.getPrimaryKey()) == null) {
				cacheResult(news);
			}
			else {
				news.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all newses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NewsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NewsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the news.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(News news) {
		EntityCacheUtil.removeResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
			NewsImpl.class, news.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<News> newses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (News news : newses) {
			EntityCacheUtil.removeResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
				NewsImpl.class, news.getPrimaryKey());
		}
	}

	/**
	 * Creates a new news with the primary key. Does not add the news to the database.
	 *
	 * @param newsId the primary key for the new news
	 * @return the new news
	 */
	@Override
	public News create(long newsId) {
		News news = new NewsImpl();

		news.setNew(true);
		news.setPrimaryKey(newsId);

		return news;
	}

	/**
	 * Removes the news with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsId the primary key of the news
	 * @return the news that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchNewsException if a news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public News remove(long newsId) throws NoSuchNewsException, SystemException {
		return remove((Serializable)newsId);
	}

	/**
	 * Removes the news with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the news
	 * @return the news that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchNewsException if a news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public News remove(Serializable primaryKey)
		throws NoSuchNewsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			News news = (News)session.get(NewsImpl.class, primaryKey);

			if (news == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNewsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(news);
		}
		catch (NoSuchNewsException nsee) {
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
	protected News removeImpl(News news) throws SystemException {
		news = toUnwrappedModel(news);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(news)) {
				news = (News)session.get(NewsImpl.class, news.getPrimaryKeyObj());
			}

			if (news != null) {
				session.delete(news);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (news != null) {
			clearCache(news);
		}

		return news;
	}

	@Override
	public News updateImpl(com.rknowsys.eapp.hrm.model.News news)
		throws SystemException {
		news = toUnwrappedModel(news);

		boolean isNew = news.isNew();

		NewsModelImpl newsModelImpl = (NewsModelImpl)news;

		Session session = null;

		try {
			session = openSession();

			if (news.isNew()) {
				session.save(news);

				news.setNew(false);
			}
			else {
				session.merge(news);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NewsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((newsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { newsModelImpl.getOriginalGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { newsModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
			NewsImpl.class, news.getPrimaryKey(), news);

		return news;
	}

	protected News toUnwrappedModel(News news) {
		if (news instanceof NewsImpl) {
			return news;
		}

		NewsImpl newsImpl = new NewsImpl();

		newsImpl.setNew(news.isNew());
		newsImpl.setPrimaryKey(news.getPrimaryKey());

		newsImpl.setNewsId(news.getNewsId());
		newsImpl.setCompanyId(news.getCompanyId());
		newsImpl.setGroupId(news.getGroupId());
		newsImpl.setCreateDate(news.getCreateDate());
		newsImpl.setModifiedDate(news.getModifiedDate());
		newsImpl.setUserId(news.getUserId());
		newsImpl.setTopic(news.getTopic());
		newsImpl.setDescription(news.getDescription());
		newsImpl.setPublishTo(news.getPublishTo());
		newsImpl.setPublishDate(news.getPublishDate());

		return newsImpl;
	}

	/**
	 * Returns the news with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the news
	 * @return the news
	 * @throws com.rknowsys.eapp.hrm.NoSuchNewsException if a news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public News findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNewsException, SystemException {
		News news = fetchByPrimaryKey(primaryKey);

		if (news == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNewsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return news;
	}

	/**
	 * Returns the news with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchNewsException} if it could not be found.
	 *
	 * @param newsId the primary key of the news
	 * @return the news
	 * @throws com.rknowsys.eapp.hrm.NoSuchNewsException if a news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public News findByPrimaryKey(long newsId)
		throws NoSuchNewsException, SystemException {
		return findByPrimaryKey((Serializable)newsId);
	}

	/**
	 * Returns the news with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the news
	 * @return the news, or <code>null</code> if a news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public News fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		News news = (News)EntityCacheUtil.getResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
				NewsImpl.class, primaryKey);

		if (news == _nullNews) {
			return null;
		}

		if (news == null) {
			Session session = null;

			try {
				session = openSession();

				news = (News)session.get(NewsImpl.class, primaryKey);

				if (news != null) {
					cacheResult(news);
				}
				else {
					EntityCacheUtil.putResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
						NewsImpl.class, primaryKey, _nullNews);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
					NewsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return news;
	}

	/**
	 * Returns the news with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsId the primary key of the news
	 * @return the news, or <code>null</code> if a news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public News fetchByPrimaryKey(long newsId) throws SystemException {
		return fetchByPrimaryKey((Serializable)newsId);
	}

	/**
	 * Returns all the newses.
	 *
	 * @return the newses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<News> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.NewsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of newses
	 * @param end the upper bound of the range of newses (not inclusive)
	 * @return the range of newses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<News> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the newses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.NewsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of newses
	 * @param end the upper bound of the range of newses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of newses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<News> findAll(int start, int end,
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

		List<News> list = (List<News>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NEWS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NEWS;

				if (pagination) {
					sql = sql.concat(NewsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<News>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<News>(list);
				}
				else {
					list = (List<News>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the newses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (News news : findAll()) {
			remove(news);
		}
	}

	/**
	 * Returns the number of newses.
	 *
	 * @return the number of newses
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

				Query q = session.createQuery(_SQL_COUNT_NEWS);

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
	 * Initializes the news persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.News")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<News>> listenersList = new ArrayList<ModelListener<News>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<News>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NewsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NEWS = "SELECT news FROM News news";
	private static final String _SQL_SELECT_NEWS_WHERE = "SELECT news FROM News news WHERE ";
	private static final String _SQL_COUNT_NEWS = "SELECT COUNT(news) FROM News news";
	private static final String _SQL_COUNT_NEWS_WHERE = "SELECT COUNT(news) FROM News news WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "news.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No News exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No News exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NewsPersistenceImpl.class);
	private static News _nullNews = new NewsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<News> toCacheModel() {
				return _nullNewsCacheModel;
			}
		};

	private static CacheModel<News> _nullNewsCacheModel = new CacheModel<News>() {
			@Override
			public News toEntityModel() {
				return _nullNews;
			}
		};
}