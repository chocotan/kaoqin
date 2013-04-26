package io.loli.kaoqin.servlet;

import io.loli.kaoqin.javabean.Calendar;
import io.loli.kaoqin.javabean.DayStatus;
import io.loli.kaoqin.javabean.Person;
import io.loli.kaoqin.service.CalendarService;
import io.loli.kaoqin.service.DayStatusService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DayStatusServlet
 */
@WebServlet("/DayStatusServlet")
public class DayStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DayStatusService dss;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DayStatusServlet() {
        super();
        dss=new DayStatusService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("save")){
			save(request,response);
		}else if(action.equals("update")){
			update(request,response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	@SuppressWarnings("deprecation")
	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DayStatus ds=new DayStatus();
		String dstr=request.getParameter("date");
		int breakHours = Integer.parseInt(request.getParameter("breakhours"));
		int workHours = Integer.parseInt(request.getParameter("workhours"));
		int extraHours = Integer.parseInt(request.getParameter("extrahours"));
		int startTimeHour = Integer.parseInt(request.getParameter("starttimehour"));
		int startTimeMin = Integer.parseInt(request.getParameter("starttimemin"));
		int endTimeHour = Integer.parseInt(request.getParameter("endtimehour"));
		int endTimeMin = Integer.parseInt(request.getParameter("endtimemin"));
		String tip = request.getParameter("tip");
		java.sql.Time startTime = new java.sql.Time(startTimeHour, startTimeMin, 0);
		java.sql.Time endTime = new java.sql.Time(endTimeHour, endTimeMin, 0);
		Calendar calendar = new CalendarService().findByDate(dstr);
		ds.setCalendar(calendar);
		ds.setP((Person)request.getSession().getAttribute(("person")));
		ds.setBreakHours(breakHours);
		ds.setExtraHours(extraHours);
		ds.setWorkHours(workHours);
		ds.setStartTime(startTime);
		ds.setEndTime(endTime);
		ds.setTip(tip);
		dss.save(ds);
		DayStatus nds = dss.findByPersonAndDate(ds.getP().getId(),calendar.getId());
		if(null!=request.getParameter("kind")&&((String)(request.getParameter("kind"))).equals("ajax")){
			response.getWriter().print(nds.getId());
		}else{
			response.sendRedirect("monthList.jsp");
		}
	}
	
	@SuppressWarnings("deprecation")
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DayStatus ds=dss.findById(Integer.parseInt(request.getParameter("id")));
		int breakHours = Integer.parseInt(request.getParameter("breakhours"));
		int workHours = Integer.parseInt(request.getParameter("workhours"));
		int extraHours = Integer.parseInt(request.getParameter("extrahours"));
		int startTimeHour = Integer.parseInt(request.getParameter("starttimehour"));
		int startTimeMin = Integer.parseInt(request.getParameter("starttimemin"));
		int endTimeHour = Integer.parseInt(request.getParameter("endtimehour"));
		int endTimeMin = Integer.parseInt(request.getParameter("endtimemin"));
		String tip = request.getParameter("tip");
		java.sql.Time startTime = new java.sql.Time(startTimeHour, startTimeMin, 0);
		java.sql.Time endTime = new java.sql.Time(endTimeHour, endTimeMin, 0);
		ds.setP((Person)request.getSession().getAttribute(("person")));
		ds.setBreakHours(breakHours);
		ds.setExtraHours(extraHours);
		ds.setWorkHours(workHours);
		ds.setStartTime(startTime);
		ds.setEndTime(endTime);
		ds.setTip(tip);
		dss.update(ds);
		if(null!=request.getParameter("kind")&&((String)(request.getParameter("kind"))).equals("ajax")){
			response.getWriter().print("SUCCESS");
		}else{
			response.sendRedirect("monthList.jsp");
		}
	}
}
