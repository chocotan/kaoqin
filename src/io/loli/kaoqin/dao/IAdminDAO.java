package io.loli.kaoqin.dao;

import io.loli.kaoqin.entity.Admin;

public interface IAdminDAO {

	public abstract void save(Admin t);

	public abstract void update(Admin t);

	public abstract void delete(int id);

	public abstract Admin findById(int id);

	public abstract Admin findByName(String name);

}