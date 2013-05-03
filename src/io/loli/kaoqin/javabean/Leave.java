package io.loli.kaoqin.javabean;

import java.sql.Date;

public class Leave {
	private int id;
	private Date startDate;
	private Date endDate;
	private boolean startMorning;
	private boolean startAfternoon;
	private boolean endMorning;
	private boolean endAfternoon;
	private boolean approved;
	private Person p;
	private String tip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isStartMorning() {
		return startMorning;
	}
	public void setStartMorning(boolean startMorning) {
		this.startMorning = startMorning;
	}
	public boolean isStartAfternoon() {
		return startAfternoon;
	}
	public void setStartAfternoon(boolean startAfternoon) {
		this.startAfternoon = startAfternoon;
	}
	public boolean isEndMorning() {
		return endMorning;
	}
	public void setEndMorning(boolean endMorning) {
		this.endMorning = endMorning;
	}
	public boolean isEndAfternoon() {
		return endAfternoon;
	}
	public void setEndAfternoon(boolean endAfternoon) {
		this.endAfternoon = endAfternoon;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
}
