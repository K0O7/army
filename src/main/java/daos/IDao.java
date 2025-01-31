package daos;

public interface IDao<T> {
	T getById(long id);
	T save(T entity);
	T update(T entity);
	void removeById(long id);
}
