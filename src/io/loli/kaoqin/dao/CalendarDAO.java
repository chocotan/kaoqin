package io.loli.kaoqin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.loli.kaoqin.javabean.Calendar;

public class CalendarDAO implements ICalendarDAO{

	@Override
	public void saveYear(List<Calendar> calendarList) {
		String sql = "insert into Calendar (holiday,day_date) values (?,?)";
		PreparedStatement pst=null;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			for(Calendar calendar : calendarList){
				pst.setBoolean(1, calendar.isHoliday());
				pst.setDate(2, calendar.getDate());
				pst.addBatch();
			}
			pst.executeBatch();
			pst.clearBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}
		
	}

	@Override
	public void delete(List<Integer> idList) {
		String sql = "delete from Calendar where id=?";
		PreparedStatement pst=null;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			for(int id : idList){
				pst.setInt(1, id);
				pst.addBatch();
			}
			pst.executeBatch();
			pst.clearBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}
	}
	
	@Override
	public void update(List<Calendar> calendarList){
		String sql = "update Calendar set holiday=? where id=?";
		PreparedStatement pst=null;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			for(Calendar calendar : calendarList){
				pst.setBoolean(1, calendar.isHoliday());
				pst.setInt(2, calendar.getId());
				pst.addBatch();
			}
			pst.executeBatch();
			pst.clearBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}
	}
	
	public Calendar findById(int id){
		String sql = "select * from Calendar where id=?";
		PreparedStatement pst=null;
		Connection conn=null;
		List<Calendar> calendarList = new ArrayList<Calendar>();
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Calendar c = new Calendar();
				c.setId(rs.getInt("id"));
				c.setDate(rs.getDate("day_date"));
				c.setHoliday(rs.getBoolean("holiday"));
				calendarList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}	
		return calendarList.get(0);
	}

	@Override
	public Calendar findByDate(String date) {
		String sql = "select * from Calendar where day_date=?";
		PreparedStatement pst=null;
		Connection conn=null;
		List<Calendar> calendarList = new ArrayList<Calendar>();
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, date);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Calendar c = new Calendar();
				c.setId(rs.getInt("id"));
				c.setDate(rs.getDate("day_date"));
				c.setHoliday(rs.getBoolean("holiday"));
				calendarList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}	
		return calendarList.get(0);
	}

	@Override
	public List<Calendar> listByYearAndMonth(int year, int month) {
		String sql = "select * from Calendar where day_date like?";
		PreparedStatement pst=null;
		Connection conn=null;
		List<Calendar> calendarList = new ArrayList<Calendar>();
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			if(month<10){
				pst.setString(1, year + "-0" + month+"%");
			}else{
				pst.setString(1, year + "-" + month+"%");
			}
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Calendar c = new Calendar();
				c.setId(rs.getInt("id"));
				c.setDate(rs.getDate("day_date"));
				c.setHoliday(rs.getBoolean("holiday"));
				calendarList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}	
		return calendarList;
	}
	
}
