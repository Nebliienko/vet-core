<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Visits</title>
</head>
<body>
<%@ include file="header.jspf" %>
    <table border="1px" style="border-collapse: collapse">
        <tr>
            <th>Veterinary</th>
            <th>Pet</th>
            <th>Reason</th>
            <th>Visit time</th>
            <th>Information</th>
            <a href="change?petId=${petId}">Add new Visit</a>
        </tr>
        <c:forEach items="${visits }" var="visit">
            <tr>
                <td>${visit.veterinary.name } ${visit.veterinary.surname }</td>
                <td>${visit.pet.moniker }</td>
                <td>${visit.reason }</td>
                <td>${visit.visitTime }</td>
                <td>${visit.information }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>