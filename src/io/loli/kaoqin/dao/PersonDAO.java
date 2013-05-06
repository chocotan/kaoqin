package io.loli.kaoqin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.loli.kaoqin.entity.Person;

public class PersonDAO implements IPersonDAO{
	public int result;
	public PersonDAO(){}
	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IPersonDAO#save(io.loli.kaoqin.entity.Person)
	 */
	@Override
	public void save(Person t) {
		String sql = "insert into Person (username,password,tel,email,address) values (?,?,?,?,?);";
		PreparedStatement pst=null;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getTel());
			pst.setString(4, t.getEmail());
			pst.setString(5, t.getAddress());
			result=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}
	}
	
	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IPersonDAO#saveAdmin(io.loli.kaoqin.entity.Person)
	 */
	@Override
	public void saveAdmin(Person t) {
		String sql = "insert into Person (username,password,isadmin) values (?,?,?);";
		PreparedStatement pst=null;
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setBoolean(3, false);
			result=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.releaseConnection(pst, conn);
		}
	}

	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IPersonDAO#update(io.loli.kaoqin.entity.Person)
	 */
	@Override
	public void update(Person t) {
		String sql = "update Person set " + "username=? ," + "password=? ,"
				+ "tel=? ," + "email=? ," + "address=? " + "where id=? " + ";";
		PreparedStatement pst = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getTel());
			pst.setString(4, t.getEmail());
			pst.setString(5, t.getAddress());
			pst.setInt(6, t.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
	}

	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IPersonDAO#delete(int)
	 */
	@Override
	public void delete(int t) {
		String sql = "delete from Person where id=?";
		PreparedStatement pst = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, t);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
	}

	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IPersonDAO#findById(int)
	 */
	@Override
	public Person findById(int id) {
		String sql = "select * from Person where id=?";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		Person p=null;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
	        pst.execute();
			rs = pst.getResultSet();
			while(rs.next()){
				p=new Person();
				p.setId(rs.getInt(1));
				p.setUsername(rs.getString("username"));
				p.setAddress(rs.getString("address"));
				p.setEmail(rs.getString("email"));
				p.setPassword(rs.getString("password"));
				p.setTel(rs.getString("tel"));
				p.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return p;
	}

	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IPersonDAO#findByUsername(java.lang.String)
	 */
	@Override
	public List<Person> findByUsername(String username) {
		String sql = "select * from Person where username=?";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Person> pl = new ArrayList<Person>();
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
	        pst.execute();
			rs = pst.getResultSet();
			while(rs.next()){
				Person p=new Person();
				p.setId(rs.getInt(1));
				p.setUsername(rs.getString("username"));
				p.setAddress(rs.getString("address"));
				p.setEmail(rs.getString("email"));
				p.setPassword(rs.getString("password"));
				p.setTel(rs.getString("tel"));
				p.setAddress(rs.getString("address"));
				pl.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return pl;
	}
	
	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IPersonDAO#list(int, int)
	 */
	@Override
	public List<Person> list(int startIndex, int count) {
		String sql = "select * from Person limit startIndex, count";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Person> pl = new ArrayList<Person>();
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, count);
			pst.setInt(2, startIndex + count -1);
	        pst.execute();
			rs = pst.getResultSet();
			while(rs.next()){
				Person p=new Person();
				p.setId(rs.getInt(1));
				p.setUsername(rs.getString("username"));
				p.setAddress(rs.getString("address"));
				p.setEmail(rs.getString("email"));
				p.setPassword(rs.getString("password"));
				p.setTel(rs.getString("tel"));
				p.setAddress(rs.getString("address"));
				pl.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return pl;
	}

	/* (non-Javadoc)
	 * @see io.loli.kaoqin.dao.IPersonDAO#listAll()
	 */
	@Override
	public List<Person> listAll() {
		String sql = "select * from Person";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Person> pl = new ArrayList<Person>();
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
	        pst.execute();
			rs = pst.getResultSet();
			while(rs.next()){
				Person p=new Person();
				p.setId(rs.getInt(1));
				p.setUsername(rs.getString("username"));
				p.setAddress(rs.getString("address"));
				p.setEmail(rs.getString("email"));
				p.setPassword(rs.getString("password"));
				p.setTel(rs.getString("tel"));
				p.setAddress(rs.getString("address"));
				pl.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(pst, conn);
		}
		return pl;
	}

}
