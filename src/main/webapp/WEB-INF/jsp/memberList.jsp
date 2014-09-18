<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Message List</title>
</head>
<body>

	<table>
		<tr>
			<th>Name</th>
			<th>Phone</th>
			<th>email</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${members}" var="member">
			<tr>
				<td>${member.name}</td>
				<td>${member.phone}</td>
				<td>${member.email}</td>
				<td colspan="2"><a href="delete?memberName=${member.name}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr />

	<a href="add">Add Member</a>
</body>
</html>