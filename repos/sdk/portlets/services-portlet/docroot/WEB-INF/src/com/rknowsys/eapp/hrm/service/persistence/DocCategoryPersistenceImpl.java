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

import com.rknowsys.eapp.hrm.NoSuchDocCategoryException;
import com.rknowsys.eapp.hrm.model.DocCategory;
import com.rknowsys.eapp.hrm.model.impl.DocCategoryImpl;
import com.rknowsys.eapp.hrm.model.impl.DocCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the doc category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see DocCategoryPersistence
 * @see DocCategoryUtil
 * @generated
 */
public class DocCategoryPersistenceImpl extends BasePersistenceImpl<DocCategory>
	implements DocCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DocCategoryUtil} to access the doc category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DocCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
			DocCategoryModelImpl.FINDER_CACHE_ENABLED, DocCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
			DocCategoryModelImpl.FINDER_CACHE_ENABLED, DocCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
			DocCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
			DocCategoryModelImpl.FINDER_CACHE_ENABLED, DocCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
			DocCategoryModelImpl.FINDER_CACHE_ENABLED, DocCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			DocCategoryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
			DocCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the doc categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching doc categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocCategory> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doc categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of doc categories
	 * @param end the upper bound of the range of doc categories (not inclusive)
	 * @return the range of matching doc categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocCategory> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the doc categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of doc categories
	 * @param end the upper bound of the range of doc categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doc categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocCategory> findByGroupId(long groupId, int start, int end,
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

		List<DocCategory> list = (List<DocCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DocCategory docCategory : list) {
				if ((groupId != docCategory.getGroupId())) {
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

			query.append(_SQL_SELECT_DOCCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DocCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<DocCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DocCategory>(list);
				}
				else {
					list = (List<DocCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first doc category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc category
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocCategoryException if a matching doc category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocCategory findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDocCategoryException, SystemException {
		DocCategory docCategory = fetchByGroupId_First(groupId,
				orderByComparator);

		if (docCategory != null) {
			return docCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocCategoryException(msg.toString());
	}

	/**
	 * Returns the first doc category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doc category, or <code>null</code> if a matching doc category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocCategory fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DocCategory> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last doc category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc category
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocCategoryException if a matching doc category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocCategory findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDocCategoryException, SystemException {
		DocCategory docCategory = fetchByGroupId_Last(groupId, orderByComparator);

		if (docCategory != null) {
			return docCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocCategoryException(msg.toString());
	}

	/**
	 * Returns the last doc category in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doc category, or <code>null</code> if a matching doc category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocCategory fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<DocCategory> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the doc categories before and after the current doc category in the ordered set where groupId = &#63;.
	 *
	 * @param docCategoryId the primary key of the current doc category
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doc category
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocCategoryException if a doc category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocCategory[] findByGroupId_PrevAndNext(long docCategoryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchDocCategoryException, SystemException {
		DocCategory docCategory = findByPrimaryKey(docCategoryId);

		Session session = null;

		try {
			session = openSession();

			DocCategory[] array = new DocCategoryImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, docCategory, groupId,
					orderByComparator, true);

			array[1] = docCategory;

			array[2] = getByGroupId_PrevAndNext(session, docCategory, groupId,
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

	protected DocCategory getByGroupId_PrevAndNext(Session session,
		DocCategory docCategory, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCCATEGORY_WHERE);

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
			query.append(DocCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(docCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DocCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the doc categories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (DocCategory docCategory : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(docCategory);
		}
	}

	/**
	 * Returns the number of doc categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching doc categories
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

			query.append(_SQL_COUNT_DOCCATEGORY_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "docCategory.groupId = ?";

	public DocCategoryPersistenceImpl() {
		setModelClass(DocCategory.class);
	}

	/**
	 * Caches the doc category in the entity cache if it is enabled.
	 *
	 * @param docCategory the doc category
	 */
	@Override
	public void cacheResult(DocCategory docCategory) {
		EntityCacheUtil.putResult(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
			DocCategoryImpl.class, docCategory.getPrimaryKey(), docCategory);

		docCategory.resetOriginalValues();
	}

	/**
	 * Caches the doc categories in the entity cache if it is enabled.
	 *
	 * @param docCategories the doc categories
	 */
	@Override
	public void cacheResult(List<DocCategory> docCategories) {
		for (DocCategory docCategory : docCategories) {
			if (EntityCacheUtil.getResult(
						DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
						DocCategoryImpl.class, docCategory.getPrimaryKey()) == null) {
				cacheResult(docCategory);
			}
			else {
				docCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all doc categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DocCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DocCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the doc category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocCategory docCategory) {
		EntityCacheUtil.removeResult(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
			DocCategoryImpl.class, docCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DocCategory> docCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DocCategory docCategory : docCategories) {
			EntityCacheUtil.removeResult(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
				DocCategoryImpl.class, docCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new doc category with the primary key. Does not add the doc category to the database.
	 *
	 * @param docCategoryId the primary key for the new doc category
	 * @return the new doc category
	 */
	@Override
	public DocCategory create(long docCategoryId) {
		DocCategory docCategory = new DocCategoryImpl();

		docCategory.setNew(true);
		docCategory.setPrimaryKey(docCategoryId);

		return docCategory;
	}

	/**
	 * Removes the doc category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param docCategoryId the primary key of the doc category
	 * @return the doc category that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocCategoryException if a doc category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocCategory remove(long docCategoryId)
		throws NoSuchDocCategoryException, SystemException {
		return remove((Serializable)docCategoryId);
	}

	/**
	 * Removes the doc category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the doc category
	 * @return the doc category that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocCategoryException if a doc category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocCategory remove(Serializable primaryKey)
		throws NoSuchDocCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DocCategory docCategory = (DocCategory)session.get(DocCategoryImpl.class,
					primaryKey);

			if (docCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(docCategory);
		}
		catch (NoSuchDocCategoryException nsee) {
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
	protected DocCategory removeImpl(DocCategory docCategory)
		throws SystemException {
		docCategory = toUnwrappedModel(docCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(docCategory)) {
				docCategory = (DocCategory)session.get(DocCategoryImpl.class,
						docCategory.getPrimaryKeyObj());
			}

			if (docCategory != null) {
				session.delete(docCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (docCategory != null) {
			clearCache(docCategory);
		}

		return docCategory;
	}

	@Override
	public DocCategory updateImpl(
		com.rknowsys.eapp.hrm.model.DocCategory docCategory)
		throws SystemException {
		docCategory = toUnwrappedModel(docCategory);

		boolean isNew = docCategory.isNew();

		DocCategoryModelImpl docCategoryModelImpl = (DocCategoryModelImpl)docCategory;

		Session session = null;

		try {
			session = openSession();

			if (docCategory.isNew()) {
				session.save(docCategory);

				docCategory.setNew(false);
			}
			else {
				session.merge(docCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DocCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((docCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						docCategoryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { docCategoryModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
			DocCategoryImpl.class, docCategory.getPrimaryKey(), docCategory);

		return docCategory;
	}

	protected DocCategory toUnwrappedModel(DocCategory docCategory) {
		if (docCategory instanceof DocCategoryImpl) {
			return docCategory;
		}

		DocCategoryImpl docCategoryImpl = new DocCategoryImpl();

		docCategoryImpl.setNew(docCategory.isNew());
		docCategoryImpl.setPrimaryKey(docCategory.getPrimaryKey());

		docCategoryImpl.setDocCategoryId(docCategory.getDocCategoryId());
		docCategoryImpl.setCompanyId(docCategory.getCompanyId());
		docCategoryImpl.setGroupId(docCategory.getGroupId());
		docCategoryImpl.setCreateDate(docCategory.getCreateDate());
		docCategoryImpl.setModifiedDate(docCategory.getModifiedDate());
		docCategoryImpl.setUserId(docCategory.getUserId());
		docCategoryImpl.setDocName(docCategory.getDocName());

		return docCategoryImpl;
	}

	/**
	 * Returns the doc category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the doc category
	 * @return the doc category
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocCategoryException if a doc category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocCategoryException, SystemException {
		DocCategory docCategory = fetchByPrimaryKey(primaryKey);

		if (docCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return docCategory;
	}

	/**
	 * Returns the doc category with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchDocCategoryException} if it could not be found.
	 *
	 * @param docCategoryId the primary key of the doc category
	 * @return the doc category
	 * @throws com.rknowsys.eapp.hrm.NoSuchDocCategoryException if a doc category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocCategory findByPrimaryKey(long docCategoryId)
		throws NoSuchDocCategoryException, SystemException {
		return findByPrimaryKey((Serializable)docCategoryId);
	}

	/**
	 * Returns the doc category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the doc category
	 * @return the doc category, or <code>null</code> if a doc category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DocCategory docCategory = (DocCategory)EntityCacheUtil.getResult(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
				DocCategoryImpl.class, primaryKey);

		if (docCategory == _nullDocCategory) {
			return null;
		}

		if (docCategory == null) {
			Session session = null;

			try {
				session = openSession();

				docCategory = (DocCategory)session.get(DocCategoryImpl.class,
						primaryKey);

				if (docCategory != null) {
					cacheResult(docCategory);
				}
				else {
					EntityCacheUtil.putResult(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
						DocCategoryImpl.class, primaryKey, _nullDocCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DocCategoryModelImpl.ENTITY_CACHE_ENABLED,
					DocCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return docCategory;
	}

	/**
	 * Returns the doc category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param docCategoryId the primary key of the doc category
	 * @return the doc category, or <code>null</code> if a doc category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DocCategory fetchByPrimaryKey(long docCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)docCategoryId);
	}

	/**
	 * Returns all the doc categories.
	 *
	 * @return the doc categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doc categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc categories
	 * @param end the upper bound of the range of doc categories (not inclusive)
	 * @return the range of doc categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the doc categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DocCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc categories
	 * @param end the upper bound of the range of doc categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of doc categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DocCategory> findAll(int start, int end,
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

		List<DocCategory> list = (List<DocCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOCCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCCATEGORY;

				if (pagination) {
					sql = sql.concat(DocCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DocCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DocCategory>(list);
				}
				else {
					list = (List<DocCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the doc categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DocCategory docCategory : findAll()) {
			remove(docCategory);
		}
	}

	/**
	 * Returns the number of doc categories.
	 *
	 * @return the number of doc categories
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

				Query q = session.createQuery(_SQL_COUNT_DOCCATEGORY);

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
	 * Initializes the doc category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.DocCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DocCategory>> listenersList = new ArrayList<ModelListener<DocCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DocCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DocCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DOCCATEGORY = "SELECT docCategory FROM DocCategory docCategory";
	private static final String _SQL_SELECT_DOCCATEGORY_WHERE = "SELECT docCategory FROM DocCategory docCategory WHERE ";
	private static final String _SQL_COUNT_DOCCATEGORY = "SELECT COUNT(docCategory) FROM DocCategory docCategory";
	private static final String _SQL_COUNT_DOCCATEGORY_WHERE = "SELECT COUNT(docCategory) FROM DocCategory docCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "docCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DocCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DocCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DocCategoryPersistenceImpl.class);
	private static DocCategory _nullDocCategory = new DocCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DocCategory> toCacheModel() {
				return _nullDocCategoryCacheModel;
			}
		};

	private static CacheModel<DocCategory> _nullDocCategoryCacheModel = new CacheModel<DocCategory>() {
			@Override
			public DocCategory toEntityModel() {
				return _nullDocCategory;
			}
		};
}