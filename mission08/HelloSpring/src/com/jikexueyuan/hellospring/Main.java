package com.jikexueyuan.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		BeanFactory beanFactory = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
		// 将XML格式输出到控制台
		IOutputHelper outputer = beanFactory.getBean("xmlOutputer", IOutputHelper.class);
		System.out.println("员工信息的XML数据");
		System.out.println(outputer.getFormatedString());
		// 将JSON格式输出到控制台
		outputer = beanFactory.getBean("jsonOutputer", IOutputHelper.class);
		System.out.println("员工信息的JSON数据");
		System.out.println(outputer.getFormatedString());

	}
}
