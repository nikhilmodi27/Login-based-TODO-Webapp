package notes.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import notes.model.Todo;

public class TodoDeleteDao {
	private static SessionFactory factory = null;

	public boolean deletetodo(Integer id) {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Todo td = (Todo) session.get(Todo.class, id);
			if(td!=null) {
				session.delete(td);
                System.out.println("todo deleted");
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
