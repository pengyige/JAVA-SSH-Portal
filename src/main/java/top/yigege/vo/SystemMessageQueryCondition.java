package top.yigege.vo;

import java.util.Date;

/**
 * @ClassName: SystemMessageQueryCondition
 * @Description:TODO
 * @author: yigege
 * @date: 2019年03月29日 20:11
 */
public class SystemMessageQueryCondition {

    /**消息ID*/
    private String ids;

    /**消息标题*/
    private String title;

    /**内容*/
    private String content;

    /**消息日期*/
    private Date date;

    /**消息类型*/
    private int type;

    /**消息状态*/
    private int state;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
