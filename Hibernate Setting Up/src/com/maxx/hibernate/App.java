package com.maxx.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maxx.hibernate.entity.Users;

public class App {

	public static void main(String[] args) {
		

			Configuration con = new Configuration();

			SessionFactory factory = con.configure("").addAnnotatedClass(Users.class).buildSessionFactory();

			Session session = factory.getCurrentSession();
			try {
			Users user = new Users("username", "password", "firstname", "lastname");
			session.beginTransaction();
			
			user=session.get(Users.class, 1);
			
			session.getTransaction().commit();
			
			System.out.println(user);

		} catch (HibernateException exception) {
			System.out.println("Problem:---");
			exception.printStackTrace();
		} finally {
			 session.close();
			 factory.close();
		}
	}
}
