package top.yigege.vo;

import java.util.Date;

/**
 * @ClassName: RiderQueryCondition
 * @Description:TODO
 * @author: yigege
 * @date: 2019年03月30日 20:20
 */
public class RiderQueryCondition {
    /**编号*/
    private String ids;

    /**注册日期*/
    private Date date;

    /**传送点*/
    private Integer teleporterId;

    public Integer getTeleporterId() {
        return teleporterId;
    }

    public void setTeleporterId(Integer teleporterId) {
        this.teleporterId = teleporterId;
    }

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


}
