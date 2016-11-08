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

	/**
	 * 通过搜索条件和关键字查询数据库，并将结果返回
	 */
	@Override
	public List<Poetry> query(Connection connection, String key, String condition, Page page) {

		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<Poetry> poetries = new ArrayList<Poetry>();

		try {
			// 根据不同的条件生成不同的PrepareStatement
			if (condition.equals("poet")) {
				pStatement = connection.prepareStatement(
						"SELECT  poetries.id,poets.name,poetries.title,poetries.content FROM poetries,poets WHERE poets.id = poetries.poet_id AND poets.name = ? LIMIT ?,?");
				pStatement.setString(1, key);

			} else if (condition.equals("title")) {
				pStatement = connection.prepareStatement(
						"SELECT  poetries.id,poets.name,poetries.title,poetries.content FROM poetries,poets WHERE poets.id = poetries.poet_id AND poetries.title = ? LIMIT ?,?");
				pStatement.setString(1, key);

			} else {
				pStatement = connection.prepareStatement(
						"SELECT  poetries.id,poets.name,poetries.title,poetries.content FROM poetries,poets WHERE poets.id = poetries.poet_id AND poetries.content LIKE ? LIMIT ?,?");
				pStatement.setString(1, "%" + key + "%");
			}
			pStatement.setInt(2, page.getBeginIndex());	//设置limit起始偏移
			pStatement.setInt(3, page.getEndIndex() - page.getBeginIndex());	//设置limit条数
			System.out.println(pStatement.toString());
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
				// 使用完PrepareStatement和ResultSet一定要关闭，否则内存会急剧增长
				rSet.close();
				pStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return poetries;
	}

	/**
	 * 根据条件和关键字查询符合条件的诗歌数目
	 */
	@Override
	public int getPoetriesAmount(Connection connection, String key, String condition) {
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		int amount = 0;

		try {
			// 根据不同的条件生成不同的PrepareStatement
			if (condition.equals("poet")) {
				pStatement = connection.prepareStatement(
						"SELECT  count(*) amount FROM poetries,poets WHERE poets.id = poetries.poet_id AND poets.name = ?");
				pStatement.setString(1, key);

			} else if (condition.equals("title")) {
				pStatement = connection.prepareStatement(
						"SELECT  count(*) amount FROM poetries,poets WHERE poets.id = poetries.poet_id AND poetries.title = ?");
				pStatement.setString(1, key);

			} else {
				pStatement = connection.prepareStatement(
						"SELECT  count(*) amount FROM poetries,poets WHERE poets.id = poetries.poet_id AND poetries.content LIKE ?");
				pStatement.setString(1, "%" + key + "%");
			}
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
}
