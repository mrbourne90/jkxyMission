package com.vipmanage.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.vipmanage.model.User;

public class UserRepositoryImpl {

	// 自动从上下文中装入已配置好的实体工厂
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public User checkUser(User user) {

		String queryString = "select u from User u where u.username = :username and u.password = :password and quanxian != 0";
		Query query = entityManager.createQuery(queryString);
		@SuppressWarnings("unchecked")
		List<User> usersCheck = query.setParameter("username", user.getUsername())
				.setParameter("password", user.getPassword()).getResultList();
		// 有结果则返回查询到的第一个结果
		if (usersCheck.size() > 0) {
			return usersCheck.get(0);
		} else {
			return null;
		}

	}

	@Transactional
	public Boolean activateUser(User user) {
		String queryString = "select u from User u where u.username = :username";
		Query query = entityManager.createQuery(queryString);
		List<User> users = (List<User>) query.setParameter("username", user.getUsername()).getResultList();
		// 用户存在 可以操作
		if (users.size() > 0) {
			User theUser = users.get(0);
			theUser.setQuanxian(1);
			entityManager.persist(theUser);
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public Boolean deactivateUser(User user) {
		String queryString = "select u from User u where u.username = :username";
		Query query = entityManager.createQuery(queryString);
		List<User> users = (List<User>) query.setParameter("username", user.getUsername()).getResultList();
		// 用户存在 可以操作
		if (users.size() > 0) {
			User theUser = users.get(0);
			theUser.setQuanxian(0);
			entityManager.persist(theUser);
			return true;
		} else {
			return false;
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
