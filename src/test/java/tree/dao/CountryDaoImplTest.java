package tree.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import tree.config.HibernateUtil;
import tree.model.Country;

//We have to create the parameters ones, so that will cost less
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CountryDaoImplTest {

	private SessionFactory sessionFactory;
	private CountryDaoImpl undertest;
	
	@BeforeAll
	public void setup() 
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		undertest = new CountryDaoImpl(Country.class, sessionFactory); 
	}
	
	@Test
	void testSaveAndFindById() 
	{
		var testCountry = new Country();
		testCountry.setCountryName( "Ukraine" );
		
		undertest.save( testCountry );
		
		Country resultCountry = undertest.findById( testCountry.getId() );
		assertNotNull( resultCountry );
		assertEquals( testCountry.getCountryName(), resultCountry.getCountryName() );
	}
	
}
