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

package com.rknowsys.eapp.hrm.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rknowsys.eapp.hrm.model.News;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing News in entity cache.
 *
 * @author rknowsys
 * @see News
 * @generated
 */
public class NewsCacheModel implements CacheModel<News>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{newsId=");
		sb.append(newsId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", topic=");
		sb.append(topic);
		sb.append(", description=");
		sb.append(description);
		sb.append(", publishTo=");
		sb.append(publishTo);
		sb.append(", publishDate=");
		sb.append(publishDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public News toEntityModel() {
		NewsImpl newsImpl = new NewsImpl();

		newsImpl.setNewsId(newsId);
		newsImpl.setCompanyId(companyId);
		newsImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			newsImpl.setCreateDate(null);
		}
		else {
			newsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			newsImpl.setModifiedDate(null);
		}
		else {
			newsImpl.setModifiedDate(new Date(modifiedDate));
		}

		newsImpl.setUserId(userId);

		if (topic == null) {
			newsImpl.setTopic(StringPool.BLANK);
		}
		else {
			newsImpl.setTopic(topic);
		}

		if (description == null) {
			newsImpl.setDescription(StringPool.BLANK);
		}
		else {
			newsImpl.setDescription(description);
		}

		if (publishTo == null) {
			newsImpl.setPublishTo(StringPool.BLANK);
		}
		else {
			newsImpl.setPublishTo(publishTo);
		}

		if (publishDate == Long.MIN_VALUE) {
			newsImpl.setPublishDate(null);
		}
		else {
			newsImpl.setPublishDate(new Date(publishDate));
		}

		newsImpl.resetOriginalValues();

		return newsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		newsId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		topic = objectInput.readUTF();
		description = objectInput.readUTF();
		publishTo = objectInput.readUTF();
		publishDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(newsId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (topic == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(topic);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (publishTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishTo);
		}

		objectOutput.writeLong(publishDate);
	}

	public long newsId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String topic;
	public String description;
	public String publishTo;
	public long publishDate;
}