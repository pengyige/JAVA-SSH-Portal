package top.yigege.web.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	private Map jsonData = new HashMap<String,Object>();
	public Map getJsonData() {
		return jsonData;
	}
	public void setJsonData(Map jsonData) {
		this.jsonData = jsonData;
	}
}
