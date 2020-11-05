<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isErrorPage="true"%>    <!--this says its an error page    -->


 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<img src="resources/img/error.gif"/>
<hr/>

<p>reason</p><%=exception.getLocalizedMessage() %>
<p>Cause</p><%=exception.getCause() %>
<p>Message</p><%=exception.getMessage() %>
<hr/>
</body>
</html>