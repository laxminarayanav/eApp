<%@page import="com.rknowsys.eapp.hrm.service.EmpAttachmentLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmpAttachment"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL var="updateEmpDocuments" name="updateEmpDocuments"></portlet:actionURL>
<portlet:resourceURL var="deleteDocs" id="deleteDocs"></portlet:resourceURL>

<portlet:renderURL var="listdocs">
	<portlet:param name="mvcPath" value="/html/employee/edit_employee.jsp"/>
</portlet:renderURL>

<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	String jsp = (String) empId.get("jsp");
	long fileEntryId = (Long) empId.get("fileId");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	DynamicQuery attachmentDynamicQuery=DynamicQueryFactoryUtil.forClass(EmpAttachment.class, PortalClassLoaderUtil.getClassLoader());
	attachmentDynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(employeeId));
	List<EmpAttachment> documentList=EmpAttachmentLocalServiceUtil.dynamicQuery(attachmentDynamicQuery);
%>
<%!public String humanReadableByteCount(double bytes, boolean si) {
		int unit = si ? 1000 : 1024;
		if (bytes < unit)
			return bytes + " B";
		int exp = (int) (Math.log(bytes) / Math.log(unit));
		String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1)
				+ (si ? "" : "i");
		return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}%>
<aui:script use="aui-form-validator, aui-overlay-context-panel,aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function(){
window.selectCategory= function(nodeValue)
     {
		var selectedCategoryValue=nodeValue;
		 if(selectedCategoryValue=="-1")
		 {
		 alert("Please select a category");
		 }
      };  
   });
var validator1 = new A.FormValidator({
     boundingBox: document.<portlet:namespace />add_documents,
     rules: {
            <portlet:namespace />doc_related_to: {
            required: true
            }},
     fieldStrings: {
            <portlet:namespace />doc_related_to: {
            required: '<liferay-ui:message key="01_select-doc-category"></liferay-ui:message>'
              }
             }
});
var A=new AUI();
A.ready(function()
  {
   A.one('#addingDocuments').hide();
   var addButton=A.one('#<portlet:namespace />addNewDocument');
   addButton.on('click',function()
     {
	   A.one('#<portlet:namespace />addNewDocument').hide();
	   A.one('#<portlet:namespace />deleteDocument').hide();
	   A.one('#addingDocuments').show();
	   A.all('input[type=text]').set('disabled',false);
	   A.all('select').set('disabled',false);
	   A.all('input[type=radio]').set('disabled',false);
   });
   var cancelButton=A.one('#<portlet:namespace />cancelDocumentAdd');
   cancelButton.on('click',function()
   {
	   A.one('#addingDocuments').hide();
	   A.one('#<portlet:namespace />addNewDocument').show();
       A.one('#<portlet:namespace />deleteDocument').show();
   });
  });
<!-- Delete code for Docs tab written by sreedhar-->  
 AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#<portlet:namespace/>deleteDocument');
    node.on(
      'click',
      function() {
     var idArray = [];
      A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      idArray.push(object.get("value"));
    
        });
       if(idArray==""){
			  alert("Please select document!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected Document?");
		  if(d){
		   var url = '<%=deleteDocs%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />documentIds: idArray,  
                 },
          on: {
               success: function() { 
                   alert('deleted successfully');
                   window.location='<%=listdocs%>';
              },
               failure: function() {
                  
                 }
                }
                 }
                );
		  																		
		  console.log(idArray);
	  
      return true;
  }
  else
    return false;
}             
      }
    );
  }
);
  
</aui:script>
<liferay-portlet:renderURL  varImpl="documentsURL">
		<portlet:param name="jsp" value="jsp12"/>
		<portlet:param name="empId" value="<%=String.valueOf(employeeId) %>" />
		<portlet:param name="fileId" value="<%=String.valueOf(fileEntryId) %>"/>
		</liferay-portlet:renderURL>
<div id="addingDocuments" class="panel">
	<div class="panel-heading">
		<h3>
			<liferay-ui:message key="01_add-documents"></liferay-ui:message>
		</h3>
	</div>
	<div class="panel-body">
		<aui:form name="add_documents" id="add_documents"
			enctype="multipart/form-data" action="<%=updateEmpDocuments%>">
			<aui:input name="docEmployeeId" type="hidden"
				value="<%=employeeId%>"></aui:input>
			<aui:input name="QualFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
			<aui:input name="doc_emp" type="hidden"></aui:input>
			<aui:select name="doc_related_to" id="doc_related_to"
				onChange="javascript:selectCategory(this.value)"
				label="Document Related To">
				<aui:option value="">--Select--</aui:option>
				<aui:option value="Personal Details">Personal Details</aui:option>
				<aui:option value="Contact Details">Contact Details</aui:option>
				<aui:option value="Dependents">Dependents</aui:option>
				<aui:option value="Immigration Details">Immigration Details</aui:option>
				<aui:option value="Reporting Details">Reporting Details</aui:option>
				<aui:option value="Qualification">Qualifications</aui:option>
				<aui:option value="Memberships">Memberships</aui:option>
				<aui:option value="Job History">Job History</aui:option>
				<aui:option value="Salary History">Salary History</aui:option>
				<aui:option value="Direct Deposit">Direct Deposit</aui:option>
			</aui:select>
			<aui:input name="emp_files" type="file" label="Select File"
				showRequiredLabel="false">
				<aui:validator name="required"></aui:validator>
			</aui:input>
			<aui:input name="doc_comments" label="Comments"></aui:input>
			<aui:button type="submit" value="Save" cssClass="button btn-primary"></aui:button>
			<aui:button type="reset" value="Cancel" id="cancelDocumentAdd" name="cancelDocumentAdd"
				cssClass="button btn-danger"></aui:button>
		</aui:form>
	</div>
