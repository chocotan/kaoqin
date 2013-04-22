package io.loli.kaoqin.service;

import io.loli.kaoqin.dao.AdminDAO;
import io.loli.kaoqin.javabean.Admin;

public class AdminService {
	private static AdminDAO ad = new AdminDAO();
	public void save(Admin admin){
		ad.save(admin);
	}
	public void upate(Admin admin){
		ad.update(admin);
	}
	public Admin findById(int id) {
		return ad.findById(id);
	}
	public Admin findByName(String name) {
		return ad.findByName(name);
	}
}
