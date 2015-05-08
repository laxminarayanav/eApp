package com.rknowsys.eapp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.EmpAttachment;
import com.rknowsys.eapp.hrm.model.EmpContactDetails;
import com.rknowsys.eapp.hrm.model.EmpDependent;
import com.rknowsys.eapp.hrm.model.EmpDirectDeposit;
import com.rknowsys.eapp.hrm.model.EmpEducation;
import com.rknowsys.eapp.hrm.model.EmpEmergencyContact;
import com.rknowsys.eapp.hrm.model.EmpImmigrationDocument;
import com.rknowsys.eapp.hrm.model.EmpJob;
import com.rknowsys.eapp.hrm.model.EmpLanguage;
import com.rknowsys.eapp.hrm.model.EmpLicense;
import com.rknowsys.eapp.hrm.model.EmpPersonalDetails;
import com.rknowsys.eapp.hrm.model.EmpSkill;
import com.rknowsys.eapp.hrm.model.EmpSubordinate;
import com.rknowsys.eapp.hrm.model.EmpSupervisor;
import com.rknowsys.eapp.hrm.model.EmpWorkExp;
import com.rknowsys.eapp.hrm.model.Employee;
import com.rknowsys.eapp.hrm.model.PayGradeCurrency;
import com.rknowsys.eapp.hrm.service.EmpAttachmentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpContactDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpDependentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpDirectDepositLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpEducationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpEmergencyContactLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpImmigrationDocumentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpJobLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpLanguageLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpLicenseLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpSkillLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpSubordinateLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpSupervisorLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpWorkExpLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalServiceUtil;

public class EmployeeAction extends MVCPortlet {
	public static final String EMPLOYEE_ID = "employeeId";
	public static final String EMPLOYEE_FIRST_NAME_COL_NAME = "firstName";
	public static final String ORDER_TYPE_ASC = "asc";
	public static final String EMPLOYEE_MIDDLE_NAME_COL_NAME = "middleName";
	public static final String EMPLOYEE_LAST_NAME_COL_NAME = "lastName";
	public static final String EMPLOYEE_GENDER = "gender";
	public static final int EMPLOYEE_GENDER_MALE = 0;
	public static final int EMPLOYEE_GENDER_FEMALE = 1;
	public static final String EMPLOYEE_MARITAL_STATUS_COL_NAME = "maritalStatus";
	public static final String EMPLOYEE_NATIONALITY_COL_NAME = "nationality";
	public static final String EMPLOYEE_DATEOFBIRTH_COL_NAME = "dateOfBirth";
	public static final String EMPLOYEE_OTHERID_COL_NAME = "otherId";
	public static final String EMPLOYEE_LICENSE_NUMBER_COL_NAME = "licenseNumber";
	public static final String EMPLOYEE_LICENSE_EXP_DATE_COL_NAME = "licenseExpiryDate";
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
	private static Logger log = Logger.getLogger(EmployeeAction.class);
	public int checkRedirect=0;
	/**
	 * <p>
	 * This method inserts new Employee record and EmpPersonalDetails in
	 * database and creates portal user credentials if user name and password
	 * are not null
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void renderEmployeeDetails(ActionRequest actionRequest,ActionResponse actionResponse) 
			throws IOException,PortletException, SystemException {
			long empId = ParamUtil.getLong(actionRequest, "prk");
			Employee emp = null;
			try {
		        emp = EmployeeLocalServiceUtil.getEmployee(empId);
		    	} catch (PortalException e) {
			        log.error("Error in reading Employee details",e);
			    }
		  if (emp != null) {
				Map<String, Comparable> map = setSessionAttributes(empId, emp.getImageId(), "jsp1");
				actionRequest.getPortletSession(true).setAttribute("empId", map,
						PortletSession.APPLICATION_SCOPE);
			     } else {
		    	    log.error("Employee is no longer available");
		       }
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
	    }

	/*public void saveEmpDetails(ActionRequest actionRequest,ActionResponse actionResponse) 
			throws IOException,PortletException, SystemException 
		{
		log.info("saveEmployeeDetails method");
		addEmployee(actionRequest, actionResponse);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		log.info("End of saveEmpDetails method");
	    }*/
	public Map<String, Comparable> setSessionAttributes(long empId,long imageId,String jsp) 
	   {
		Map<String, Comparable> sessionAttributes=new HashMap<String, Comparable>();
		sessionAttributes.put("empId", empId);
		sessionAttributes.put("fileId", imageId);
		sessionAttributes.put("jsp", jsp);
		return sessionAttributes;
	   }
	public Date formatDate(String date)
	{
		String[] dateArray=date.split("/");
		int month=Integer.parseInt(dateArray[0]);
		int day=Integer.parseInt(dateArray[1]);
		int year=Integer.parseInt(dateArray[2]);
		Calendar cal=Calendar.getInstance();
		cal.set(year, month-1, day);
		return cal.getTime();
	}
	/** This method updates EmpPersonalDetails record in Database */
	
