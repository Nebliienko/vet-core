<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PetOwner</title>
</head>
<body>
    <form:form method="POST" action="create" commandName="visitHistory">
        <form:hidden path="pet.id" />
        <table>
            <tr>
                <td><form:label path="reason">Reason</form:label></td>
                <td><form:input path="reason" /></td>
                <td><form:errors path="reason" /></td>
            </tr>
            <tr>
                <td><form:label path="visitTime">Visit time</form:label></td>
                <td><form:input path="visitTime" /></td>
                <td><form:errors path="visitTime" /></td>
            </tr>
            <tr>
                <td><form:label path="information">Information</form:label></td>
                <td><form:input path="information" /></td>
            </tr>
            <tr>
                <td><form:label path="veterinary.id">Veterinary</form:label></td>
                <td><form:select path="veterinary.id" items="${veterinaries }"
                        itemLabel="name" itemValue="id" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>