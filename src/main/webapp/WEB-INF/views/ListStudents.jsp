<%@page import="com.bean.StudentBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	List<StudentBean> students = (List<StudentBean>) request.getAttribute("students");
	%>


	<table border="1">
		<tr>
			<td>StudentId</td>
			<td>FirstName</td>
			<td>LastName</td>
			<td>Action</td>
		</tr>
		
		
		<%
			for(StudentBean s:students){
		%>
				<tr>
					<td><%=s.getStudentId() %></td>
					<td><%=s.getFirstName() %></td>
					<td><%=s.getLastName() %></td>
					<td><a href="deletestudent?studentId=<%=s.getStudentId()%>">Delete</a></td>
				</tr>
				
		<%} %>
	</table>

</body>
</html>