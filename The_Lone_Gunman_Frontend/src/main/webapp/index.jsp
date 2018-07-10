<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
	<layout:extends name="layout.jsp">
		<layout:put block="content">	
			<div class="page-header">
			  <h1>Bienvenido <b>${usuario}</b></h1>
			</div>
		</layout:put>
	</layout:extends>