package io.loli.kaoqin.dao;

import java.util.List;

import io.loli.kaoqin.javabean.Calendar;

public interface ICalendarDAO {
	void saveYear(List<Calendar> calendarList);
	void delete(List<Integer> idList);
	void update(List<Calendar> calendarList);
	Calendar findById(int id);
	Calendar findByDate(String date);
	List<Calendar> listByYearAndMonth(int year,int month);
}
