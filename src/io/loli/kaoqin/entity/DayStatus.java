package io.loli.kaoqin.entity;

public class DayStatus {
	private int id;
	private Person p;
	private MonthStatus m;
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
	private Calendar calendar;
	//星期几
	private int day;
	//作业内容
	private String tip;
	//请假种类,0为未请假正常上班，1为上午请假，2为下午请假，3为请假一整天
	private int type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
