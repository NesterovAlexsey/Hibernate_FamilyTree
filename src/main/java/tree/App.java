package tree;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tree.config.HibernateUtil;
import tree.model.Person;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Start session with db
		Session session = HibernateUtil.getSessionFactory().openSession();		
		//Start the transaction
		Transaction transaction = session.beginTransaction();
				
		//Create the person
		Person person = new Person();
		person.setFirstName("Alex");
		person.setFamilyName("Nesterov");
		person.setProfession("Developer");
		
		//Method save was deprecated
		session.persist(person);
		
		//Commit transaction 
		transaction.commit();
		
		Long personId = person.getId();
		Session newSession = HibernateUtil.getSessionFactory().openSession();
		Person personFromDB = newSession.get(Person.class, personId);
		
		System.out.println("************Person from db: " + personFromDB);
		
		//Close the session, close the connection to db
		newSession.close();
		session.close();
		HibernateUtil.shutdown();
	}
}
