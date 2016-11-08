package com.jikexueyuan.dao;

import java.sql.Connection;

public interface PoetDao {

	/**
	 * 根据id查出诗人的名称
	 * @param connection
	 * @param id
	 * @return
	 */
	public String queryById(Connection connection, Long id);
}
