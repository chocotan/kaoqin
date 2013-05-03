package io.loli.kaoqin.servlet;

import io.loli.kaoqin.service.CalendarService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
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
		String action = request.getParameter("action");
		if(action.equals("create")){
			this.save(request, response);
		}else if(action.equals("saveHoliday")){
			this.saveHoliday(request, response);
		}else if(action.equals("edit")){
			this.editSetupForm(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	private void save(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int year = Integer.parseInt(request.getParameter("year"));
		cs.createYearCalendar(year);
	}
	
	private void saveHoliday(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] temp1=request.getParameterValues("holiday");
		String[] temp2=request.getParameterValues("notholiday");
		if(temp1.length>0){
			int[] ids1=new int[temp1.length];
			for(int i=0;i<temp1.length;i++){
				ids1[i]=Integer.parseInt(temp1[i]);
			}
			cs.updateDayList(ids1, true);
		}
		if(temp2.length>0){
			int[] ids2=new int[temp2.length];
			for(int i=0;i<temp2.length;i++){
				ids2[i]=Integer.parseInt(temp2[i]);
			}
			cs.updateDayList(ids2, true);
		}
	}
	
	@SuppressWarnings("deprecation")
	private void editSetupForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		CalendarService  cs = new CalendarService();
		List<io.loli.kaoqin.javabean.Calendar> calendarList = cs.listByYearAndMonth(year, month);
		Map<io.loli.kaoqin.javabean.Calendar,Integer> map = new TreeMap<io.loli.kaoqin.javabean.Calendar,Integer>();
		for(io.loli.kaoqin.javabean.Calendar calendar :calendarList){
			map.put(calendar, calendar.getDate().getDay());
		}
		request.setAttribute("map", map);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("editCalendar.jsp");
		dispatcher.forward(request, response);
	}
}
