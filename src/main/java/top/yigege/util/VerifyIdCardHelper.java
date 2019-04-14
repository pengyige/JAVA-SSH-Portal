package top.yigege.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.HttpResponse;
import com.sun.deploy.net.HttpUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import top.yigege.domain.VerfifyReturnDTO;
import top.yigege.domain.VerifyIdCardInfor;
import top.yigege.domain.VerifyResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: VerifyIdCardHelper
 * @Description:TODO
 * @author: yigege
 * @date: 2019年04月13日 17:08
 */
public class VerifyIdCardHelper {

    private static Logger logger = Logger.getLogger(VerifyIdCardHelper.class);

    /**接口地址*/
    private static final String VERIFY_ID_CARD_V2 = "http://aliyunverifyidcard.haoservice.com/idcard/VerifyIdcardv2";

    /**身份证KEY*/
    private static final String CARD_NO = "cardNo";

    /**姓名KEY*/
    private static final String REAL_NAME = "realName";

    /**认证KEY*/
    private static final String APPCODE = "Authorization";


    /**key值*/
    private static final String AppKey = "26033244";

    /**code值*/
    private static final String code = "57f90abe1bf8404c9bc64e89a96a5ba1";

    /**返回成功*/
    private static final int SUCCESS_CODE = 0;

    /**
     * 是否实名认证
     * @param cardNo
     * @param realName
     * @return
     */
    public static boolean sendVerfidyIdCardRequest(String cardNo,String realName) {
        logger.info("开始实名认证,身份证="+cardNo+",用户名="+realName);
      /*  Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put(APPCODE, "APPCODE " + code);*/
        RestTemplate restTemplate = new RestTemplate();

        //设置参数
      /*  MultiValueMap<String, String> querys = new LinkedMultiValueMap<>();
       *//* querys.add(CARD_NO, cardNo);
        querys.add(REAL_NAME, realName);
*/
        //设置响应头
        HttpHeaders restHeaders = new HttpHeaders();

        restHeaders.add(APPCODE,"APPCODE " + code);

        HttpEntity<MultiValueMap<String,String>> requestEntity = new HttpEntity<>(restHeaders);
        //执行请求
        ResponseEntity<String> resp = restTemplate.exchange(VERIFY_ID_CARD_V2+"?cardNo="+cardNo+"&realName="+realName,HttpMethod.GET,requestEntity,String.class);
        String result = resp.getBody();
        logger.info("认证结束，结果="+result);
        /*JSONObject jsonObject = JSON.parseObject(result);
        if (jsonObject.getInteger("error_code").equals(SUCCESS_CODE)) {
            return jsonObject.getJSONObject("result").getBoolean("isok");
        }else {
            return false;
        }*/

        //String result = "{\"error_code\":0,\"reason\":\"成功\",\"result\":{\"realname\":\"余越\",\"idcard\":\"429006199802126410\",\"isok\":true}";
        VerfifyReturnDTO verfifyReturnDTO = JSONObject.parseObject(result,VerfifyReturnDTO.class);

        return verfifyReturnDTO.getResult().isIsok();

    }



}
