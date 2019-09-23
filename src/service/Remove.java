package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.M_Action;
import model.CenterDAO;

public class Remove implements M_Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		new CenterDAO().Delete(request.getParameter("id"));
		request.setAttribute("data", new CenterDAO().list((String)request.getAttribute("loca")));
	}
}
