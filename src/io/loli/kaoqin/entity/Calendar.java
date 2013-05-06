package io.loli.kaoqin.entity;

import java.sql.Date;

@SuppressWarnings("rawtypes")
public class Calendar implements Comparable{
	private int id;
	private boolean holiday;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isHoliday() {
		return holiday;
	}
	public void setHoliday(boolean holiday) {
		this.holiday = holiday;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@SuppressWarnings("deprecation")
	@Override
	public int compareTo(Object o) {
		return this.date.getDate();
	}
}
