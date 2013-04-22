package io.loli.kaoqin.service;

import java.util.List;

import io.loli.kaoqin.dao.PersonDAO;
import io.loli.kaoqin.javabean.Person;

public class PersonService {
	private static PersonDAO pd = new PersonDAO();
	public void save(Person p){
		pd.save(p);
	}
	public void saveAdmin(Person p) {
		pd.save(p);
	}
	public void update(Person p){
		pd.update(p);
	}
	public void delete(int id){
		pd.delete(id);
	}
	public Person findById(int id){
		return pd.findById(id);
	}
	public List<Person> findByUsername(String username){
		return pd.findByUsername(username);
	}
	public List<Person> list(int startIndex,int count){
		return pd.list(startIndex, count);
	}
	public List<Person> listAll(){
		return pd.listAll();
	}
}
