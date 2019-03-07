package top.yigege.dao;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName:  BaseDao   
 * @Description:公共Dao接口
 * @author: yigege
 * @date:   2018年12月16日 上午10:31:38   
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 保存对象
	 * @param t
	 */
	void save(T t);
	
	/**
	 * 删除对象
	 * @param t
	 */
	void delete(T t);
	
	/**
	 * 更新对象
	 * @param t
	 */
	void update(T t);
	
	/**
	 * 通过id查找对象
	 * @param id
	 * @return
	 */
	T find(Serializable id);
	
	/**
	 * 返回所有对象
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 返回所有数量
	 * @return
	 */
	Long getAllCount(); 
	
	/**
	 * 分页查询
	 * @param page 当前页
	 * @param rows 分页大小
	 * @return
	 */
	List<T> pageList(int page , int rows);
}
