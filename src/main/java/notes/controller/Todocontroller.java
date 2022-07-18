package notes.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import notes.dao.Tododao;

import java.io.IOException;
import java.util.Date;

@WebServlet("/insert")
public class Todocontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Todocontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String title = request.getParameter("title");
		String des = request.getParameter("description");
		String status = request.getParameter("isDone");
		String name = (String)session.getAttribute("uname");
	    
		Date dt = new Date();
	    System.out.println(dt);
		
		Tododao td = new Tododao();
		
		td.addtodo(name,title,des,status,dt);		
		response.sendRedirect("todo_list.jsp");
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
