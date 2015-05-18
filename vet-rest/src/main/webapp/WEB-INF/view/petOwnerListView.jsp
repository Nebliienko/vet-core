<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PetOwners</title>
</head>
<body>
<%@ include file="header.jspf" %>
    <table border="1px" style="border-collapse: collapse">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Age</th>
            <th>Email</th>
            <th><a href="change">Pet Owner</a></th>
        </tr>
        <c:forEach items="${petOwners }" var="petOwner">
            <tr>
                <td>${petOwner.name }</td>
                <td>${petOwner.surname }</td>
                <td>${petOwner.age }</td>
                <td>${petOwner.email }</td>
            <td><a href="change?id=${petOwner.id}">Update</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>