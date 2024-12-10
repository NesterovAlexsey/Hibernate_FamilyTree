package tree.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDaoIf<T, ID> 
{
	protected final SessionFactory sessionFactory;
	private Class<T> entityClass;
	
	public GenericDaoImpl(Class<T> entityClass, SessionFactory aSessionFactory) {
		this.entityClass = entityClass;
		this.sessionFactory = aSessionFactory;
	}
	
	//Get current session
	protected Session getSession() 
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T entity, Session aSession) 
	{
		aSession.save(entity);		
	}

	@Override
	public T findById(ID id) 
	{
		return getSession().get(entityClass, id);
	}

	@Override
	public List<T> findAll(Session aSession) 
	{
		return aSession
				.createQuery("from " + entityClass.getName(), entityClass )
				.getResultList();
	}

	@Override
	public void update(T entity) 
	{
		getSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		Session session = getSession();
		session.delete(session.contains(entity) ? entity : session.merge(entity));
		
	}
}
