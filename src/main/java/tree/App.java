package tree;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tree.config.HibernateUtil;
import tree.dao.CountryDaoImpl;
import tree.dao.PersonDaoImpl;
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
		
	//	savePerson();
		saveCountry();
		HibernateUtil.shutdown();
		
	}
	
	/**
	 * Method for saving Country in db. 
	 */
	private static void saveCountry() 
	{
		//TODO add logger
		
		SessionFactory addCountrySession = HibernateUtil.getSessionFactory();
		
		try(Session session = addCountrySession.openSession())
		{
			Transaction transactionForCountry = session.beginTransaction();
			
			Country testCountry = new Country("Test Country");
			CountryDaoImpl countryDaoImpl = new CountryDaoImpl(Country.class, addCountrySession);
			
			countryDaoImpl.save( testCountry, session );
			countryDaoImpl.save( new Country("TestCountry2"), session );
			
			transactionForCountry.commit();
			
			logger.info("Countrys was added succesfully: " + countryDaoImpl.findAll( session ).toString());
			
			session.close();			
		}
		catch (Exception e)
		{
			logger.error("Exception during opening the session in App.class: ", e);
		}
		
	}
	
	/**
	 * Method for saving Person in db. 
	 */
	private static void savePerson() 
	{
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			PersonDaoImpl personDao = new PersonDaoImpl( Person.class, HibernateUtil.getSessionFactory() );
			
			transaction = session.beginTransaction();
			Person person = new Person( "Alex", "Nesterov" );
			personDao.save( person, session );
			
			Person personFromDb = personDao.findById( person.getId() );
			logger.info(String.format("Person %s was added to the db", personFromDb.toString()));
			
			transaction.commit();
		}
		catch (Exception e)
		{
			if (transaction != null)
			{
				transaction.rollback();
			}
		}	
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
