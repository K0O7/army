package daos.myBatis;

public interface IDao<T> {
	T getById(long id);
	void save(T entity);
	void update(T entity);
	void removeById(long id);
}
