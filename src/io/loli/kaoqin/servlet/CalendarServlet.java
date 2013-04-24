package io.loli.kaoqin.servlet;

import io.loli.kaoqin.service.CalendarService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CalendarService cs = new CalendarService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalendarServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int year = Integer.parseInt(request.getParameter("year"));
		cs.createYearCalendar(year);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
