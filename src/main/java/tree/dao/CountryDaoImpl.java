package tree.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tree.model.Country;

public class CountryDaoImpl extends GenericDaoImpl<Country, Long> implements CountryDaoIf {
	
	public CountryDaoImpl(Class<Country> entityClass, SessionFactory aSessionFactory) {
		super(entityClass, aSessionFactory);		
	}
	
	public Country findCountryByName(String name, Session session) 
	{
		return session.createQuery("FROM Country WHERE countryName = :name", Country.class)
				.setParameter("name", name)
				.uniqueResult();
		
	}
	
}
