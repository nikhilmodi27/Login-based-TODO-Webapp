package notes.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import notes.model.Todo;

public class Tododao {
	private static SessionFactory factory = null;

	public void addtodo(String uname, String title, String desc, String stat, Date dt) {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		Todo td = new Todo(uname, title, desc, stat, dt);

		session.save(td);

		tx.commit();
		System.out.println("todo saved");
		factory.close();
		session.close();
	}
}
