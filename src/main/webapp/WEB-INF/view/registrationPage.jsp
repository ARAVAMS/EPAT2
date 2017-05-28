<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta charset='utf-8' />
<title>Registration form</title>
 	 <link href="${pageContext.request.contextPath}/css/rt3.css" rel="stylesheet" type="text/css" />
 	  <link href="${pageContext.request.contextPath}/css/organization.css" rel="stylesheet" type="text/css" />
	 <link href="${pageContext.request.contextPath}/css/jquery-ui.css" rel="stylesheet" type="text/css" />	
	 <script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery/jquery.min.js'></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.watermarkinput.js"> </script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/rt3.js"> </script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/organization.js"> </script>
	
</head>

<body class="background-color">

<table width="100%">
		<tr>
			<td id="epatBody">


<form:form id="employeeForm" name="employeeForm" modelAttribute="employeeForm" >
<div align="center" class="header div_space">
	EPAT Login
</div>

<div align="center" class="header div_space">
	<table>
		<tr>
			<td>
				<form:input type="text" width="80%" id="userId" path="userId" title="Phone,Email,UserName"  maxlength="200" class="required"/>
			</td>
		</tr>

		<tr>
			<td>
				<form:input type="password" id="pwd" path="pwd" title="Password"  class="required" />
			</td>
		</tr>
	</table>
</div>	

<div align="right" style="margin-right: 300px;">
	<table>
			<tr>
				<td>
					<Button id="save" type="button" name="save" onclick="saveEmployee()">LOGIN</Button>
				</td>
			</tr>
	</table>
</div>
</form:form>

<form:form id="organizationForm" name="organizationForm" modelAttribute="organizationForm" >
<div align="center" class="header div_space">
	EPAT Registration Form
</div>
<div align="center" class="header div_space">
	<table>
		<tr>
			<td>
				<form:input type="text" width="80%" id="orgName" path="orgName" title="Organization Name"  maxlength="200" class="required"/>
			</td>
		</tr>

		<tr>
			<td>
				<form:input type="text" id="orgAdd1" path="orgAdd1" title="Organization Address1" class="required" />
			</td>
		</tr>
		
		<tr>
			<td>
				<form:input type="text" id="orgAdd2" path="orgAdd2"  title="Organization Address2" class="required" />
			</td>
		</tr>
	</table>
</div>	

<div align="right" style="margin-right: 300px;">
	<table>
			<tr>
				<td>
					<Button id="saveBtnId" type="button" name="saveBtn" onclick="saveOrganization()">SIGN UP</Button>
				</td>
			</tr>
	</table>
</div>
</form:form>
</td>
			</tr>
	</table>

</body>
</html>