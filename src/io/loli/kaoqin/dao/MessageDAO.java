package io.loli.kaoqin.dao;

import io.loli.kaoqin.entity.Message;
import io.loli.kaoqin.service.PersonService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO implements IMessageDAO {
	@Override
	public void save(Message message) {
		String sql = "insert into message (date,message,url,p_id,read) values (?,?,?,?,?)";
		PreparedStatement pst = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setDate(1, message.getDate());
			pst.setString(2, message.getMessage());
			pst.setString(3, message.getUrl());
			pst.setInt(4, message.getP().getId());
			pst.setBoolean(5, message.isRead());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
	}

	@Override
	public List<Message> list(int p_id) {
		String sql = "select * from message where p_id";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Message> ml = new ArrayList<Message>();
		try {
			Message m = new Message();
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, p_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				m.setDate(rs.getDate("date"));
				m.setId(rs.getInt("id"));
				m.setMessage(rs.getString("message"));
				m.setP(new PersonService().findById(rs.getInt("p_id")));
				m.setRead(rs.getBoolean("read"));
				m.setUrl(rs.getString("url"));
				ml.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return ml;
	}
}
