package io.loli.kaoqin.dao;

import io.loli.kaoqin.javabean.MonthStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonthStatusDAO implements IDAO<MonthStatus>{
	public int result;
	@Override
	public void save(MonthStatus t) {
		String sql = "insert into month_status (year,month,p_id) values (?,?,?);";
		PreparedStatement pst=null;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, t.getYear());
			pst.setInt(2, t.getMonth());
			pst.setInt(3, t.getP().getId());
			result=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}
	}

	@Override
	public void update(MonthStatus t) {
		String sql = "update month_status set approved=?,submitted=? where id=?";
		PreparedStatement pst=null;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setBoolean(1, t.isApproved());
			pst.setBoolean(2, t.isSubmitted());
			pst.setInt(3, t.getId());
			result=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from month_status where id=?";
		PreparedStatement pst=null;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(0, id);
			result=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}
	}

	@Override
	public MonthStatus findById(int id) {
		String sql = "select * from month_status where id=?";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		MonthStatus m=null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
	        pst.execute();
			rs = pst.getResultSet();
			while(rs.next()){
				m=new MonthStatus();
				m.setId(rs.getInt("id"));
				m.setApproved(rs.getBoolean("approved"));
				m.setMonth(rs.getInt("month"));
				m.setSubmitted(rs.getBoolean("submitted"));
				m.setYear(rs.getInt("year"));
				m.setP(new PersonDAO().findById(rs.getInt("p_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return m;
	}
	//查询指定年月的MonthStatus列表
	public List<MonthStatus> findByYearAndMonth(int year,int month){
		String sql = "select * from month_status where year=? and month=?";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<MonthStatus> msl=new ArrayList<MonthStatus>();
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, year);
			pst.setInt(2, month);
	        pst.execute();
			rs = pst.getResultSet();
			while(rs.next()){
				MonthStatus m=new MonthStatus();
				m.setId(rs.getInt("id"));
				m.setApproved(rs.getBoolean("approved"));
				m.setMonth(rs.getInt("month"));
				m.setSubmitted(rs.getBoolean("submitted"));
				m.setYear(rs.getInt("year"));
				m.setP(new PersonDAO().findById(rs.getInt("p_id")));
				msl.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return msl;
	}
	
	//根据year,month和person的id来查询出MonthStatus
	public List<MonthStatus> findByYearAndMonth(int year,int month,int p_id){
		String sql = "select * from month_status where year=? and month=? and p_id=?";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<MonthStatus> msl=new ArrayList<MonthStatus>();
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, year);
			pst.setInt(2, month);
			pst.setInt(3, p_id);
	        pst.execute();
			rs = pst.getResultSet();
			while(rs.next()){
				MonthStatus m=new MonthStatus();
				m.setId(rs.getInt("id"));
				m.setApproved(rs.getBoolean("approved"));
				m.setMonth(rs.getInt("month"));
				m.setSubmitted(rs.getBoolean("submitted"));
				m.setYear(rs.getInt("year"));
				m.setP(new PersonDAO().findById(rs.getInt("p_id")));
				msl.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return msl;
	}

	// 查询指定p_id的所有MonthStatus
	public List<MonthStatus> findByPersonId(int p_id) {
		String sql = "select * from month_status where p_id=? order by year desc , month desc";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<MonthStatus> msl = new ArrayList<MonthStatus>();
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, p_id);
			pst.execute();
			rs = pst.getResultSet();
			while (rs.next()) {
				MonthStatus m = new MonthStatus();
				m.setId(rs.getInt("id"));
				m.setApproved(rs.getBoolean("approved"));
				m.setMonth(rs.getInt("month"));
				m.setSubmitted(rs.getBoolean("submitted"));
				m.setYear(rs.getInt("year"));
				m.setP(new PersonDAO().findById(rs.getInt("p_id")));
				msl.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return msl;
	}
	
	// 根据是否提交和是否通过来查询
	public List<MonthStatus> findBySubmittedAndApproved(boolean submitted,boolean approved) {
		String sql = "select * from month_status where submitted=? and approved=?";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<MonthStatus> msl = new ArrayList<MonthStatus>();
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setBoolean(1, submitted);
			pst.setBoolean(2, approved);
			pst.execute();
			rs = pst.getResultSet();
			while (rs.next()) {
				MonthStatus m = new MonthStatus();
				m.setId(rs.getInt("id"));
				m.setApproved(rs.getBoolean("approved"));
				m.setMonth(rs.getInt("month"));
				m.setSubmitted(rs.getBoolean("submitted"));
				m.setYear(rs.getInt("year"));
				m.setP(new PersonDAO().findById(rs.getInt("p_id")));
				msl.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return msl;
	}
}