	public void updateEmpPersonalDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		long fileEntryId = ParamUtil.getLong(actionRequest, "fileIdemp");
		Long empId = ParamUtil.getLong(actionRequest, "perEmpId");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String firstName = ParamUtil.getString(actionRequest,EMPLOYEE_FIRST_NAME_COL_NAME);
		String middleName = ParamUtil.getString(actionRequest,EMPLOYEE_MIDDLE_NAME_COL_NAME);
		String lastName = ParamUtil.getString(actionRequest,EMPLOYEE_LAST_NAME_COL_NAME);
		String empNo = ParamUtil.getString(actionRequest, "employee_no");
		String otherId = ParamUtil.getString(actionRequest, "other_id");
		String driverLicenseNo = ParamUtil.getString(actionRequest,"driver_license_no");
		String expiryDate = ParamUtil.getString(actionRequest, "expiry_date");
		log.info("Expiry date is "+expiryDate);
		Date expDate=null;
		if(expiryDate!=null && expiryDate.trim()!="")
		{
			expDate=formatDate(expiryDate);
		}
		String gender = ParamUtil.getString(actionRequest, "gender");
		String maritalStatus = ParamUtil.getString(actionRequest,"marital_status");
		long nationality = ParamUtil.getLong(actionRequest, "emp_nationality");
		String dateOfB = ParamUtil.getString(actionRequest, "date_of_birth");
		long perEmpId = ParamUtil.getLong(actionRequest, "personalDetailsId");
		EmpPersonalDetails empPersonalDetails = null;
			try {
				empPersonalDetails = EmpPersonalDetailsLocalServiceUtil
						.getEmpPersonalDetails(perEmpId);
				} catch (PortalException e) {
					log.error("Error in getting Employee details",e);
				} catch (SystemException e) {
					log.error("Error in getting Employee details",e);
			}
			if (empPersonalDetails != null) {
				empPersonalDetails.setFirstName(firstName);
				empPersonalDetails.setMiddleName(middleName);
				empPersonalDetails.setLastName(lastName);
				Date dteOfB=null;
				if(dateOfB!=null && dateOfB.trim()!="")
				{
					dteOfB=formatDate(dateOfB);
				}
				empPersonalDetails.setDateOfBirth(dteOfB);
				empPersonalDetails.setEmployeeId(empId);
				empPersonalDetails.setEmployeeNo(empNo);
			    empPersonalDetails.setLicenseExpDate(expDate);
				empPersonalDetails.setLicenseNo(driverLicenseNo);
				empPersonalDetails.setOtherId(otherId);
				empPersonalDetails.setCompanyId(themeDisplay.getCompanyId());
				empPersonalDetails.setUserId(themeDisplay.getUserId());
					try {
						empPersonalDetails.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
						} catch (PortalException e1) {
							log.error("Error in obtaining groupId",e1);
						} catch (SystemException e1) {
							log.error("Error in obtaining groupId",e1);
					  }
				empPersonalDetails.setModifiedDate(date);
				empPersonalDetails.setNationalityId(nationality);
				empPersonalDetails.setMaritalStatus(maritalStatus);
				empPersonalDetails.setGender(gender);
				try {
					EmpPersonalDetailsLocalServiceUtil
							.updateEmpPersonalDetails(empPersonalDetails);
					} catch (SystemException e) {
						log.error("Error in updating Employee details",e);
				}
			}
		Map<String, Comparable> map = setSessionAttributes(empId, fileEntryId, "jsp1");
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		log.info("End of updateEmpPersonalDetails method");
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
	}       
	/**
	 * <p>
	 * This method inserts new EmpContactDetails record in database if the id is
	 * not existing, otherwise updates the record based on the record id.
	 * </p>
	 */
	public void addOrUpdateEmpContactDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException,
			IOException, SystemException {
		log.info("Update or add Employee contact details:in updateEmpContactDetails method");
		Long contactDetailsId = ParamUtil.getLong(actionRequest, "conDetailsId");
		long fileEntryId = ParamUtil.getLong(actionRequest, "conFileId");
		String addressStreet1 = ParamUtil.getString(actionRequest,"address_street1");
		String addressStreet2 = ParamUtil.getString(actionRequest,"address_street2");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String zip = ParamUtil.getString(actionRequest, "zip");
		String country = ParamUtil.getString(actionRequest, "country");
		String homeTele = ParamUtil.getString(actionRequest, "home_telephone");
		String workTele = ParamUtil.getString(actionRequest, "work_telephone");
		String mobile = ParamUtil.getString(actionRequest, "mobile");
		String workMail = ParamUtil.getString(actionRequest, "work_email");
		String otherMail = ParamUtil.getString(actionRequest, "other_email");
		Long empId = ParamUtil.getLong(actionRequest, "conEmpId");
		DynamicQuery contactDetailsDynamicQuery = DynamicQueryFactoryUtil.forClass(EmpContactDetails.class,
						PortletClassLoaderUtil.getClassLoader());
		contactDetailsDynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(empId));
		List<EmpContactDetails> l = null;
			try {
					l = EmpContactDetailsLocalServiceUtil
							.dynamicQuery(contactDetailsDynamicQuery);
				} catch (SystemException e) {
					log.error("Error in obtaining Employee contact details",e);
			}
		EmpContactDetails empContactDetails = null;
			if (l.size() == 0) {
					try {
						empContactDetails = EmpContactDetailsLocalServiceUtil
								.createEmpContactDetails(CounterLocalServiceUtil.increment());
					} catch (SystemException e) {
						log.error("Error in obtaining Employee contact details",e);
				   }
				empContactDetails.setAddressStreet1(addressStreet1);
				empContactDetails.setAddressStreet2(addressStreet2);
				empContactDetails.setCity(city);
				empContactDetails.setCountry(country);
				empContactDetails.setHomeTelephone(homeTele);
				empContactDetails.setMobile(mobile);
				empContactDetails.setOtherEmail(otherMail);
				empContactDetails.setState(state);
				empContactDetails.setOtherEmail(otherMail);
				empContactDetails.setPostalCode(zip);
				empContactDetails.setWorkEmail(workMail);
				empContactDetails.setWorkTelephone(workTele);
				empContactDetails.setEmployeeId(empId);
				empContactDetails.setCreateDate(date);
				empContactDetails.setUserId(themeDisplay.getUserId());
				empContactDetails.setCompanyId(themeDisplay.getCompanyId());
				empContactDetails.setGroupId(themeDisplay.getCompanyGroupId());
					try {
						EmpContactDetailsLocalServiceUtil
								.addEmpContactDetails(empContactDetails);
					    } catch (SystemException e) {
					      log.error("Error in saving Employee contact details",e);
					}
		   } 
		   else {
					try {
						empContactDetails = EmpContactDetailsLocalServiceUtil
								.getEmpContactDetails(l.get(0).getEmpContactDetailsId());
						} catch (PortalException e) {
							log.error("Error in obtaining Employee contact details",e);
						} catch (SystemException e) {
							log.error("Error in obtaining Employee contact details",e);
					}
				empContactDetails.setAddressStreet1(addressStreet1);
				empContactDetails.setAddressStreet2(addressStreet2);
				empContactDetails.setCity(city);
				empContactDetails.setCountry(country);
				empContactDetails.setHomeTelephone(homeTele);
				empContactDetails.setMobile(mobile);
				empContactDetails.setOtherEmail(otherMail);
				empContactDetails.setState(state);
				empContactDetails.setOtherEmail(otherMail);
				empContactDetails.setPostalCode(zip);
				empContactDetails.setWorkEmail(workMail);
				empContactDetails.setWorkTelephone(workTele);
				empContactDetails.setUserId(themeDisplay.getUserId());
				empContactDetails.setCompanyId(themeDisplay.getCompanyId());
					try {
							empContactDetails.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
						} catch (PortalException e1) {
							log.error("Error in obtaining groupId",e1);
						}
				empContactDetails.setModifiedDate(date);
					try {
							EmpContactDetailsLocalServiceUtil
									.updateEmpContactDetails(empContactDetails);
						 } catch (SystemException e) {
							log.error("Error in updating Employee contact details",e);
					}
		}
		Map<String, Comparable> map = setSessionAttributes(empId, fileEntryId, "jsp2");
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		log.info("End of addOrUpdateEmpContactDetails method");
	}

	/**
	 * <p>
	 * This method inserts new EmpEmergencyContact record in database if the id
	 * is not existing, otherwise updates the record based on the record id.
	 * </p>
	 */
	public void updateContactDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		log.info("updating emegergency contact details:updateContactDetails method");
		long empId = ParamUtil.getLong(actionRequest, "emgEmpId");
		long fileEntryId = ParamUtil.getLong(actionRequest, "conFileId");
		String emergencyName = ParamUtil.getString(actionRequest, "emg_name");
		String relationship = ParamUtil.getString(actionRequest,"emg_relationship");
		String homeTele = ParamUtil.getString(actionRequest, "emg_hm_telephone");
		String mobile = ParamUtil.getString(actionRequest, "emg_mobile");
		String workTele = ParamUtil.getString(actionRequest,"emg_work_telephone");
		log.info("emergency name is "+emergencyName);
		EmpEmergencyContact empEmergencyContact = null;
			try {
				empEmergencyContact = EmpEmergencyContactLocalServiceUtil
						.createEmpEmergencyContact(CounterLocalServiceUtil
								.increment());
			} catch (SystemException e1) {
				log.error("Error in adding emergency contact details for Employee",e1);
			}
		empEmergencyContact.setCompanyId(themeDisplay.getCompanyId());
			try {
				empEmergencyContact.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
			} catch (PortalException e1) {
				log.error("Error in obtaining groupId"+e1);
			} catch (SystemException e1) {
				log.error("Error in obtaining groupId"+e1);
			}
		empEmergencyContact.setCreateDate(date);
		empEmergencyContact.setEmployeeId(empId);
		empEmergencyContact.setHomeTelephone(homeTele);
		empEmergencyContact.setMobile(mobile);
		empEmergencyContact.setRelationship(relationship);
		empEmergencyContact.setName(emergencyName);
		empEmergencyContact.setWorkTelephone(workTele);
		empEmergencyContact.setModifiedDate(date);
			try {
				EmpEmergencyContactLocalServiceUtil
						.addEmpEmergencyContact(empEmergencyContact);
			} catch (SystemException e) {
				log.error("Error in saving emergency contact details for Employee"+e);
			}
		Map<String, Comparable> map =setSessionAttributes(empId, fileEntryId, "jsp3");
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		log.info("End of updateContactDetails method");
	}

	/**
	 * <p>
	 * This method inserts new EmpDependent record in database if the id is not
	 * existing, otherwise updates the record based on the record id.
	 * </p>
	 */
	public void updateAssignedDependents(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		log.info("In updateAssignedDependents method");
		long fileEntryId = ParamUtil.getLong(actionRequest, "dependentFileId");
		String name = ParamUtil.getString(actionRequest, "dependent_name");
		String relation = ParamUtil.getString(actionRequest,"dependent_relationship");
		Long empId = ParamUtil.getLong(actionRequest, "empDependentId");
		String dateOfBirth=ParamUtil.getString(actionRequest, "dateOfBirth");
		Date dateOfB=null;
		if(dateOfBirth!=null && dateOfBirth.trim()!="")
		{
		dateOfB=formatDate(dateOfBirth);
		}
		EmpDependent empDependent = null;
			try {
				empDependent = EmpDependentLocalServiceUtil
						.createEmpDependent(CounterLocalServiceUtil.increment());
			} catch (SystemException e) {
			    log.error("Error in creating depenents for Employee",e);
			}
		empDependent.setEmployeeId(empId);
		empDependent.setCompanyId(themeDisplay.getCompanyId());
			try {
				empDependent.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
			} catch (PortalException e2) {
				log.error("Error in obtaining groupId", e2);
			} catch (SystemException e2) {
				log.error("Error in obtaining groupId", e2);
			}
		empDependent.setUserId(themeDisplay.getUserId());
		empDependent.setCreateDate(date);
		empDependent.setModifiedDate(date);
		empDependent.setDateOfBirth(dateOfB);
		empDependent.setName(name);
		empDependent.setRelationship(relation);
			try {
				EmpDependentLocalServiceUtil.addEmpDependent(empDependent);
			} catch (SystemException e) {
				log.error("Error in saving employee dependent details",e);
			}
		Map<String, Comparable> map = setSessionAttributes(empId, fileEntryId, "jsp4");
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		log.info("End of updateAssignedDependents method");

	  }

	/**
	 * <p>
	 * This method inserts new EmpSupervisor and EmpSubordinate records in
	 * database
	 * </p>
	 */
	public void addReportToEmp(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException, IOException {
		log.info("In addReportToEmp method");
		long fileEntryId = ParamUtil.getLong(actionRequest, "reportFileId");
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		log.info("Constats.CMD : "+cmd);
		String reportTo = "", reportingMethod = "";
		Long empId = 0l;
		if (cmd.equals("sup_add")) {
			log.info("Assigning supervisor for the employee...");
			empId = ParamUtil.getLong(actionRequest, "empSupId");
			reportTo = ParamUtil.getString(actionRequest, "report_sup_name");
			reportingMethod = ParamUtil.getString(actionRequest,
					"reporting_sup_method");
			long supervisorId = ParamUtil
					.getLong(actionRequest, "supervisorId");
			EmpSupervisor empSupervisor = null;
			try {
					empSupervisor = EmpSupervisorLocalServiceUtil
							.createEmpSupervisor(CounterLocalServiceUtil
									.increment());
				} catch (SystemException e) {
					log.error("Error in assigning supervisor for the employee"+e);
			 }
			empSupervisor.setReportingMethod(reportingMethod);
			empSupervisor.setEmployeeId(empId);
			empSupervisor.setReporterEmployeeId(supervisorId);
			empSupervisor.setCreateDate(date);
			empSupervisor.setCompanyId(themeDisplay.getCompanyId());
			empSupervisor.setGroupId(themeDisplay.getCompanyGroupId());
			empSupervisor.setUserId(themeDisplay.getUserId());
				try {
					EmpSupervisorLocalServiceUtil.addEmpSupervisor(empSupervisor);
				 } catch (SystemException e) {
					log.error("Error in assigning supervisor for the employee"+e);
			}
			Map<String, Comparable> map = setSessionAttributes(empId, fileEntryId, "jsp6");
			actionRequest.getPortletSession(true).setAttribute("empId", map,
					PortletSession.APPLICATION_SCOPE);
			actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		} else {
			log.info("Assigning subordinate for the employee...");
			EmpSubordinate empSubordinate=null;
			empId = ParamUtil.getLong(actionRequest, "empSubId");
			reportTo = ParamUtil.getString(actionRequest, "report_sub_name");
			reportingMethod = ParamUtil.getString(actionRequest,
					"reporting_sub_method");
				try {
					empSubordinate= EmpSubordinateLocalServiceUtil
							.createEmpSubordinate(CounterLocalServiceUtil
									.increment());
				} catch (SystemException e) {
					log.error("Error in assigning subordinate for the employee"+e);
			 }
			empSubordinate.setReportingMethod(reportingMethod);
			empSubordinate.setEmployeeId(empId);
			empSubordinate.setReporterEmployeeId(empId);
			empSubordinate.setCreateDate(date);
			empSubordinate.setCompanyId(themeDisplay.getCompanyId());
			empSubordinate.setGroupId(themeDisplay.getCompanyGroupId());
			empSubordinate.setUserId(themeDisplay.getUserId());
				try {
					EmpSubordinateLocalServiceUtil.addEmpSubordinate(empSubordinate);
				} catch (SystemException e) {
					log.error("Error in assigning subordinate for the employee"+e);
			 }
			Map<String, Comparable> map = setSessionAttributes(empId, fileEntryId, "jsp6");
			actionRequest.getPortletSession(true).setAttribute("empId", map,
					PortletSession.APPLICATION_SCOPE);
			actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		}
	}

	/**
	 * <p>
	 * This method inserts new EmpSkill,EmpEducation,EmpWorkExperience,
	 * EmpLanguage,EmpLicense records in database for a particular Employee
	 * </p>
	 */
	public void addQualifications(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException, IOException {
		log.info("In addQualifications method");
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		long fileEntryId = ParamUtil.getLong(actionRequest, "QualFileId");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		Long empId = 0l;
		log.info("Constants.CMD: " + cmd);
		if (cmd.equals("empExperience")) {
			log.info("updating employee work experience");
			empId = ParamUtil.getLong(actionRequest, "empWrkExpId");
			String expCompany = ParamUtil.getString(actionRequest,"exp_company");
			String jobTitle = ParamUtil.getString(actionRequest, "exp_jobtitle");
			String fromDate = ParamUtil.getString(actionRequest, "exp_from_date");
			String toDate = ParamUtil.getString(actionRequest, "exp_to_date");
			String comments = ParamUtil.getString(actionRequest, "exp_comments");
			EmpWorkExp empWorkExp = null;
				try {
					empWorkExp = EmpWorkExpLocalServiceUtil
							.createEmpWorkExp(CounterLocalServiceUtil.increment());
				} catch (SystemException e) {
					log.info("Error in adding work experience details of employee..."+e);
				}
			Date frmDate=null,expToDate=null;
			if(fromDate!=null && fromDate.trim()!="")
				{
					frmDate=formatDate(fromDate);
				}
			if(toDate!=null && toDate.trim()!="")
				{
					expToDate=formatDate(toDate);
				}
			empWorkExp.setEmployeeId(empId);
			empWorkExp.setComment(comments);
			empWorkExp.setCompany(expCompany);
			empWorkExp.setFromDate(frmDate);
			empWorkExp.setToDate(expToDate);
			empWorkExp.setJobTitle(jobTitle);
			empWorkExp.setCreateDate(date);
			empWorkExp.setModifiedDate(date);
			empWorkExp.setUserId(themeDisplay.getUserId());
			empWorkExp.setCompanyId(themeDisplay.getCompanyId());
				try {
					empWorkExp.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
				  } catch (PortalException e1) {
					log.error("Error in obtaining groupId "+e1);
				  } catch (SystemException e1) {
					log.error("Error in obtaining groupId "+e1);
				}
				try {
					EmpWorkExpLocalServiceUtil.addEmpWorkExp(empWorkExp);
				  } catch (SystemException e) {
					log.error("Error in saving employee work experience details",e);
				}
		  }
		if (cmd.equals("empEducation")) {
			log.info("Updating education details of employee");
			empId = ParamUtil.getLong(actionRequest, "empEduId");
			long level = ParamUtil.getLong(actionRequest, "edu_level");
			String institute = ParamUtil.getString(actionRequest,"edu_institute");
			String splization = ParamUtil.getString(actionRequest, "edu_major");
			String year = ParamUtil.getString(actionRequest, "edu_year");
			String score = ParamUtil.getString(actionRequest, "edu_score");
			String from = ParamUtil.getString(actionRequest, "edu_from_date");
			String to = ParamUtil.getString(actionRequest, "edu_to_date");
			EmpEducation education = null;
				try {
					education = EmpEducationLocalServiceUtil
							.createEmpEducation(CounterLocalServiceUtil.increment());
				    } catch (SystemException e) {
					log.error("Error in adding eduaction details of employee", e);
				}
				Date startDate=null,endDate=null;
			if(from!=null && from.trim()!="")
				{
					startDate=formatDate(from);
				}
			if(to!=null && to.trim()!="")
				{
					endDate=formatDate(to);
				}
			education.setEmployeeId(empId);
			education.setInstitute(institute);
			education.setMajor(splization);
			education.setYear(year);
			education.setStartDate(startDate);
			education.setEndDate(endDate);
			education.setEducationId(level);
			education.setCreateDate(date);
			education.setModifiedDate(date);
			education.setCompanyId(themeDisplay.getCompanyId());
			education.setGroupId(themeDisplay.getCompanyGroupId());
			education.setUserId(themeDisplay.getUserId());
				try {
						EmpEducationLocalServiceUtil.addEmpEducation(education);
					} catch (SystemException e) {
						log.error("Error in saving eduaction details of employee", e);
				}
		 }
		if (cmd.equals("empSkills")) {
			log.info("Updating employee skills");
			empId = ParamUtil.getLong(actionRequest, "empSkillId");
			long skill = ParamUtil.getLong(actionRequest, "emp_skill");
			String exp = ParamUtil.getString(actionRequest, "skill_exp");
			String comments = ParamUtil.getString(actionRequest,"skill_comments");
			EmpSkill empSkill = null;
				try {
					empSkill = EmpSkillLocalServiceUtil
							.createEmpSkill(CounterLocalServiceUtil.increment());
				} catch (SystemException e) {
					log.error("Error in updating skills of employee"+e);
				}
			empSkill.setEmployeeId(empId);
			empSkill.setYears(exp);
			empSkill.setComments(comments);
			empSkill.setSkillId(skill);
			empSkill.setCreateDate(date);
			empSkill.setModifiedDate(date);
			empSkill.setCompanyId(themeDisplay.getCompanyId());
				try {
						empSkill.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
					} catch (PortalException e1) {
						log.error("Error in obtaining groupId", e1);
					} catch (SystemException e1) {
						log.error("Error in obtaining groupId", e1);
				}
			empSkill.setUserId(themeDisplay.getUserId());
				try {
					EmpSkillLocalServiceUtil.addEmpSkill(empSkill);
					} catch (SystemException e) {
						log.error("Error in updating skills of employee"+e);
				}
		    }
		if (cmd.equals("empLanguage")) {
			log.info("Updating employee language skills");
			empId = ParamUtil.getLong(actionRequest, "empLanId");
			Long language = ParamUtil.getLong(actionRequest, "emp_language");
			String skill = ParamUtil.getString(actionRequest, "lan_skill");
			String fluency = ParamUtil.getString(actionRequest, "lan_fluency");
			EmpLanguage empLanguage = null;
				try {
					empLanguage = EmpLanguageLocalServiceUtil
							.createEmpLanguage(CounterLocalServiceUtil.increment());
				} catch (SystemException e) {
					log.error("Error in saving employee language skills", e);
			   }
			empLanguage.setEmployeeId(empId);
			empLanguage.setLanguageId(language);
			empLanguage.setLanguageSkill(skill);
			empLanguage.setLanguageFluency(fluency);
			empLanguage.setCreateDate(date);
			empLanguage.setModifiedDate(date);
			empLanguage.setCompanyId(themeDisplay.getCompanyId());
				try {
					empLanguage.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
				} catch (PortalException e1) {
					log.error("Error in obtaining groupId", e1);
				} catch (SystemException e1) {
					log.error("Error in obtaining groupId", e1);
			  }
			empLanguage.setUserId(themeDisplay.getUserId());
				try {
					EmpLanguageLocalServiceUtil.addEmpLanguage(empLanguage);
				} catch (SystemException e) {
					log.error("Error in saving employee language skills", e);
				}
		}
		if (cmd.equals("empLicense")) {
			log.info("Updating license information of the employee");
			empId = ParamUtil.getLong(actionRequest, "empLicId");
			long licenseId = ParamUtil.getLong(actionRequest,"emp_license_type");
			String licenseNo = ParamUtil.getString(actionRequest,"emp_license_no");
			String issueDate = ParamUtil.getString(actionRequest,"license_issue_date");
			String expiryDate = ParamUtil.getString(actionRequest,"license_exp_date");
			EmpLicense empLicense = null;
				try {
					empLicense = EmpLicenseLocalServiceUtil
							.createEmpLicense(CounterLocalServiceUtil.increment());
				} catch (SystemException e) {
					log.error("Error in adding license information of the employee", e);
				}
			Date issuedDate=null,expDate=null;
			if(issueDate!=null && issueDate.trim()!="")
					{
					issuedDate=formatDate(issueDate);
					}
			if(expiryDate!=null && expiryDate.trim()!="")
					{
					expDate=formatDate(expiryDate);
					}
			empLicense.setEmployeeId(empId);
			empLicense.setExpiryDate(expDate);
			empLicense.setIssuedDate(issuedDate);
			empLicense.setLicenseNumber(licenseNo);
			empLicense.setLicenseId(licenseId);
			empLicense.setCreateDate(date);
			empLicense.setModifiedDate(date);
			empLicense.setCompanyId(themeDisplay.getCompanyId());
				try {
					empLicense.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
				} catch (PortalException e1) {
					log.error("Error in obtaining groupId", e1);
				} catch (SystemException e1) {
					log.error("Error in obtaining groupId", e1);
			 }
			empLicense.setUserId(themeDisplay.getUserId());
				try {
					EmpLicenseLocalServiceUtil.addEmpLicense(empLicense);
				} catch (SystemException e) {
					log.error("Error in saving license information of the employee", e);
			 }

		}
		Map<String, Comparable> map =setSessionAttributes(empId, fileEntryId, "jsp7");
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		log.info("End of addEmpQualifications method...");
	 }

	public void updateEmpSalaryDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException, IOException {
		log.info("in updateEmpSalaryDetails method");
		long empId = ParamUtil.getLong(actionRequest, "empSalId");
		long fileEntryId = ParamUtil.getLong(actionRequest, "SalFileId");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		String payGradeCurrency = ParamUtil.getString(actionRequest,"emp_paygrade_currency");
		Map<String, Comparable> map = setSessionAttributes(empId, fileEntryId, "jsp10");
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		log.info("End of updateEmpSalaryDetails method");
	 }
	public void updateEmpDirectDeposits(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		log.info("In updateEmpDirectDeposits method ");
		long empId = ParamUtil.getLong(actionRequest, "empDirId");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		long fileEntryId = ParamUtil.getLong(actionRequest, "directFileId");
		long amount = ParamUtil.getLong(actionRequest, "deposit_amount");
		long acntNumber = ParamUtil.getLong(actionRequest,"deposit_acnt_number");
		String finInst = ParamUtil.getString(actionRequest, "fin_institute");
		String acntType = ParamUtil.getString(actionRequest, "acnt_type");
		String brncLocation = ParamUtil.getString(actionRequest,"branch_location");
		String routingNo = ParamUtil.getString(actionRequest, "routing_number");
		EmpDirectDeposit empDirectDeposit = null;
			try {
				empDirectDeposit = EmpDirectDepositLocalServiceUtil
						.createEmpDirectDeposit(CounterLocalServiceUtil.increment());
			} catch (SystemException e) {
				log.error("Error in adding employee direct deposits", e);
		   }
		empDirectDeposit.setAccountNumber(acntNumber);
		empDirectDeposit.setAccountType(acntType);
		empDirectDeposit.setAmount(amount);
		empDirectDeposit.setBankName(finInst);
		empDirectDeposit.setBranchLocation(brncLocation);
		empDirectDeposit.setEmployeeId(empId);
		empDirectDeposit.setRoutingNumber(routingNo);
		empDirectDeposit.setCreateDate(date);
		empDirectDeposit.setModifiedDate(date);
		empDirectDeposit.setCompanyId(themeDisplay.getCompanyId());
			try {
				empDirectDeposit.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
			} catch (PortalException e1) {
				log.error("Error in obtaining groupId", e1);
			} catch (SystemException e1) {
				log.error("Error in obtaining groupId", e1);
		 }
		empDirectDeposit.setUserId(themeDisplay.getUserId());
			try {
				EmpDirectDepositLocalServiceUtil
						.addEmpDirectDeposit(empDirectDeposit);
			} catch (SystemException e) {
				log.error("Error in saving employee direct deposits info...", e);
		 }
		Map<String, Comparable> map = setSessionAttributes(empId, fileEntryId, "jsp11");
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		log.info("End of updateEmpDirectDeposits method ");
	}

	public void addImmigrationDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		log.info("In addImmigrationDetails method");
		long empId = ParamUtil.getLong(actionRequest, "empImgId");
		String docType = ParamUtil.getString(actionRequest, "document_type");
		String number = ParamUtil.getString(actionRequest, "img_number");
		String issuedDate = ParamUtil.getString(actionRequest, "img_issued_date");
		String issuedBy = ParamUtil.getString(actionRequest, "issued_by");
		String eligibleStatus = ParamUtil.getString(actionRequest,"eligible_status");
		String reviewDate = ParamUtil.getString(actionRequest, "review_date");
		String comments = ParamUtil.getString(actionRequest, "img_comments");
		String expiryDate = ParamUtil.getString(actionRequest, "img_exp_date");
		long fileEntryId = ParamUtil.getLong(actionRequest, "immiFileId");
		EmpImmigrationDocument empImmigrationDocument = null;
			try {
				empImmigrationDocument = EmpImmigrationDocumentLocalServiceUtil
						.createEmpImmigrationDocument(CounterLocalServiceUtil
								.increment());
			} catch (SystemException e) {
				log.error("Error in saving immigration details of the employee", e);
		  }
		empImmigrationDocument.setEmployeeId(empId);
		empImmigrationDocument.setDocNumber(number);
		empImmigrationDocument.setIssuedBy(Long.parseLong(issuedBy));
		Date issueDate=null,expDate=null,rewDate=null;
		if(issuedDate!=null && issuedDate.trim()!="")
			{
				issueDate=formatDate(issuedDate);
			}
		if(expiryDate!=null && expiryDate.trim()!="")
			{
				expDate=formatDate(expiryDate);
			}
		if(reviewDate!=null && reviewDate.trim()!="")
			{
				rewDate=formatDate(reviewDate);
			}
		empImmigrationDocument.setIssuedDate(issueDate);
		empImmigrationDocument.setExpiryDate(expDate);
		empImmigrationDocument.setEligibleReviewDate(rewDate);
		empImmigrationDocument.setEligibleStatus(eligibleStatus);
		empImmigrationDocument.setComments(comments);
		empImmigrationDocument.setDocType(docType);
		empImmigrationDocument.setCreateDate(date);
		empImmigrationDocument.setModifiedDate(date);
		empImmigrationDocument.setCompanyId(themeDisplay.getCompanyId());
			try {
				empImmigrationDocument.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
			} catch (PortalException e1) {
				log.error("Error in obtaining groupId", e1);
			} catch (SystemException e1) {
				log.error("Error in obtaining groupId", e1);
		  }
		empImmigrationDocument.setUserId(themeDisplay.getUserId());
			try {
				EmpImmigrationDocumentLocalServiceUtil
						.addEmpImmigrationDocument(empImmigrationDocument);
			} catch (SystemException e) {
				log.error("Error in saving immigration details of the employee", e);
		  }
		Map<String, Comparable> map = setSessionAttributes(empId, fileEntryId, "jsp5");
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		log.info("End of addImmigrationDetails method");
	 }

	public void updateMembership(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		log.info("In updateMembership method");
		long empId = ParamUtil.getLong(actionRequest, "empMemId");
		long fileEntryId = ParamUtil.getLong(actionRequest, "memFileId");
		Map<String, Comparable> map = setSessionAttributes(empId, fileEntryId, "jsp8");
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		log.info("End of updateMembership method");
	 }
	public void deleteEmployee(ActionRequest actionRequest,ActionResponse actionResponse)
	{
		long[] idsArray = ParamUtil.getLongValues(actionRequest,"empIds");
		log.info("length of array"+idsArray.length);
		for (int i = 0; i <= idsArray.length - 1; i++) {
			try {
				try {
					log.info(idsArray[i]);
				Employee employee=EmployeeLocalServiceUtil.getEmployee(idsArray[1]);
				log.info("employe object is "+employee);
				EmployeeLocalServiceUtil.deleteEmployee(employee);
					log.info("Employee deleted successfully");
				  } catch (PortalException e) {
					log.error("Error in deleting emergency contact details",e);
				  } catch (SystemException e) {
					log.error("Error in deleting emergency contact details",e);
				}
			} catch (NumberFormatException e) {
				log.info("Selected all records to delete",e);
			}
		}
		try {
			actionResponse.sendRedirect("jspPage","/html/employee/employeelist.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateEmpJobHistory(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		log.info("In updateEmpJobHistory method");
		long empId = ParamUtil.getLong(actionRequest, "empJId");
		String joinedDate = ParamUtil.getString(actionRequest, "joined_date");
		String probationDte = ParamUtil.getString(actionRequest, "probation_date");
		String dateOfPermanency = ParamUtil.getString(actionRequest,"date_permanency");
		long jobTitle = ParamUtil.getLong(actionRequest, "emp_job_title");
		long employmentStatus = ParamUtil.getLong(actionRequest, "emp_status");
		long jobCategory = ParamUtil.getLong(actionRequest, "emp_job_category");
		long subUnit = ParamUtil.getLong(actionRequest, "emp_sub_unit");
		long location = ParamUtil.getLong(actionRequest, "emp_location");
		String effectiveDate = ParamUtil.getString(actionRequest, "effective_date");
		long workshift = ParamUtil.getLong(actionRequest, "emp_workshift");
		String comments = ParamUtil.getString(actionRequest, "job_comments");
		long fileEntryId = ParamUtil.getLong(actionRequest, "jobFileId");
		Date joinDate=null,prbationDate=null,dateOfPrmanancy=null,effectDate=null;
		if(joinedDate!=null && joinedDate.trim()!="")
			{
				joinDate=formatDate(joinedDate);
			}
		if(probationDte!=null && probationDte.trim()!="")
			{
				prbationDate=formatDate(probationDte);
			}
		if(dateOfPermanency!=null && dateOfPermanency.trim()!="")
			{
				dateOfPrmanancy=formatDate(dateOfPermanency);
			}
		if(effectiveDate!=null && effectiveDate.trim()!="")
			{
				effectDate=formatDate(effectiveDate);
			}
	EmpJob empJob = null;
			try {
				empJob = EmpJobLocalServiceUtil
						.createEmpJob(CounterLocalServiceUtil.increment());
			} catch (Exception e) {
				log.error("Error in adding employee job details",e);
		  }
		empJob.setEmployeeId(empId);
		empJob.setJoinedDate(joinDate);
		empJob.setEffectiveDate(effectDate);
		empJob.setPermanentDate(dateOfPrmanancy);
		empJob.setEmploymentStatusId(employmentStatus);
		empJob.setJobCategoryId(jobCategory);
		empJob.setJobTitleId(jobTitle);
		empJob.setSubUnitId(subUnit);
		empJob.setLocationId(location);
		empJob.setProbationEndDate(prbationDate);
		empJob.setComments(comments);
		empJob.setIsCurrentJob(true);
		empJob.setShiftId(workshift);
		empJob.setCreateDate(date);
		empJob.setModifiedDate(date);
		empJob.setCompanyId(themeDisplay.getCompanyId());
			try {
				empJob.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
			} catch (PortalException e2) {
				log.error("Error in obtaining groupId", e2);
			} catch (SystemException e2) {
				log.error("Error in obtaining groupId", e2);
		  }
		empJob.setUserId(themeDisplay.getUserId());
		  try {
			EmpJobLocalServiceUtil.addEmpJob(empJob);
		  } catch (SystemException e) {
			log.error("Error in adding job details of Employee", e);
		 }
		DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.
				forClass(EmpJob.class,PortletClassLoaderUtil.getClassLoader());
		dynamicQuery.add(RestrictionsFactoryUtil.ne("empJobId", empJob.getEmpJobId()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("employeeId", empId));
		List<EmpJob> empList=null;
			try {
				empList=EmpJobLocalServiceUtil.dynamicQuery(dynamicQuery);
			} catch (SystemException e1) {
				log.error("Error in obtaing job details of Employee", e1);
		  }
		if(empList!=null && empList.size()!=0)
		 {
			Iterator<EmpJob> empJobs=empList.iterator();
			while(empJobs.hasNext())
			{
				EmpJob empJobHistory=empJobs.next();
				empJobHistory.setIsCurrentJob(false);
				try {
					EmpJobLocalServiceUtil.updateEmpJob(empJobHistory);
				} catch (SystemException e) {
					log.error("Error in updating job details of Employee", e);
				}
			}
		  }
		/*
		 * To update the location column in employee when updated in emp_job table
		 */
		Employee employee=null;
			try {
				employee=EmployeeLocalServiceUtil.getEmployee(empId);
			 } catch (PortalException e) {
				log.error("Error in obtaing job details of Employee", e);
			 } catch (SystemException e) {
				log.error("Error in obtaing job details of Employee", e);
		    }
		if(employee!=null)
		{
			employee.setLocationId(location);
			try {
				EmployeeLocalServiceUtil.updateEmployee(employee);
			} catch (SystemException e) {
				log.error("Error in updating employee job location", e);
			}
		} 
		Map<String, Comparable> map = setSessionAttributes(empId, fileEntryId, "jsp9");
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		log.info("End of updateEmpJobHistory method");
	}
	/* (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		log.info("in serve resource mehtod");
		if (resourceRequest.getResourceID().equals("deleteEmergencyContact")) {
			log.info("Deleting Emergency contact records");
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,"emgContactIds");
			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						EmpEmergencyContactLocalServiceUtil
								.deleteEmpEmergencyContact(Long
										.parseLong(idsArray[i]));
						log.info("Emergency contact deleted successfully");
					  } catch (PortalException e) {
						log.error("Error in deleting emergency contact details",e);
					  } catch (SystemException e) {
						log.error("Error in deleting emergency contact details",e);
					}
				} catch (NumberFormatException e) {
					log.info("Selected all records to delete");
				}
			}

		}
		else if (resourceRequest.getResourceID().equals("deleteDependent")) {
			log.info("Deleting Dependent records");
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,"dependentIds");
			for (int i = 0; i <= idsArray.length - 1; i++) {
				try {
					try {
						EmpDependentLocalServiceUtil
								.deleteEmpDependent((Long.parseLong(idsArray[i])));
						log.info("deleted");
					  } catch (PortalException e) {
						log.error("Error in deleting dependent details of employee",e);
					  } catch (SystemException e) {
						  log.error("Error in deleting dependent details of employee",e);
					}
				} catch (NumberFormatException e) {
					log.info("Selected all records to delete");
				}
			}

		}
		else if (resourceRequest.getResourceID().equals("deleteLanguage")) {
			log.info("Deleting Dependent records");
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,"deleteIds");
			for (int i = 0; i <= idsArray.length - 1; i++) {
				try {
					try {
						EmpLanguageLocalServiceUtil
								.deleteEmpLanguage((Long.parseLong(idsArray[i])));
						log.info("deleted");
					  } catch (PortalException e) {
						log.error("Error in deleting language details of employee",e);
					  } catch (SystemException e) {
						  log.error("Error in deleting language details of employee",e);
					}
				} catch (NumberFormatException e) {
					log.info("Selected all records to delete");
				}
			}

		}
		else if (resourceRequest.getResourceID().equals("deleteEmpWorkExp")) {
			log.info("Deleting Dependent records");
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,"deleteIds");
			for (int i = 0; i <= idsArray.length - 1; i++) {
				try {
					try {
						EmpWorkExpLocalServiceUtil
								.deleteEmpWorkExp((Long.parseLong(idsArray[i])));
						log.info("deleted");
					  } catch (PortalException e) {
						log.error("Error in deleting work experience details of employee",e);
					  } catch (SystemException e) {
						log.error("Error in deleting work experience details of employee",e);
					}
				} catch (NumberFormatException e) {
					log.info("Selected all records to delete");
				}
			}

		}
		else if (resourceRequest.getResourceID().equals("deleteLicense")) {
			log.info("Deleting Dependent records");
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,"deleteIds");
			for (int i = 0; i <= idsArray.length - 1; i++) {
				try {
					try {
						EmpLicenseLocalServiceUtil
								.deleteEmpLicense((Long.parseLong(idsArray[i])));
						log.info("deleted");
					  } catch (PortalException e) {
						log.error("Error in deleting license details of employee",e);
					  } catch (SystemException e) {
						  log.error("Error in deleting license details of employee",e);
					}
				} catch (NumberFormatException e) {
					log.info("Selected all records to delete");
				}
			}

		}
		else if (resourceRequest.getResourceID().equals("deleteSkill")) {
			log.info("Deleting Dependent records");
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,"deleteIds");
			for (int i = 0; i <= idsArray.length - 1; i++) {
				try {
					try {
						EmpSkillLocalServiceUtil
								.deleteEmpSkill((Long.parseLong(idsArray[i])));
						log.info("deleted");
					  } catch (PortalException e) {
						log.error("Error in deleting employee skills",e);
					  } catch (SystemException e) {
						log.error("Error in deleting employee skills",e);
					}
				} catch (NumberFormatException e) {
					log.info("Selected all records to delete");
				}
			}

		}
		else if (resourceRequest.getResourceID().equals("deleteEducation")) {
			log.info("Deleting Dependent records");
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,"deleteIds");
			for (int i = 0; i <= idsArray.length - 1; i++) {
				try {
					try {
						EmpEducationLocalServiceUtil
								.deleteEmpEducation((Long.parseLong(idsArray[i])));
						log.info("deleted");
					  } catch (PortalException e) {
						log.error("Error in deleting education details of employee",e);
					  } catch (SystemException e) {
						  log.error("Error in deleting education details of employee",e);
					}
				} catch (NumberFormatException e) {
					log.info("Selected all records to delete");
				}
			}

		}
		else if (resourceRequest.getResourceID().equals("deleteImmigrationDetails")) {
			log.info("Deleting Immigration details of employee");
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,"immigrationIds");
			for (int i = 0; i <= idsArray.length - 1; i++) {
				try {
					try {
						EmpImmigrationDocumentLocalServiceUtil
								.deleteEmpImmigrationDocument((Long.parseLong(idsArray[i])));
						log.info("Immigration details deleted successfully");
					} catch (PortalException e) {
						log.error("Error in deleting immigration details of employee",e);
					} catch (SystemException e) {
						log.error("Error in deleting immigration details of employee",e);
					}
				} catch (NumberFormatException e) {
					log.info("selected all records to delete");
				}
			}

		}

		else if (resourceRequest.getResourceID().equals("updateImage9")) {
			log.info("Updating employee image...");
			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(resourceRequest);
			File newImage = uploadRequest.getFile("newImage");
			String fileName=uploadRequest.getFileName("newImage");
			long fileEntryId2 = ParamUtil.getLong(uploadRequest,"imageIdtoUpdate");
			String changeLog = ParamUtil.getString(resourceRequest, "changeLog");
			ServiceContext serviceContext = null;
			try {
				try {
					serviceContext = ServiceContextFactory.getInstance(
							DLFileEntry.class.getName(), resourceRequest);
				} catch (SystemException e) {
					log.error("Error in updating employee image",e);
				}
			} catch (PortalException e1) {
				log.error("Error in updating employee image",e1);
			}
			DLFileEntry updateImage = null;
			try {
					updateImage = DLFileEntryLocalServiceUtil
							.getDLFileEntry(fileEntryId2);
				} catch (PortalException e) {
					log.error("Error in updating employee image",e);
				} catch (SystemException e) {
					log.error("Error in updating employee image",e);
				}
			if (updateImage != null) {
				try {
					DLAppLocalServiceUtil.updateFileEntry(
							themeDisplay.getUserId(), fileEntryId2,
							fileName+date.getTime(), "image/jpeg", fileName+date.getTime(), "",
							changeLog, true, newImage, serviceContext);
				} catch (PortalException e) {
					log.error("Error in updating employee image",e);
				} catch (SystemException e) {
					log.error("Error in updating employee image",e);
				}
			}
			PrintWriter out = resourceResponse.getWriter();
			log.info("Image updated successfully");

		}

		else if (resourceRequest.getResourceID().equals("displayImage")) {
			long fileEntryId = ParamUtil.getLong(resourceRequest, "imageId");
			DLFileEntry b = null;
			try {
					b = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
					} catch (PortalException e) {
						log.error("Error in displaying employee image",e);
					} catch (SystemException e) {
						log.error("Error in displaying employee image",e);
				}
			InputStream is = null;
			try {
					is = b.getContentStream();
					} catch (PortalException e1) {
						log.error("Error in displaying employee image",e1);
					} catch (SystemException e1) {
						log.error("Error in displaying employee image",e1);
				}

			if (is != null) {
				byte[] imgData = null;
				imgData = IOUtils.toByteArray(is);
				if (imgData != null) {
					resourceResponse.setContentType("image/jpg");
					OutputStream o = resourceResponse.getPortletOutputStream();
					o.write(imgData);
					o.flush();
					o.close();
				}
			}
		} else if (resourceRequest.getResourceID().equals("supervisorsAutoComplete")) {
			List<EmpPersonalDetails> l = null;
			try {
					l = EmpPersonalDetailsLocalServiceUtil.getEmpPersonalDetailses(-1, -1);
				} catch (SystemException e) {
					log.error("Error in obtaining personal details of the employee");
				}
			String userEnteredText = ParamUtil.getString(resourceRequest,"userEnteredText");
			JSONArray usersJSONArray = JSONFactoryUtil.createJSONArray();
			DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(
					EmpPersonalDetails.class,PortletClassLoaderUtil.getClassLoader());
			Criterion criterion = RestrictionsFactoryUtil.like("firstName",
					StringPool.PERCENT + userEnteredText + StringPool.PERCENT);
			userQuery.add(criterion);
			JSONObject userJSON = null;
			try {
				List<EmpPersonalDetails> userList = EmpPersonalDetailsLocalServiceUtil
						.dynamicQuery(userQuery);
				for (EmpPersonalDetails personalDetails : userList) {
					userJSON = JSONFactoryUtil.createJSONObject();
					userJSON.put("firstName", personalDetails.getFirstName());
					userJSON.put("id", personalDetails.getEmployeeId());
					System.out.println(personalDetails.getFirstName());
					System.out.println(personalDetails.getEmployeeId());
					usersJSONArray.put(userJSON);
				}
			 } catch (Exception e) {
				 log.error("Error in obtaining list of employee names");
				 
			}
			PrintWriter out = resourceResponse.getWriter();
			out.println(usersJSONArray.toString());
		} else if (resourceRequest.getResourceID().equals("dependencyDropdown")) {
			String currency = ParamUtil.getString(resourceRequest,"dropDownValue");
			DynamicQuery currencyDynamicQuery = DynamicQueryFactoryUtil
					.forClass(PayGradeCurrency.class,PortletClassLoaderUtil.getClassLoader());
			currencyDynamicQuery.add(PropertyFactoryUtil.forName("payGradeId")
					.eq(Long.parseLong(currency)));
			List<PayGradeCurrency> list = null;
			try {
				list = PayGradeCurrencyLocalServiceUtil
						.dynamicQuery(currencyDynamicQuery);
			} catch (SystemException e) {
				log.error("Error in obtaining paygrade curreny list",e);
			}
			JSONArray currencyJsonArray = null;
			if (list != null) {
				currencyJsonArray = JSONFactoryUtil.createJSONArray();
				for (int i = 0; i < list.size(); i++) {
					PayGradeCurrency currencyObj = list.get(i);
					currencyJsonArray.put(currencyObj.getCurrency());
				}
			}
			PrintWriter out = resourceResponse.getWriter();
			System.out.println(currencyJsonArray.toString());
			out.write(currencyJsonArray.toString());
		}
		
		/*Delete code for Docs tab written by sreedhar*/
		
			else if(resourceRequest.getResourceID().equals("deleteDocs")){
				log.info("Deleting document records");
				String[] idsArray = ParamUtil.getParameterValues(resourceRequest,"documentIds");
				for (int i = 0; i <= idsArray.length - 1; i++) {
					try {
						log.info("idArray values "+idsArray[i]);
							try {
								log.info("before servicebuilder method");
								EmpAttachmentLocalServiceUtil.deleteEmpAttachment((Long.parseLong(idsArray[i])));
								log.info("deleted");
							} catch (PortalException e) {
								log.error("Error in deleting dependent details of employee",e);
							}
							
							catch(SystemException e){
								log.error("Error in deleting dependent details of employee",e);
							
							}
						}
					catch(NumberFormatException e){
						log.error("selected all records are deleted");

					}
				}
			}
			
		else {
			log.error("in serveResource method:Resource is not matched");
		}
	}

/*	public void addEmployee(ActionRequest actionRequest,ActionResponse actionResponse)
			throws IOException,PortletException, SystemException {
		log.info("In addEmployee method");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);
		Long location = ParamUtil.getLong(uploadRequest, "location");
		String firstName = ParamUtil.getString(uploadRequest,EMPLOYEE_FIRST_NAME_COL_NAME);
		String middleName = ParamUtil.getString(uploadRequest,EMPLOYEE_MIDDLE_NAME_COL_NAME);
		String lastName = ParamUtil.getString(uploadRequest,EMPLOYEE_LAST_NAME_COL_NAME);
		String empNo = ParamUtil.getString(uploadRequest, "employee_no");
		String username = ParamUtil.getString(uploadRequest, "user_name");
		String password = ParamUtil.getString(uploadRequest, "password");
		File uploadPhoto = uploadRequest.getFile("emp_photograph");
		String fileName=uploadRequest.getFileName("emp_photograph");
		String contentType = MimeTypesUtil.getContentType(uploadPhoto);
		System.out.println("content type is" + contentType);
		String changeLog = ParamUtil.getString(actionRequest, "changeLog");
		System.out.println("changeLog" + changeLog);
		EmpContactDetails empContactDetails = null;
		Employee employee = null;
		EmpPersonalDetails empPersonalDetails = null;
		employee = EmployeeLocalServiceUtil
				.createEmployee(CounterLocalServiceUtil.increment());
		employee.setLocationId(location);
		employee.setUserId(themeDisplay.getUserId());
		employee.setCompanyId(themeDisplay.getCompanyId());
			try {
				employee.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
			} catch (PortalException e2) {
				log.error("Error in obtaining groupId",e2);
			}
		employee.setCreateDate(date);
		employee.setModifiedDate(date);
		EmployeeLocalServiceUtil.addEmployee(employee);
		empPersonalDetails = EmpPersonalDetailsLocalServiceUtil
				.createEmpPersonalDetails(CounterLocalServiceUtil.increment());
		empPersonalDetails.setEmployeeId(employee.getPrimaryKey());
		empPersonalDetails.setFirstName(firstName);
		empPersonalDetails.setMiddleName(middleName);
		empPersonalDetails.setLastName(lastName);
		empPersonalDetails.setEmployeeNo(empNo);
		empPersonalDetails.setUserId(themeDisplay.getUserId());
		empPersonalDetails.setCompanyId(themeDisplay.getCompanyId());
		empPersonalDetails.setCreateDate(date);
		empPersonalDetails.setModifiedDate(date);
		EmpPersonalDetailsLocalServiceUtil
				.addEmpPersonalDetails(empPersonalDetails);
		EmpJob empJob=EmpJobLocalServiceUtil.createEmpJob(CounterLocalServiceUtil.increment());
		empJob.setCreateDate(date);
			try {
				empJob.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
			} catch (PortalException e2) {
				log.error("Error in obtaining groupId",e2);
			}
		empJob.setEmployeeId(employee.getEmployeeId());
		empJob.setLocationId(employee.getLocationId());
		empJob.setUserId(themeDisplay.getUserId());
		empJob.setCompanyId(themeDisplay.getCompanyGroupId());
		empJob.setIsCurrentJob(true);
		EmpJobLocalServiceUtil.addEmpJob(empJob);
		ServiceContext serviceContext = null;
		FileEntry fileEntry = null;
			try {
				serviceContext = ServiceContextFactory.getInstance(
						DLFileEntry.class.getName(), actionRequest);
			} catch (PortalException e1) {
				log.error("Error in adding image of the employee",e1);
			}
			try {
				fileEntry = DLAppLocalServiceUtil.addFileEntry(
						themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
						0, fileName+date.getTime(), contentType,
						fileName+date.getTime(), contentType,
						" ", uploadPhoto, serviceContext);
			} catch (PortalException e1) {
				log.error("Error in adding image of the employee",e1);
			}
		if (fileEntry.getExpandoBridge().hasAttribute("employeeId")) {
			fileEntry.getExpandoBridge().setAttribute("employeeId",
					String.valueOf(employee.getEmployeeId()));
		   }  else {
			log.info("No expando attribute available with the name employeeId for DLFileEntry table");
				try {
					fileEntry.getExpandoBridge().addAttribute("employeeId");
				} catch (PortalException e) {
					log.error("Error while adding expando attribute to DLFileEntry table",e);
				}
		  }
		fileEntry.getExpandoBridge().setAttribute("employeeId",String.valueOf(employee.getEmployeeId()));
		try {
			DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(),
					fileEntry.getFileEntryId(), fileName,
					contentType, fileName,"",
					changeLog, false, uploadPhoto, serviceContext);
		} catch (PortalException e) {
			log.error("Error in adding image of the employee",e);
		}
		if (username != null || password != null) {
			User user = null;
			try {
				user = UserLocalServiceUtil.addUser(themeDisplay.getUserId(),
						themeDisplay.getCompanyId(), false, password, password,
						true, "", username
								+ "@liferay.com", 0L, "",
						themeDisplay.getLocale(), firstName,
						middleName,  lastName, 0, 0, false, 0, 1,
						1970, "", null, null, null, null, false,
						new ServiceContext());
			}
				if (user.getExpandoBridge().hasAttribute("employeeId")) {
					user.getExpandoBridge().setAttribute("employeeId",
							String.valueOf(employee.getEmployeeId()));
					UserLocalServiceUtil.updateUser(user);
				} else {
					log.info("No expando attribute available with the name employeeId for User table");
					user.getExpandoBridge().addAttribute("employeeId");
					user.getExpandoBridge().setAttribute("employeeId",
							String.valueOf(employee.getEmployeeId()));
					UserLocalServiceUtil.updateUser(user);
				}
				
				catch (PortalException e) {
				log.error("Error in updating employee with user details",e);
				}
			if (user != null) {
				Employee employee2 = null;
				try {
					employee2 = EmployeeLocalServiceUtil.getEmployee(employee
							.getEmployeeId());
				} catch (PortalException e) {
					log.error("Error in updating employee with user details",e);
				}
				employee2.setAssignedUserId(user.getUserId());
				EmployeeLocalServiceUtil.updateEmployee(employee2);
			}
			if (fileEntry != null) {
				Employee employee3 = null;
				try {
					employee3 = EmployeeLocalServiceUtil.getEmployee(employee
							.getEmployeeId());
				} catch (PortalException e) {
					log.error("Error in updating employee with user details",e);
				}
				employee3.setImageId(fileEntry.getFileEntryId());
				EmployeeLocalServiceUtil.updateEmployee(employee3);

			}
		}
		Map<String, Comparable> map = setSessionAttributes(employee.getEmployeeId(),
				fileEntry.getFileEntryId(), "jsp0");
		actionRequest.getPortletSession(true).setAttribute("empId", map,PortletSession.APPLICATION_SCOPE);

	}*/
	public void updateEmpDocuments(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException,
			SystemException {
		log.info("In updateEmpDocuments method");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		long employeeId = ParamUtil.getLong(uploadRequest, "docEmployeeId");
		String docCategory = ParamUtil.getString(uploadRequest,	"doc_related_to");
		String description=ParamUtil.getString(uploadRequest, "doc_comments");
		String fileName=uploadRequest.getFileName("emp_files");
		File document = uploadRequest.getFile("emp_files");
		log.info("document name is "+fileName);
		long fileEntryId = ParamUtil.getLong(uploadRequest, "QualFileId");
		ServiceContext serviceContext = null;
		String changeLog = ParamUtil.getString(uploadRequest, "changeLog");
		String contentType = MimeTypesUtil.getContentType(document);
		FileEntry fileEntry = null;EmpAttachment empAttachment=null;
			try {
				serviceContext = ServiceContextFactory.getInstance(
						DLFileEntry.class.getName(), actionRequest);
			} catch (PortalException e1) {
				log.error("Error in saving employee documents", e1);
			}
			try {
				fileEntry = DLAppLocalServiceUtil.addFileEntry(
						themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
						0, fileName+date.getTime(), contentType, fileName+date.getTime(), description, " ",
						document, serviceContext);
			} catch (PortalException e1) {
				log.error("Error in saving employee documents", e1);
			}
			if(fileEntry!=null)
			{
				String fileExt=fileEntry.getExtension();
				String regex="[0-9]";
				Pattern pattern=Pattern.compile(regex);
				Matcher matcher=pattern.matcher(fileExt);
				if(matcher.find())
				{
					fileExt=fileExt.substring(0	, matcher.start());
				}
				empAttachment=EmpAttachmentLocalServiceUtil.createEmpAttachment(CounterLocalServiceUtil.increment());
				empAttachment.setAttachmentTypeId(fileEntry.getFileEntryId());
				empAttachment.setUuid(fileEntry.getUuid());
				empAttachment.setCreateDate(fileEntry.getCreateDate());
				empAttachment.setModifiedDate(fileEntry.getModifiedDate());
				empAttachment.setEmployeeId(employeeId);
				empAttachment.setRelatedTo(docCategory);
				empAttachment.setFileName(fileName);
				empAttachment.setFileSize(fileEntry.getSize());
				empAttachment.setFileType(fileExt);
				empAttachment.setUserName(fileEntry.getUserName());
				empAttachment.setComment(description);
				EmpAttachmentLocalServiceUtil.addEmpAttachment(empAttachment);
				
			}
		/*if (fileEntry != null) {
			if (fileEntry.getExpandoBridge().hasAttribute("employeeId")) {
				fileEntry.getExpandoBridge().setAttribute("employeeId",String.valueOf(employeeId));
			}
			else {
				try {
					fileEntry.getExpandoBridge().addAttribute("employeeId");
				} catch (PortalException e) {
					log.error("Error while adding expando attribute to DLFileEntry table",e);
				}
				fileEntry.getExpandoBridge().setAttribute("employeeId",String.valueOf(employeeId));
			}

			try {
				DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(),
						fileEntry.getFileEntryId(), fileName,
						contentType, fileName, description,
						changeLog, false, document, serviceContext);
			} catch (PortalException e) {
				log.error("Error while updating employee documents", e);
			}*/
			Map<String, Comparable> map =setSessionAttributes(employeeId, fileEntryId, "jsp12");
			actionRequest.getPortletSession(true).setAttribute("empId", map,PortletSession.APPLICATION_SCOPE);
			actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
			/*} else {
			log.error("Error occured while adding documents of employee");
		}
*/
	}
	public void doView(RenderRequest renderRequest,RenderResponse renderResponse)
	{ 
		String jsp=renderRequest.getParameter("jsp");
		long fileEntryId = ParamUtil.getLong(renderRequest, "fileId");
		Long empId = ParamUtil.getLong(renderRequest, "empId");
		PortletSession addEmpSession=renderRequest.getPortletSession();
		String employeeJsp="/html/employee/edit_employee.jsp";
		String empListJsp="/html/employee/employeelist.jsp";
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId=themeDisplay.getCompanyId();
		long userId=themeDisplay.getUserId();
		long groupId=0;
		try {
			groupId=themeDisplay.getLayout().getGroup().getGroupId();
		} catch (PortalException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (SystemException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		long layoutId=themeDisplay.getLayout().getLayoutId();
		Role role=null;
		Employee employee=null;
		Layout layout=null;
		try  {
			layout=LayoutLocalServiceUtil.getLayout( groupId,false,layoutId);
			log.info("layout object is "+layout);
		      } catch (PortalException e2) {
			log.info("Error in getting the layout with primary key"+layoutId,e2);
		      } catch (SystemException e2) {
			log.info("Error in getting the layout with primary key"+layoutId,e2);
		  }
		
	
		DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(Employee.class,PortletClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("assignedUserId").eq(userId));
		try {
			role=RoleLocalServiceUtil.getRole(companyId,"Hrm user");
			log.info("role object is "+role);
			List<Employee> empList=EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(empList!=null && empList.size()!=0)
			    {
				employee=empList.get(0);
		    	}
      		} catch (PortalException e1) {
		        log.info("Role is "+role,e1);
	        } catch (SystemException e1) {
		        log.info("Role is "+role,e1);
      		}
		if(role!=null && employee!=null) 
		{
			if(role.getName().equalsIgnoreCase("Hrm User") && userId==employee.getAssignedUserId())
			{
				if(layout!=null)
				{
					layout.setName("My Info");
					try {
						LayoutLocalServiceUtil.updateLayout(layout);
						log.info("layout name is "+layout.getTitle());
					} catch (SystemException e) {
						log.info("Cannot change layout title in at user role hrm",e);
					}
				}
			}
			else
			{
				if(layout!=null)
				{
					layout.setName("Employee List");
					try {
						LayoutLocalServiceUtil.updateLayout(layout);
						log.info("layout name is "+layout.getTitle());
					} catch (SystemException e) {
						log.info("Cannot change layout title in at user role hrm",e);
					}
				}
			}
		}
		Map employeeMap=(Map)renderRequest.getPortletSession(false).getAttribute("empId",addEmpSession.APPLICATION_SCOPE);
		if(jsp!=null)
		{ 
			Map<String, Comparable> map = setSessionAttributes(empId, fileEntryId, jsp);
			renderRequest.getPortletSession(true).setAttribute("empId", map,
					PortletSession.APPLICATION_SCOPE);
			try {
					this.include(employeeJsp, renderRequest, renderResponse);
				} catch (IOException e) {
					log.error("Error in getting requested jsp", e);
				} catch (PortletException e) {
					log.error("Error in getting requested jsp", e);
			}
		}
		else if(employeeMap!=null && employeeMap.get("jsp")=="empEditJsp" && (Long)employeeMap.get("empId")!=0 && AddEmployee.checkPageRedirect>checkRedirect)
		{
			
			Map<String, Comparable> map = setSessionAttributes((Long)employeeMap.get("empId"), 
					(Long)employeeMap.get("fileId"),(String) employeeMap.get("jsp"));
			renderRequest.getPortletSession(true).setAttribute("empId", map,
					PortletSession.APPLICATION_SCOPE);
			try {
				this.include(employeeJsp, renderRequest, renderResponse);
			} catch (IOException e) {
				log.error("Error in getting requested jsp", e);
			} catch (PortletException e) {
				log.error("Error in getting requested jsp", e);
			}
				checkRedirect++;
		}
		else if(role!=null && employee!=null) 
		{
			if(role.getName().equalsIgnoreCase("Hrm User") && userId==employee.getAssignedUserId())
			{
			Map<String, Comparable> map = setSessionAttributes(employee.getEmployeeId(), employee.getImageId(), "jsp0");
			renderRequest.getPortletSession(true).setAttribute("empId", map,
					PortletSession.APPLICATION_SCOPE);
			try {
					this.include(employeeJsp, renderRequest, renderResponse);
				} catch (IOException e) {
					log.error("Error in getting requested jsp", e);
				} catch (PortletException e) {
					log.error("Error in getting requested jsp", e);
			 }
			}
		}
		else 
		{
			log.info("In else block of doView");
			try {
				this.include(empListJsp, renderRequest, renderResponse);
			} catch (IOException e) {
				log.error("Error in getting requested jsp", e);
			} catch (PortletException e) {
				log.error("Error in getting requested jsp", e);
			}
		}
		
	}
	
}