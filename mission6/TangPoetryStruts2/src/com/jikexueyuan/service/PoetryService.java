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

	public List<Poetry> queryByPoet(String key, Page page) {
		Connection connection = ConnectionFactory.getInstance().makeConnection();
		List<Poetry> poetries = poetryDao.queryByPoet(connection, key, page);
		return poetries;
	}

	public List<Poetry> queryByTitle(String key, Page page) {
		Connection connection = ConnectionFactory.getInstance().makeConnection();
		List<Poetry> poetries = poetryDao.queryByTitle(connection, key, page);
		return poetries;
	}

	public List<Poetry> queryByContent(String key, Page page) {
		Connection connection = ConnectionFactory.getInstance().makeConnection();
		List<Poetry> poetries = poetryDao.queryByContent(connection, key, page);
		return poetries;
	}

	public int countByPoet(String key) {
		Connection connection = ConnectionFactory.getInstance().makeConnection();
		int amount = poetryDao.countByPoet(connection, key);
		return amount;
	}

	public int countByTitle(String key) {
		Connection connection = ConnectionFactory.getInstance().makeConnection();
		int amount = poetryDao.countByTitle(connection, key);
		return amount;
	}

	public int countByContent(String key) {
		Connection connection = ConnectionFactory.getInstance().makeConnection();
		int amount = poetryDao.countByContent(connection, key);
		return amount;
	}
}
