package io.loli.kaoqin.service;

import java.util.List;

import io.loli.kaoqin.dao.LeaveDAO;
import io.loli.kaoqin.javabean.Leave;

public class LeaveService {
	private static LeaveDAO ld = new LeaveDAO();
	public void save(Leave leave){
		ld.save(leave);
	}
	public Leave findById(int id){
		return ld.findById(id);
	}
	public List<Leave> listByPersonId(int p_id){
		return ld.listByPersonId(p_id);
	}
	public List<Leave> listByApproved(boolean approved){
		return ld.listByApproved(approved);
	}
}
