<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="addReportToEmp" var="addSupervisorEmp">
<portlet:param name="<%=Constants.CMD%>" value="sup_add" /></portlet:actionURL>
<portlet:actionURL name="addReportToEmp" var="addSubordinateEmp">
<portlet:param name="<%=Constants.CMD%>" value="sub_add" />
</portlet:actionURL>
<portlet:resourceURL var="supervisorsAutoComplete" 
id="supervisorsAutoComplete" ></portlet:resourceURL>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
{
A.one('#assignedSupervisorAdd').hide();
A.one('#assignedSubordinateAdd').hide();
A.all('input[type=text]').set('disabled',true);
	A.all('select]').set('disabled',true);
	A.all('input[type=radio]').set('disabled',true);
});
   var addSupButton=A.one('#<portlet:namespace />supervisorAdd');
   addSupButton.on('click',
   function()
   {
   alert("adding supervisor details");
   A.one('#assignedSubordinateAdd').hide();
   A.one('#<portlet:namespace/>supervisorAdd').hide();
   A.one('#<portlet:namespace/>supervisorDelete').hide();
   A.one('#<portlet:namespace/>subordinateAdd').hide();
   A.one('#<portlet:namespace/>subordinateDelete').hide();
   A.one('#assignedSupervisorAdd').show();
   A.all('input[type=text]').set('disabled',false);
   A.all('select').set('disabled',false);
   A.all('input[type=radio]').set('disabled',false);
   });
   var addSubButton=A.one('#<portlet:namespace />subordinateAdd');
   addSubButton.on('click',
   function()
   {
   alert("adding subordinate details");
    A.one('#assignedSupervisorAdd').hide();
    A.one('#<portlet:namespace/>supervisorAdd').hide();
    A.one('#<portlet:namespace/>supervisorDelete').hide();
    A.one('#<portlet:namespace/>subordinateAdd').hide();
    A.one('#<portlet:namespace/>subordinateDelete').hide();
    A.one('#assignedSubordinateAdd').show();
   A.all('input[type=text]').set('disabled',false);
   A.all('select').set('disabled',false);
   A.all('input[type=radio]').set('disabled',false);
   });
   var cancelButton=A.one('#<portlet:namespace/>cancelReportTo');
   cancelButton.on('click',function()
   {
   A.one('#assignedSupervisorAdd').hide();
   A.one('#assignedSubordinateAdd').hide();
   A.one('#supervisorAddDelete').show();
   A.one('#subordinateAddDelete').show();
   A.one('#<portlet:namespace/>supervisorAdd').show();
    A.one('#<portlet:namespace/>supervisorDelete').show();
    A.one('#<portlet:namespace/>subordinateAdd').show();
    A.one('#<portlet:namespace/>subordinateDelete').show();
   });
   var cancelButton2=A.one('#<portlet:namespace/>cancelSubordinate');
   cancelButton2.on('click',function()
   {
   A.one('#assignedSupervisorAdd').hide();
   A.one('#assignedSubordinateAdd').hide();
   A.one('#supervisorAddDelete').show();
   A.one('#subordinateAddDelete').show();
   A.one('#<portlet:namespace/>supervisorAdd').show();
    A.one('#<portlet:namespace/>supervisorDelete').show();
    A.one('#<portlet:namespace/>subordinateAdd').show();
    A.one('#<portlet:namespace/>subordinateDelete').show();
   });
    AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated',
    'autocomplete-filters','autocomplete-highlighters',function (A) {
	var testData;
	new A.AutoCompleteList({
		allowBrowserAutocomplete: 'true',
		activateFirstItem: 'true',
		inputNode: '#<portlet:namespace/>report_sup_name',
		render: 'true',
		resultHighlighter: 'phraseMatch',
		resultTextLocator:'firstName',
		resultFilters:['phraseMatch'],
		source:function(){
		var inputValue=A.one("#<portlet:namespace />report_sup_name").get('value');
		var myAjaxRequest=A.io.request('<%=supervisorsAutoComplete.toString()%>',{
		dataType: 'json',
		method:'POST',
		data:{
		<portlet:namespace />userEnteredText:inputValue,
		},
		autoLoad:false,
		sync:false,
		on: {
		success:function(){
		var data=this.get('responseData');
		testData=data;
		}}
		});
		myAjaxRequest.start();
		return testData;},
		});
	});
