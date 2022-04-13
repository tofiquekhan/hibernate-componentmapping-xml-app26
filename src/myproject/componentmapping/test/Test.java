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
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("/myproject/componentmapping/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry = builder.build();
			sessionFactory = cfg.buildSessionFactory(registry);
			session = sessionFactory.openSession();
			Employee emp = (Employee) session.get(Employee.class, 1);
			System.out.println(emp.getEno());
			System.out.println(emp.getEname());
			System.out.println(emp.getEsal());
			System.out.println(emp.getAddr().getPno());
			System.out.println(emp.getAddr().getStreet());
			System.out.println(emp.getAddr().getCity());
			System.out.println(emp.getAcc().getAccNo());
			System.out.println(emp.getAcc().getAccName());
			System.out.println(emp.getAcc().getAccType());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
	}
}
