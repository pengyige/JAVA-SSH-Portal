package top.yigege.domain;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: VerifyResult
 * @Description:TODO
 * @author: yigege
 * @date: 2019年04月14日 16:33
 */
public class VerifyResult {

    /**真实姓名*/
    private String realname;

    /**身份证*/
    private String idcard;

    /**是否匹配*/
    private boolean isok;

    /**身份证对象*/
    private VerifyIdCardInfor IdCardInfor;

    @JSONField(name = "idCardInfor")
    public VerifyIdCardInfor getIdCardInfor() {
        return IdCardInfor;
    }

    public void setIdCardInfor(VerifyIdCardInfor idCardInfor) {
        IdCardInfor = idCardInfor;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public boolean isIsok() {
        return isok;
    }

    public void setIsok(boolean isok) {
        this.isok = isok;
    }

    public VerifyResult() {
    }
}
