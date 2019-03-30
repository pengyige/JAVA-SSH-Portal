package top.yigege.domain;


import java.util.Date;
import java.util.Set;

/**
 * 
 * @ClassName:  Message   
 * @Description:系统消息
 * @author: yigege
 * @date:   2018年12月31日 下午7:13:11
 */
public class SystemMessage {
	
	/**系统消息id*/
	private Integer messageId;
	
	/**系统消息标题*/
	private String title;
	
	/**系统消息内容*/
	private String content;
	
	/**系统消息图片*/
	private String imgPath;
	
	/**系统消息类型 1:传送点消息 2:骑手消息 3:用户消息*/
	private int type;
	
	/**创建时间*/
	private Date createTime;
	
	/**消息状态 1:有效  0:无效*/
	private int state;
	
	/**一条消息对应一个系统管理员*/
	private SuperAdmin superAdmin;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public SuperAdmin getSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(SuperAdmin superAdmin) {
		this.superAdmin = superAdmin;
	}

	@Override
	public String toString() {
		return "SystemMessage [messageId=" + messageId + ", title=" + title + ", content=" + content + ", imgPath="
				+ imgPath + ", type=" + type + ", createTime=" + createTime + ", state=" + state + ", superAdmin="
				+ superAdmin + "]";
	}
	
	
	
	
}
