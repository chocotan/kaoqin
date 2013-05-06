package io.loli.kaoqin.dao;

import io.loli.kaoqin.entity.DayStatus;

import java.util.List;

public interface IDayStatusDAO {

	public abstract void save(DayStatus t);

	public abstract void update(DayStatus t);

	public abstract void delete(int id);

	public abstract DayStatus findById(int id);

	public abstract List<DayStatus> findByPerson(int p_id);

	public abstract List<DayStatus> findByPersonAndMonth(int p_id, int m_id);

	public abstract DayStatus findByPersonAndDate(int p_id, int d_id);

}