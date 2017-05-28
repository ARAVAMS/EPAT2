<!DOCTYPE html>
<%@page	language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	
</head>

<body>
	<table class="table">
		<tr>
			<td ><tiles:insertAttribute name="header"/></td>
		</tr>
		
		<tr>
			<td  width="82%"valign="top"><tiles:insertAttribute name="body"/></td>
		</tr>
		<tr>
			<td id="rt3Footer" colspan="3"><tiles:insertAttribute name="footer"/></td>
		</tr>
	</table>
</body>

</html>