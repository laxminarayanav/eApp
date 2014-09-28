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

package com.rknowsys.eapp.hrm.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.rknowsys.eapp.hrm.model.AttachmentClp;
import com.rknowsys.eapp.hrm.model.ContactDetailsClp;
import com.rknowsys.eapp.hrm.model.DependentClp;
import com.rknowsys.eapp.hrm.model.DocCategoryClp;
import com.rknowsys.eapp.hrm.model.EducationClp;
import com.rknowsys.eapp.hrm.model.EmergencyContactClp;
import com.rknowsys.eapp.hrm.model.EmployeeClp;
import com.rknowsys.eapp.hrm.model.EmploymentStatusClp;
import com.rknowsys.eapp.hrm.model.ImmigrationDocumentClp;
import com.rknowsys.eapp.hrm.model.InterviewClp;
import com.rknowsys.eapp.hrm.model.JobCategoryClp;
import com.rknowsys.eapp.hrm.model.JobClp;
import com.rknowsys.eapp.hrm.model.JobTitleClp;
import com.rknowsys.eapp.hrm.model.LanguageClp;
import com.rknowsys.eapp.hrm.model.LicenseClp;
import com.rknowsys.eapp.hrm.model.LocationClp;
import com.rknowsys.eapp.hrm.model.MembershipClp;
import com.rknowsys.eapp.hrm.model.NationalityClp;
import com.rknowsys.eapp.hrm.model.NewsClp;
import com.rknowsys.eapp.hrm.model.OrganizationClp;
import com.rknowsys.eapp.hrm.model.PayGradeClp;
import com.rknowsys.eapp.hrm.model.PayGradeCurrencyClp;
import com.rknowsys.eapp.hrm.model.SalaryComponentClp;
import com.rknowsys.eapp.hrm.model.SkillClp;
import com.rknowsys.eapp.hrm.model.SubUnitClp;
import com.rknowsys.eapp.hrm.model.SupervisorClp;
import com.rknowsys.eapp.hrm.model.WorkExpCompanyClp;
import com.rknowsys.eapp.hrm.model.WorkshiftClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rknowsys
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"services-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"services-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "services-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AttachmentClp.class.getName())) {
			return translateInputAttachment(oldModel);
		}

		if (oldModelClassName.equals(ContactDetailsClp.class.getName())) {
			return translateInputContactDetails(oldModel);
		}

		if (oldModelClassName.equals(DependentClp.class.getName())) {
			return translateInputDependent(oldModel);
		}

		if (oldModelClassName.equals(DocCategoryClp.class.getName())) {
			return translateInputDocCategory(oldModel);
		}

		if (oldModelClassName.equals(EducationClp.class.getName())) {
			return translateInputEducation(oldModel);
		}

		if (oldModelClassName.equals(EmergencyContactClp.class.getName())) {
			return translateInputEmergencyContact(oldModel);
		}

		if (oldModelClassName.equals(EmployeeClp.class.getName())) {
			return translateInputEmployee(oldModel);
		}

		if (oldModelClassName.equals(EmploymentStatusClp.class.getName())) {
			return translateInputEmploymentStatus(oldModel);
		}

		if (oldModelClassName.equals(ImmigrationDocumentClp.class.getName())) {
			return translateInputImmigrationDocument(oldModel);
		}

		if (oldModelClassName.equals(InterviewClp.class.getName())) {
			return translateInputInterview(oldModel);
		}

		if (oldModelClassName.equals(JobClp.class.getName())) {
			return translateInputJob(oldModel);
		}

		if (oldModelClassName.equals(JobCategoryClp.class.getName())) {
			return translateInputJobCategory(oldModel);
		}

		if (oldModelClassName.equals(JobTitleClp.class.getName())) {
			return translateInputJobTitle(oldModel);
		}

		if (oldModelClassName.equals(LanguageClp.class.getName())) {
			return translateInputLanguage(oldModel);
		}

		if (oldModelClassName.equals(LicenseClp.class.getName())) {
			return translateInputLicense(oldModel);
		}

		if (oldModelClassName.equals(LocationClp.class.getName())) {
			return translateInputLocation(oldModel);
		}

		if (oldModelClassName.equals(MembershipClp.class.getName())) {
			return translateInputMembership(oldModel);
		}

		if (oldModelClassName.equals(NationalityClp.class.getName())) {
			return translateInputNationality(oldModel);
		}

		if (oldModelClassName.equals(NewsClp.class.getName())) {
			return translateInputNews(oldModel);
		}

		if (oldModelClassName.equals(OrganizationClp.class.getName())) {
			return translateInputOrganization(oldModel);
		}

		if (oldModelClassName.equals(PayGradeClp.class.getName())) {
			return translateInputPayGrade(oldModel);
		}

		if (oldModelClassName.equals(PayGradeCurrencyClp.class.getName())) {
			return translateInputPayGradeCurrency(oldModel);
		}

		if (oldModelClassName.equals(SalaryComponentClp.class.getName())) {
			return translateInputSalaryComponent(oldModel);
		}

		if (oldModelClassName.equals(SkillClp.class.getName())) {
			return translateInputSkill(oldModel);
		}

		if (oldModelClassName.equals(SubUnitClp.class.getName())) {
			return translateInputSubUnit(oldModel);
		}

		if (oldModelClassName.equals(SupervisorClp.class.getName())) {
			return translateInputSupervisor(oldModel);
		}

		if (oldModelClassName.equals(WorkExpCompanyClp.class.getName())) {
			return translateInputWorkExpCompany(oldModel);
		}

		if (oldModelClassName.equals(WorkshiftClp.class.getName())) {
			return translateInputWorkshift(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAttachment(BaseModel<?> oldModel) {
		AttachmentClp oldClpModel = (AttachmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAttachmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContactDetails(BaseModel<?> oldModel) {
		ContactDetailsClp oldClpModel = (ContactDetailsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContactDetailsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDependent(BaseModel<?> oldModel) {
		DependentClp oldClpModel = (DependentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDependentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDocCategory(BaseModel<?> oldModel) {
		DocCategoryClp oldClpModel = (DocCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDocCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEducation(BaseModel<?> oldModel) {
		EducationClp oldClpModel = (EducationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEducationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmergencyContact(BaseModel<?> oldModel) {
		EmergencyContactClp oldClpModel = (EmergencyContactClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmergencyContactRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmployee(BaseModel<?> oldModel) {
		EmployeeClp oldClpModel = (EmployeeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmployeeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmploymentStatus(BaseModel<?> oldModel) {
		EmploymentStatusClp oldClpModel = (EmploymentStatusClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmploymentStatusRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputImmigrationDocument(
		BaseModel<?> oldModel) {
		ImmigrationDocumentClp oldClpModel = (ImmigrationDocumentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getImmigrationDocumentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputInterview(BaseModel<?> oldModel) {
		InterviewClp oldClpModel = (InterviewClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInterviewRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJob(BaseModel<?> oldModel) {
		JobClp oldClpModel = (JobClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJobRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJobCategory(BaseModel<?> oldModel) {
		JobCategoryClp oldClpModel = (JobCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJobCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJobTitle(BaseModel<?> oldModel) {
		JobTitleClp oldClpModel = (JobTitleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJobTitleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLanguage(BaseModel<?> oldModel) {
		LanguageClp oldClpModel = (LanguageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLanguageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLicense(BaseModel<?> oldModel) {
		LicenseClp oldClpModel = (LicenseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLicenseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLocation(BaseModel<?> oldModel) {
		LocationClp oldClpModel = (LocationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLocationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMembership(BaseModel<?> oldModel) {
		MembershipClp oldClpModel = (MembershipClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMembershipRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNationality(BaseModel<?> oldModel) {
		NationalityClp oldClpModel = (NationalityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNationalityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNews(BaseModel<?> oldModel) {
		NewsClp oldClpModel = (NewsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNewsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrganization(BaseModel<?> oldModel) {
		OrganizationClp oldClpModel = (OrganizationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrganizationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPayGrade(BaseModel<?> oldModel) {
		PayGradeClp oldClpModel = (PayGradeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPayGradeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPayGradeCurrency(BaseModel<?> oldModel) {
		PayGradeCurrencyClp oldClpModel = (PayGradeCurrencyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPayGradeCurrencyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSalaryComponent(BaseModel<?> oldModel) {
		SalaryComponentClp oldClpModel = (SalaryComponentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSalaryComponentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSkill(BaseModel<?> oldModel) {
		SkillClp oldClpModel = (SkillClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSkillRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSubUnit(BaseModel<?> oldModel) {
		SubUnitClp oldClpModel = (SubUnitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSubUnitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSupervisor(BaseModel<?> oldModel) {
		SupervisorClp oldClpModel = (SupervisorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSupervisorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkExpCompany(BaseModel<?> oldModel) {
		WorkExpCompanyClp oldClpModel = (WorkExpCompanyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkExpCompanyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkshift(BaseModel<?> oldModel) {
		WorkshiftClp oldClpModel = (WorkshiftClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkshiftRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.AttachmentImpl")) {
			return translateOutputAttachment(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.ContactDetailsImpl")) {
			return translateOutputContactDetails(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.DependentImpl")) {
			return translateOutputDependent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.DocCategoryImpl")) {
			return translateOutputDocCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EducationImpl")) {
			return translateOutputEducation(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmergencyContactImpl")) {
			return translateOutputEmergencyContact(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmployeeImpl")) {
			return translateOutputEmployee(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmploymentStatusImpl")) {
			return translateOutputEmploymentStatus(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentImpl")) {
			return translateOutputImmigrationDocument(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.InterviewImpl")) {
			return translateOutputInterview(oldModel);
		}

		if (oldModelClassName.equals("com.rknowsys.eapp.hrm.model.impl.JobImpl")) {
			return translateOutputJob(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.JobCategoryImpl")) {
			return translateOutputJobCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.JobTitleImpl")) {
			return translateOutputJobTitle(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LanguageImpl")) {
			return translateOutputLanguage(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LicenseImpl")) {
			return translateOutputLicense(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LocationImpl")) {
			return translateOutputLocation(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.MembershipImpl")) {
			return translateOutputMembership(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.NationalityImpl")) {
			return translateOutputNationality(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.NewsImpl")) {
			return translateOutputNews(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.OrganizationImpl")) {
			return translateOutputOrganization(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.PayGradeImpl")) {
			return translateOutputPayGrade(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.PayGradeCurrencyImpl")) {
			return translateOutputPayGradeCurrency(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.SalaryComponentImpl")) {
			return translateOutputSalaryComponent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.SkillImpl")) {
			return translateOutputSkill(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.SubUnitImpl")) {
			return translateOutputSubUnit(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.SupervisorImpl")) {
			return translateOutputSupervisor(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.WorkExpCompanyImpl")) {
			return translateOutputWorkExpCompany(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.WorkshiftImpl")) {
			return translateOutputWorkshift(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchAttachmentException")) {
			return new com.rknowsys.eapp.hrm.NoSuchAttachmentException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchContactDetailsException")) {
			return new com.rknowsys.eapp.hrm.NoSuchContactDetailsException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchDependentException")) {
			return new com.rknowsys.eapp.hrm.NoSuchDependentException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchDocCategoryException")) {
			return new com.rknowsys.eapp.hrm.NoSuchDocCategoryException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchEducationException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEducationException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmergencyContactException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmergencyContactException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchEmployeeException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmployeeException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException")) {
			return new com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchInterviewException")) {
			return new com.rknowsys.eapp.hrm.NoSuchInterviewException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchJobException")) {
			return new com.rknowsys.eapp.hrm.NoSuchJobException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchJobCategoryException")) {
			return new com.rknowsys.eapp.hrm.NoSuchJobCategoryException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchJobTitleException")) {
			return new com.rknowsys.eapp.hrm.NoSuchJobTitleException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchLanguageException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLanguageException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchLicenseException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLicenseException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchLocationException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLocationException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchMembershipException")) {
			return new com.rknowsys.eapp.hrm.NoSuchMembershipException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchNationalityException")) {
			return new com.rknowsys.eapp.hrm.NoSuchNationalityException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchNewsException")) {
			return new com.rknowsys.eapp.hrm.NoSuchNewsException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchOrganizationException")) {
			return new com.rknowsys.eapp.hrm.NoSuchOrganizationException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchPayGradeException")) {
			return new com.rknowsys.eapp.hrm.NoSuchPayGradeException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException")) {
			return new com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchSalaryComponentException")) {
			return new com.rknowsys.eapp.hrm.NoSuchSalaryComponentException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchSkillException")) {
			return new com.rknowsys.eapp.hrm.NoSuchSkillException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchSubUnitException")) {
			return new com.rknowsys.eapp.hrm.NoSuchSubUnitException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchSupervisorException")) {
			return new com.rknowsys.eapp.hrm.NoSuchSupervisorException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException")) {
			return new com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchWorkshiftException")) {
			return new com.rknowsys.eapp.hrm.NoSuchWorkshiftException();
		}

		return throwable;
	}

	public static Object translateOutputAttachment(BaseModel<?> oldModel) {
		AttachmentClp newModel = new AttachmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAttachmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContactDetails(BaseModel<?> oldModel) {
		ContactDetailsClp newModel = new ContactDetailsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContactDetailsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDependent(BaseModel<?> oldModel) {
		DependentClp newModel = new DependentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDependentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDocCategory(BaseModel<?> oldModel) {
		DocCategoryClp newModel = new DocCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDocCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEducation(BaseModel<?> oldModel) {
		EducationClp newModel = new EducationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEducationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmergencyContact(BaseModel<?> oldModel) {
		EmergencyContactClp newModel = new EmergencyContactClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmergencyContactRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmployee(BaseModel<?> oldModel) {
		EmployeeClp newModel = new EmployeeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmployeeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmploymentStatus(BaseModel<?> oldModel) {
		EmploymentStatusClp newModel = new EmploymentStatusClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmploymentStatusRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputImmigrationDocument(
		BaseModel<?> oldModel) {
		ImmigrationDocumentClp newModel = new ImmigrationDocumentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setImmigrationDocumentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputInterview(BaseModel<?> oldModel) {
		InterviewClp newModel = new InterviewClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInterviewRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJob(BaseModel<?> oldModel) {
		JobClp newModel = new JobClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJobRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJobCategory(BaseModel<?> oldModel) {
		JobCategoryClp newModel = new JobCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJobCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJobTitle(BaseModel<?> oldModel) {
		JobTitleClp newModel = new JobTitleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJobTitleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLanguage(BaseModel<?> oldModel) {
		LanguageClp newModel = new LanguageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLanguageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLicense(BaseModel<?> oldModel) {
		LicenseClp newModel = new LicenseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLicenseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLocation(BaseModel<?> oldModel) {
		LocationClp newModel = new LocationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLocationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMembership(BaseModel<?> oldModel) {
		MembershipClp newModel = new MembershipClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMembershipRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNationality(BaseModel<?> oldModel) {
		NationalityClp newModel = new NationalityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNationalityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNews(BaseModel<?> oldModel) {
		NewsClp newModel = new NewsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNewsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrganization(BaseModel<?> oldModel) {
		OrganizationClp newModel = new OrganizationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrganizationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPayGrade(BaseModel<?> oldModel) {
		PayGradeClp newModel = new PayGradeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPayGradeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPayGradeCurrency(BaseModel<?> oldModel) {
		PayGradeCurrencyClp newModel = new PayGradeCurrencyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPayGradeCurrencyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSalaryComponent(BaseModel<?> oldModel) {
		SalaryComponentClp newModel = new SalaryComponentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSalaryComponentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSkill(BaseModel<?> oldModel) {
		SkillClp newModel = new SkillClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSkillRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSubUnit(BaseModel<?> oldModel) {
		SubUnitClp newModel = new SubUnitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSubUnitRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSupervisor(BaseModel<?> oldModel) {
		SupervisorClp newModel = new SupervisorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSupervisorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkExpCompany(BaseModel<?> oldModel) {
		WorkExpCompanyClp newModel = new WorkExpCompanyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkExpCompanyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkshift(BaseModel<?> oldModel) {
		WorkshiftClp newModel = new WorkshiftClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkshiftRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}