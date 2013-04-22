package io.loli.kaoqin.service;

import java.util.List;

import io.loli.kaoqin.dao.MonthStatusDAO;
import io.loli.kaoqin.javabean.DayStatus;
import io.loli.kaoqin.javabean.MonthStatus;

public class MonthStatusService {
	private static MonthStatusDAO msd = new MonthStatusDAO();

	public void save(MonthStatus m) {
		msd.save(m);
	}

	public void update(MonthStatus m) {
		msd.update(m);
	}

	public void delete(int id) {
		DayStatusService dss = new DayStatusService();
		List<DayStatus> dsl = dss.findByPersonAndMonth(this.findById(id).getP()
				.getId(), id);
		for (DayStatus ds : dsl) {
			dss.delete(ds.getId());
		}
		msd.delete(id);
	}

	public MonthStatus findById(int id) {
		return msd.findById(id);
	}

	public List<MonthStatus> findByYearAndMonth(int year, int month) {
		return msd.findByYearAndMonth(year, month);
	}

	public List<MonthStatus> findByYearAndMonth(int year, int month, int p_id) {
		return msd.findByYearAndMonth(year, month, p_id);
	}

	public List<MonthStatus> findByPersonId(int p_id) {
		return msd.findByPersonId(p_id);
	}

	// 根据是否提交和是否通过来查询
	public List<MonthStatus> findBySubmittedAndApproved(boolean submitted,
			boolean approved) {
		return msd.findBySubmittedAndApproved(submitted, approved);
	}
}
