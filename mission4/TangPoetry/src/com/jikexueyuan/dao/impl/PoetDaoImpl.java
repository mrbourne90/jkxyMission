package com.jikexueyuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jikexueyuan.dao.PoetDao;

public class PoetDaoImpl implements PoetDao {

	@Override
	public String queryById(Connection connection, Long id) {

		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		try {
			pStatement = connection.prepareStatement("SELECT name FROM poets WHERE id = ?");
			pStatement.setLong(1, id);
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				return rSet.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rSet.close();
				pStatement.close();
				connection.close();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

		return null;
	}

}
