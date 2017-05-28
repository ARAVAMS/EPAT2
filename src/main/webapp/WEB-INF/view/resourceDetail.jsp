<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<html>
<head>
<meta charset='utf-8' />
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/jquery-ui.min.css' />
<link href='${pageContext.request.contextPath}/css/fullcalendar.css' rel='stylesheet' />
<link href="${pageContext.request.contextPath}/css/rt3.css" rel="stylesheet" type="text/css" />
<link href='${pageContext.request.contextPath}/css/fullcalendar.print.css' rel='stylesheet' media='print' />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/rt3.js"> </script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/moment.min.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery/jquery.min.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/fullcalendar.min.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/lang-all.js'></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/resourceDetail.js"> </script>

<style>
	body {
		margin: 0;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#top {
		background: #eee;
		border-bottom: 1px solid #ddd;
		padding: 0 10px;
		line-height: 40px;
		font-size: 12px;
	}

	#calendar {
		max-width: 900px;
		margin: 40px auto;
		padding: 0 10px;
	}

</style>
</head>

<body>
	
<h1> Header Would be here </h1>
<h3>User Information</h3>
<table width="60%">
	   <tr>
			<td width="30%">
			Resource Name:
			</td>
			  <td width="70%">
					<select name="resourceName" id="resourceName" align="left"  > 
									<option value="blank"> - Select Resource Name- </option>
									<option value="0">Siva1</option>
									<option value="1">Siva2</option>
									<option value="2">Siva3</option>
									<option value="3">Siva4</option>
									<option value="4">Siva5</option>
					</select>
			   </td>
		</tr>
		<tr>
		
	</table> 


	<div id='top'>

		Language:
		<select id='lang-selector'></select>

	</div>

	<div id='calendar'></div>

</body>
</html>