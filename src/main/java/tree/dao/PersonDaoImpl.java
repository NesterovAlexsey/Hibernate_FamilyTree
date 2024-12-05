package tree.dao;

import org.hibernate.SessionFactory;

import tree.config.HibernateUtil;
import tree.model.Person;

public class PersonDaoImpl extends GenericDaoImpl<Person, Long> implements PersonDaoIf  {

	/**
	 * Create Dao object for person
	 * @param entityClass
	 */
	public PersonDaoImpl(Class<Person> entityClass) {
		super(entityClass, HibernateUtil.getSessionFactory());
	}

}
