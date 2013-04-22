package io.loli.kaoqin.dao;

public interface IDAO<T> {
	public void save(T t);
	public void update(T t);
	public void delete(int id);
	public T findById(int id);
}
