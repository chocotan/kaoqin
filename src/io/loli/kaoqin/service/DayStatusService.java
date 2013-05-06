package io.loli.kaoqin.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import io.loli.kaoqin.dao.DayStatusDAO;
import io.loli.kaoqin.dao.IDayStatusDAO;
import io.loli.kaoqin.entity.DayStatus;
import io.loli.kaoqin.entity.MonthStatus;
/**
 * 考勤管理的service
 * @author ye
 *
 */
public class DayStatusService {
	private static IDayStatusDAO dsd = new DayStatusDAO();

	//新建考勤
	public void save(DayStatus d) {
		MonthStatusService mss = new MonthStatusService();
		Calendar c = Calendar.getInstance();
		c.setTime(d.getCalendar().getDate());
		//如果没有此月信息的话新建一个
		if (mss.findByYearAndMonth(c.get(Calendar.YEAR), c.get(Calendar.MONTH),
				d.getP().getId()).size() == 0) {
			MonthStatus m = new MonthStatus();
			m.setMonth(c.get(Calendar.MONTH));
			m.setYear(c.get(Calendar.YEAR));
			m.setP(d.getP());
			mss.save(m);
		}
		d.setCalendar(new CalendarService().findByDate(new SimpleDateFormat(
				"yyyy-MM-dd").format(c.getTime())));
		d.setM(mss.findByYearAndMonth(c.get(Calendar.YEAR),
				c.get(Calendar.MONTH), d.getP().getId()).get(0));
		dsd.save(d);
	}

	//更新这天的情况
	public void update(DayStatus d) {
		MonthStatusService mss = new MonthStatusService();
		Calendar c = new GregorianCalendar();
		c.setTime(d.getCalendar().getDate());
		if (mss.findByYearAndMonth(c.get(Calendar.YEAR), c.get(Calendar.MONTH),
				d.getP().getId()).size() == 0) {
			MonthStatus m = new MonthStatus();
			m.setMonth(c.get(Calendar.MONTH));
			m.setYear(c.get(Calendar.YEAR));
			m.setP(d.getP());
			mss.save(m);
		}
		d.setM(mss.findByYearAndMonth(c.get(Calendar.YEAR),
				c.get(Calendar.MONTH), d.getP().getId()).get(0));
		dsd.update(d);
	}
	//根据id删除
	public void delete(int id) {
		dsd.delete(id);
	}
	//根据id查询
	public DayStatus findById(int id) {
		return dsd.findById(id);
	}
	//查询出指定id用户的考勤情况
	public List<DayStatus> findByPerson(int p_id) {
		return dsd.findByPerson(p_id);
	}
	//查询出指定id用户和指定月份的考勤情况
	public List<DayStatus> findByPersonAndMonth(int p_id, int m_id) {
		return dsd.findByPersonAndMonth(p_id, m_id);
	}
	//查询出指定id用户和指定日期的考勤情况
	public DayStatus findByPersonAndDate(int p_id,int d_id){
		return dsd.findByPersonAndDate(p_id, d_id);
	}
}
