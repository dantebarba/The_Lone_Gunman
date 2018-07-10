<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>The Lone Gunman</title>
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://localhost:8080/The_Lone_Gunman_Web/resources/css/message.css">
<layout:block name="header">
</layout:block>
</head>

<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${not empty message}">
		<%@include file="message.jsp"%>
	</c:if>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-8">
				<layout:block name="content">
				</layout:block>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
<layout:block name="script">
</layout:block>
</html>