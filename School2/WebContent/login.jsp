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
<br>
<form action="login" method="post" style="text-align:center;">
<h1 style="color:red;">${smsg}</h1>
<h2 style="color:purple;"> USER LOGIN </h2>

<label>UserName:</label>
<input type="text" name="userName"/><br><br>
<label>Password:</label>
<input type="text" name="passwords"/><br><br>

<input type="submit" value="login" style="background-color:orange;"/>
<a href="/School2/index.jsp" style="background-color:gray;">BACK</a>
<br>
<br>
<br>

<jsp:include page="/footer.jsp"></jsp:include>
</form>
</body>
</html>