<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<layout:extends name="layout.jsp">
	<layout:put block="content">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Usuario</th>
					<th>Email</th>
					<th>Rango</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${agentList}" var="anAgent">
					<tr>
						<td>${anAgent.id}</td>
						<td>${anAgent.username}</td>
						<td>${anAgent.email }</td>
						<td>${anAgent.rank}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</layout:put>
</layout:extends>