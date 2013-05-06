package io.loli.kaoqin.service;

import io.loli.kaoqin.dao.CalendarDAO;
import io.loli.kaoqin.dao.ICalendarDAO;
import io.loli.kaoqin.entity.Calendar;

import java.util.ArrayList;
import java.util.List;

/**
 * 日历管理的service
 * @author ye
 *
 */
public class CalendarService {
	private static ICalendarDAO cd = new CalendarDAO();

	//建立指定年份的日历
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

	//根据指定日期查询
	public Calendar findByDate(String date) {
		return cd.findByDate(date);
	}

	//设置更新这一天是否是假期
	public void updateDayList(int[] ids ,boolean holiday) {
		cd.update(ids,holiday);
	}

	//根据指定id查询
	public Calendar findById(int id) {
		return cd.findById(id);
	}
	
	//查询出指定年和月的日历
	public List<Calendar> listByYearAndMonth(int year ,int month){
		return cd.listByYearAndMonth(year, month);
	}
}
