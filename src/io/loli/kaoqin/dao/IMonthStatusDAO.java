package io.loli.kaoqin.dao;

import io.loli.kaoqin.entity.MonthStatus;

import java.util.List;

public interface IMonthStatusDAO {

	public abstract void save(MonthStatus t);

	public abstract void update(MonthStatus t);

	public abstract void delete(int id);

	public abstract MonthStatus findById(int id);

	//查询指定年月的MonthStatus列表
	public abstract List<MonthStatus> findByYearAndMonth(int year, int month);

	//根据year,month和person的id来查询出MonthStatus
	public abstract List<MonthStatus> findByYearAndMonth(int year, int month,
			int p_id);

	// 查询指定p_id的所有MonthStatus
	public abstract List<MonthStatus> findByPersonId(int p_id);

	// 根据是否提交和是否通过来查询
	public abstract List<MonthStatus> findBySubmittedAndApproved(
			boolean submitted, boolean approved);

}