</aui:script>
<%
	Map empId = (Map) request.getSession(false).getAttribute(
			"empId");
	long employeeId = (Long)empId.get("empId");
	String jsp=(String)empId.get("jsp");
	DynamicQuery supervisorDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpSupervisor.class,
					PortletClassLoaderUtil.getClassLoader());
	supervisorDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpSupervisor> empSupervisorDetails = EmpSupervisorLocalServiceUtil
			.dynamicQuery(supervisorDynamicQuery);
	DynamicQuery subordinateDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpSubordinate.class,
					PortletClassLoaderUtil.getClassLoader());
	supervisorDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpSubordinate> empSubordinateDetails = EmpSubordinateLocalServiceUtil
			.dynamicQuery(supervisorDynamicQuery);
%>
<div id="assignedSupervisorAdd" class="panel">
	<div class="panel-heading">
		<h3>Add Supervisor</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addSupervisor" id="addSupervisor"
			action="<%=addSupervisorEmp %>" method="post">
			<aui:input name="empSupId" value="<%=employeeId %>"
			type="hidden"></aui:input>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="report_sup_name" id="report_sup_name" 
					label="Name" inlineLabel="left" >
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:select name="reporting_sup_method" label="Reporting Method"
						inlineLabel="left" showRequiredLabel="false">
						<aui:option name="direct">Direct</aui:option>
						<aui:option name="direct">Indirect</aui:option>
						<aui:option name="direct">Other</aui:option>
					</aui:select>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitReportingDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
			name="cancelReportTo" id="cancelReportTo"></aui:button>
		</aui:form>
	</div>
</div>
<div id="assignedSubordinateAdd" class="panel">
	<div class="panel-heading">
		<h3>Add Subordinate</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addSubordinate" id="addSubordinate"
			action="<%=addSubordinateEmp %>" method="post">
			<aui:input name="empSubId" value="<%=employeeId %>"
			type="hidden"></aui:input>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="report_sub_name" label="Name" inlineLabel="left"
						showRequiredLabel="false">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:select name="reporting_sub_method" label="Reporting Method"
						inlineLabel="left" showRequiredLabel="false">
						<aui:option name="direct">Direct</aui:option>
						<aui:option name="direct">Indirect</aui:option>
						<aui:option name="direct">Other</aui:option>
					</aui:select>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="subReportingDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
			name="cancelSubordinate" id="cancelSubordinate"></aui:button>
		</aui:form>
	</div>
</div>
<div id="supervisorAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Supervisors</h3>
	</div>
	<div class="panel-body">
		<aui:button id="supervisorAdd" name="supervisorAdd" value="Add" 
		cssClass="button btn-primary"></aui:button>
		<aui:button id="supervisorDelete" value="Delete"
			name="supervisorDelete" cssClass="button btn-danger" ></aui:button>
			<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpSupervisor"
			deltaConfigurable="true" rowChecker="<%= new RowChecker(renderResponse) %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpSupervisor> supervisorDetails = empSupervisorDetails;
							results = supervisorDetails;
							total = supervisorDetails.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpSupervisor"
				modelVar="id">
				<liferay-ui:search-container-column-text name="Assigned Supervisor" />
				<liferay-ui:search-container-column-text name="Reporting Method"
					property="reportingMethod" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
<div id="subordinateAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Subordinates</h3>
	</div>
	<div class="panel-body">
		<aui:button id="subordinateAdd" name="subordinateAdd" value="Add" 
		cssClass="button btn-primary"></aui:button>
		<aui:button id="subordinateDelete" value="Delete"
			name="subordinateDelete" cssClass="button btn-danger"></aui:button>
			<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpSubordinate"
			deltaConfigurable="true" rowChecker="<%= new RowChecker(renderResponse) %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpSubordinate> subordinateDetails = empSubordinateDetails;
							results = subordinateDetails;
							total = subordinateDetails.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpDependent"
				modelVar="id">
				<liferay-ui:search-container-column-text name="Assigned Subordinate"  />
				<liferay-ui:search-container-column-text name="Reporting Method"
					property="reportingMethod" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
