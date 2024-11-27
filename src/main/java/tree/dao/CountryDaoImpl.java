package tree.dao;

import org.hibernate.SessionFactory;

import tree.model.Country;

public class CountryDaoImpl extends GenericDaoImpl<Country, Long> implements CountryDaoIf {

	public CountryDaoImpl(Class<Country> entityClass, SessionFactory aSessionFactory) {
		super(entityClass, aSessionFactory);
		
	}

}
