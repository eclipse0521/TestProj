package service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.M_Action;
import model.CenterDAO;
import model.CenterDTO;

public class WriteIn implements M_Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CenterDTO dto = new CenterDTO();
		
		dto.setPname("관리자");
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
//		dto.setCate((String)request.getAttribute("loca"));
		
		int id = new CenterDAO().insert(dto);
		request.setAttribute("data", new CenterDAO().detail(request.getParameter("id")));
		
		RequestDispatcher dp = request.getRequestDispatcher("../../view/template.jsp");
		dp.forward(request, response);
		
	}

}
