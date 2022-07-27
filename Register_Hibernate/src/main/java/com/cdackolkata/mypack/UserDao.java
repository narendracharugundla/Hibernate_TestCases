package com.cdackolkata.mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UserDao {

	public static int register(User u) {
		int i = 0;
//Hibernate Sudo Code

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		/*
		 * Configuration cfg= new Configuration(); cfg.configure();
		 * 
		 * SessionFactory factory = cfg.buildSessionFactory();
		 */
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		i = (Integer) session.save(u);

		t.commit();
		session.close();

		return i;

	}
}