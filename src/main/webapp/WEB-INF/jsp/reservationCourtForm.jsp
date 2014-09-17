<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation court form</title>
<style type="text/css">
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
</head>
<body>
	<form:form method="post" modelAttribute="reservation">
		<table>
			<tr>
				<td>Court Name</td>
				<td><form:input path="courtName" /></td>
				<td><form:errors path="courtName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="hidden" value="0" name="_page" /> 
					<input type="submit" value="Next" name="_target1" /> 
					<input type="submit" value="Cancel" name="_cancel" />
				</td>
			</tr>
		</table>

	</form:form>
</body>
</html>