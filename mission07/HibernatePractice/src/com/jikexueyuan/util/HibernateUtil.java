package com.jikexueyuan.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private HibernateUtil(){
		
	}
	
	public static Session getSession(){
		
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = cfg.buildSessionFactory(registry);
		Session session = factory.openSession();
		return session;
	}

}
