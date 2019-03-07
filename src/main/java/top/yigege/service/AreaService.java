package top.yigege.service;

import java.util.Iterator;
import java.util.List;

import top.yigege.dao.AreaDao;
import top.yigege.domain.Area;

/**
 * 
 * @ClassName:  AreaService   
 * @Description:区域服务层
 * @author: yigege
 * @date:   2019年3月6日 下午8:01:51
 */
public class AreaService {
	
	/**区域dao*/
	private AreaDao areaDao;
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}
	
	/**
	 * 得到所有区域信息
	 * @return
	 */
	public List<Area> getAllAreas() {
		List<Area> areas = areaDao.findAll();
		
		for (int i = 0; i < areas.size(); i++) {
			Area area = areas.get(i);
			//如果是省级，则填充其下级
			if (0 == area.getParent_id().intValue()) {
				
				for (int j = 0; j < areas.size() ; j++) {
					Area childArea = areas.get(j);
					if (area.getId().intValue() == childArea.getParent_id().intValue()) {
						area.getChild().add(childArea);
					}
				}
			}
		}
		
		//去掉list中不是省级的项
		Iterator<Area> it = areas.iterator();
		while (it.hasNext()) {
			Area area = it.next();
		    if(0 != area.getParent_id().intValue()){
		        it.remove();
		    }
		}
		
		return areas;
	}
	
	/**
	 * 返回所有城市
	 * @return
	 */
	public List<Area> getCities(){
		
		return areaDao.getCities();
	}
	
	/**
	 * 通过id返回区域
	 * @param id
	 * @return
	 */
	public Area getAreaById(Integer id) {
		return areaDao.find(id);
	}
}
