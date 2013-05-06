package io.loli.kaoqin.service;

import java.util.List;

import io.loli.kaoqin.dao.IPersonDAO;
import io.loli.kaoqin.dao.PersonDAO;
import io.loli.kaoqin.entity.Person;
/**
 * 用户service
 * @author ye
 *
 */
public class PersonService {
	private static IPersonDAO pd = new PersonDAO();
	//新用户注册
	public void save(Person p){
		pd.save(p);
	}
	
	public void saveAdmin(Person p) {
		pd.save(p);
	}
	//修改信息
	public void update(Person p){
		pd.update(p);
	}
	//删除此用户
	public void delete(int id){
		pd.delete(id);
	}
	public Person findById(int id){
		return pd.findById(id);
	}
	//通过指定用户名查询
	public List<Person> findByUsername(String username){
		return pd.findByUsername(username);
	}
	//分页
	public List<Person> list(int startIndex,int count){
		return pd.list(startIndex, count);
	}
	//查询出所有用户
	public List<Person> listAll(){
		return pd.listAll();
	}
}
