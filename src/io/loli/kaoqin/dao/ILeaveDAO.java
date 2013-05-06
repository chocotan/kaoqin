package io.loli.kaoqin.dao;

import io.loli.kaoqin.entity.Leave;

import java.util.List;

public interface ILeaveDAO {
	void save(Leave leave);

	void update(Leave leave);

	Leave findById(int id);

	List<Leave> listByPersonId(int p_id);

	List<Leave> listByApprovedAndSubmitted(boolean approved, boolean submitted);
}
