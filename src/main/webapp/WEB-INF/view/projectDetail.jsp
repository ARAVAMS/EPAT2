<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
 
<html>
<head>
 <title>Project Detail</title> 
	
	 <link href="${pageContext.request.contextPath}/css/jquery-ui.css" rel="stylesheet" type="text/css" />
	 <link href="${pageContext.request.contextPath}/css/jquery.dataTables.css" rel="stylesheet" type="text/css" />
	  <link href="${pageContext.request.contextPath}/css/rt3.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery/jquery.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.dataTables.js"></script>	
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/projectDetail.js"></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-ui.js"></script>
	 
	 
	 
	 
	 
	
</head>
<body>


<table class="table">
	<tr><td height="10px"></td></tr>
	<tr align="left">
		<td valign="top">
			<fieldset> 
				<legend class="sub_header">Project Detail</legend>
				<table id="projectDetail" class="table" width="100%">
				
					<tbody></tbody>
					
				</table>
			</fieldset>
		</td>
	</tr>
</table>
<div id="divIFrame" style="display: none; width:100%">	
	<iframe src="" id="projectDetailIFrame"> </iframe>
</div>

<div id="divIFrame" style="display: none; width:100%">	
	<iframe src="" id="imageIFrame"> </iframe>
</div>

</body>
</html>