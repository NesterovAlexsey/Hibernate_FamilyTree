package tree;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tree.config.HibernateUtil;
//import tree.model.Person;
import tree.model.Test;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Start session with db
		Session session = HibernateUtil.getSessionFactory().openSession();		
		//Start the transaction
		Transaction transaction = session.beginTransaction();
		
		Test test = new Test();
		test.setTestInfo("Some test info");
		
		session.persist(test);
		
		//Create the person
//		Person person = new Person();
//		person.setFirstName("Alex");
//		person.setFamilyName("Nesterov");
//		person.setProfession("Developer");
		
		//Method save was deprecated
//		session.persist(person);
		
		//Commit transaction, Close the session, close the connection to db
		transaction.commit();
		session.close();
		HibernateUtil.shutdown();
	}
}
