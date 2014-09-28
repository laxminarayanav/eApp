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

package com.rknowsys.eapp.hrm.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.rknowsys.eapp.hrm.service.AttachmentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.ClpSerializer;
import com.rknowsys.eapp.hrm.service.ContactDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.DependentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.DocCategoryLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EducationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmergencyContactLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.ImmigrationDocumentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.InterviewLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobCategoryLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobTitleLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LanguageLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LicenseLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LocationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.MembershipLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.NationalityLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.NewsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.OrganizationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.PayGradeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SalaryComponentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SkillLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SubUnitLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SupervisorLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.WorkExpCompanyLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.WorkshiftLocalServiceUtil;

/**
 * @author rknowsys
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AttachmentLocalServiceUtil.clearService();

			ContactDetailsLocalServiceUtil.clearService();

			DependentLocalServiceUtil.clearService();

			DocCategoryLocalServiceUtil.clearService();

			EducationLocalServiceUtil.clearService();

			EmergencyContactLocalServiceUtil.clearService();

			EmployeeLocalServiceUtil.clearService();

			EmploymentStatusLocalServiceUtil.clearService();

			ImmigrationDocumentLocalServiceUtil.clearService();

			InterviewLocalServiceUtil.clearService();

			JobLocalServiceUtil.clearService();

			JobCategoryLocalServiceUtil.clearService();

			JobTitleLocalServiceUtil.clearService();

			LanguageLocalServiceUtil.clearService();

			LicenseLocalServiceUtil.clearService();

			LocationLocalServiceUtil.clearService();

			MembershipLocalServiceUtil.clearService();

			NationalityLocalServiceUtil.clearService();

			NewsLocalServiceUtil.clearService();

			OrganizationLocalServiceUtil.clearService();

			PayGradeLocalServiceUtil.clearService();

			PayGradeCurrencyLocalServiceUtil.clearService();

			SalaryComponentLocalServiceUtil.clearService();

			SkillLocalServiceUtil.clearService();

			SubUnitLocalServiceUtil.clearService();

			SupervisorLocalServiceUtil.clearService();

			WorkExpCompanyLocalServiceUtil.clearService();

			WorkshiftLocalServiceUtil.clearService();
		}
	}
}