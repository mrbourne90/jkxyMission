package com.jikexueyuan.dao;

import java.sql.Connection;
import java.util.List;

import com.jikexueyuan.entity.Poetry;
import com.jikexueyuan.util.Page;

public interface PoetryDao {
	
	/**
	 * 根据条件和关键字查询诗歌
	 * @param connection
	 * @param key
	 * @param condition
	 * @return
	 */
	public List<Poetry> query(Connection connection, String key, String condition, Page page);
	
	/**
	 * 根据条件和关键字查询符合条件的诗歌数目
	 * @param connection
	 * @param key
	 * @param conditon
	 * @return
	 */
	public int getPoetriesAmount(Connection connection,String key, String condition);

}
