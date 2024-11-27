package tree.dao;

import org.hibernate.SessionFactory;

import tree.model.Person;

public class PersonDaoImpl extends GenericDaoImpl<Person, Long> implements PersonDaoIf  {

	private static SessionFactory sessionFactory;

	public PersonDaoImpl(Class<Person> entityClass) {
		super(entityClass, sessionFactory);
	}

}
