package io.loli.kaoqin.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import io.loli.kaoqin.dao.DayStatusDAO;
import io.loli.kaoqin.javabean.DayStatus;
import io.loli.kaoqin.javabean.MonthStatus;

public class DayStatusService {
	private static DayStatusDAO dsd = new DayStatusDAO();

	public void save(DayStatus d) {
		MonthStatusService mss = new MonthStatusService();
		Calendar c = Calendar.getInstance();
		c.setTime(d.getCalendar().getDate());
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

	public void delete(int id) {
		dsd.delete(id);
	}

	public DayStatus findById(int id) {
		return dsd.findById(id);
	}

	public List<DayStatus> findByPerson(int p_id) {
		return dsd.findByPerson(p_id);
	}

	public List<DayStatus> findByPersonAndMonth(int p_id, int m_id) {
		return dsd.findByPersonAndMonth(p_id, m_id);
	}
	
	public DayStatus findByPersonAndDate(int p_id,int d_id){
		return dsd.findByPersonAndDate(p_id, d_id);
	}
}
