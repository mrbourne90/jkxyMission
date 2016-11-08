package com.jikexueyuan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.jikexueyuan.entity.Poetry;
import com.jikexueyuan.util.Page;

public interface PoetryDao {

	public List<Poetry> query(Connection connection, PreparedStatement pStatement);

	public int count(Connection connection, PreparedStatement pStatement);

	public List<Poetry> queryByPoet(Connection connection, String poet, Page page);

	public List<Poetry> queryByTitle(Connection connection, String title, Page page);

	public List<Poetry> queryByContent(Connection connection, String key, Page page);

	public int countByPoet(Connection connection, String poet);

	public int countByTitle(Connection connection, String title);

	public int countByContent(Connection connection, String key);

}
