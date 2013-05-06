package io.loli.kaoqin.dao;

import io.loli.kaoqin.entity.Person;

import java.util.List;

public interface IPersonDAO {

	public abstract void save(Person t);

	public abstract void saveAdmin(Person t);

	public abstract void update(Person t);

	public abstract void delete(int t);

	public abstract Person findById(int id);

	public abstract List<Person> findByUsername(String username);

	public abstract List<Person> list(int startIndex, int count);

	public abstract List<Person> listAll();

}