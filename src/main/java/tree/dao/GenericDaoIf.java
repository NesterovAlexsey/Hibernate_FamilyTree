package tree.dao;

import java.util.List;

/**
 * this is the type of entity that the DAO will work with, declared basic CRUD operation
 * @param <T> this is the type of entity that the DAO will work with
 * @param <ID> Type for identificator: long, integer
 */
public interface GenericDaoIf<T, ID> {
	
	void save(T entity);

	T findById(ID id);
	
	List<T> findAll();
	
	void update(T entity);
	
	void delete(T entity);
}
