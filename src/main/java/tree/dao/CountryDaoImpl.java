package tree.dao;

import org.hibernate.SessionFactory;

import tree.model.Country;

public class CountryDaoImpl extends GenericDaoImpl<Country, Long> implements CountryDaoIf {

	SessionFactory sessionFactory;
	
	public CountryDaoImpl(Class<Country> entityClass, SessionFactory aSessionFactory) {
		super(entityClass, aSessionFactory);
		this.sessionFactory = aSessionFactory;
	}
	
	//TODO - add posibility to find Country by name
	public Country findCountryByName(String name) 
	{
		return sessionFactory.getCurrentSession().byId(name)
	}
	
}
