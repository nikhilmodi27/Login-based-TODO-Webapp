package notes.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import notes.model.User;

public class Userdao {
    private static SessionFactory factory = null;
    
    public void adduser(String fname,String lname,String uname,String ps) {
    	
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		User u1 = new User(fname, lname, uname, ps);
		session.save(u1);
		
		tx.commit();
		System.out.println("User saved");
		factory.close();
		session.close();
    }
}
