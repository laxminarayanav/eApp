eApp ![This is a rknowsys eApp!](http://rknowsys.com/assets/img/logo.gif) 
====

### The Human Resource Application in Liferay 
<small>
[Official website](http://rknowsys.com/)&bull;
[Project Page](http://r-knowsys.github.io/eApp)

</small>

---

###What is eApp?
eApp aka Enterprise application is an Human Resource Management portal in Liferay for enterprises. It provides employee information management , employee absence management, employee performance evaluation and other HR management tools.
Employee information management includes storing details like personal and contact details, qualifications, job history, salary components like allowances and gross pay and documents related to these categories.
Absent managements deals with the Leave accruals and entitlements.
Employee reports are generated to evaluate the performance of the Employee.
###Who will use this project?
Small and medium enterprises.
###Who is behind this?
Enthusiastic Developers of R-Knowsys Technologies, which uses best of breed Open source technologies to build highly reliable, low maintenance solutions providing best ROI in the industry are behind the eApp HR application.

###How to contribute?
1.       Fork eApp v1.0 branch where the actual development commits go.
2.       Set up your development environment.

```
a) In eclipse(preferably LiferayIDE), launch a new workspace. For example: D:/eApp/workspace_eApp

b) File --> Import --> Git --> Projects from Git --> "Select Repository Source", choose "Clone URI" option. Click Next.

c) In "Source Git Repository" enter details: URI: "https://github.com/username/eApp.git" Check that the fields are filed up for host, repository path and protocol. (Host: "github.com". repository path:"R-Knowsys/eApp.git". Protocol: "https"). Authentication: and ***Note: Do not check "Store in Secure Store".

d) All branches on Github for eApp fork will be listed. Check the branch from which, you want to check out the codebase. Example : "master"

e) Provide "Local Destination" to a folder on your system (in the same drive where Liferay server is installed, otherwise the project ant builds throws relative path errors). 
For example: D:\eApp. 
All files will be fetched from the remote branch to your system. This is location of cloned repository. 
Click Next.

f)  On the 'select a wizard for importing projects' page, the option 'Import existing projects' is selected by default. The files start downloading. 
This will take few minutes depending upon internet speed.

g) 'Import Projects' page will list all the portlets projects available in the remote branch. 
Check all. Click Finish.

h) Open Liferay perspective. If you don't have the Liferay perspective then follow this link to get one http://www.liferay.com/community/wiki/-/wiki/Main/Liferay+IDE+Installation+Guide

i)   Add a liferay server (in left bottom portion) to point to the directory where liferay 6.2 CE Server (Tomcat 7) is available. In my machine this location is D:/eApp/liferay-portal-6.2-ce-ga2/tomcat-7.0.42.

j)   In sdk project, rename the build.sample.properties to build.COMPUTERNAME.properties. The user I log onto my machine is 'lenovo'.  Modify the contents in this file to reflect the paths on your system.

k)  Right clicking on build.xml in services-portlet gives a context menu and then Liferay-->Build-Services. 
This will generate all services related classes in service-portlet-service.jar.

l)   Deploy the services-portlet. The database will get generated.

```    

3.       Configure remotes
4.       Pick up an issue from the list of open issues.
5.       Start sending pull requests to the v1.0 branch.

###What is v1.0 branch means?
v1.0 branch is the development branch for the First Release

###How to configure remotes?
If you are using git windows follow these steps.
```
Configure remotes to keep your forked repository in sync with the original repo.Navigate to your local repository location in command prompt. 
         
a) Check for configured remotes with the command ‘git remote  -v’
                               origin    https://github.com/username/eApp.git 
                               origin    https://github.com/username/eApp.git 
        
b)Add a new remote to configure fetch from R-Knowsys/eApp with command 
‘git remote add rknowsys(can be any name) https://github.com/R-Knowsys/eApp.git’.
                rknowsys   https://github.com/R-Knowsys/eApp.git 
                               rknowsys  https://github.com/R-Knowsys/eApp.git 
c)Type ‘git fetch   rknowsys’ command.  Keep updating regularly to avoid conflicts in the source.
d)Type ‘git merge  rknowsys/v1.0(any branch that need to be in sync with)’ to apply the remote changes to local repository.
e)The changes made in the local repository should be pushed to the your forked repository and then you need to send a pull request.
```

###How do I know that an issue is still open?
See the label under the issues.
###Where do I find the documentation?
Documentation is available in git wiki.
###What will happen to my pull request?
Project collaborator reviews the changes made by you and merges the commits to original repository.
Follow the below link to know more about the pull requests. https://help.github.com/articles/using-pull-requests 
###When will I get to know that my pull request is being reviewed?
As soon as the pull request is being reviewed a message will be sent to the contributor.
###Can I propose for new features?
Yes, You can create a new issue under github issue tracker for the eApp repository.
