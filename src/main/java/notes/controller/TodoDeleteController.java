package notes.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import notes.dao.TodoDeleteDao;

import java.io.IOException;

@WebServlet("/Delete")
public class TodoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TodoDeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Integer id = Integer.parseInt(request.getParameter("id"));

		TodoDeleteDao tl = new TodoDeleteDao();
		boolean ch = tl.deletetodo(id);

		if (ch) {
			response.sendRedirect("todo_list.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
