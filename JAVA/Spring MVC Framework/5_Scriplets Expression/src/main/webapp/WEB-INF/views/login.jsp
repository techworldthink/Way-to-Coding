<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>login</title>
</head>
<%
out.print(request.getParameter("name")); 
Date date = new Date();
%>  
<body>
<p>Login page , Hi ${name}</p>
<p>Current date is <%=date%></p>
</body>
</html>