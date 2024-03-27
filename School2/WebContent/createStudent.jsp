<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<br>
<br>
<form action="student" method="post" style="text-align:center;">
<h1 style="color:orange;">${smsg}</h1>
<h2 style="color:purple;">Create student</h2>

<label>StudentName:</label>
<input type="text" name="studentName"/><br><br>

<label>Email Address:</label>
<input type="text" name="emailAddress"/><br><br>

<label>Mobile Number:</label>
<input type="text" name="mobileNumber"/><br><br>

<label>Address:</label>
<input type="text" name="address"/><br><br>

<input type="submit" value="SAVE" style="background-color:orange;"/>
<a href="/School2/welcome.jsp" style="background-color:gray;">Home</a>
<br>
<br>
<br>
<br>
<jsp:include page="/footer.jsp"></jsp:include>
</form>
</body>
</html>