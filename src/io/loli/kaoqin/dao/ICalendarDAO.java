package io.loli.kaoqin.dao;

import java.util.List;

import io.loli.kaoqin.javabean.Calendar;

public interface ICalendarDAO {
	void saveYear(List<Calendar> calendarList);
	void delete(List<Integer> idList);
	void update(int[] ids,boolean holiday);
	Calendar findById(int id);
	Calendar findByDate(String date);
	List<Calendar> listByYearAndMonth(int year,int month);
}