<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<nav class="navbar navbar-default" role="navigation">

<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse"
		data-target="#example-navbar-collapse">
		<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>

	<a class="navbar-brand" href="<c:url value="/index"/>">Menu backend</a>
</div>

<div class="collapse navbar-collapse" id="example-navbar-collapse">

	<ul class="nav navbar-nav">
		<li><a href="#" class="
			dropdown-toggle"
			data-toggle="dropdown">Espias <b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="<c:url value="/agent/add"/>">Alta</a></li>
				<li><a href="<c:url value="/agent/findAll"/>">Listar Espias</a></li>
			</ul></li>
		<li><a href="#" class="dropdown-toggle" data-toggle="dropdown">Archivos
				<b class="caret"></b>
		</a>
			<ul class="dropdown-menu">
				<li><a href="#">Mis archivos</a></li>
				<li><a href="#">Subir archivo</a></li>
			</ul></li>

		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown"> Mensajeria <b class="caret"></b>
		</a>
			<ul class="dropdown-menu">
				<li><a href="#">Nuevo mensaje</a></li>
				<li><a href="#">Bandeja de entrada</a></li>
			</ul></li>
	</ul>
</div>

</nav>
