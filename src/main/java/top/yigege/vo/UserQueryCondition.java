package top.yigege.vo;

import java.util.Date;

/**
 * @ClassName: UserQueryCondition
 * @Description:用户查询条件
 * @author: yigege
 * @date: 2019年03月30日 18:53
 */
public class UserQueryCondition {

    /**编号*/
    private String ids;

    /**注册日期*/
    private Date date;

    /**用户类型*/
    private int type;


    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
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
}
