package io.loli.kaoqin.servlet;

import io.loli.kaoqin.javabean.MonthStatus;
import io.loli.kaoqin.service.MonthStatusService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MonthStatusServlet
 */
@WebServlet("/MonthStatusServlet")
public class MonthStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MonthStatusService mss ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonthStatusServlet() {
        super();
        mss=new MonthStatusService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = (String)request.getParameter("action");
		if(action.equals("submit")){
			submit(request,response);
		}else if(action.equals("back")){
			back(request,response);
		}else if(action.equals("approve")){
			approve(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	
	private void submit(HttpServletRequest request, HttpServletResponse response) {
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		MonthStatus ms = mss.findById(m_id);
		ms.setSubmitted(true);
		mss.update(ms);
	}
	
	private void back(HttpServletRequest request, HttpServletResponse response) {
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		MonthStatus ms = mss.findById(m_id);
		ms.setSubmitted(false);
		ms.setApproved(false);
		mss.update(ms);
	}
	private void approve(HttpServletRequest request, HttpServletResponse response) {
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		MonthStatus ms = mss.findById(m_id);
		ms.setSubmitted(true);
		ms.setApproved(true);
		mss.update(ms);
	}
}
