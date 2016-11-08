package com.jikexueyuan.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jikexueyuan.dao.UserDao;
import com.jikexueyuan.dao.impl.UserDaoImpl;
import com.jikexueyuan.entity.User;
import com.jikexueyuan.util.HibernateUtils;

public class UserService {
	
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * 根据用户名密码查找出一个相应的用户
	 * @param userName
	 * @param password
	 * @return
	 */
	public User findUnique(String userName, String password){
		
		User user = null;
		Transaction tx = null;
		String sql = "select * from users where user_name='" + userName + "' and password='" + password + "'";
		
		try {
			Session session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			user = userDao.findUnique(sql);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return user;
	}
	
	/**
	 * 保存一个用户
	 * @param user
	 */
	public void save(User user){
		
		Transaction tx = null;
		
		try {
			Session session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			userDao.save(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> findAll(){
		
		List<User> list = null;
		Transaction tx = null;
		
		try {
			Session session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			list = userDao.findAll();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return list;
	}
	
	/**
	 * 删除一个用户
	 */
	public void delete(int id){
		
		Transaction tx = null;
			
		try {
			Session session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			userDao.delete(id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	/**
	 * 获取一个用户
	 * @param id
	 * @return
	 */
	public User get(int id){
		
		User user = null;
		Transaction tx = null;
		
		try {
			Session session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			user = userDao.get(id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return user;
	}
}
