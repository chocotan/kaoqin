package io.loli.kaoqin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.loli.kaoqin.dao.CalendarDAO;
import io.loli.kaoqin.javabean.Calendar;

public class CalendarService {
	private static CalendarDAO cd = new CalendarDAO();

	/**
	 * 建立指定年份的日历
	 * 
	 * @param year
	 */
	public void createYearCalendar(int year) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		List<Calendar> calendarList = new ArrayList<Calendar>();
		for (cal.set(year, java.util.Calendar.JANUARY, 1); cal
				.get(java.util.Calendar.YEAR) == year; cal.set(
				java.util.Calendar.DATE, cal.get(java.util.Calendar.DATE) + 1)) {
			Calendar calendar = new Calendar();
			calendar.setDate(new java.sql.Date(cal.getTime().getTime()));
			if (cal.get(java.util.Calendar.DAY_OF_WEEK) == 1
					|| cal.get(java.util.Calendar.DAY_OF_WEEK) == 7) {
				calendar.setHoliday(true);
			} else {
				calendar.setHoliday(false);
			}
			calendarList.add(calendar);
		}
		cd.saveYear(calendarList);
	}

	/**
	 * 根据指定日期查询
	 * 
	 * @param date
	 * @return
	 */
	public Calendar findByDate(String date) {
		return cd.findByDate(date);
	}

	/**
	 * 设置更新这一天是否是假期
	 * 
	 * @param calendar
	 */
	public void updateDayList(List<Calendar> dayList) {
		cd.update(dayList);
	}

	/**
	 * 根据指定id查询
	 * 
	 * @param id
	 * @return
	 */
	public Calendar findById(int id) {
		return cd.findById(id);
	}
	
	@SuppressWarnings("deprecation")
	public Map<Calendar,Integer> listByYearAndMonth(int year ,int month){
		List<Calendar> calendarList = cd.listByYearAndMonth(year, month);
		Map<Calendar,Integer> map = new TreeMap<Calendar,Integer>();
		for(Calendar calendar:calendarList){
			map.put(calendar, calendar.getDate().getDay());
		}
		return map;
	}
}