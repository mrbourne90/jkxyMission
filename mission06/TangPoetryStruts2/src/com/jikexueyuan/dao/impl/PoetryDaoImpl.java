package com.jikexueyuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jikexueyuan.dao.PoetryDao;
import com.jikexueyuan.entity.Poetry;
import com.jikexueyuan.util.Page;

public class PoetryDaoImpl implements PoetryDao {

	PreparedStatement pStatement = null;
	ResultSet rSet = null;
	List<Poetry> poetries = new ArrayList<Poetry>();
	int amount = 0;

	@Override
	public List<Poetry> query(Connection connection, PreparedStatement pStatement) {
		try {
			rSet = pStatement.executeQuery();
			// 将结果集中的内容存放在List中
			while (rSet.next()) {
				Poetry poetry = new Poetry();
				poetry.setId(rSet.getLong("id"));
				poetry.setPoetName(rSet.getString("name"));
				poetry.setTitle(rSet.getString("title"));
				poetry.setContent(rSet.getString("content"));
				poetries.add(poetry);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rSet.close();
				pStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return poetries;
	}

	@Override
	public int count(Connection connection, PreparedStatement pStatement) {
		try {
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				amount = rSet.getInt("amount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 使用完PrepareStatement和ResultSet一定要关闭，否则内存会急剧增长
				rSet.close();
				pStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return amount;
	}

	@Override
	public List<Poetry> queryByPoet(Connection connection, String poet, Page page) {

		try {
			pStatement = connection.prepareStatement(
					"SELECT  poetries.id,poets.name,poetries.title,poetries.content FROM poetries,poets WHERE poets.id = poetries.poet_id AND poets.name = ? LIMIT ?,?");
			pStatement.setString(1, poet);
			pStatement.setInt(2, page.getBeginIndex()); // 设置limit起始偏移
			pStatement.setInt(3, page.getEndIndex() - page.getBeginIndex()); // 设置limit条数
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(pStatement.toString());
		poetries = query(connection, pStatement);
		return poetries;
	}

	@Override
	public List<Poetry> queryByTitle(Connection connection, String title, Page page) {
		try {
			pStatement = connection.prepareStatement(
					"SELECT  poetries.id,poets.name,poetries.title,poetries.content FROM poetries,poets WHERE poets.id = poetries.poet_id AND poetries.title = ? LIMIT ?,?");
			pStatement.setString(1, title);
			pStatement.setInt(2, page.getBeginIndex()); // 设置limit起始偏移
			pStatement.setInt(3, page.getEndIndex() - page.getBeginIndex()); // 设置limit条数
			System.out.println(pStatement.toString());
			poetries = query(connection, pStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return poetries;
	}

	@Override
	public List<Poetry> queryByContent(Connection connection, String key, Page page) {
		try {
			pStatement = connection.prepareStatement(
					"SELECT  poetries.id,poets.name,poetries.title,poetries.content FROM poetries,poets WHERE poets.id = poetries.poet_id AND poetries.content LIKE ? LIMIT ?,?");
			pStatement.setString(1, "%" + key + "%");
			pStatement.setInt(2, page.getBeginIndex()); // 设置limit起始偏移
			pStatement.setInt(3, page.getEndIndex() - page.getBeginIndex()); // 设置limit条数
			System.out.println(pStatement.toString());
			poetries = query(connection, pStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return poetries;
	}

	@Override
	public int countByPoet(Connection connection, String poet) {
		try {
			pStatement = connection.prepareStatement(
					"SELECT  count(*) amount FROM poetries,poets WHERE poets.id = poetries.poet_id AND poets.name = ?");
			pStatement.setString(1, poet);
			System.out.println(pStatement.toString());
			amount = count(connection, pStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return amount;
	}

	@Override
	public int countByTitle(Connection connection, String title) {
		try {
			pStatement = connection.prepareStatement(
					"SELECT  count(*) amount FROM poetries,poets WHERE poets.id = poetries.poet_id AND poetries.title = ?");
			pStatement.setString(1, title);
			System.out.println(pStatement.toString());
			amount = count(connection, pStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return amount;
	}

	@Override
	public int countByContent(Connection connection, String key) {
		try {
			pStatement = connection.prepareStatement(
					"SELECT  count(*) amount FROM poetries,poets WHERE poets.id = poetries.poet_id AND poetries.content LIKE ?");
			pStatement.setString(1, "%" + key + "%");
			System.out.println(pStatement.toString());
			amount = count(connection, pStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return amount;
	}
}
