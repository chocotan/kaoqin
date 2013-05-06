package io.loli.kaoqin.dao;

import io.loli.kaoqin.entity.Message;

import java.util.List;

public interface IMessageDAO {
	void save(Message message);

	List<Message> list(int p_id);
}
