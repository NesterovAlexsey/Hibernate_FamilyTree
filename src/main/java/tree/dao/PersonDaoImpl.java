package tree.dao;

import tree.model.Person;

public class PersonDaoImpl extends GenericDaoImpl<Person, Long> implements PersonDaoIf  {

	public PersonDaoImpl(Class<Person> entityClass) {
		super(entityClass, sessionFactory);
	}

}
