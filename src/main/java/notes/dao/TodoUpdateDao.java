package notes.dao;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import notes.model.Todo;

public class TodoUpdateDao {
	private static SessionFactory factory = null;

	public boolean updatetodo(Integer id,String title,String des,String stat) {

		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();

		Transaction tx = null;
		Date d = new Date();
		try {
			tx = session.beginTransaction();
			Todo td = (Todo) session.get(Todo.class, id);
			if (td != null) {
				td.setTitle(title);
				td.setDescription(des);
				td.setStatus(stat);
				td.setDt(d);
				session.update(td);
				System.out.println("todo updated");
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			factory.close();
			session.close();
		}
		return true;
	}
}
