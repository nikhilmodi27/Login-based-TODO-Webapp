package notes.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import notes.dao.TodoUpdateDao;

import java.io.IOException;

@WebServlet("/Edit")
public class TodoEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TodoEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String desc = request.getParameter("description");
		String status = request.getParameter("isDone");
        
		TodoUpdateDao tf = new TodoUpdateDao();
		boolean ch2 = tf.updatetodo(id,title,desc,status);
		
		if (ch2) {
			response.sendRedirect("todo_list.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
