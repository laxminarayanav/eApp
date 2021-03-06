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

package com.rknowsys.eapp.hrm.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rknowsys.eapp.hrm.model.EmpPersonalDetails;
import com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalService;
import com.rknowsys.eapp.hrm.service.persistence.DocCategoryPersistence;
import com.rknowsys.eapp.hrm.service.persistence.DocumentCategoriesPersistence;
import com.rknowsys.eapp.hrm.service.persistence.DocumentsAttachmentsPersistence;
import com.rknowsys.eapp.hrm.service.persistence.DocumentsFinder;
import com.rknowsys.eapp.hrm.service.persistence.DocumentsPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EducationPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpAttachmentPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpContactDetailsPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpDependentPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpDetailsFinder;
import com.rknowsys.eapp.hrm.service.persistence.EmpDetailsPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpDirectDepositPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpEducationPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpEmergencyContactPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpImmigrationDocumentPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpJobFinder;
import com.rknowsys.eapp.hrm.service.persistence.EmpJobPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpLanguagePersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpLicensePersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpMembershipPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpPersonalDetailsFinder;
import com.rknowsys.eapp.hrm.service.persistence.EmpPersonalDetailsPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpSalaryComponentPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpSalaryPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpSkillPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpSubordinatePersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpSupervisorPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmpWorkExpPersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmployeePersistence;
import com.rknowsys.eapp.hrm.service.persistence.EmploymentStatusPersistence;
import com.rknowsys.eapp.hrm.service.persistence.HolidayFinder;
import com.rknowsys.eapp.hrm.service.persistence.HolidayPersistence;
import com.rknowsys.eapp.hrm.service.persistence.InterviewPersistence;
import com.rknowsys.eapp.hrm.service.persistence.JobCategoryPersistence;
import com.rknowsys.eapp.hrm.service.persistence.JobTitlePersistence;
import com.rknowsys.eapp.hrm.service.persistence.LanguagePersistence;
import com.rknowsys.eapp.hrm.service.persistence.LeaveAccrualPersistence;
import com.rknowsys.eapp.hrm.service.persistence.LeaveCarryForwardPolicyPersistence;
import com.rknowsys.eapp.hrm.service.persistence.LeaveGeneralPersistence;
import com.rknowsys.eapp.hrm.service.persistence.LeavePeriodPersistence;
import com.rknowsys.eapp.hrm.service.persistence.LeaveRestrictionPersistence;
import com.rknowsys.eapp.hrm.service.persistence.LeaveRuleApplicablePersistence;
import com.rknowsys.eapp.hrm.service.persistence.LeaveTypeEmployeeGroupsPersistence;
import com.rknowsys.eapp.hrm.service.persistence.LeaveTypePersistence;
import com.rknowsys.eapp.hrm.service.persistence.LicensePersistence;
import com.rknowsys.eapp.hrm.service.persistence.LocationPersistence;
import com.rknowsys.eapp.hrm.service.persistence.MembershipPersistence;
import com.rknowsys.eapp.hrm.service.persistence.NationalityPersistence;
import com.rknowsys.eapp.hrm.service.persistence.NewsAttachmentsPersistence;
import com.rknowsys.eapp.hrm.service.persistence.NewsFinder;
import com.rknowsys.eapp.hrm.service.persistence.NewsPersistence;
import com.rknowsys.eapp.hrm.service.persistence.OrganizationPersistence;
import com.rknowsys.eapp.hrm.service.persistence.PayGradeCurrencyPersistence;
import com.rknowsys.eapp.hrm.service.persistence.PayGradePersistence;
import com.rknowsys.eapp.hrm.service.persistence.ReportingMethodsPersistence;
import com.rknowsys.eapp.hrm.service.persistence.SalaryComponentPersistence;
import com.rknowsys.eapp.hrm.service.persistence.SkillPersistence;
import com.rknowsys.eapp.hrm.service.persistence.SubUnitPersistence;
import com.rknowsys.eapp.hrm.service.persistence.TerminationReasonsPersistence;
import com.rknowsys.eapp.hrm.service.persistence.WorkWeekPersistence;
import com.rknowsys.eapp.hrm.service.persistence.WorkshiftPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the EmpPersonalDetails local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rknowsys.eapp.hrm.service.impl.EmpPersonalDetailsLocalServiceImpl}.
 * </p>
 *
 * @author rknowsys
 * @see com.rknowsys.eapp.hrm.service.impl.EmpPersonalDetailsLocalServiceImpl
 * @see com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil
 * @generated
 */
