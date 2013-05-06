package io.loli.kaoqin.service;

import io.loli.kaoqin.dao.AdminDAO;
import io.loli.kaoqin.dao.IAdminDAO;
import io.loli.kaoqin.entity.Admin;

/**
 * 管理员service
 * @author ye
 *
 */
public class AdminService {
	private static IAdminDAO ad = new AdminDAO();

	//新建管理员
	public void save(Admin admin){
		ad.save(admin);
	}
	//更新管理员信息
	public void upate(Admin admin){
		ad.update(admin);
	}
	
	//根据id查询出管理员信息
	public Admin findById(int id) {
		return ad.findById(id);
	}
	//根据用户名查询出管理员信息
	public Admin findByName(String name) {
		return ad.findByName(name);
	}
}
