package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.M_Action;

/**
 * Servlet implementation class N_Control
 */
@WebServlet("/center/*")
public class N_Control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String [] location = request.getRequestURI().substring((request.getContextPath() + "/center/").length()).split("/");
		
			request.setAttribute("loca", location[0]);
			request.setAttribute("mainUrl", location[1]);
			
			
			M_Action action = (M_Action)Class.forName("service." + location[1]).newInstance();
			action.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("../../view/template.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
