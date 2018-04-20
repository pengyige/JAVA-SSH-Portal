package top.yigege.dao;
import java.util.List;

public interface BaseDao<T> {
	void save(T t);
	void delete(T t);
	void update(T t);
	T find(String id);
	List<T> findAll();
}
