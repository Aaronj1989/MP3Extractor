
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<h1>MP3 List</h1>

<body>

<jsp:include page="submitpath.jsp"/>

<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Artist</th>
		<th>title</th>
		<th>Year</th>
	</tr>
	<c:if test = "${empty mp3List}">
	<h2>No MP3's found in directory  </h2>
	</c:if>
	
	<c:forEach var="mp3" items="${mp3List}">

		<tr>
			<td>${mp3.artist}</td>
			<td>${mp3.title}</td>
			<td>${mp3.year}</td>
		</tr>

	</c:forEach>
</table>
</body>
</html>