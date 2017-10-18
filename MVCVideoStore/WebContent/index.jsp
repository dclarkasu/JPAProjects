<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="styles.css" />" rel="stylesheet">

<div class="currentList">
	<h2>Film List</h2>
		<c:forEach var="film" items="${students}">
			<a href="findStudent.do?id=${student.id}">${student.firstName}
			${student.lastName}
			${student.grade }
			</a>
			<br />
		</c:forEach>
</div>