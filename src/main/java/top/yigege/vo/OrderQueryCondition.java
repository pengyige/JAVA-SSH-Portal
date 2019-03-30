package top.yigege.vo;

/**
 * @ClassName: OrderQueryCondition
 * @Description:TODO
 * @author: yigege
 * @date: 2019年03月30日 21:20
 */
public class OrderQueryCondition {

    /**编号*/
    private String ids;

    /**订单状态*/
    private int state;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
