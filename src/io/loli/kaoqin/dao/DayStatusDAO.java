package io.loli.kaoqin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import io.loli.kaoqin.javabean.DayStatus;
import io.loli.kaoqin.service.CalendarService;

public class DayStatusDAO implements IDAO<DayStatus>{
	public int result;
	@Override
	public void save(DayStatus t) {
		String sql = "insert into day_status (p_id,m_id,d_id,startTime,endTime,breakHours,workHours,extraHours,tip) values (?,?,?,?,?,?,?,?,?);";
		PreparedStatement pst=null;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, t.getP().getId());
			pst.setInt(2, t.getM().getId());
			pst.setInt(3, t.getCalendar().getId());
			pst.setTime(4, t.getStartTime());
			pst.setTime(5, t.getEndTime());
			pst.setInt(6, t.getBreakHours());
			pst.setInt(7, t.getWorkHours());
			pst.setInt(8, t.getExtraHours());
			pst.setString(9, t.getTip());
			result=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}
	}

	@Override
	public void update(DayStatus t) {
		String sql = "update day_status set p_id=?,m_id=?,startTime=?,endTime=?,breakHours=?,workHours=?,extraHours=?,tip=? where id=?;";
		PreparedStatement pst=null;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, t.getP().getId());
			pst.setInt(2, t.getM().getId());
			pst.setTime(3, t.getStartTime());
			pst.setTime(4, t.getEndTime());
			pst.setInt(5, t.getBreakHours());
			pst.setInt(6, t.getWorkHours());
			pst.setInt(7, t.getExtraHours());
			pst.setString(8, t.getTip());
			pst.setInt(9,t.getId());
			result=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from day_status where id=?";
		PreparedStatement pst=null;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			result=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}
	}

	@Override
	public DayStatus findById(int id) {
		String sql = "select * from day_status where id=?";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<DayStatus> dsl = new ArrayList<DayStatus>();
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			rs = pst.getResultSet();
			while (rs.next()) {
				DayStatus d = new DayStatus();
				d.setId(rs.getInt("id"));
				d.setP(new PersonDAO().findById(rs.getInt("p_id")));
				d.setM(new MonthStatusDAO().findById(rs.getInt("m_id")));
				d.setStartTime(rs.getTime("startTime"));
				d.setEndTime(rs.getTime("endTime"));
				d.setCalendar(new CalendarService().findById(rs.getInt("d_id")));
				d.setBreakHours(rs.getInt("breakHours"));
				d.setWorkHours(rs.getInt("workHours"));
				d.setExtraHours(rs.getInt("extraHours"));
				d.setTip(rs.getString("tip"));
				Calendar c = Calendar.getInstance();
				c.setTime(d.getCalendar().getDate());
				d.setDay(c.get(Calendar.DAY_OF_WEEK));
				dsl.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return dsl.get(0);
	}
	
	
	public List<DayStatus> findByPerson(int p_id) {
		String sql = "select * from day_status where p_id=? group by date";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<DayStatus> dsl = new ArrayList<DayStatus>();
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, p_id);
			pst.execute();
			rs = pst.getResultSet();
			while (rs.next()) {
				DayStatus d = new DayStatus();
				d.setId(rs.getInt("id"));
				d.setP(new PersonDAO().findById(rs.getInt("p_id")));
				d.setM(new MonthStatusDAO().findById(rs.getInt("m_id")));
				d.setStartTime(rs.getTime("startTime"));
				d.setEndTime(rs.getTime("endTime"));
				d.setBreakHours(rs.getInt("breakHours"));
				d.setWorkHours(rs.getInt("workHours"));
				d.setCalendar(new CalendarService().findById(rs.getInt("d_id")));
				d.setExtraHours(rs.getInt("extraHours"));
				d.setTip(rs.getString("tip"));
				Calendar c = new GregorianCalendar();
				c.setTime(d.getCalendar().getDate());
				d.setDay(c.get(Calendar.DAY_OF_WEEK));
				dsl.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return dsl;
	}
	
	public List<DayStatus> findByPersonAndMonth(int p_id,int m_id) {
		String sql = "select * from day_status where p_id=? and m_id=? group by d_id";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<DayStatus> dsl = new ArrayList<DayStatus>();
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, p_id);
			pst.setInt(2, m_id);
			pst.execute();
			rs = pst.getResultSet();
			while (rs.next()) {
				DayStatus d = new DayStatus();
				d.setId(rs.getInt("id"));
				d.setP(new PersonDAO().findById(rs.getInt("p_id")));
				d.setM(new MonthStatusDAO().findById(rs.getInt("m_id")));
				d.setStartTime(rs.getTime("startTime"));
				d.setEndTime(rs.getTime("endTime"));
				d.setBreakHours(rs.getInt("breakHours"));
				d.setWorkHours(rs.getInt("workHours"));
				d.setExtraHours(rs.getInt("extraHours"));
				d.setCalendar(new CalendarService().findById(rs.getInt("d_id")));
				d.setTip(rs.getString("tip"));
				Calendar c = Calendar.getInstance();
				c.setTime(d.getCalendar().getDate());
				d.setDay(c.get(Calendar.DAY_OF_WEEK));
				dsl.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return dsl;
	}

}
