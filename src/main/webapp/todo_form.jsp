<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #08871b">
			<div>
				<a href="" class="navbar-brand"> Todo
					App</a>
			</div>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<h2 style="text-align:center; margin-top:5px; color:green;">Add Todo</h2>
	<div class="container col-md-5" style="margin-top:30px;">
		<div class="card">
			<div class="card-body">

				<form action="insert">
					<fieldset class="form-group">
						<label>Todo Title</label> <input type="text"
							value="" class="form-control"
							name="title" required="required" minlength="5">
					</fieldset>

					<fieldset class="form-group">
						<label>Todo Decription</label> <input type="text"
							value=""
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
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
