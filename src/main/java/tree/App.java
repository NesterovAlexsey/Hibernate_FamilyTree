package tree;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tree.config.HibernateUtil;
import tree.dao.CountryDaoImpl;
import tree.model.Country;
import tree.model.Person;

//TODO - add country, Tests and Address, tests and Persons

public class App {

	/**
	 * Logger for class App
	 */
	private static final Logger logger = LoggerFactory.getLogger( App.class );
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		savePerson();
		saveCountry();
		HibernateUtil.shutdown();
		
	}
	
	/**
	 * Method for saving Country in db. 
	 */
	private static void saveCountry() 
	{
			// TODO Auto-generated method stub
			
	}
	
	/**
	 * Method for saving Person in db. 
	 */
	private static void savePerson() 
	{
			// TODO Auto-generated method stub
			
	}
		
		
//		//Start session with db
//		Session session = HibernateUtil.getSessionFactory().openSession();		
//		//Start the transaction
//		Transaction transaction = session.beginTransaction();
//				
//		//Create the person
//		Person person = new Person();
//		person.setFirstName("Alex");
//		person.setFamilyName("Nesterov");
//		person.setProfession("Developer");
//		
//		//Method save was deprecated
//		session.persist(person);
//		
//		//Commit transaction 
//		transaction.commit();
//		
//		Long personId = person.getId();
//		Session newSession = HibernateUtil.getSessionFactory().openSession();
//		Person personFromDB = newSession.get(Person.class, personId);
//		
//		System.out.println("************Person from db: " + personFromDB);
//		
//		//Close the session, close the connection to db
//		newSession.close();
//		session.close();	
//		
//		SessionFactory addCountrySession = HibernateUtil.getSessionFactory();
//		Session session2 = addCountrySession.openSession();
//		Transaction transaction2 = session2.beginTransaction();
//		Country testCountry = new Country("TestCountry");
//		CountryDaoImpl countryDaoImpl = new CountryDaoImpl(Country.class, addCountrySession);
//		countryDaoImpl.save( testCountry );
//		countryDaoImpl.save( new Country("TestCountry2") );
//		transaction2.commit();
//		
//		System.out.println("***************Countrys: " + countryDaoImpl.findAll().toString());
//		
//		session2.close();

}
