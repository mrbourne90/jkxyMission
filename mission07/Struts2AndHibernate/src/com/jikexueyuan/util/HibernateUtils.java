package com.jikexueyuan.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory sessionFactory;

	static {
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistry service = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = cfg.buildSessionFactory(service);
	}

	private HibernateUtils() {

	}

	public static Session getSession() {
		return sessionFactory.getCurrentSession();
		
	}

}
