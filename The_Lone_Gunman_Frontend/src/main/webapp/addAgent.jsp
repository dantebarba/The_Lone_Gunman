<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
  prefix="layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<layout:extends name="layout.jsp">
	<layout:put block="content">
		<form:form method="post" action="/agent/add">
			<div class="form-group">
				<label for="user">Usuario:</label>
				<form:input path="${agentDto.username}" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="email">Email:</label>
				<form:input path="${agentDto.email}" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:select path="${agentDto.rank}">
					<form:options items="${rankList}" />
				</form:select>
			</div>
			<button type="submit" class="btn btn-default">Guardar</button>
		</form:form>
	</layout:put>
</layout:extends>
