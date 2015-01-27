<%@ include file="/html/skill/init.jsp" %>
<portlet:actionURL var="updateSkills" name="updateSkill">
</portlet:actionURL>
<portlet:resourceURL var="deleteSkills" id="deleteSkill"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/skill/add.jsp" />
</portlet:renderURL>
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
    var node = A.one('#cancel');
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
<% 
  Skill editSkill = (Skill) portletSession.getAttribute("editSkill");
if(SessionMessages.contains(renderRequest.getPortletSession(),"skillName-empty-error")){%>
<p id="editSkillMessage" class="alert alert-error"><liferay-ui:message key="Please Enter Skill Name"/></p>
<%} 
 
%>
<div id="editSkillForm">
  <aui:form name="myForm" action="<%=updateSkills.toString()%>">
  	<div class="form-horizontal">
		<aui:input name="skillId" type="hidden" id="skillId"  value="<%=editSkill.getSkillId()%>"/>
		<aui:input label="name" name="skill_name" type="text" required ="true" value="<%=editSkill.getSkillName() %>" showRequiredLabel="false"></aui:input>
		<aui:input type="textarea" label="Description" name="skill_description" rows="5" cols="5" ></aui:input>	 
		<div class="control-group">	
			<div class="controls">	
			<button type="submit" class="btn btn-primary"><i class="icon-ok"></i></button>
			<button  type="reset" id ="cancel" class="btn btn-danger"><i class="icon-remove"></i></button>
			</div>
		</div>
	</div>
	</aui:form>
</div>
</body>
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/skill/edit.jsp");
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
long groupId=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery skillDynamicQuery = DynamicQueryFactoryUtil
.forClass(Skill.class,
		PortletClassLoaderUtil.getClassLoader());
skillDynamicQuery.add(PropertyFactoryUtil.forName("groupId")
.eq(groupId));
List<Skill> skillDetails = SkillLocalServiceUtil
.dynamicQuery(skillDynamicQuery);
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Skill> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Jobcategory"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
		 List<Skill> skillList = skillDetails;
		OrderByComparator orderByComparator =  CustomComparatorUtil.getSkillsrOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(skillList,orderByComparator);
  
               results = ListUtil.subList(skillList, searchContainer.getStart(), searchContainer.getEnd());
               total = skillList!=null && skillList.size()!=0  ?skillList.size():0;
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Skill" keyProperty="skillId" modelVar="skillId"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="name" property="skillName" orderableProperty="skillName"/>
			     <liferay-ui:search-container-column-text orderable="<%=true %>" name="description" property="description" orderableProperty="description"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/skill/editClick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</html>