public abstract class EmpPersonalDetailsLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements EmpPersonalDetailsLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil} to access the EmpPersonalDetails local service.
	 */

	/**
	 * Adds the EmpPersonalDetails to the database. Also notifies the appropriate model listeners.
	 *
	 * @param empPersonalDetails the EmpPersonalDetails
	 * @return the EmpPersonalDetails that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmpPersonalDetails addEmpPersonalDetails(
		EmpPersonalDetails empPersonalDetails) throws SystemException {
		empPersonalDetails.setNew(true);

		return empPersonalDetailsPersistence.update(empPersonalDetails);
	}

	/**
	 * Creates a new EmpPersonalDetails with the primary key. Does not add the EmpPersonalDetails to the database.
	 *
	 * @param empPersonalDetailsId the primary key for the new EmpPersonalDetails
	 * @return the new EmpPersonalDetails
	 */
	@Override
	public EmpPersonalDetails createEmpPersonalDetails(
		long empPersonalDetailsId) {
		return empPersonalDetailsPersistence.create(empPersonalDetailsId);
	}

	/**
	 * Deletes the EmpPersonalDetails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empPersonalDetailsId the primary key of the EmpPersonalDetails
	 * @return the EmpPersonalDetails that was removed
	 * @throws PortalException if a EmpPersonalDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmpPersonalDetails deleteEmpPersonalDetails(
		long empPersonalDetailsId) throws PortalException, SystemException {
		return empPersonalDetailsPersistence.remove(empPersonalDetailsId);
	}

	/**
	 * Deletes the EmpPersonalDetails from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empPersonalDetails the EmpPersonalDetails
	 * @return the EmpPersonalDetails that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmpPersonalDetails deleteEmpPersonalDetails(
		EmpPersonalDetails empPersonalDetails) throws SystemException {
		return empPersonalDetailsPersistence.remove(empPersonalDetails);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(EmpPersonalDetails.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return empPersonalDetailsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return empPersonalDetailsPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return empPersonalDetailsPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return empPersonalDetailsPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return empPersonalDetailsPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public EmpPersonalDetails fetchEmpPersonalDetails(long empPersonalDetailsId)
		throws SystemException {
		return empPersonalDetailsPersistence.fetchByPrimaryKey(empPersonalDetailsId);
	}

	/**
	 * Returns the EmpPersonalDetails with the primary key.
	 *
	 * @param empPersonalDetailsId the primary key of the EmpPersonalDetails
	 * @return the EmpPersonalDetails
	 * @throws PortalException if a EmpPersonalDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpPersonalDetails getEmpPersonalDetails(long empPersonalDetailsId)
		throws PortalException, SystemException {
		return empPersonalDetailsPersistence.findByPrimaryKey(empPersonalDetailsId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return empPersonalDetailsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the EmpPersonalDetailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmpPersonalDetailses
	 * @param end the upper bound of the range of EmpPersonalDetailses (not inclusive)
	 * @return the range of EmpPersonalDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpPersonalDetails> getEmpPersonalDetailses(int start, int end)
		throws SystemException {
		return empPersonalDetailsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of EmpPersonalDetailses.
	 *
	 * @return the number of EmpPersonalDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getEmpPersonalDetailsesCount() throws SystemException {
		return empPersonalDetailsPersistence.countAll();
	}

	/**
	 * Updates the EmpPersonalDetails in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param empPersonalDetails the EmpPersonalDetails
	 * @return the EmpPersonalDetails that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmpPersonalDetails updateEmpPersonalDetails(
		EmpPersonalDetails empPersonalDetails) throws SystemException {
		return empPersonalDetailsPersistence.update(empPersonalDetails);
	}

	/**
	 * Returns the doc category local service.
	 *
	 * @return the doc category local service
	 */
	public com.rknowsys.eapp.hrm.service.DocCategoryLocalService getDocCategoryLocalService() {
		return docCategoryLocalService;
	}

	/**
	 * Sets the doc category local service.
	 *
	 * @param docCategoryLocalService the doc category local service
	 */
	public void setDocCategoryLocalService(
		com.rknowsys.eapp.hrm.service.DocCategoryLocalService docCategoryLocalService) {
		this.docCategoryLocalService = docCategoryLocalService;
	}

	/**
	 * Returns the doc category persistence.
	 *
	 * @return the doc category persistence
	 */
	public DocCategoryPersistence getDocCategoryPersistence() {
		return docCategoryPersistence;
	}

	/**
	 * Sets the doc category persistence.
	 *
	 * @param docCategoryPersistence the doc category persistence
	 */
	public void setDocCategoryPersistence(
		DocCategoryPersistence docCategoryPersistence) {
		this.docCategoryPersistence = docCategoryPersistence;
	}

	/**
	 * Returns the document categories local service.
	 *
	 * @return the document categories local service
	 */
	public com.rknowsys.eapp.hrm.service.DocumentCategoriesLocalService getDocumentCategoriesLocalService() {
		return documentCategoriesLocalService;
	}

	/**
	 * Sets the document categories local service.
	 *
	 * @param documentCategoriesLocalService the document categories local service
	 */
	public void setDocumentCategoriesLocalService(
		com.rknowsys.eapp.hrm.service.DocumentCategoriesLocalService documentCategoriesLocalService) {
		this.documentCategoriesLocalService = documentCategoriesLocalService;
	}

	/**
	 * Returns the document categories persistence.
	 *
	 * @return the document categories persistence
	 */
	public DocumentCategoriesPersistence getDocumentCategoriesPersistence() {
		return documentCategoriesPersistence;
	}

	/**
	 * Sets the document categories persistence.
	 *
	 * @param documentCategoriesPersistence the document categories persistence
	 */
	public void setDocumentCategoriesPersistence(
		DocumentCategoriesPersistence documentCategoriesPersistence) {
		this.documentCategoriesPersistence = documentCategoriesPersistence;
	}

	/**
	 * Returns the documents local service.
	 *
	 * @return the documents local service
	 */
	public com.rknowsys.eapp.hrm.service.DocumentsLocalService getDocumentsLocalService() {
		return documentsLocalService;
	}

	/**
	 * Sets the documents local service.
	 *
	 * @param documentsLocalService the documents local service
	 */
	public void setDocumentsLocalService(
		com.rknowsys.eapp.hrm.service.DocumentsLocalService documentsLocalService) {
		this.documentsLocalService = documentsLocalService;
	}

	/**
	 * Returns the documents persistence.
	 *
	 * @return the documents persistence
	 */
	public DocumentsPersistence getDocumentsPersistence() {
		return documentsPersistence;
	}

	/**
	 * Sets the documents persistence.
	 *
	 * @param documentsPersistence the documents persistence
	 */
	public void setDocumentsPersistence(
		DocumentsPersistence documentsPersistence) {
		this.documentsPersistence = documentsPersistence;
	}

	/**
	 * Returns the documents finder.
	 *
	 * @return the documents finder
	 */
	public DocumentsFinder getDocumentsFinder() {
		return documentsFinder;
	}

	/**
	 * Sets the documents finder.
	 *
	 * @param documentsFinder the documents finder
	 */
	public void setDocumentsFinder(DocumentsFinder documentsFinder) {
		this.documentsFinder = documentsFinder;
	}

	/**
	 * Returns the documents attachments local service.
	 *
	 * @return the documents attachments local service
	 */
	public com.rknowsys.eapp.hrm.service.DocumentsAttachmentsLocalService getDocumentsAttachmentsLocalService() {
		return documentsAttachmentsLocalService;
	}

	/**
	 * Sets the documents attachments local service.
	 *
	 * @param documentsAttachmentsLocalService the documents attachments local service
	 */
	public void setDocumentsAttachmentsLocalService(
		com.rknowsys.eapp.hrm.service.DocumentsAttachmentsLocalService documentsAttachmentsLocalService) {
		this.documentsAttachmentsLocalService = documentsAttachmentsLocalService;
	}

	/**
	 * Returns the documents attachments persistence.
	 *
	 * @return the documents attachments persistence
	 */
	public DocumentsAttachmentsPersistence getDocumentsAttachmentsPersistence() {
		return documentsAttachmentsPersistence;
	}

	/**
	 * Sets the documents attachments persistence.
	 *
	 * @param documentsAttachmentsPersistence the documents attachments persistence
	 */
	public void setDocumentsAttachmentsPersistence(
		DocumentsAttachmentsPersistence documentsAttachmentsPersistence) {
		this.documentsAttachmentsPersistence = documentsAttachmentsPersistence;
	}

	/**
	 * Returns the education local service.
	 *
	 * @return the education local service
	 */
	public com.rknowsys.eapp.hrm.service.EducationLocalService getEducationLocalService() {
		return educationLocalService;
	}

	/**
	 * Sets the education local service.
	 *
	 * @param educationLocalService the education local service
	 */
	public void setEducationLocalService(
		com.rknowsys.eapp.hrm.service.EducationLocalService educationLocalService) {
		this.educationLocalService = educationLocalService;
	}

	/**
	 * Returns the education persistence.
	 *
	 * @return the education persistence
	 */
	public EducationPersistence getEducationPersistence() {
		return educationPersistence;
	}

	/**
	 * Sets the education persistence.
	 *
	 * @param educationPersistence the education persistence
	 */
	public void setEducationPersistence(
		EducationPersistence educationPersistence) {
		this.educationPersistence = educationPersistence;
	}

	/**
	 * Returns the EmpAttachment local service.
	 *
	 * @return the EmpAttachment local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpAttachmentLocalService getEmpAttachmentLocalService() {
		return empAttachmentLocalService;
	}

	/**
	 * Sets the EmpAttachment local service.
	 *
	 * @param empAttachmentLocalService the EmpAttachment local service
	 */
	public void setEmpAttachmentLocalService(
		com.rknowsys.eapp.hrm.service.EmpAttachmentLocalService empAttachmentLocalService) {
		this.empAttachmentLocalService = empAttachmentLocalService;
	}

	/**
	 * Returns the EmpAttachment persistence.
	 *
	 * @return the EmpAttachment persistence
	 */
	public EmpAttachmentPersistence getEmpAttachmentPersistence() {
		return empAttachmentPersistence;
	}

	/**
	 * Sets the EmpAttachment persistence.
	 *
	 * @param empAttachmentPersistence the EmpAttachment persistence
	 */
	public void setEmpAttachmentPersistence(
		EmpAttachmentPersistence empAttachmentPersistence) {
		this.empAttachmentPersistence = empAttachmentPersistence;
	}

	/**
	 * Returns the EmpContactDetails local service.
	 *
	 * @return the EmpContactDetails local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpContactDetailsLocalService getEmpContactDetailsLocalService() {
		return empContactDetailsLocalService;
	}

	/**
	 * Sets the EmpContactDetails local service.
	 *
	 * @param empContactDetailsLocalService the EmpContactDetails local service
	 */
	public void setEmpContactDetailsLocalService(
		com.rknowsys.eapp.hrm.service.EmpContactDetailsLocalService empContactDetailsLocalService) {
		this.empContactDetailsLocalService = empContactDetailsLocalService;
	}

	/**
	 * Returns the EmpContactDetails persistence.
	 *
	 * @return the EmpContactDetails persistence
	 */
	public EmpContactDetailsPersistence getEmpContactDetailsPersistence() {
		return empContactDetailsPersistence;
	}

	/**
	 * Sets the EmpContactDetails persistence.
	 *
	 * @param empContactDetailsPersistence the EmpContactDetails persistence
	 */
	public void setEmpContactDetailsPersistence(
		EmpContactDetailsPersistence empContactDetailsPersistence) {
		this.empContactDetailsPersistence = empContactDetailsPersistence;
	}

	/**
	 * Returns the emp dependent local service.
	 *
	 * @return the emp dependent local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpDependentLocalService getEmpDependentLocalService() {
		return empDependentLocalService;
	}

	/**
	 * Sets the emp dependent local service.
	 *
	 * @param empDependentLocalService the emp dependent local service
	 */
	public void setEmpDependentLocalService(
		com.rknowsys.eapp.hrm.service.EmpDependentLocalService empDependentLocalService) {
		this.empDependentLocalService = empDependentLocalService;
	}

	/**
	 * Returns the emp dependent persistence.
	 *
	 * @return the emp dependent persistence
	 */
	public EmpDependentPersistence getEmpDependentPersistence() {
		return empDependentPersistence;
	}

	/**
	 * Sets the emp dependent persistence.
	 *
	 * @param empDependentPersistence the emp dependent persistence
	 */
	public void setEmpDependentPersistence(
		EmpDependentPersistence empDependentPersistence) {
		this.empDependentPersistence = empDependentPersistence;
	}

	/**
	 * Returns the emp details local service.
	 *
	 * @return the emp details local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpDetailsLocalService getEmpDetailsLocalService() {
		return empDetailsLocalService;
	}

	/**
	 * Sets the emp details local service.
	 *
	 * @param empDetailsLocalService the emp details local service
	 */
	public void setEmpDetailsLocalService(
		com.rknowsys.eapp.hrm.service.EmpDetailsLocalService empDetailsLocalService) {
		this.empDetailsLocalService = empDetailsLocalService;
	}

	/**
	 * Returns the emp details persistence.
	 *
	 * @return the emp details persistence
	 */
	public EmpDetailsPersistence getEmpDetailsPersistence() {
		return empDetailsPersistence;
	}

	/**
	 * Sets the emp details persistence.
	 *
	 * @param empDetailsPersistence the emp details persistence
	 */
	public void setEmpDetailsPersistence(
		EmpDetailsPersistence empDetailsPersistence) {
		this.empDetailsPersistence = empDetailsPersistence;
	}

	/**
	 * Returns the emp details finder.
	 *
	 * @return the emp details finder
	 */
	public EmpDetailsFinder getEmpDetailsFinder() {
		return empDetailsFinder;
	}

	/**
	 * Sets the emp details finder.
	 *
	 * @param empDetailsFinder the emp details finder
	 */
	public void setEmpDetailsFinder(EmpDetailsFinder empDetailsFinder) {
		this.empDetailsFinder = empDetailsFinder;
	}

	/**
	 * Returns the emp direct deposit local service.
	 *
	 * @return the emp direct deposit local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpDirectDepositLocalService getEmpDirectDepositLocalService() {
		return empDirectDepositLocalService;
	}

	/**
	 * Sets the emp direct deposit local service.
	 *
	 * @param empDirectDepositLocalService the emp direct deposit local service
	 */
	public void setEmpDirectDepositLocalService(
		com.rknowsys.eapp.hrm.service.EmpDirectDepositLocalService empDirectDepositLocalService) {
		this.empDirectDepositLocalService = empDirectDepositLocalService;
	}

	/**
	 * Returns the emp direct deposit persistence.
	 *
	 * @return the emp direct deposit persistence
	 */
	public EmpDirectDepositPersistence getEmpDirectDepositPersistence() {
		return empDirectDepositPersistence;
	}

	/**
	 * Sets the emp direct deposit persistence.
	 *
	 * @param empDirectDepositPersistence the emp direct deposit persistence
	 */
	public void setEmpDirectDepositPersistence(
		EmpDirectDepositPersistence empDirectDepositPersistence) {
		this.empDirectDepositPersistence = empDirectDepositPersistence;
	}

	/**
	 * Returns the emp education local service.
	 *
	 * @return the emp education local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpEducationLocalService getEmpEducationLocalService() {
		return empEducationLocalService;
	}

	/**
	 * Sets the emp education local service.
	 *
	 * @param empEducationLocalService the emp education local service
	 */
	public void setEmpEducationLocalService(
		com.rknowsys.eapp.hrm.service.EmpEducationLocalService empEducationLocalService) {
		this.empEducationLocalService = empEducationLocalService;
	}

	/**
	 * Returns the emp education persistence.
	 *
	 * @return the emp education persistence
	 */
	public EmpEducationPersistence getEmpEducationPersistence() {
		return empEducationPersistence;
	}

	/**
	 * Sets the emp education persistence.
	 *
	 * @param empEducationPersistence the emp education persistence
	 */
	public void setEmpEducationPersistence(
		EmpEducationPersistence empEducationPersistence) {
		this.empEducationPersistence = empEducationPersistence;
	}

	/**
	 * Returns the EmpEmergencyContact local service.
	 *
	 * @return the EmpEmergencyContact local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpEmergencyContactLocalService getEmpEmergencyContactLocalService() {
		return empEmergencyContactLocalService;
	}

	/**
	 * Sets the EmpEmergencyContact local service.
	 *
	 * @param empEmergencyContactLocalService the EmpEmergencyContact local service
	 */
	public void setEmpEmergencyContactLocalService(
		com.rknowsys.eapp.hrm.service.EmpEmergencyContactLocalService empEmergencyContactLocalService) {
		this.empEmergencyContactLocalService = empEmergencyContactLocalService;
	}

	/**
	 * Returns the EmpEmergencyContact persistence.
	 *
	 * @return the EmpEmergencyContact persistence
	 */
	public EmpEmergencyContactPersistence getEmpEmergencyContactPersistence() {
		return empEmergencyContactPersistence;
	}

	/**
	 * Sets the EmpEmergencyContact persistence.
	 *
	 * @param empEmergencyContactPersistence the EmpEmergencyContact persistence
	 */
	public void setEmpEmergencyContactPersistence(
		EmpEmergencyContactPersistence empEmergencyContactPersistence) {
		this.empEmergencyContactPersistence = empEmergencyContactPersistence;
	}

	/**
	 * Returns the ImmigrationDocument local service.
	 *
	 * @return the ImmigrationDocument local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpImmigrationDocumentLocalService getEmpImmigrationDocumentLocalService() {
		return empImmigrationDocumentLocalService;
	}

	/**
	 * Sets the ImmigrationDocument local service.
	 *
	 * @param empImmigrationDocumentLocalService the ImmigrationDocument local service
	 */
	public void setEmpImmigrationDocumentLocalService(
		com.rknowsys.eapp.hrm.service.EmpImmigrationDocumentLocalService empImmigrationDocumentLocalService) {
		this.empImmigrationDocumentLocalService = empImmigrationDocumentLocalService;
	}

	/**
	 * Returns the ImmigrationDocument persistence.
	 *
	 * @return the ImmigrationDocument persistence
	 */
	public EmpImmigrationDocumentPersistence getEmpImmigrationDocumentPersistence() {
		return empImmigrationDocumentPersistence;
	}

	/**
	 * Sets the ImmigrationDocument persistence.
	 *
	 * @param empImmigrationDocumentPersistence the ImmigrationDocument persistence
	 */
	public void setEmpImmigrationDocumentPersistence(
		EmpImmigrationDocumentPersistence empImmigrationDocumentPersistence) {
		this.empImmigrationDocumentPersistence = empImmigrationDocumentPersistence;
	}

	/**
	 * Returns the emp job local service.
	 *
	 * @return the emp job local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpJobLocalService getEmpJobLocalService() {
		return empJobLocalService;
	}

	/**
	 * Sets the emp job local service.
	 *
	 * @param empJobLocalService the emp job local service
	 */
	public void setEmpJobLocalService(
		com.rknowsys.eapp.hrm.service.EmpJobLocalService empJobLocalService) {
		this.empJobLocalService = empJobLocalService;
	}

	/**
	 * Returns the emp job persistence.
	 *
	 * @return the emp job persistence
	 */
	public EmpJobPersistence getEmpJobPersistence() {
		return empJobPersistence;
	}

	/**
	 * Sets the emp job persistence.
	 *
	 * @param empJobPersistence the emp job persistence
	 */
	public void setEmpJobPersistence(EmpJobPersistence empJobPersistence) {
		this.empJobPersistence = empJobPersistence;
	}

	/**
	 * Returns the emp job finder.
	 *
	 * @return the emp job finder
	 */
	public EmpJobFinder getEmpJobFinder() {
		return empJobFinder;
	}

	/**
	 * Sets the emp job finder.
	 *
	 * @param empJobFinder the emp job finder
	 */
	public void setEmpJobFinder(EmpJobFinder empJobFinder) {
		this.empJobFinder = empJobFinder;
	}

	/**
	 * Returns the emp language local service.
	 *
	 * @return the emp language local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpLanguageLocalService getEmpLanguageLocalService() {
		return empLanguageLocalService;
	}

	/**
	 * Sets the emp language local service.
	 *
	 * @param empLanguageLocalService the emp language local service
	 */
	public void setEmpLanguageLocalService(
		com.rknowsys.eapp.hrm.service.EmpLanguageLocalService empLanguageLocalService) {
		this.empLanguageLocalService = empLanguageLocalService;
	}

	/**
	 * Returns the emp language persistence.
	 *
	 * @return the emp language persistence
	 */
	public EmpLanguagePersistence getEmpLanguagePersistence() {
		return empLanguagePersistence;
	}

	/**
	 * Sets the emp language persistence.
	 *
	 * @param empLanguagePersistence the emp language persistence
	 */
	public void setEmpLanguagePersistence(
		EmpLanguagePersistence empLanguagePersistence) {
		this.empLanguagePersistence = empLanguagePersistence;
	}

	/**
	 * Returns the emp license local service.
	 *
	 * @return the emp license local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpLicenseLocalService getEmpLicenseLocalService() {
		return empLicenseLocalService;
	}

	/**
	 * Sets the emp license local service.
	 *
	 * @param empLicenseLocalService the emp license local service
	 */
	public void setEmpLicenseLocalService(
		com.rknowsys.eapp.hrm.service.EmpLicenseLocalService empLicenseLocalService) {
		this.empLicenseLocalService = empLicenseLocalService;
	}

	/**
	 * Returns the emp license persistence.
	 *
	 * @return the emp license persistence
	 */
	public EmpLicensePersistence getEmpLicensePersistence() {
		return empLicensePersistence;
	}

	/**
	 * Sets the emp license persistence.
	 *
	 * @param empLicensePersistence the emp license persistence
	 */
	public void setEmpLicensePersistence(
		EmpLicensePersistence empLicensePersistence) {
		this.empLicensePersistence = empLicensePersistence;
	}

	/**
	 * Returns the Employee local service.
	 *
	 * @return the Employee local service
	 */
	public com.rknowsys.eapp.hrm.service.EmployeeLocalService getEmployeeLocalService() {
		return employeeLocalService;
	}

	/**
	 * Sets the Employee local service.
	 *
	 * @param employeeLocalService the Employee local service
	 */
	public void setEmployeeLocalService(
		com.rknowsys.eapp.hrm.service.EmployeeLocalService employeeLocalService) {
		this.employeeLocalService = employeeLocalService;
	}

	/**
	 * Returns the Employee persistence.
	 *
	 * @return the Employee persistence
	 */
	public EmployeePersistence getEmployeePersistence() {
		return employeePersistence;
	}

	/**
	 * Sets the Employee persistence.
	 *
	 * @param employeePersistence the Employee persistence
	 */
	public void setEmployeePersistence(EmployeePersistence employeePersistence) {
		this.employeePersistence = employeePersistence;
	}

	/**
	 * Returns the employment status local service.
	 *
	 * @return the employment status local service
	 */
	public com.rknowsys.eapp.hrm.service.EmploymentStatusLocalService getEmploymentStatusLocalService() {
		return employmentStatusLocalService;
	}

	/**
	 * Sets the employment status local service.
	 *
	 * @param employmentStatusLocalService the employment status local service
	 */
	public void setEmploymentStatusLocalService(
		com.rknowsys.eapp.hrm.service.EmploymentStatusLocalService employmentStatusLocalService) {
		this.employmentStatusLocalService = employmentStatusLocalService;
	}

	/**
	 * Returns the employment status persistence.
	 *
	 * @return the employment status persistence
	 */
	public EmploymentStatusPersistence getEmploymentStatusPersistence() {
		return employmentStatusPersistence;
	}

	/**
	 * Sets the employment status persistence.
	 *
	 * @param employmentStatusPersistence the employment status persistence
	 */
	public void setEmploymentStatusPersistence(
		EmploymentStatusPersistence employmentStatusPersistence) {
		this.employmentStatusPersistence = employmentStatusPersistence;
	}

	/**
	 * Returns the emp membership local service.
	 *
	 * @return the emp membership local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpMembershipLocalService getEmpMembershipLocalService() {
		return empMembershipLocalService;
	}

	/**
	 * Sets the emp membership local service.
	 *
	 * @param empMembershipLocalService the emp membership local service
	 */
	public void setEmpMembershipLocalService(
		com.rknowsys.eapp.hrm.service.EmpMembershipLocalService empMembershipLocalService) {
		this.empMembershipLocalService = empMembershipLocalService;
	}

	/**
	 * Returns the emp membership persistence.
	 *
	 * @return the emp membership persistence
	 */
	public EmpMembershipPersistence getEmpMembershipPersistence() {
		return empMembershipPersistence;
	}

	/**
	 * Sets the emp membership persistence.
	 *
	 * @param empMembershipPersistence the emp membership persistence
	 */
	public void setEmpMembershipPersistence(
		EmpMembershipPersistence empMembershipPersistence) {
		this.empMembershipPersistence = empMembershipPersistence;
	}

	/**
	 * Returns the EmpPersonalDetails local service.
	 *
	 * @return the EmpPersonalDetails local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalService getEmpPersonalDetailsLocalService() {
		return empPersonalDetailsLocalService;
	}

	/**
	 * Sets the EmpPersonalDetails local service.
	 *
	 * @param empPersonalDetailsLocalService the EmpPersonalDetails local service
	 */
	public void setEmpPersonalDetailsLocalService(
		com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalService empPersonalDetailsLocalService) {
		this.empPersonalDetailsLocalService = empPersonalDetailsLocalService;
	}

	/**
	 * Returns the EmpPersonalDetails persistence.
	 *
	 * @return the EmpPersonalDetails persistence
	 */
	public EmpPersonalDetailsPersistence getEmpPersonalDetailsPersistence() {
		return empPersonalDetailsPersistence;
	}

	/**
	 * Sets the EmpPersonalDetails persistence.
	 *
	 * @param empPersonalDetailsPersistence the EmpPersonalDetails persistence
	 */
	public void setEmpPersonalDetailsPersistence(
		EmpPersonalDetailsPersistence empPersonalDetailsPersistence) {
		this.empPersonalDetailsPersistence = empPersonalDetailsPersistence;
	}

	/**
	 * Returns the EmpPersonalDetails finder.
	 *
	 * @return the EmpPersonalDetails finder
	 */
	public EmpPersonalDetailsFinder getEmpPersonalDetailsFinder() {
		return empPersonalDetailsFinder;
	}

	/**
	 * Sets the EmpPersonalDetails finder.
	 *
	 * @param empPersonalDetailsFinder the EmpPersonalDetails finder
	 */
	public void setEmpPersonalDetailsFinder(
		EmpPersonalDetailsFinder empPersonalDetailsFinder) {
		this.empPersonalDetailsFinder = empPersonalDetailsFinder;
	}

	/**
	 * Returns the emp salary local service.
	 *
	 * @return the emp salary local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpSalaryLocalService getEmpSalaryLocalService() {
		return empSalaryLocalService;
	}

	/**
	 * Sets the emp salary local service.
	 *
	 * @param empSalaryLocalService the emp salary local service
	 */
	public void setEmpSalaryLocalService(
		com.rknowsys.eapp.hrm.service.EmpSalaryLocalService empSalaryLocalService) {
		this.empSalaryLocalService = empSalaryLocalService;
	}

	/**
	 * Returns the emp salary persistence.
	 *
	 * @return the emp salary persistence
	 */
	public EmpSalaryPersistence getEmpSalaryPersistence() {
		return empSalaryPersistence;
	}

	/**
	 * Sets the emp salary persistence.
	 *
	 * @param empSalaryPersistence the emp salary persistence
	 */
	public void setEmpSalaryPersistence(
		EmpSalaryPersistence empSalaryPersistence) {
		this.empSalaryPersistence = empSalaryPersistence;
	}

	/**
	 * Returns the emp salary component local service.
	 *
	 * @return the emp salary component local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpSalaryComponentLocalService getEmpSalaryComponentLocalService() {
		return empSalaryComponentLocalService;
	}

	/**
	 * Sets the emp salary component local service.
	 *
	 * @param empSalaryComponentLocalService the emp salary component local service
	 */
	public void setEmpSalaryComponentLocalService(
		com.rknowsys.eapp.hrm.service.EmpSalaryComponentLocalService empSalaryComponentLocalService) {
		this.empSalaryComponentLocalService = empSalaryComponentLocalService;
	}

	/**
	 * Returns the emp salary component persistence.
	 *
	 * @return the emp salary component persistence
	 */
	public EmpSalaryComponentPersistence getEmpSalaryComponentPersistence() {
		return empSalaryComponentPersistence;
	}

	/**
	 * Sets the emp salary component persistence.
	 *
	 * @param empSalaryComponentPersistence the emp salary component persistence
	 */
	public void setEmpSalaryComponentPersistence(
		EmpSalaryComponentPersistence empSalaryComponentPersistence) {
		this.empSalaryComponentPersistence = empSalaryComponentPersistence;
	}

	/**
	 * Returns the emp skill local service.
	 *
	 * @return the emp skill local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpSkillLocalService getEmpSkillLocalService() {
		return empSkillLocalService;
	}

	/**
	 * Sets the emp skill local service.
	 *
	 * @param empSkillLocalService the emp skill local service
	 */
	public void setEmpSkillLocalService(
		com.rknowsys.eapp.hrm.service.EmpSkillLocalService empSkillLocalService) {
		this.empSkillLocalService = empSkillLocalService;
	}

	/**
	 * Returns the emp skill persistence.
	 *
	 * @return the emp skill persistence
	 */
	public EmpSkillPersistence getEmpSkillPersistence() {
		return empSkillPersistence;
	}

	/**
	 * Sets the emp skill persistence.
	 *
	 * @param empSkillPersistence the emp skill persistence
	 */
	public void setEmpSkillPersistence(EmpSkillPersistence empSkillPersistence) {
		this.empSkillPersistence = empSkillPersistence;
	}

	/**
	 * Returns the EmpSubordinate local service.
	 *
	 * @return the EmpSubordinate local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpSubordinateLocalService getEmpSubordinateLocalService() {
		return empSubordinateLocalService;
	}

	/**
	 * Sets the EmpSubordinate local service.
	 *
	 * @param empSubordinateLocalService the EmpSubordinate local service
	 */
	public void setEmpSubordinateLocalService(
		com.rknowsys.eapp.hrm.service.EmpSubordinateLocalService empSubordinateLocalService) {
		this.empSubordinateLocalService = empSubordinateLocalService;
	}

	/**
	 * Returns the EmpSubordinate persistence.
	 *
	 * @return the EmpSubordinate persistence
	 */
	public EmpSubordinatePersistence getEmpSubordinatePersistence() {
		return empSubordinatePersistence;
	}

	/**
	 * Sets the EmpSubordinate persistence.
	 *
	 * @param empSubordinatePersistence the EmpSubordinate persistence
	 */
	public void setEmpSubordinatePersistence(
		EmpSubordinatePersistence empSubordinatePersistence) {
		this.empSubordinatePersistence = empSubordinatePersistence;
	}

	/**
	 * Returns the EmpSupervisor local service.
	 *
	 * @return the EmpSupervisor local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpSupervisorLocalService getEmpSupervisorLocalService() {
		return empSupervisorLocalService;
	}

	/**
	 * Sets the EmpSupervisor local service.
	 *
	 * @param empSupervisorLocalService the EmpSupervisor local service
	 */
	public void setEmpSupervisorLocalService(
		com.rknowsys.eapp.hrm.service.EmpSupervisorLocalService empSupervisorLocalService) {
		this.empSupervisorLocalService = empSupervisorLocalService;
	}

	/**
	 * Returns the EmpSupervisor persistence.
	 *
	 * @return the EmpSupervisor persistence
	 */
	public EmpSupervisorPersistence getEmpSupervisorPersistence() {
		return empSupervisorPersistence;
	}

	/**
	 * Sets the EmpSupervisor persistence.
	 *
	 * @param empSupervisorPersistence the EmpSupervisor persistence
	 */
	public void setEmpSupervisorPersistence(
		EmpSupervisorPersistence empSupervisorPersistence) {
		this.empSupervisorPersistence = empSupervisorPersistence;
	}

	/**
	 * Returns the EmpWorkExp local service.
	 *
	 * @return the EmpWorkExp local service
	 */
	public com.rknowsys.eapp.hrm.service.EmpWorkExpLocalService getEmpWorkExpLocalService() {
		return empWorkExpLocalService;
	}

	/**
	 * Sets the EmpWorkExp local service.
	 *
	 * @param empWorkExpLocalService the EmpWorkExp local service
	 */
	public void setEmpWorkExpLocalService(
		com.rknowsys.eapp.hrm.service.EmpWorkExpLocalService empWorkExpLocalService) {
		this.empWorkExpLocalService = empWorkExpLocalService;
	}

	/**
	 * Returns the EmpWorkExp persistence.
	 *
	 * @return the EmpWorkExp persistence
	 */
	public EmpWorkExpPersistence getEmpWorkExpPersistence() {
		return empWorkExpPersistence;
	}

	/**
	 * Sets the EmpWorkExp persistence.
	 *
	 * @param empWorkExpPersistence the EmpWorkExp persistence
	 */
	public void setEmpWorkExpPersistence(
		EmpWorkExpPersistence empWorkExpPersistence) {
		this.empWorkExpPersistence = empWorkExpPersistence;
	}

	/**
	 * Returns the Holiday local service.
	 *
	 * @return the Holiday local service
	 */
	public com.rknowsys.eapp.hrm.service.HolidayLocalService getHolidayLocalService() {
		return holidayLocalService;
	}

	/**
	 * Sets the Holiday local service.
	 *
	 * @param holidayLocalService the Holiday local service
	 */
	public void setHolidayLocalService(
		com.rknowsys.eapp.hrm.service.HolidayLocalService holidayLocalService) {
		this.holidayLocalService = holidayLocalService;
	}

	/**
	 * Returns the Holiday persistence.
	 *
	 * @return the Holiday persistence
	 */
	public HolidayPersistence getHolidayPersistence() {
		return holidayPersistence;
	}

	/**
	 * Sets the Holiday persistence.
	 *
	 * @param holidayPersistence the Holiday persistence
	 */
	public void setHolidayPersistence(HolidayPersistence holidayPersistence) {
		this.holidayPersistence = holidayPersistence;
	}

	/**
	 * Returns the Holiday finder.
	 *
	 * @return the Holiday finder
	 */
	public HolidayFinder getHolidayFinder() {
		return holidayFinder;
	}

	/**
	 * Sets the Holiday finder.
	 *
	 * @param holidayFinder the Holiday finder
	 */
	public void setHolidayFinder(HolidayFinder holidayFinder) {
		this.holidayFinder = holidayFinder;
	}

	/**
	 * Returns the interview local service.
	 *
	 * @return the interview local service
	 */
	public com.rknowsys.eapp.hrm.service.InterviewLocalService getInterviewLocalService() {
		return interviewLocalService;
	}

	/**
	 * Sets the interview local service.
	 *
	 * @param interviewLocalService the interview local service
	 */
	public void setInterviewLocalService(
		com.rknowsys.eapp.hrm.service.InterviewLocalService interviewLocalService) {
		this.interviewLocalService = interviewLocalService;
	}

	/**
	 * Returns the interview persistence.
	 *
	 * @return the interview persistence
	 */
	public InterviewPersistence getInterviewPersistence() {
		return interviewPersistence;
	}

	/**
	 * Sets the interview persistence.
	 *
	 * @param interviewPersistence the interview persistence
	 */
	public void setInterviewPersistence(
		InterviewPersistence interviewPersistence) {
		this.interviewPersistence = interviewPersistence;
	}

	/**
	 * Returns the job category local service.
	 *
	 * @return the job category local service
	 */
	public com.rknowsys.eapp.hrm.service.JobCategoryLocalService getJobCategoryLocalService() {
		return jobCategoryLocalService;
	}

	/**
	 * Sets the job category local service.
	 *
	 * @param jobCategoryLocalService the job category local service
	 */
	public void setJobCategoryLocalService(
		com.rknowsys.eapp.hrm.service.JobCategoryLocalService jobCategoryLocalService) {
		this.jobCategoryLocalService = jobCategoryLocalService;
	}

	/**
	 * Returns the job category persistence.
	 *
	 * @return the job category persistence
	 */
	public JobCategoryPersistence getJobCategoryPersistence() {
		return jobCategoryPersistence;
	}

	/**
	 * Sets the job category persistence.
	 *
	 * @param jobCategoryPersistence the job category persistence
	 */
	public void setJobCategoryPersistence(
		JobCategoryPersistence jobCategoryPersistence) {
		this.jobCategoryPersistence = jobCategoryPersistence;
	}

	/**
	 * Returns the job title local service.
	 *
	 * @return the job title local service
	 */
	public com.rknowsys.eapp.hrm.service.JobTitleLocalService getJobTitleLocalService() {
		return jobTitleLocalService;
	}

	/**
	 * Sets the job title local service.
	 *
	 * @param jobTitleLocalService the job title local service
	 */
	public void setJobTitleLocalService(
		com.rknowsys.eapp.hrm.service.JobTitleLocalService jobTitleLocalService) {
		this.jobTitleLocalService = jobTitleLocalService;
	}

	/**
	 * Returns the job title persistence.
	 *
	 * @return the job title persistence
	 */
	public JobTitlePersistence getJobTitlePersistence() {
		return jobTitlePersistence;
	}

	/**
	 * Sets the job title persistence.
	 *
	 * @param jobTitlePersistence the job title persistence
	 */
	public void setJobTitlePersistence(JobTitlePersistence jobTitlePersistence) {
		this.jobTitlePersistence = jobTitlePersistence;
	}

	/**
	 * Returns the language local service.
	 *
	 * @return the language local service
	 */
	public com.rknowsys.eapp.hrm.service.LanguageLocalService getLanguageLocalService() {
		return languageLocalService;
	}

	/**
	 * Sets the language local service.
	 *
	 * @param languageLocalService the language local service
	 */
	public void setLanguageLocalService(
		com.rknowsys.eapp.hrm.service.LanguageLocalService languageLocalService) {
		this.languageLocalService = languageLocalService;
	}

	/**
	 * Returns the language persistence.
	 *
	 * @return the language persistence
	 */
	public LanguagePersistence getLanguagePersistence() {
		return languagePersistence;
	}

	/**
	 * Sets the language persistence.
	 *
	 * @param languagePersistence the language persistence
	 */
	public void setLanguagePersistence(LanguagePersistence languagePersistence) {
		this.languagePersistence = languagePersistence;
	}

	/**
	 * Returns the leave accrual local service.
	 *
	 * @return the leave accrual local service
	 */
	public com.rknowsys.eapp.hrm.service.LeaveAccrualLocalService getLeaveAccrualLocalService() {
		return leaveAccrualLocalService;
	}

	/**
	 * Sets the leave accrual local service.
	 *
	 * @param leaveAccrualLocalService the leave accrual local service
	 */
	public void setLeaveAccrualLocalService(
		com.rknowsys.eapp.hrm.service.LeaveAccrualLocalService leaveAccrualLocalService) {
		this.leaveAccrualLocalService = leaveAccrualLocalService;
	}

	/**
	 * Returns the leave accrual persistence.
	 *
	 * @return the leave accrual persistence
	 */
	public LeaveAccrualPersistence getLeaveAccrualPersistence() {
		return leaveAccrualPersistence;
	}

	/**
	 * Sets the leave accrual persistence.
	 *
	 * @param leaveAccrualPersistence the leave accrual persistence
	 */
	public void setLeaveAccrualPersistence(
		LeaveAccrualPersistence leaveAccrualPersistence) {
		this.leaveAccrualPersistence = leaveAccrualPersistence;
	}

	/**
	 * Returns the leave carry forward policy local service.
	 *
	 * @return the leave carry forward policy local service
	 */
	public com.rknowsys.eapp.hrm.service.LeaveCarryForwardPolicyLocalService getLeaveCarryForwardPolicyLocalService() {
		return leaveCarryForwardPolicyLocalService;
	}

	/**
	 * Sets the leave carry forward policy local service.
	 *
	 * @param leaveCarryForwardPolicyLocalService the leave carry forward policy local service
	 */
	public void setLeaveCarryForwardPolicyLocalService(
		com.rknowsys.eapp.hrm.service.LeaveCarryForwardPolicyLocalService leaveCarryForwardPolicyLocalService) {
		this.leaveCarryForwardPolicyLocalService = leaveCarryForwardPolicyLocalService;
	}

	/**
	 * Returns the leave carry forward policy persistence.
	 *
	 * @return the leave carry forward policy persistence
	 */
	public LeaveCarryForwardPolicyPersistence getLeaveCarryForwardPolicyPersistence() {
		return leaveCarryForwardPolicyPersistence;
	}

	/**
	 * Sets the leave carry forward policy persistence.
	 *
	 * @param leaveCarryForwardPolicyPersistence the leave carry forward policy persistence
	 */
	public void setLeaveCarryForwardPolicyPersistence(
		LeaveCarryForwardPolicyPersistence leaveCarryForwardPolicyPersistence) {
		this.leaveCarryForwardPolicyPersistence = leaveCarryForwardPolicyPersistence;
	}

	/**
	 * Returns the leave general local service.
	 *
	 * @return the leave general local service
	 */
	public com.rknowsys.eapp.hrm.service.LeaveGeneralLocalService getLeaveGeneralLocalService() {
		return leaveGeneralLocalService;
	}

	/**
	 * Sets the leave general local service.
	 *
	 * @param leaveGeneralLocalService the leave general local service
	 */
	public void setLeaveGeneralLocalService(
		com.rknowsys.eapp.hrm.service.LeaveGeneralLocalService leaveGeneralLocalService) {
		this.leaveGeneralLocalService = leaveGeneralLocalService;
	}

	/**
	 * Returns the leave general persistence.
	 *
	 * @return the leave general persistence
	 */
	public LeaveGeneralPersistence getLeaveGeneralPersistence() {
		return leaveGeneralPersistence;
	}

	/**
	 * Sets the leave general persistence.
	 *
	 * @param leaveGeneralPersistence the leave general persistence
	 */
	public void setLeaveGeneralPersistence(
		LeaveGeneralPersistence leaveGeneralPersistence) {
		this.leaveGeneralPersistence = leaveGeneralPersistence;
	}

	/**
	 * Returns the leave period local service.
	 *
	 * @return the leave period local service
	 */
	public com.rknowsys.eapp.hrm.service.LeavePeriodLocalService getLeavePeriodLocalService() {
		return leavePeriodLocalService;
	}

	/**
	 * Sets the leave period local service.
	 *
	 * @param leavePeriodLocalService the leave period local service
	 */
	public void setLeavePeriodLocalService(
		com.rknowsys.eapp.hrm.service.LeavePeriodLocalService leavePeriodLocalService) {
		this.leavePeriodLocalService = leavePeriodLocalService;
	}

	/**
	 * Returns the leave period persistence.
	 *
	 * @return the leave period persistence
	 */
	public LeavePeriodPersistence getLeavePeriodPersistence() {
		return leavePeriodPersistence;
	}

	/**
	 * Sets the leave period persistence.
	 *
	 * @param leavePeriodPersistence the leave period persistence
	 */
	public void setLeavePeriodPersistence(
		LeavePeriodPersistence leavePeriodPersistence) {
		this.leavePeriodPersistence = leavePeriodPersistence;
	}

	/**
	 * Returns the leave restriction local service.
	 *
	 * @return the leave restriction local service
	 */
	public com.rknowsys.eapp.hrm.service.LeaveRestrictionLocalService getLeaveRestrictionLocalService() {
		return leaveRestrictionLocalService;
	}

	/**
	 * Sets the leave restriction local service.
	 *
	 * @param leaveRestrictionLocalService the leave restriction local service
	 */
	public void setLeaveRestrictionLocalService(
		com.rknowsys.eapp.hrm.service.LeaveRestrictionLocalService leaveRestrictionLocalService) {
		this.leaveRestrictionLocalService = leaveRestrictionLocalService;
	}

	/**
	 * Returns the leave restriction persistence.
	 *
	 * @return the leave restriction persistence
	 */
	public LeaveRestrictionPersistence getLeaveRestrictionPersistence() {
		return leaveRestrictionPersistence;
	}

	/**
	 * Sets the leave restriction persistence.
	 *
	 * @param leaveRestrictionPersistence the leave restriction persistence
	 */
	public void setLeaveRestrictionPersistence(
		LeaveRestrictionPersistence leaveRestrictionPersistence) {
		this.leaveRestrictionPersistence = leaveRestrictionPersistence;
	}

	/**
	 * Returns the leave rule applicable local service.
	 *
	 * @return the leave rule applicable local service
	 */
	public com.rknowsys.eapp.hrm.service.LeaveRuleApplicableLocalService getLeaveRuleApplicableLocalService() {
		return leaveRuleApplicableLocalService;
	}

	/**
	 * Sets the leave rule applicable local service.
	 *
	 * @param leaveRuleApplicableLocalService the leave rule applicable local service
	 */
	public void setLeaveRuleApplicableLocalService(
		com.rknowsys.eapp.hrm.service.LeaveRuleApplicableLocalService leaveRuleApplicableLocalService) {
		this.leaveRuleApplicableLocalService = leaveRuleApplicableLocalService;
	}

	/**
	 * Returns the leave rule applicable persistence.
	 *
	 * @return the leave rule applicable persistence
	 */
	public LeaveRuleApplicablePersistence getLeaveRuleApplicablePersistence() {
		return leaveRuleApplicablePersistence;
	}

	/**
	 * Sets the leave rule applicable persistence.
	 *
	 * @param leaveRuleApplicablePersistence the leave rule applicable persistence
	 */
	public void setLeaveRuleApplicablePersistence(
		LeaveRuleApplicablePersistence leaveRuleApplicablePersistence) {
		this.leaveRuleApplicablePersistence = leaveRuleApplicablePersistence;
	}

	/**
	 * Returns the leave type local service.
	 *
	 * @return the leave type local service
	 */
	public com.rknowsys.eapp.hrm.service.LeaveTypeLocalService getLeaveTypeLocalService() {
		return leaveTypeLocalService;
	}

	/**
	 * Sets the leave type local service.
	 *
	 * @param leaveTypeLocalService the leave type local service
	 */
	public void setLeaveTypeLocalService(
		com.rknowsys.eapp.hrm.service.LeaveTypeLocalService leaveTypeLocalService) {
		this.leaveTypeLocalService = leaveTypeLocalService;
	}

	/**
	 * Returns the leave type persistence.
	 *
	 * @return the leave type persistence
	 */
	public LeaveTypePersistence getLeaveTypePersistence() {
		return leaveTypePersistence;
	}

	/**
	 * Sets the leave type persistence.
	 *
	 * @param leaveTypePersistence the leave type persistence
	 */
	public void setLeaveTypePersistence(
		LeaveTypePersistence leaveTypePersistence) {
		this.leaveTypePersistence = leaveTypePersistence;
	}

	/**
	 * Returns the leave type employee groups local service.
	 *
	 * @return the leave type employee groups local service
	 */
	public com.rknowsys.eapp.hrm.service.LeaveTypeEmployeeGroupsLocalService getLeaveTypeEmployeeGroupsLocalService() {
		return leaveTypeEmployeeGroupsLocalService;
	}

	/**
	 * Sets the leave type employee groups local service.
	 *
	 * @param leaveTypeEmployeeGroupsLocalService the leave type employee groups local service
	 */
	public void setLeaveTypeEmployeeGroupsLocalService(
		com.rknowsys.eapp.hrm.service.LeaveTypeEmployeeGroupsLocalService leaveTypeEmployeeGroupsLocalService) {
		this.leaveTypeEmployeeGroupsLocalService = leaveTypeEmployeeGroupsLocalService;
	}

	/**
	 * Returns the leave type employee groups persistence.
	 *
	 * @return the leave type employee groups persistence
	 */
	public LeaveTypeEmployeeGroupsPersistence getLeaveTypeEmployeeGroupsPersistence() {
		return leaveTypeEmployeeGroupsPersistence;
	}

	/**
	 * Sets the leave type employee groups persistence.
	 *
	 * @param leaveTypeEmployeeGroupsPersistence the leave type employee groups persistence
	 */
	public void setLeaveTypeEmployeeGroupsPersistence(
		LeaveTypeEmployeeGroupsPersistence leaveTypeEmployeeGroupsPersistence) {
		this.leaveTypeEmployeeGroupsPersistence = leaveTypeEmployeeGroupsPersistence;
	}

	/**
	 * Returns the license local service.
	 *
	 * @return the license local service
	 */
	public com.rknowsys.eapp.hrm.service.LicenseLocalService getLicenseLocalService() {
		return licenseLocalService;
	}

	/**
	 * Sets the license local service.
	 *
	 * @param licenseLocalService the license local service
	 */
	public void setLicenseLocalService(
		com.rknowsys.eapp.hrm.service.LicenseLocalService licenseLocalService) {
		this.licenseLocalService = licenseLocalService;
	}

	/**
	 * Returns the license persistence.
	 *
	 * @return the license persistence
	 */
	public LicensePersistence getLicensePersistence() {
		return licensePersistence;
	}

	/**
	 * Sets the license persistence.
	 *
	 * @param licensePersistence the license persistence
	 */
	public void setLicensePersistence(LicensePersistence licensePersistence) {
		this.licensePersistence = licensePersistence;
	}

	/**
	 * Returns the location local service.
	 *
	 * @return the location local service
	 */
	public com.rknowsys.eapp.hrm.service.LocationLocalService getLocationLocalService() {
		return locationLocalService;
	}

	/**
	 * Sets the location local service.
	 *
	 * @param locationLocalService the location local service
	 */
	public void setLocationLocalService(
		com.rknowsys.eapp.hrm.service.LocationLocalService locationLocalService) {
		this.locationLocalService = locationLocalService;
	}

	/**
	 * Returns the location persistence.
	 *
	 * @return the location persistence
	 */
	public LocationPersistence getLocationPersistence() {
		return locationPersistence;
	}

	/**
	 * Sets the location persistence.
	 *
	 * @param locationPersistence the location persistence
	 */
	public void setLocationPersistence(LocationPersistence locationPersistence) {
		this.locationPersistence = locationPersistence;
	}

	/**
	 * Returns the membership local service.
	 *
	 * @return the membership local service
	 */
	public com.rknowsys.eapp.hrm.service.MembershipLocalService getMembershipLocalService() {
		return membershipLocalService;
	}

	/**
	 * Sets the membership local service.
	 *
	 * @param membershipLocalService the membership local service
	 */
	public void setMembershipLocalService(
		com.rknowsys.eapp.hrm.service.MembershipLocalService membershipLocalService) {
		this.membershipLocalService = membershipLocalService;
	}

	/**
	 * Returns the membership persistence.
	 *
	 * @return the membership persistence
	 */
	public MembershipPersistence getMembershipPersistence() {
		return membershipPersistence;
	}

	/**
	 * Sets the membership persistence.
	 *
	 * @param membershipPersistence the membership persistence
	 */
	public void setMembershipPersistence(
		MembershipPersistence membershipPersistence) {
		this.membershipPersistence = membershipPersistence;
	}

	/**
	 * Returns the Nationality local service.
	 *
	 * @return the Nationality local service
	 */
	public com.rknowsys.eapp.hrm.service.NationalityLocalService getNationalityLocalService() {
		return nationalityLocalService;
	}

	/**
	 * Sets the Nationality local service.
	 *
	 * @param nationalityLocalService the Nationality local service
	 */
	public void setNationalityLocalService(
		com.rknowsys.eapp.hrm.service.NationalityLocalService nationalityLocalService) {
		this.nationalityLocalService = nationalityLocalService;
	}

	/**
	 * Returns the Nationality persistence.
	 *
	 * @return the Nationality persistence
	 */
	public NationalityPersistence getNationalityPersistence() {
		return nationalityPersistence;
	}

	/**
	 * Sets the Nationality persistence.
	 *
	 * @param nationalityPersistence the Nationality persistence
	 */
	public void setNationalityPersistence(
		NationalityPersistence nationalityPersistence) {
		this.nationalityPersistence = nationalityPersistence;
	}

	/**
	 * Returns the news local service.
	 *
	 * @return the news local service
	 */
	public com.rknowsys.eapp.hrm.service.NewsLocalService getNewsLocalService() {
		return newsLocalService;
	}

	/**
	 * Sets the news local service.
	 *
	 * @param newsLocalService the news local service
	 */
	public void setNewsLocalService(
		com.rknowsys.eapp.hrm.service.NewsLocalService newsLocalService) {
		this.newsLocalService = newsLocalService;
	}

	/**
	 * Returns the news persistence.
	 *
	 * @return the news persistence
	 */
	public NewsPersistence getNewsPersistence() {
		return newsPersistence;
	}

	/**
	 * Sets the news persistence.
	 *
	 * @param newsPersistence the news persistence
	 */
	public void setNewsPersistence(NewsPersistence newsPersistence) {
		this.newsPersistence = newsPersistence;
	}

	/**
	 * Returns the news finder.
	 *
	 * @return the news finder
	 */
	public NewsFinder getNewsFinder() {
		return newsFinder;
	}

	/**
	 * Sets the news finder.
	 *
	 * @param newsFinder the news finder
	 */
	public void setNewsFinder(NewsFinder newsFinder) {
		this.newsFinder = newsFinder;
	}

	/**
	 * Returns the news attachments local service.
	 *
	 * @return the news attachments local service
	 */
	public com.rknowsys.eapp.hrm.service.NewsAttachmentsLocalService getNewsAttachmentsLocalService() {
		return newsAttachmentsLocalService;
	}

	/**
	 * Sets the news attachments local service.
	 *
	 * @param newsAttachmentsLocalService the news attachments local service
	 */
	public void setNewsAttachmentsLocalService(
		com.rknowsys.eapp.hrm.service.NewsAttachmentsLocalService newsAttachmentsLocalService) {
		this.newsAttachmentsLocalService = newsAttachmentsLocalService;
	}

	/**
	 * Returns the news attachments persistence.
	 *
	 * @return the news attachments persistence
	 */
	public NewsAttachmentsPersistence getNewsAttachmentsPersistence() {
		return newsAttachmentsPersistence;
	}

	/**
	 * Sets the news attachments persistence.
	 *
	 * @param newsAttachmentsPersistence the news attachments persistence
	 */
	public void setNewsAttachmentsPersistence(
		NewsAttachmentsPersistence newsAttachmentsPersistence) {
		this.newsAttachmentsPersistence = newsAttachmentsPersistence;
	}

	/**
	 * Returns the organization local service.
	 *
	 * @return the organization local service
	 */
	public com.rknowsys.eapp.hrm.service.OrganizationLocalService getOrganizationLocalService() {
		return organizationLocalService;
	}

	/**
	 * Sets the organization local service.
	 *
	 * @param organizationLocalService the organization local service
	 */
	public void setOrganizationLocalService(
		com.rknowsys.eapp.hrm.service.OrganizationLocalService organizationLocalService) {
		this.organizationLocalService = organizationLocalService;
	}

	/**
	 * Returns the organization persistence.
	 *
	 * @return the organization persistence
	 */
	public OrganizationPersistence getOrganizationPersistence() {
		return organizationPersistence;
	}

	/**
	 * Sets the organization persistence.
	 *
	 * @param organizationPersistence the organization persistence
	 */
	public void setOrganizationPersistence(
		OrganizationPersistence organizationPersistence) {
		this.organizationPersistence = organizationPersistence;
	}

	/**
	 * Returns the pay grade local service.
	 *
	 * @return the pay grade local service
	 */
	public com.rknowsys.eapp.hrm.service.PayGradeLocalService getPayGradeLocalService() {
		return payGradeLocalService;
	}

	/**
	 * Sets the pay grade local service.
	 *
	 * @param payGradeLocalService the pay grade local service
	 */
	public void setPayGradeLocalService(
		com.rknowsys.eapp.hrm.service.PayGradeLocalService payGradeLocalService) {
		this.payGradeLocalService = payGradeLocalService;
	}

	/**
	 * Returns the pay grade persistence.
	 *
	 * @return the pay grade persistence
	 */
	public PayGradePersistence getPayGradePersistence() {
		return payGradePersistence;
	}

	/**
	 * Sets the pay grade persistence.
	 *
	 * @param payGradePersistence the pay grade persistence
	 */
	public void setPayGradePersistence(PayGradePersistence payGradePersistence) {
		this.payGradePersistence = payGradePersistence;
	}

	/**
	 * Returns the pay grade currency local service.
	 *
	 * @return the pay grade currency local service
	 */
	public com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalService getPayGradeCurrencyLocalService() {
		return payGradeCurrencyLocalService;
	}

	/**
	 * Sets the pay grade currency local service.
	 *
	 * @param payGradeCurrencyLocalService the pay grade currency local service
	 */
	public void setPayGradeCurrencyLocalService(
		com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalService payGradeCurrencyLocalService) {
		this.payGradeCurrencyLocalService = payGradeCurrencyLocalService;
	}

	/**
	 * Returns the pay grade currency persistence.
	 *
	 * @return the pay grade currency persistence
	 */
	public PayGradeCurrencyPersistence getPayGradeCurrencyPersistence() {
		return payGradeCurrencyPersistence;
	}

	/**
	 * Sets the pay grade currency persistence.
	 *
	 * @param payGradeCurrencyPersistence the pay grade currency persistence
	 */
	public void setPayGradeCurrencyPersistence(
		PayGradeCurrencyPersistence payGradeCurrencyPersistence) {
		this.payGradeCurrencyPersistence = payGradeCurrencyPersistence;
	}

	/**
	 * Returns the reporting methods local service.
	 *
	 * @return the reporting methods local service
	 */
	public com.rknowsys.eapp.hrm.service.ReportingMethodsLocalService getReportingMethodsLocalService() {
		return reportingMethodsLocalService;
	}

	/**
	 * Sets the reporting methods local service.
	 *
	 * @param reportingMethodsLocalService the reporting methods local service
	 */
	public void setReportingMethodsLocalService(
		com.rknowsys.eapp.hrm.service.ReportingMethodsLocalService reportingMethodsLocalService) {
		this.reportingMethodsLocalService = reportingMethodsLocalService;
	}

	/**
	 * Returns the reporting methods persistence.
	 *
	 * @return the reporting methods persistence
	 */
	public ReportingMethodsPersistence getReportingMethodsPersistence() {
		return reportingMethodsPersistence;
	}

	/**
	 * Sets the reporting methods persistence.
	 *
	 * @param reportingMethodsPersistence the reporting methods persistence
	 */
	public void setReportingMethodsPersistence(
		ReportingMethodsPersistence reportingMethodsPersistence) {
		this.reportingMethodsPersistence = reportingMethodsPersistence;
	}

	/**
	 * Returns the salary component local service.
	 *
	 * @return the salary component local service
	 */
	public com.rknowsys.eapp.hrm.service.SalaryComponentLocalService getSalaryComponentLocalService() {
		return salaryComponentLocalService;
	}

	/**
	 * Sets the salary component local service.
	 *
	 * @param salaryComponentLocalService the salary component local service
	 */
	public void setSalaryComponentLocalService(
		com.rknowsys.eapp.hrm.service.SalaryComponentLocalService salaryComponentLocalService) {
		this.salaryComponentLocalService = salaryComponentLocalService;
	}

	/**
	 * Returns the salary component persistence.
	 *
	 * @return the salary component persistence
	 */
	public SalaryComponentPersistence getSalaryComponentPersistence() {
		return salaryComponentPersistence;
	}

	/**
	 * Sets the salary component persistence.
	 *
	 * @param salaryComponentPersistence the salary component persistence
	 */
	public void setSalaryComponentPersistence(
		SalaryComponentPersistence salaryComponentPersistence) {
		this.salaryComponentPersistence = salaryComponentPersistence;
	}

	/**
	 * Returns the skill local service.
	 *
	 * @return the skill local service
	 */
	public com.rknowsys.eapp.hrm.service.SkillLocalService getSkillLocalService() {
		return skillLocalService;
	}

	/**
	 * Sets the skill local service.
	 *
	 * @param skillLocalService the skill local service
	 */
	public void setSkillLocalService(
		com.rknowsys.eapp.hrm.service.SkillLocalService skillLocalService) {
		this.skillLocalService = skillLocalService;
	}

	/**
	 * Returns the skill persistence.
	 *
	 * @return the skill persistence
	 */
	public SkillPersistence getSkillPersistence() {
		return skillPersistence;
	}

	/**
	 * Sets the skill persistence.
	 *
	 * @param skillPersistence the skill persistence
	 */
	public void setSkillPersistence(SkillPersistence skillPersistence) {
		this.skillPersistence = skillPersistence;
	}

	/**
	 * Returns the SubUnit local service.
	 *
	 * @return the SubUnit local service
	 */
	public com.rknowsys.eapp.hrm.service.SubUnitLocalService getSubUnitLocalService() {
		return subUnitLocalService;
	}

	/**
	 * Sets the SubUnit local service.
	 *
	 * @param subUnitLocalService the SubUnit local service
	 */
	public void setSubUnitLocalService(
		com.rknowsys.eapp.hrm.service.SubUnitLocalService subUnitLocalService) {
		this.subUnitLocalService = subUnitLocalService;
	}

	/**
	 * Returns the SubUnit persistence.
	 *
	 * @return the SubUnit persistence
	 */
	public SubUnitPersistence getSubUnitPersistence() {
		return subUnitPersistence;
	}

	/**
	 * Sets the SubUnit persistence.
	 *
	 * @param subUnitPersistence the SubUnit persistence
	 */
	public void setSubUnitPersistence(SubUnitPersistence subUnitPersistence) {
		this.subUnitPersistence = subUnitPersistence;
	}

	/**
	 * Returns the termination reasons local service.
	 *
	 * @return the termination reasons local service
	 */
	public com.rknowsys.eapp.hrm.service.TerminationReasonsLocalService getTerminationReasonsLocalService() {
		return terminationReasonsLocalService;
	}

	/**
	 * Sets the termination reasons local service.
	 *
	 * @param terminationReasonsLocalService the termination reasons local service
	 */
	public void setTerminationReasonsLocalService(
		com.rknowsys.eapp.hrm.service.TerminationReasonsLocalService terminationReasonsLocalService) {
		this.terminationReasonsLocalService = terminationReasonsLocalService;
	}

	/**
	 * Returns the termination reasons persistence.
	 *
	 * @return the termination reasons persistence
	 */
	public TerminationReasonsPersistence getTerminationReasonsPersistence() {
		return terminationReasonsPersistence;
	}

	/**
	 * Sets the termination reasons persistence.
	 *
	 * @param terminationReasonsPersistence the termination reasons persistence
	 */
	public void setTerminationReasonsPersistence(
		TerminationReasonsPersistence terminationReasonsPersistence) {
		this.terminationReasonsPersistence = terminationReasonsPersistence;
	}

	/**
	 * Returns the workshift local service.
	 *
	 * @return the workshift local service
	 */
	public com.rknowsys.eapp.hrm.service.WorkshiftLocalService getWorkshiftLocalService() {
		return workshiftLocalService;
	}

	/**
	 * Sets the workshift local service.
	 *
	 * @param workshiftLocalService the workshift local service
	 */
	public void setWorkshiftLocalService(
		com.rknowsys.eapp.hrm.service.WorkshiftLocalService workshiftLocalService) {
		this.workshiftLocalService = workshiftLocalService;
	}

	/**
	 * Returns the workshift persistence.
	 *
	 * @return the workshift persistence
	 */
	public WorkshiftPersistence getWorkshiftPersistence() {
		return workshiftPersistence;
	}

	/**
	 * Sets the workshift persistence.
	 *
	 * @param workshiftPersistence the workshift persistence
	 */
	public void setWorkshiftPersistence(
		WorkshiftPersistence workshiftPersistence) {
		this.workshiftPersistence = workshiftPersistence;
	}

	/**
	 * Returns the WorkWeek local service.
	 *
	 * @return the WorkWeek local service
	 */
	public com.rknowsys.eapp.hrm.service.WorkWeekLocalService getWorkWeekLocalService() {
		return workWeekLocalService;
	}

	/**
	 * Sets the WorkWeek local service.
	 *
	 * @param workWeekLocalService the WorkWeek local service
	 */
	public void setWorkWeekLocalService(
		com.rknowsys.eapp.hrm.service.WorkWeekLocalService workWeekLocalService) {
		this.workWeekLocalService = workWeekLocalService;
	}

	/**
	 * Returns the WorkWeek persistence.
	 *
	 * @return the WorkWeek persistence
	 */
	public WorkWeekPersistence getWorkWeekPersistence() {
		return workWeekPersistence;
	}

	/**
	 * Sets the WorkWeek persistence.
	 *
	 * @param workWeekPersistence the WorkWeek persistence
	 */
	public void setWorkWeekPersistence(WorkWeekPersistence workWeekPersistence) {
		this.workWeekPersistence = workWeekPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.rknowsys.eapp.hrm.model.EmpPersonalDetails",
			empPersonalDetailsLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.rknowsys.eapp.hrm.model.EmpPersonalDetails");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return EmpPersonalDetails.class;
	}

	protected String getModelClassName() {
		return EmpPersonalDetails.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = empPersonalDetailsPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rknowsys.eapp.hrm.service.DocCategoryLocalService.class)
	protected com.rknowsys.eapp.hrm.service.DocCategoryLocalService docCategoryLocalService;
	@BeanReference(type = DocCategoryPersistence.class)
	protected DocCategoryPersistence docCategoryPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.DocumentCategoriesLocalService.class)
	protected com.rknowsys.eapp.hrm.service.DocumentCategoriesLocalService documentCategoriesLocalService;
	@BeanReference(type = DocumentCategoriesPersistence.class)
	protected DocumentCategoriesPersistence documentCategoriesPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.DocumentsLocalService.class)
	protected com.rknowsys.eapp.hrm.service.DocumentsLocalService documentsLocalService;
	@BeanReference(type = DocumentsPersistence.class)
	protected DocumentsPersistence documentsPersistence;
	@BeanReference(type = DocumentsFinder.class)
	protected DocumentsFinder documentsFinder;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.DocumentsAttachmentsLocalService.class)
	protected com.rknowsys.eapp.hrm.service.DocumentsAttachmentsLocalService documentsAttachmentsLocalService;
	@BeanReference(type = DocumentsAttachmentsPersistence.class)
	protected DocumentsAttachmentsPersistence documentsAttachmentsPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EducationLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EducationLocalService educationLocalService;
	@BeanReference(type = EducationPersistence.class)
	protected EducationPersistence educationPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpAttachmentLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpAttachmentLocalService empAttachmentLocalService;
	@BeanReference(type = EmpAttachmentPersistence.class)
	protected EmpAttachmentPersistence empAttachmentPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpContactDetailsLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpContactDetailsLocalService empContactDetailsLocalService;
	@BeanReference(type = EmpContactDetailsPersistence.class)
	protected EmpContactDetailsPersistence empContactDetailsPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpDependentLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpDependentLocalService empDependentLocalService;
	@BeanReference(type = EmpDependentPersistence.class)
	protected EmpDependentPersistence empDependentPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpDetailsLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpDetailsLocalService empDetailsLocalService;
	@BeanReference(type = EmpDetailsPersistence.class)
	protected EmpDetailsPersistence empDetailsPersistence;
	@BeanReference(type = EmpDetailsFinder.class)
	protected EmpDetailsFinder empDetailsFinder;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpDirectDepositLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpDirectDepositLocalService empDirectDepositLocalService;
	@BeanReference(type = EmpDirectDepositPersistence.class)
	protected EmpDirectDepositPersistence empDirectDepositPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpEducationLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpEducationLocalService empEducationLocalService;
	@BeanReference(type = EmpEducationPersistence.class)
	protected EmpEducationPersistence empEducationPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpEmergencyContactLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpEmergencyContactLocalService empEmergencyContactLocalService;
	@BeanReference(type = EmpEmergencyContactPersistence.class)
	protected EmpEmergencyContactPersistence empEmergencyContactPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpImmigrationDocumentLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpImmigrationDocumentLocalService empImmigrationDocumentLocalService;
	@BeanReference(type = EmpImmigrationDocumentPersistence.class)
	protected EmpImmigrationDocumentPersistence empImmigrationDocumentPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpJobLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpJobLocalService empJobLocalService;
	@BeanReference(type = EmpJobPersistence.class)
	protected EmpJobPersistence empJobPersistence;
	@BeanReference(type = EmpJobFinder.class)
	protected EmpJobFinder empJobFinder;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpLanguageLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpLanguageLocalService empLanguageLocalService;
	@BeanReference(type = EmpLanguagePersistence.class)
	protected EmpLanguagePersistence empLanguagePersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpLicenseLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpLicenseLocalService empLicenseLocalService;
	@BeanReference(type = EmpLicensePersistence.class)
	protected EmpLicensePersistence empLicensePersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmployeeLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmployeeLocalService employeeLocalService;
	@BeanReference(type = EmployeePersistence.class)
	protected EmployeePersistence employeePersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmploymentStatusLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmploymentStatusLocalService employmentStatusLocalService;
	@BeanReference(type = EmploymentStatusPersistence.class)
	protected EmploymentStatusPersistence employmentStatusPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpMembershipLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpMembershipLocalService empMembershipLocalService;
	@BeanReference(type = EmpMembershipPersistence.class)
	protected EmpMembershipPersistence empMembershipPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalService empPersonalDetailsLocalService;
	@BeanReference(type = EmpPersonalDetailsPersistence.class)
	protected EmpPersonalDetailsPersistence empPersonalDetailsPersistence;
	@BeanReference(type = EmpPersonalDetailsFinder.class)
	protected EmpPersonalDetailsFinder empPersonalDetailsFinder;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpSalaryLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpSalaryLocalService empSalaryLocalService;
	@BeanReference(type = EmpSalaryPersistence.class)
	protected EmpSalaryPersistence empSalaryPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpSalaryComponentLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpSalaryComponentLocalService empSalaryComponentLocalService;
	@BeanReference(type = EmpSalaryComponentPersistence.class)
	protected EmpSalaryComponentPersistence empSalaryComponentPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpSkillLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpSkillLocalService empSkillLocalService;
	@BeanReference(type = EmpSkillPersistence.class)
	protected EmpSkillPersistence empSkillPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpSubordinateLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpSubordinateLocalService empSubordinateLocalService;
	@BeanReference(type = EmpSubordinatePersistence.class)
	protected EmpSubordinatePersistence empSubordinatePersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpSupervisorLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpSupervisorLocalService empSupervisorLocalService;
	@BeanReference(type = EmpSupervisorPersistence.class)
	protected EmpSupervisorPersistence empSupervisorPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.EmpWorkExpLocalService.class)
	protected com.rknowsys.eapp.hrm.service.EmpWorkExpLocalService empWorkExpLocalService;
	@BeanReference(type = EmpWorkExpPersistence.class)
	protected EmpWorkExpPersistence empWorkExpPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.HolidayLocalService.class)
	protected com.rknowsys.eapp.hrm.service.HolidayLocalService holidayLocalService;
	@BeanReference(type = HolidayPersistence.class)
	protected HolidayPersistence holidayPersistence;
	@BeanReference(type = HolidayFinder.class)
	protected HolidayFinder holidayFinder;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.InterviewLocalService.class)
	protected com.rknowsys.eapp.hrm.service.InterviewLocalService interviewLocalService;
	@BeanReference(type = InterviewPersistence.class)
	protected InterviewPersistence interviewPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.JobCategoryLocalService.class)
	protected com.rknowsys.eapp.hrm.service.JobCategoryLocalService jobCategoryLocalService;
	@BeanReference(type = JobCategoryPersistence.class)
	protected JobCategoryPersistence jobCategoryPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.JobTitleLocalService.class)
	protected com.rknowsys.eapp.hrm.service.JobTitleLocalService jobTitleLocalService;
	@BeanReference(type = JobTitlePersistence.class)
	protected JobTitlePersistence jobTitlePersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.LanguageLocalService.class)
	protected com.rknowsys.eapp.hrm.service.LanguageLocalService languageLocalService;
	@BeanReference(type = LanguagePersistence.class)
	protected LanguagePersistence languagePersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.LeaveAccrualLocalService.class)
	protected com.rknowsys.eapp.hrm.service.LeaveAccrualLocalService leaveAccrualLocalService;
	@BeanReference(type = LeaveAccrualPersistence.class)
	protected LeaveAccrualPersistence leaveAccrualPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.LeaveCarryForwardPolicyLocalService.class)
	protected com.rknowsys.eapp.hrm.service.LeaveCarryForwardPolicyLocalService leaveCarryForwardPolicyLocalService;
	@BeanReference(type = LeaveCarryForwardPolicyPersistence.class)
	protected LeaveCarryForwardPolicyPersistence leaveCarryForwardPolicyPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.LeaveGeneralLocalService.class)
	protected com.rknowsys.eapp.hrm.service.LeaveGeneralLocalService leaveGeneralLocalService;
	@BeanReference(type = LeaveGeneralPersistence.class)
	protected LeaveGeneralPersistence leaveGeneralPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.LeavePeriodLocalService.class)
	protected com.rknowsys.eapp.hrm.service.LeavePeriodLocalService leavePeriodLocalService;
	@BeanReference(type = LeavePeriodPersistence.class)
	protected LeavePeriodPersistence leavePeriodPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.LeaveRestrictionLocalService.class)
	protected com.rknowsys.eapp.hrm.service.LeaveRestrictionLocalService leaveRestrictionLocalService;
	@BeanReference(type = LeaveRestrictionPersistence.class)
	protected LeaveRestrictionPersistence leaveRestrictionPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.LeaveRuleApplicableLocalService.class)
	protected com.rknowsys.eapp.hrm.service.LeaveRuleApplicableLocalService leaveRuleApplicableLocalService;
	@BeanReference(type = LeaveRuleApplicablePersistence.class)
	protected LeaveRuleApplicablePersistence leaveRuleApplicablePersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.LeaveTypeLocalService.class)
	protected com.rknowsys.eapp.hrm.service.LeaveTypeLocalService leaveTypeLocalService;
	@BeanReference(type = LeaveTypePersistence.class)
	protected LeaveTypePersistence leaveTypePersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.LeaveTypeEmployeeGroupsLocalService.class)
	protected com.rknowsys.eapp.hrm.service.LeaveTypeEmployeeGroupsLocalService leaveTypeEmployeeGroupsLocalService;
	@BeanReference(type = LeaveTypeEmployeeGroupsPersistence.class)
	protected LeaveTypeEmployeeGroupsPersistence leaveTypeEmployeeGroupsPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.LicenseLocalService.class)
	protected com.rknowsys.eapp.hrm.service.LicenseLocalService licenseLocalService;
	@BeanReference(type = LicensePersistence.class)
	protected LicensePersistence licensePersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.LocationLocalService.class)
	protected com.rknowsys.eapp.hrm.service.LocationLocalService locationLocalService;
	@BeanReference(type = LocationPersistence.class)
	protected LocationPersistence locationPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.MembershipLocalService.class)
	protected com.rknowsys.eapp.hrm.service.MembershipLocalService membershipLocalService;
	@BeanReference(type = MembershipPersistence.class)
	protected MembershipPersistence membershipPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.NationalityLocalService.class)
	protected com.rknowsys.eapp.hrm.service.NationalityLocalService nationalityLocalService;
	@BeanReference(type = NationalityPersistence.class)
	protected NationalityPersistence nationalityPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.NewsLocalService.class)
	protected com.rknowsys.eapp.hrm.service.NewsLocalService newsLocalService;
	@BeanReference(type = NewsPersistence.class)
	protected NewsPersistence newsPersistence;
	@BeanReference(type = NewsFinder.class)
	protected NewsFinder newsFinder;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.NewsAttachmentsLocalService.class)
	protected com.rknowsys.eapp.hrm.service.NewsAttachmentsLocalService newsAttachmentsLocalService;
	@BeanReference(type = NewsAttachmentsPersistence.class)
	protected NewsAttachmentsPersistence newsAttachmentsPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.OrganizationLocalService.class)
	protected com.rknowsys.eapp.hrm.service.OrganizationLocalService organizationLocalService;
	@BeanReference(type = OrganizationPersistence.class)
	protected OrganizationPersistence organizationPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.PayGradeLocalService.class)
	protected com.rknowsys.eapp.hrm.service.PayGradeLocalService payGradeLocalService;
	@BeanReference(type = PayGradePersistence.class)
	protected PayGradePersistence payGradePersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalService.class)
	protected com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalService payGradeCurrencyLocalService;
	@BeanReference(type = PayGradeCurrencyPersistence.class)
	protected PayGradeCurrencyPersistence payGradeCurrencyPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.ReportingMethodsLocalService.class)
	protected com.rknowsys.eapp.hrm.service.ReportingMethodsLocalService reportingMethodsLocalService;
	@BeanReference(type = ReportingMethodsPersistence.class)
	protected ReportingMethodsPersistence reportingMethodsPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.SalaryComponentLocalService.class)
	protected com.rknowsys.eapp.hrm.service.SalaryComponentLocalService salaryComponentLocalService;
	@BeanReference(type = SalaryComponentPersistence.class)
	protected SalaryComponentPersistence salaryComponentPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.SkillLocalService.class)
	protected com.rknowsys.eapp.hrm.service.SkillLocalService skillLocalService;
	@BeanReference(type = SkillPersistence.class)
	protected SkillPersistence skillPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.SubUnitLocalService.class)
	protected com.rknowsys.eapp.hrm.service.SubUnitLocalService subUnitLocalService;
	@BeanReference(type = SubUnitPersistence.class)
	protected SubUnitPersistence subUnitPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.TerminationReasonsLocalService.class)
	protected com.rknowsys.eapp.hrm.service.TerminationReasonsLocalService terminationReasonsLocalService;
	@BeanReference(type = TerminationReasonsPersistence.class)
	protected TerminationReasonsPersistence terminationReasonsPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.WorkshiftLocalService.class)
	protected com.rknowsys.eapp.hrm.service.WorkshiftLocalService workshiftLocalService;
	@BeanReference(type = WorkshiftPersistence.class)
	protected WorkshiftPersistence workshiftPersistence;
	@BeanReference(type = com.rknowsys.eapp.hrm.service.WorkWeekLocalService.class)
	protected com.rknowsys.eapp.hrm.service.WorkWeekLocalService workWeekLocalService;
	@BeanReference(type = WorkWeekPersistence.class)
	protected WorkWeekPersistence workWeekPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private EmpPersonalDetailsLocalServiceClpInvoker _clpInvoker = new EmpPersonalDetailsLocalServiceClpInvoker();
}