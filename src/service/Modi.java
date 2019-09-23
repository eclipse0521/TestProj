package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.M_Action;
import model.CenterDAO;

public class Modi implements M_Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("data", new CenterDAO().Modify(request.getParameter("id"),
				request.getParameter("title"),
				request.getParameter("content")));
	}

}
