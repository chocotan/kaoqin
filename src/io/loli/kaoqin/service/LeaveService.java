package io.loli.kaoqin.service;

import io.loli.kaoqin.dao.ILeaveDAO;
import io.loli.kaoqin.dao.LeaveDAO;
import io.loli.kaoqin.entity.Leave;

import java.util.List;
/**
 * 请假管理的service
 * @author ye
 *
 */
public class LeaveService {
	private static ILeaveDAO ld = new LeaveDAO();
	//新建请假
	public void save(Leave leave){
		ld.save(leave);
	}
	//根据id查询出请假信息
	public Leave findById(int id){
		return ld.findById(id);
	}
	//查询出指定用户的请假信息
	public List<Leave> listByPersonId(int p_id){
		return ld.listByPersonId(p_id);
	}
	//查询出已通过/未通过的请假信息
	public List<Leave> listByApprovedAndSubmitted(boolean approved,boolean submitted){
		return ld.listByApprovedAndSubmitted(approved,submitted);
	}
	public void update(Leave leave) {
		ld.update(leave);
	}
}
