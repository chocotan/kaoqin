package io.loli.kaoqin.service;

import java.util.List;

import io.loli.kaoqin.dao.IMonthStatusDAO;
import io.loli.kaoqin.dao.MonthStatusDAO;
import io.loli.kaoqin.entity.DayStatus;
import io.loli.kaoqin.entity.MonthStatus;

/**
 * 管理每月信息的service
 * @author ye
 *
 */
public class MonthStatusService {
	private static IMonthStatusDAO msd = new MonthStatusDAO();

	//新建每月情況
	public void save(MonthStatus m) {
		msd.save(m);
	}
	//更新
	public void update(MonthStatus m) {
		msd.update(m);
	}
	//刪除
	public void delete(int id) {
		DayStatusService dss = new DayStatusService();
		List<DayStatus> dsl = dss.findByPersonAndMonth(this.findById(id).getP()
				.getId(), id);
		//同時刪除此月下指定用户的所有考勤
		for (DayStatus ds : dsl) {
			dss.delete(ds.getId());
		}
		msd.delete(id);
	}
	//根据id查询
	public MonthStatus findById(int id) {
		return msd.findById(id);
	}
	//根据指定年月查询
	public List<MonthStatus> findByYearAndMonth(int year, int month) {
		return msd.findByYearAndMonth(year, month);
	}
	//根据指定年月和用户id查询
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
