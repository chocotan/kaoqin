package io.loli.kaoqin.javabean;

public class MonthStatus {
	private int id;
	private int year;
	private int month;
	private Person p;
	private boolean submitted;
	private boolean approved;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isSubmitted() {
		return submitted;
	}
	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
}
