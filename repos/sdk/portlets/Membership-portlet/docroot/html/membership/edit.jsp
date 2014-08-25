<%@ include file="/html/membership/init.jsp" %>
<portlet:actionURL var="updateMemberships" name="updateMembership">
</portlet:actionURL>
<portlet:resourceURL var="deleteMemberships" id="deleteMembership"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/membership/add.jsp" />
</portlet:renderURL>
<%Membership editMembership=(Membership)request.getSession().getAttribute("editMembership"); %>
<style type="text/css">	
.table-first-header{
width: 10%;
}
.table-last-header{
width: 15%;
}
</style>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#deleteMembership');
    node.on(
      'click',
      function() {
     var idArray = [];
      A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      idArray.push(object.get("value"));
    
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected membership?");
		  if(d){
		   var url = '<%=deleteMemberships%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />membershipIds: idArray,  
                 },
          on: {
               success: function() { 
                   alert('deleted successfully');
                   window.location='<%=listview%>';
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
</aui:script><aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#addMembership');
    node.on(
      'click',
      function() {
         A.one('#editMembershipAddDelete').hide();
         A.one('#editMembershipForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editMembershipAddDelete').hide();
 
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editCancelMembership');
    node.on(
      'click',
      function() {
      	  window.location='<%=listview%>';      	
          
      }
    );																																
  }
);

</aui:script>



</head>
<body>
<div class="row-fluid">
	<div id="membershipAddDelete" class="span12">
		<div class="pull-right">
		<button id="addMembership" class="btn btn-success" type="button"><i class="icon-plus"></i> Add </button>
		<button id="deleteMembership" class="btn btn-danger" type="button"><i class="icon-trash"></i> Delete </button>
		</div>
	</div>
</div>
	<div id="editMembershipForm">
  <aui:form name="myForm" action="<%=updateMemberships.toString()%>">
  <aui:input name="membershipId" type="hidden" id="membershipId"  value="<%=editMembership.getId()%>"/>
		<div class="span12">
			<div class="span2">
				<label>Membership Name</label>
		</div>
		<div class="span3">		
		 <input name="<portlet:namespace/>membership_name" type="text" required = "required" value="<%=editMembership.getMembershipName() %>" >
			</div>
		</div>
	<aui:button type="submit" value="Submit"/> <aui:button  type="reset" value="Cancel" id ="editCancelMembership"></aui:button>
	</aui:form>
	</div>
</body>
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/membership/edit.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Membership> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Jobcategory"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<Membership> listOfMemberships = MembershipLocalServiceUtil.getMemberships(searchContainer.getStart(), searchContainer.getEnd());
            OrderByComparator orderByComparator = CustomComparatorUtil.getMembershipOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(listOfMemberships,orderByComparator);
  
          results = listOfMemberships;
          
           
     
               total = MembershipLocalServiceUtil.getMembershipsCount();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Membership" keyProperty="id" modelVar="id"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="name" property="membershipName" orderableProperty="membershipName"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/membership/editClick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</html>





