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
<div style="text-align:center;">
<h1>View Student List</h1>
<table border="1" style="width:1500px;">
<tr>
<th>Student Id</th>
<th>Student Name</th>
<th>Student Email</th>
<th>Student Number</th>
<th>Student Address</th>
</tr>
<c:forEach var="sList" items="${studentList}">
			
			<tr>
				<td>${sList.studentId}</td>
				<td>${sList.studetName }</td>				
				<td>${sList.emailAddress }</td>
				<td>${sList.mobileNumber }</td>
				<td>${sList.address }</td>
				
			</tr>
		</c:forEach>
		</table>
<a href="/School2/welcome.jsp">Back Home</a>
</div>
<br>
<br>
<br>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>