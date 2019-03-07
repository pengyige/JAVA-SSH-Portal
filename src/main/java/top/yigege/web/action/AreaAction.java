package top.yigege.web.action;

import java.util.List;

import top.yigege.domain.Area;
import top.yigege.service.AreaService;
import top.yigege.util.ReturnDTOUtil;
import top.yigege.vo.ReturnDTO;

/**
 * 
 * @ClassName:  AreaAction   
 * @Description:区域action
 * @author: yigege
 * @date:   2019年3月6日 下午8:06:28
 */
public class AreaAction extends BaseAction {

	/**区域服务对象*/
	private AreaService areaService;

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	
	
	/**
	 * 获取所有城市
	 * @return
	 */
	public String getCities() {
		List<Area> areas = null;
		try {
			areas = areaService.getAllAreas();
		} catch (Exception e) {
			this.returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}
		this.returnDTO = ReturnDTOUtil.success(areas);
		
		return JSON_DATA;
	}
	
	/**
	 * 获取城市
	 * @return
	 */
	public String getOnlyIncludeCity() {
		logger.info("获取城市");
		List<Area> areas = null;
		try {
			areas = areaService.getCities();
			this.returnDTO = ReturnDTOUtil.success(areas);
		}catch (Exception e) {
			e.printStackTrace();
			this.returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}
		
		return JSON_DATA;
	}
}
