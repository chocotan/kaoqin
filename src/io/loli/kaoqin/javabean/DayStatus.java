package io.loli.kaoqin.javabean;

public class DayStatus {
	private int id;
	private Person p;
	private MonthStatus m;
	//这天的日期
	private java.sql.Date date;
	//开始时间
	private java.sql.Time startTime;
	//结束时间
	private java.sql.Time endTime;
	//休息时间
	private int breakHours;
	//工作的时间
	private int workHours;
	//加班时间
	private int extraHours;
	//星期几
	private int day;
	//作业内容
	private String tip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public int getBreakHours() {
		return breakHours;
	}
	public void setBreakHours(int breakHours) {
		this.breakHours = breakHours;
	}
	public int getWorkHours() {
		return workHours;
	}
	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}
	public int getExtraHours() {
		return extraHours;
	}
	public void setExtraHours(int extraHours) {
		this.extraHours = extraHours;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public java.sql.Time getStartTime() {
		return startTime;
	}
	public void setStartTime(java.sql.Time startTime) {
		this.startTime = startTime;
	}
	public java.sql.Time getEndTime() {
		return endTime;
	}
	public void setEndTime(java.sql.Time endTime) {
		this.endTime = endTime;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public MonthStatus getM() {
		return m;
	}
	public void setM(MonthStatus m) {
		this.m = m;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
}
