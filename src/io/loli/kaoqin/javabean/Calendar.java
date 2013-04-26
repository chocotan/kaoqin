package io.loli.kaoqin.javabean;

import java.sql.Date;

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
	@Override
	public int compareTo(Object o) {
		return this.date.getDate();
	}
}
