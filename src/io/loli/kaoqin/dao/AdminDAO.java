package io.loli.kaoqin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.loli.kaoqin.entity.Admin;

public class AdminDAO implements IAdminDAO {

	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IAdminDAO#save(io.loli.kaoqin.entity.Admin)
	 */
	@Override
	public void save(Admin t) {
		String sql = "insert into admin (name,passowrd) values (?,?)";
		PreparedStatement pst = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setString(2, t.getPassword());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
	}

	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IAdminDAO#update(io.loli.kaoqin.entity.Admin)
	 */
	@Override
	public void update(Admin t) {
		String sql = "update admin set name=?,password=? where id=?";
		PreparedStatement pst = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setString(2, t.getPassword());
			pst.setInt(3, t.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
	}

	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IAdminDAO#delete(int)
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IAdminDAO#findById(int)
	 */
	@Override
	public Admin findById(int id) {
		String sql = "select * from admin where id=?";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Admin> asl = new ArrayList<Admin>();
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				asl.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return asl.get(0);
	}

	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IAdminDAO#findByName(java.lang.String)
	 */
	@Override
	public Admin findByName(String name) {
		String sql = "select * from admin where name=?";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Admin> asl = new ArrayList<Admin>();
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				asl.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return asl.get(0);
	}
}
