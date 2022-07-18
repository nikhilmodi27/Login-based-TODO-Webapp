package notes.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import notes.dao.Logindao;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String un = request.getParameter("username");
		String ps = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Logindao ld = new Logindao();
		Boolean check = ld.checkuser(un,ps);
		
		if(check) {
			HttpSession session = request.getSession();
			session.setAttribute("uname",un);
			RequestDispatcher rd = request.getRequestDispatcher("todo_list.jsp");
			rd.forward(request, response);
			doGet(request, response);
		}
		else {
			out.println("<script>alert('username or password is not correct')</script>");
			RequestDispatcher rd2 = request.getRequestDispatcher("login.jsp");
			rd2.include(request, response);
			doGet(request, response);
		}
	}

}
