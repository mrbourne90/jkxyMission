package com.jikexueyuan.service;

import java.sql.Connection;
import java.util.List;

import com.jikexueyuan.dao.PoetryDao;
import com.jikexueyuan.dao.impl.PoetryDaoImpl;
import com.jikexueyuan.entity.Poetry;
import com.jikexueyuan.util.ConnectionFactory;
import com.jikexueyuan.util.Page;

public class PoetryService {

	private PoetryDao poetryDao = new PoetryDaoImpl();

	// 根据条件和关键字查询诗歌列表
	public List<Poetry> query(String condition, String key, Page page) {

		Connection connection = ConnectionFactory.getInstance().makeConnection();
		List<Poetry> poetries = poetryDao.query(connection, key, condition,page);
		return poetries;
	}

	//查询符合条件的诗歌记录数
	public int getPoetriesAmount(String key, String condition){
		
		Connection connection = ConnectionFactory.getInstance().makeConnection();
		int amount = poetryDao.getPoetriesAmount(connection, key, condition);
		return amount;
	}
}
