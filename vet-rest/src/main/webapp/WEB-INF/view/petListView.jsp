<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Pets</title>
</head>
<body>
<%@ include file="header.jspf" %>
	<table border="1px" style="border-collapse: collapse">
		<tr>
			<th>Moniker</th>
			<th>Owner</th>
			<th>Age</th>
			<th>Species</th>
			<th><a href="change">Pet</a></th>
			<th>Visitations</th>
		</tr>
		<c:forEach items="${pets }" var="pet">
			<tr>
				<td>${pet.moniker }</td>
				<td>${pet.owner.name }${pet.owner.surname }</td>
				<td>${pet.age }</td>
				<td>${pet.species }</td>
				<td><a href="change?id=${pet.id}">Update</a></td>
				<td><a href="../visitations/get?petId=${pet.id }">Visitations</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>