<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<style>
 table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
} 

tr:nth-child(even) {
	background-color:#ffe6e6
}
</style>
 <body>


	<table border="1" align="center">
 		<tr>
			<td><b> Page Route</b></td>
			<td><b> Page Route Count</b></td>
		</tr>
		<%
			Map<String, Integer> pageRouteDepthCountHashMap = (Map<String, Integer>) request.getAttribute("pageRouteDepthHashMap");
			Set<Entry<String, Integer>> entryset = pageRouteDepthCountHashMap.entrySet(); 
			
			for (Entry<String, Integer> entry : entryset) 
			{
				Integer values= entry.getValue();
				String key= entry.getKey();
		%>
		<tr>
			<td><%=key%></td>
			<td><%=values.toString().replace("[", "").replace("]", "")%></td>
		</tr>
		
		<%
			}
		%>
	</table>


</body>
</html>