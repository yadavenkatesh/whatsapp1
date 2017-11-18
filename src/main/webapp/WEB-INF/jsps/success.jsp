<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 tdansitional//EN" "http://www.w3.org/td/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function deleteUsers() {
	document.forms[0].action="deleteStudent";
	document.forms[0].submit();
}

function editButton(studentId) {
	var action = "getStudent/"+studentId;
	document.forms[0].action=action;
	document.forms[0].submit();
}
</script>
<body>
<a href="<c:url value="/j_spring_security_logout" />">logout</a>
<form action="">
<table border="1" />
<tr>
<th>Student Id</th>
<th>Studnet Name</th>
<th>College</th>
</tr>
<c:forEach  var="std" items="${stdList}">
    <tr>
        <td><c:out value="${std.studId}"/></td>
        <td><c:out value="${std.name}"/></td>
        <td><c:out value="${std.college}"/></td>
        <td><input type="checkbox" id="check" name="checkId" value="${std.studId}"/></td>
        <td><input type="button" id="${std.studId}" name="editbtn" value="Edit" onclick="editButton(this.id)"/></td>
       </tr>
</c:forEach>
</table>
<input type="button" onclick="deleteUsers()" value="Delete">
</form>
</body>
</html>