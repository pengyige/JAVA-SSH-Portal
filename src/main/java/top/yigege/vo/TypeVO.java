package top.yigege.vo;

/**
 * @ClassName: TypeVO
 * @Description:TODO
 * @author: yigege
 * @date: 2019年03月30日 19:34
 */
public class TypeVO {

    /**值*/
    private Long value;

    /**描述*/
    private String desc;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TypeVO(Long value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
