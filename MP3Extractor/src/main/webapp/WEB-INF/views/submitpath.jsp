<html  xmlns="http://java.sun.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
 
    >
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix ="form"%>

<head>
<meta charset="ISO-8859-1"></meta>
<title>Insert Path</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styles.css"></link>
	
	
</head>
<h1>submit a directory with the desired mp3 files you want to extract</h1> <a href="${pageContext.request.contextPath}/showAllMp3Data">show All</a>
<body>
<form:form action = "${pageContext.request.contextPath}/"  modelAttribute="mp3Extractor"> 
<table>
<tr>
<td>
<form:input path ="path" />
</td>
<td>
<form:errors path="path" cssClass="error-message"/>
</td>
</tr>
<tr>
<td><input type="submit"/></input></td>
</tr>
</table>
</form:form>
</body>
</html>
