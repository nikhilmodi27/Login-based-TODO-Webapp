<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<title>User Management Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/student" user="root"
		password="Nikhil@8246" />

	<sql:query dataSource="${db}" var="rs">  
       SELECT * from todo WHERE USERNAME="<%=session.getAttribute("uname")%>";  
     </sql:query>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #08871b">
			<div>
				<a href="" class="navbar-brand"> Todo App</a>
			</div>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="logout.jsp"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Todos</h3>
			<hr>

			<h4 style="margin-left: 15px;">
				Hello
				<%=session.getAttribute("uname")%>
			</h4>
			<div class="container text-left">

				<a href="todo_form.jsp" class="btn btn-success">Add Todo</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Description</th>
						<th>Date</th>
						<th>Todo Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="table" items="${rs.rows}">
						<tr>
							<td><c:out value="${table.TITLE}" /></td>
							<td><c:out value="${table.DESCRIPTION}" /></td>
							<td><c:out value="${table.DATE}" /></td>
							<td><c:out value="${table.STATUS}" /></td>

							<td><a style="background-color: green; width: 67px;"
								class="btn btn-primary"
								href="todoupdate.jsp?id=<c:out value='${table.ID}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a style="background-color: red;"
								class="btn btn-primary"
								href="Delete?id=<c:out value='${table.ID}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
