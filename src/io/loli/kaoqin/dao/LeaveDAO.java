package io.loli.kaoqin.dao;

import io.loli.kaoqin.javabean.Leave;
import io.loli.kaoqin.service.PersonService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAO {
	public void save(Leave leave) {
		String sql = "insert into `leave` (startDate,endDate,startMorning,startAfternoon,endMorning,endAfternoon,p_id,approved,tip) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setDate(1, leave.getStartDate());
			pst.setDate(2, leave.getEndDate());
			pst.setBoolean(3, leave.isStartMorning());
			pst.setBoolean(4, leave.isStartAfternoon());
			pst.setBoolean(5, leave.isEndMorning());
			pst.setBoolean(6, leave.isEndAfternoon());
			pst.setInt(7, leave.getP().getId());
			pst.setBoolean(8, leave.isApproved());
			pst.setString(9, leave.getTip());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
	}

	public void update(Leave leave) {
		String sql = "update `leave` set approved=? where id=?";
		PreparedStatement pst = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setBoolean(1, leave.isApproved());
			pst.setInt(2, leave.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
	}
	public Leave findById(int id){
		String sql = "select * from `leave` where id=?";
		PreparedStatement pst=null;
		Connection conn=null;
		List<Leave> leaveList = new ArrayList<Leave>();
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Leave c = new Leave();
				c.setId(rs.getInt("id"));
				c.setApproved(rs.getBoolean("approved"));
				c.setEndAfternoon(rs.getBoolean("endAfternoon"));
				c.setEndDate(rs.getDate("endDate"));
				c.setEndMorning(rs.getBoolean("endMorning"));
				c.setP(new PersonService().findById(rs.getInt("p_id")));
				c.setStartAfternoon(rs.getBoolean("startAfternoon"));
				c.setStartDate(rs.getDate("startDate"));
				c.setStartMorning(rs.getBoolean("startMorning"));
				c.setTip(rs.getString("tip"));
				leaveList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}	
		return leaveList.get(0);
	}
	
	
	public List<Leave> listByPersonId(int p_id){
		String sql = "select * from `leave` where p_id=?";
		PreparedStatement pst=null;
		Connection conn=null;
		List<Leave> leaveList = new ArrayList<Leave>();
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, p_id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Leave c = new Leave();
				c.setId(rs.getInt("id"));
				c.setApproved(rs.getBoolean("approved"));
				c.setEndAfternoon(rs.getBoolean("endAfternoon"));
				c.setEndDate(rs.getDate("endDate"));
				c.setEndMorning(rs.getBoolean("endMorning"));
				c.setP(new PersonService().findById(rs.getInt("p_id")));
				c.setStartAfternoon(rs.getBoolean("startAfternoon"));
				c.setStartDate(rs.getDate("startDate"));
				c.setStartMorning(rs.getBoolean("startMorning"));
				c.setTip(rs.getString("tip"));
				leaveList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}	
		return leaveList;
	}
	public List<Leave> listByApproved(boolean approved){
		String sql = "select * from `leave` where approved=?";
		PreparedStatement pst=null;
		Connection conn=null;
		List<Leave> leaveList = new ArrayList<Leave>();
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setBoolean(1, approved);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Leave c = new Leave();
				c.setId(rs.getInt("id"));
				c.setApproved(rs.getBoolean("approved"));
				c.setEndAfternoon(rs.getBoolean("endAfternoon"));
				c.setEndDate(rs.getDate("endDate"));
				c.setEndMorning(rs.getBoolean("endMorning"));
				c.setP(new PersonService().findById(rs.getInt("p_id")));
				c.setStartAfternoon(rs.getBoolean("startAfternoon"));
				c.setStartDate(rs.getDate("startDate"));
				c.setStartMorning(rs.getBoolean("startMorning"));
				c.setTip(rs.getString("tip"));
				leaveList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}	
		return leaveList;
	}
}
