<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<layout:extends name="layout.jsp">
	<layout:put block="content">
		<form role="form">
			<div class="form-group">
				<label for="user">Usuario:</label> <input type="text"
					class="form-control" required id="user" value="${agent.username }">
			</div>
			<div class="form-group">
				<label for="email">Usuario:</label> <input type="email"
					class="form-control" required id="email" value="${agent.email }">
			</div>
			<div class="form-group">
				<select name="rankSelection">
					<c:forEach items="${rankList}" var="aRank">
						<option value="${aRank}" ${agent.rank == aRank ? 'selected' : ''}>${aRank}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="state">Usuario:</label> <input type="text"
					class="form-control" readonly id="state" value="${agent.state }">
			</div>
			<button type="button" class="btn btn-default">Editar</button>
		</form>
	</layout:put>
</layout:extends>