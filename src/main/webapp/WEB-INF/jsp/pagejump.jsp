<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedList"%>
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

.test{
	height:50px;
	width:200px;
	background-color: #ffcccc
	color: white;
}
</style>
 <body>

 <br>
 <br>
	<table border="1" align="center">
		<tr>
			<td><b> Depth Id</b></td>
			<td><b> First Page</b></td>
			<td><b> Next Page</b></td>
			<td><b> Page Depth count</b></td>
		</tr>
		
		
		<%
		Map<String, Integer> hash = (Map<String, Integer>)request.getAttribute("depthIdWithPageDepthCount");
		
		try
		{
			Set<Entry<String, Integer>> entryset = hash.entrySet(); 
			
			for (Entry<String, Integer> entry : entryset) 
			{
				Integer values= entry.getValue();
				String key= entry.getKey();
				String[] parts = key.split(":");


		%>
		<tr>
			
			<td><%=parts[0]%></td>
			<td><%=parts[1]%></td>
			<td><%=parts[2]%></td>
			<td><%=values.toString().replace("[", "").replace("]", "")%></td>
			
		</tr>
		
		<%
			}}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
		%>
	</table>


</body>
</html>




