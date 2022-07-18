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
       SELECT * from todo WHERE ID="<%=Integer.parseInt(request.getParameter("id"))%>";  
     </sql:query>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #08871b">
			<div>
				<a href="" class="navbar-brand"> Todo App</a>
			</div>

		</nav>
	</header>
	<h2 style="text-align: center; margin-top: 5px; color: green;">Edit
		Todo</h2>

	<div class="container col-md-5" style="margin-top: 30px;">
		<div class="card">
			<div class="card-body">
				<c:forEach var="table" items="${rs.rows}">

					<form action="Edit">
						<input type="hidden" name="id"
							value="<c:out value="${table.ID}" />">
						<fieldset class="form-group">
							<label>Todo Title</label> <input type="text"
								value="<c:out value="${table.TITLE}" />" class="form-control"
								name="title" required="required" minlength="5">
						</fieldset>

						<fieldset class="form-group">
							<label>Todo Decription</label> <input type="text"
								value="<c:out value="${table.DESCRIPTION}" />"
								class="form-control" name="description" minlength="5">
						</fieldset>

						<fieldset class="form-group">
							<label>Todo Status</label> <select class="form-control"
								name="isDone">
								<option value="In Progress">In Progress</option>
								<option value="Complete">Complete</option>
							</select>
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
					</form>
				</c:forEach>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
