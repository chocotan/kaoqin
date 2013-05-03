package io.loli.kaoqin.servlet;

import io.loli.kaoqin.javabean.Leave;
import io.loli.kaoqin.javabean.Person;
import io.loli.kaoqin.service.LeaveService;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LeaveServlet extends HttpServlet {
	private static LeaveService ls = new LeaveService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("save")){
			this.save(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startDateString = request.getParameter("startDate");
		String endDateString = request.getParameter("endDate");
		Date startDate = null;
		try {
			startDate = new Date(sdf.parse(startDateString).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date endDate = null;
		try {
			endDate = new Date(sdf.parse(endDateString).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		boolean startMorning;
		boolean startAfternoon;
		boolean endMorning;
		boolean endAfternoon;
		if(start.equals("morning")){
			startMorning=true;
			startAfternoon=true;
		}else{
			startMorning=false;
			startAfternoon=true;
		}
		if(end.equals("afternoon")){
			endMorning=true;
			endAfternoon=true;
		}else{
			endMorning=true;
			endAfternoon=false;
		}
		if(startDateString.equals(endDateString)){
			if(start.equals("morning")&&start.equals(end)){
				startMorning=true;
				startAfternoon=false;
				endMorning=true;
				endAfternoon=false;
			}else if(start.equals("afternoon")&&start.equals(end)){
				startMorning=false;
				startAfternoon=true;
				endMorning=false;
				endAfternoon=true;
			}else if(start.equals("morning")&&end.equals("afternoon")){
				startMorning=true;
				startAfternoon=true;
				endMorning=true;
				endAfternoon=true;
			}
		}
		String tip = request.getParameter("tip");
		Person p = (Person)(request.getSession().getAttribute("person"));
		Leave leave = new Leave();
		leave.setApproved(false);
		leave.setEndAfternoon(endAfternoon);
		leave.setEndDate(endDate);
		leave.setEndMorning(endMorning);
		leave.setP(p);
		leave.setStartAfternoon(startAfternoon);
		leave.setStartDate(startDate);
		leave.setStartMorning(startMorning);
		leave.setTip(tip);
		ls.save(leave);
	}
}