</div>
<div id="addDeleteDocuments" class="panel">
	<div class="panel-heading">
		<h3>Documents</h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
			<aui:button id="addNewDocument" name="addNewDocument" value="Add"
				cssClass="button btn-primary"></aui:button>
			<aui:button id="deleteDocument" name="deleteDocument" value="Delete"
				cssClass="button btn-danger"></aui:button>
		</div>
	</div>
	<%!com.liferay.portal.kernel.dao.search.SearchContainer<DLFileEntry> searchContainer;%>
	<liferay-ui:search-container delta="5"
		emptyResultsMessage="no-records-available-for-employee"
		deltaConfigurable="true" rowChecker="<%= new RowChecker(renderResponse) %>" iteratorURL="<%=documentsURL %>">
		<liferay-ui:search-container-results>
			<%
			/* 	long classNameId = ClassNameLocalServiceUtil
								.getClassNameId(DLFileEntry.class);
						long companyId = PortalUtil.getDefaultCompanyId();
						List<ExpandoValue> values = ExpandoValueLocalServiceUtil
								.getColumnValues(companyId, classNameId,
										ExpandoTableConstants.DEFAULT_TABLE_NAME,
										"employeeId", String.valueOf(employeeId),
										-1, -1);
						System.out.println("is expando value empty? " + values.isEmpty());
						Set<DLFileEntry> files = new HashSet<DLFileEntry>();
						//temp user object
						DLFileEntry fileEntry;

						//iterate through list of ExpandoValues and for each
						// element try to find corresponding user object
						for (int i = 0; i < values.size(); i++) {
							long fileId = values.get(i).getClassPK();
							try {
								System.out.println(fileId);
								long fileEntryId2 = DLAppLocalServiceUtil
										.getFileVersion(fileId).getFileEntryId();
								fileEntry = DLFileEntryLocalServiceUtil
										.getDLFileEntry(fileEntryId2);
								System.out.println("file entry id is"
										+ fileEntry.getFileEntryId());
								files.add(fileEntry);
								System.out.println("is file entry objects available with expando value "
										+ files.isEmpty());
							} catch (Exception e) {
								System.out.println("exception occured is" + e.getMessage());
							}
						}
						List<DLFileEntry> fileEntries=new ArrayList<DLFileEntry>(files);
						results = ListUtil.subList(fileEntries, searchContainer.getStart(), searchContainer.getEnd());
						total = fileEntries.size();
						pageContext.setAttribute("results", results);
						pageContext.setAttribute("total", total); */
						List<EmpAttachment> documents=documentList;
						results = ListUtil.subList(documents, searchContainer.getStart(), searchContainer.getEnd());
						total = documents.size();
						pageContext.setAttribute("results", results);
						pageContext.setAttribute("total", total); 
			%>
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row  className="EmpAttachment" modelVar="empDocument"  rowVar="curRow" keyProperty="empAttachmentId"
	escapedModel="<%=true %>">
			<liferay-ui:search-container-column-text orderable="true" name="Name"
				property="fileName" href='<%=themeDisplay.getPortalURL()+"/c/document_library/get_file?uuid="+empDocument.getUuid()+"&groupId="+themeDisplay.getScopeGroupId() %>' />
			<liferay-ui:search-container-column-text orderable="true"
				name="Related To" property="relatedTo" />
				<liferay-ui:search-container-column-text orderable="true"
				name="Description" property="comment" />
			<liferay-ui:search-container-column-text orderable="true"
				name="Size" value='<%=humanReadableByteCount(empDocument.getFileSize(), true) %>' />
			<liferay-ui:search-container-column-text orderable="true"
				name="Type" property="fileType" />
			<liferay-ui:search-container-column-text orderable="true"
				name="Date Added"  value='<%=sdf.format(empDocument.getCreateDate()) %>'/>
			<liferay-ui:search-container-column-text orderable="true"
				name="Added by" property="userName" />
			<%-- <liferay-ui:search-container-column-jsp name="edit"
		path="/html/employee/editClick.jsp" /> --%>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />

	</liferay-ui:search-container>
</div>