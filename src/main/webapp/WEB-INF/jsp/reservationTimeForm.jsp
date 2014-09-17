<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Time Form</title>
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
    <td>From Date</td>
    <td><form:input path="fromDate"/></td>
    <td><form:errors path="fromDate" cssClass="error"></form:errors></td>
  </tr>
  <tr>
    <td>To date</td>
    <td><form:input path="toDate"/></td>
    <td><form:errors path="toDate" cssClass="error"></form:errors></td>
  </tr>
  <tr>
    <td>Hour</td>
    <td><form:input path="hour"/></td>
    <td><form:errors path="hour" cssClass="error"></form:errors></td>
  </tr>
  <tr>
    <td>Period</td>
    <td><form:select path="period" items="${periods }"></form:select></td>
    <td><form:errors path="period" cssClass="error"></form:errors></td>
  </tr>
  <tr>
    <td colspan="3">
    <input type="hidden" value="1" name="_page" />
    <input type="submit" value="Previous" name="_target0" />
    <input type="submit" value="Next" name="_target2" />
    <input type="submit" value="Cancel" name="_cancel" />
    </td>
  </tr>
</table>

</form:form>
</body>
</html>