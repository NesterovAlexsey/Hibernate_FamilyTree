package tree.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import tree.config.HibernateUtil;
import tree.model.Country;

//We have to create the parameters ones, so that will cost less
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CountryDaoImplTest {

	private SessionFactory sessionFactory;
	private CountryDaoImpl undertest;
	private Session session;
	
	@BeforeAll
	public void setup() 
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		undertest = new CountryDaoImpl(Country.class, sessionFactory); 
	}
	
	@BeforeEach
	void startTransaction()
	{
		this.session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}
	
	@Test
	void testSaveAndFindById() 
	{
		var testCountry = new Country( "Ukraine" );
		
		undertest.save( testCountry );
		
		Country resultCountry = undertest.findById( testCountry.getId() );
		assertNotNull( resultCountry );
		assertEquals( testCountry.getCountryName(), resultCountry.getCountryName() );
	}
	
	@Test
	void testFindAllCountry()
	{
		var firstCountry = new Country( "Germany" );
		var secondCountry = new Country( "Spanish" );
		
		undertest.save( firstCountry );
		undertest.save( secondCountry );
		
		List<Country> result = undertest.findAll();
		assertEquals(2, result.size());		
	}
	
	@Test
	void testDeleteCountry()
	{
		var deleteCountry = new Country( "TestCountry" );
		undertest.save( deleteCountry );
		
		undertest.delete( deleteCountry );
		Country result = undertest.findById( deleteCountry.getId() );
		
		assertNull(result);
	}
	
	@AfterEach
	void closeTransaction()
	{
		this.session.getTransaction().commit();
		session.close();
	}
	
	
	
}
