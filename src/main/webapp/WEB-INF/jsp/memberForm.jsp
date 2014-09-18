<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member Form</title>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
</head>
<body>
	<form:form method="post" modelAttribute="member">
		<table>
			<tr>
				<td>Member Name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Member Phone</td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Member Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>