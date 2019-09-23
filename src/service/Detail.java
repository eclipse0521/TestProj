package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.M_Action;
import model.CenterDAO;

public class Detail implements M_Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		new CenterDAO().Update(request.getParameter("id"));
		request.setAttribute("data", new CenterDAO().detail(request.getParameter("id")));
	}

}
