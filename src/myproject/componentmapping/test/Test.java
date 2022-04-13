package myproject.componentmapping.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import myproject.componentmapping.entity.Account;
import myproject.componentmapping.entity.Address;
import myproject.componentmapping.entity.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("/myproject/componentmapping/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry = builder.build();
			sessionFactory = cfg.buildSessionFactory(registry);
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Employee emp = new Employee();
			emp.setEname("AAA");
			emp.setEsal(5000);
			Address addr = new Address();
			addr.setPno("101");
			addr.setCity("Indore");
			addr.setStreet("Ring Road");
			Account acc = new Account();
			acc.setAccNo("23101");
			acc.setAccName("Axis Bank");
			acc.setAccType("Saving");
			int pk = (Integer)session.save(emp);
			tx.commit();
			System.out.println("Employee Add & PK is : "+pk);
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
		
		
		
		
	}
}
