package notes.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import notes.dao.Userdao;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class Usercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Usercontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String uname = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(fname);
		System.out.println(lname);
		System.out.println(uname);
		System.out.println(password);

		try {
			Userdao ub = new Userdao();
			System.out.println("hello");
			ub.adduser(fname,lname,uname,password);
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			out.println("<script>alert('User Added Successfully')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			//response.sendRedirect("login.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
