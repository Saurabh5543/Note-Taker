package com.hib.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class hiber_utility {
	
	public static SessionFactory factory =null;
	
	
	public static SessionFactory getSessionFactory() {
		//step 1
		Configuration config=new Configuration();
		config.configure("session2.cfg.xml");
		//step 2
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        //step 3
		factory= 
        	config.buildSessionFactory(registry);
		
		return factory;
	}
	

}
