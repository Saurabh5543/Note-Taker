
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.hib.util.*"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All notes: Note Taker</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>

	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1 class="text-uppercase">All Notes:</h1>


		<div class="row">

			<div class="col-12">

				<%
				SessionFactory factory =hiber_utility.getSessionFactory();
					Session s = factory.getCurrentSession();
					Transaction txn = s.beginTransaction();
				Query q = s.createQuery("from Note");
				List<Note> list = q.list();
				for (Note note : list) {
				%>

				<div class="card mt-3" >
					<img class="card-img-top m-4 mx-auto" style="max-width:100px;" src="img/noteimage.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%= note.getTitle() %></h5>
						<p class="card-text">
						<%= note.getContent() %>
						</p>
						<p ><b class="text-primary"><%= note.getAddedDate()  %></b></p>
						<div class="container text-center mt-2">
						<a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger">Delete</a>
						<a href="edit.jsp?note_id=<%= note.getId() %>" class="btn btn-primary">Update</a>
						</div>
					</div>
				</div>


				<%
					}

				txn.commit();
				
				%>


			</div>

		</div>


	</div>
</body>
</html>