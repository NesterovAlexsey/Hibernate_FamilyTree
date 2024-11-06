package tree.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDaoImpl<T, ID> implements GenericDao<T, ID> 
{
	@PersistenceContext
	protected EntityManager entityManager;
	
	private Class<T> entityClass;
	
	public GenericDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void save(T entity) {
		entityManager.persist(entity);		
	}

	@Override
	public T findById(ID id) {
		return entityManager.find(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		return entityManager.createQuery(
				"from" + entityClass.getName(), entityClass
				).getResultList();
	}

	@Override
	public void update(T entity) {
		entityManager.merge(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}
}
