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
		
		//Later will come from other class
		String countryName = "Test Country";

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		saveCountry( sessionFactory, countryName );
		savePerson( sessionFactory, countryName );
		
		HibernateUtil.shutdown();
		
	}
	
	/**
	 * Method for saving Country in db. 
	 */
	private static void saveCountry( SessionFactory addCountrySession, String aCountryName ) 
	
	{
				
		try(Session session = addCountrySession.openSession())
		{
			Transaction transactionForCountry = session.beginTransaction();
			
			Country testCountry = new Country( aCountryName );
			CountryDaoImpl countryDaoImpl = new CountryDaoImpl(Country.class, addCountrySession);
			
			countryDaoImpl.save( testCountry, session );
			countryDaoImpl.save( new Country("TestCountry2"), session );
			
			transactionForCountry.commit();
			
			logger.info("Countrys was added succesfully: " + countryDaoImpl.findAll( session ).toString());
			
			session.close();			
		}
		catch (Exception e)
		{
			logger.error("Exception during opening the session in App.class, method saveCountry: ", e);
		}
		
	}
	
	/**
	 * Method for saving Person in db. 
	 */
	private static void savePerson( SessionFactory aSessionFactory, String aCountryName ) 
	{
		
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			Transaction transaction = session.beginTransaction(); 
			
			PersonDaoImpl personDao = new PersonDaoImpl( Person.class, HibernateUtil.getSessionFactory() );			
			Person person = new Person( "Alex", "Nesterov" );
			
			//added the country to the person
			CountryDaoImpl countryDaoImpl = new CountryDaoImpl( Country.class, aSessionFactory );
			Country country = countryDaoImpl.findCountryByName( aCountryName, session );
			if ( country != null) 
			{
				person.setCountry( country );
				logger.info( String.format("Country %s with id %d was added to the person %s", 
						aCountryName, country.getId(), person.toString()));
			}
			else
			{
				logger.error( String.format( "Country with name '%s' was not found.", aCountryName ) );
			}
			
			personDao.save( person, session );
			
			Person personFromDb = personDao.findById( person.getId(), session );
			logger.info( String.format( "Person %s was added to the db", personFromDb.toString() ) );
			
			transaction.commit();
		}
		catch (Exception e)
		{
			logger.error("Exception during opening the session in App.class, method savePerson: ", e);			
		}	
	}
	
}
