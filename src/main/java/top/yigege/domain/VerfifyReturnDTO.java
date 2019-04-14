package top.yigege.domain;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: VerfifyReturnDTO
 * @Description:TODO
 * @author: yigege
 * @date: 2019年04月14日 15:37
 */
public class VerfifyReturnDTO {

    /**返回码*/
    private Integer error_code;

    /**消息*/
    private String reason;

    /**result*/
    private VerifyResult result;

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public VerifyResult getResult() {
        return result;
    }

    public void setResult(VerifyResult result) {
        this.result = result;
    }

    public VerfifyReturnDTO() {


    }
}


