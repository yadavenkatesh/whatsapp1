<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Edit Details
<form action="${pageContext.request.contextPath}/updateStudent" method="post">
Student Id : <input type="text" name="studId" readonly="readonly" value="${student.studId}"/>
Student Name : <input type="text" name="name" value="${student.name}"/>
College Name : <input type="text" name="college" value="${student.college}"/>
<input type="submit" value="Update">
</form>
</body>
</html>