package io.loli.kaoqin.entity;

import java.sql.Date;

public class Message {
	private int id;
	private Person p;
	private Date date;
	private String message;
	private String url;
	private boolean read;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
