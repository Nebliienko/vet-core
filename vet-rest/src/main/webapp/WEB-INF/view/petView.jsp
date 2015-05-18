<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Pet</title>
</head>
<body>
	<form:form method="POST" action="create" commandName="pet">
        <form:hidden path="id" />
		<table>
			<tr>
				<td><form:label path="moniker">Moniker</form:label></td>
				<td><form:input path="moniker" /></td>
				<td><form:errors path="moniker"/></td>
			</tr>
			<tr>
				<td><form:label path="age">Age</form:label></td>
				<td><form:input path="age" /></td>
                <td><form:errors path="age"/></td>
			</tr>
            <tr>
                <td><form:label path="species">Species</form:label></td>
                <td><form:select path="species" items="${species }"/></td>
            </tr>
			<tr>
				<td><form:label path="owner.id">Owner</form:label></td>
				<td><form:select path="owner.id" items="${petOwners }"
                        itemLabel="name" itemValue="id"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>