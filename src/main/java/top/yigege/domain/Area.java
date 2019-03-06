package top.yigege.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName:  Area   
 * @Description:区域
 * @author: yigege
 * @date:   2019年3月6日 下午1:33:53
 */
public class Area {
	
	/**id*/
	private Integer id;
	
	/**父id*/
	private Integer parent_id;
	
	/**名称*/
	private String name;
	
	/**排序*/
	private Integer sort;

	private List<Area> child = new ArrayList<Area>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public List<Area> getChild() {
		return child;
	}

	public void setChild(List<Area> child) {
		this.child = child;
	}
	
	
}
