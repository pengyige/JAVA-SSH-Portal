package top.yigege.web.action;

import top.yigege.domain.User;
import top.yigege.enums.HttpCodeEnum;
import top.yigege.service.RiderService;
import top.yigege.service.UserService;
import top.yigege.util.ReturnDTOUtil;
import top.yigege.util.ValidatorUtil;
import top.yigege.vo.ReturnDTO;

import static top.yigege.enums.HttpCodeEnum.USER_ALREADY_REGISTER;

/**
 * @ClassName: SmsAction
 * @Description:TODO
 * @author: yigege
 * @date: 2019年05月03日 10:28
 */
public class SmsAction extends BaseAction {

    /**手机号*/
    private Long phone;

    private UserService userService;

    private RiderService riderService;

    public RiderService getRiderService() {
        return riderService;
    }

    public void setRiderService(RiderService riderService) {
        this.riderService = riderService;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取注册短信验证码
     */
    public String getRegisterCode() {
        logger.info("获取短信验证码");

        if (null == phone) {
            returnDTO = ReturnDTOUtil.paramError("手机号不能为空");
            return JSON_DATA;
        }

        if (!ValidatorUtil.isMobile(phone.toString())) {
            returnDTO = ReturnDTOUtil.paramError("手机号非法");
            return  JSON_DATA;
        }


        User user = userService.findUserByTel(phone.toString());
        if (null != user) {
            returnDTO = new ReturnDTO(HttpCodeEnum.USER_ALREADY_REGISTER.getCode(),null,USER_ALREADY_REGISTER.getMessage());
            return JSON_DATA;
        }

        //通过第三方获取短信码
        returnDTO = ReturnDTOUtil.success("1234");

        return JSON_DATA;

    }

    public String test(){
        return JSON_DATA;
    }
}
