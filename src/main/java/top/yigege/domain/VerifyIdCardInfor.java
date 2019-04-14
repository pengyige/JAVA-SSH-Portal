package top.yigege.domain;

/**
 * @ClassName: VerifyIdCardInfor
 * @Description:TODO
 * @author: yigege
 * @date: 2019年04月14日 16:11
 */
public class VerifyIdCardInfor {


    /**区域*/
    private String area;

    /**性别*/
    private String sex;

    /**生日*/
    private String birthday;


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public VerifyIdCardInfor() {
    }
}
