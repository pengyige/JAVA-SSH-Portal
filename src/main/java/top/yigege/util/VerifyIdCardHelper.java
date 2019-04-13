package top.yigege.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.HttpResponse;
import com.sun.deploy.net.HttpUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
    private static final String REAL_NAME = "readlName";

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
     * @param readName
     * @return
     */
    public static boolean sendVerfidyIdCardRequest(String cardNo,String readName) {
        logger.info("开始实名认证,身份证="+cardNo+",用户名="+readName);
      /*  Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put(APPCODE, "APPCODE " + code);*/
        RestTemplate restTemplate = new RestTemplate();

        //设置参数
        Map<String, String> querys = new HashMap<String, String>();
        querys.put(CARD_NO, cardNo);
        querys.put(REAL_NAME, readName);

        //设置响应头
        HttpHeaders restHeaders = new HttpHeaders();
        restHeaders.add(APPCODE,"APPCODE " + code);

        HttpEntity<Map<String,String>> requestEntity = new HttpEntity<>(querys,restHeaders);

        //执行请求
        ResponseEntity<String> resp = restTemplate.exchange(VERIFY_ID_CARD_V2, HttpMethod.GET,requestEntity,String.class);
        String result = resp.getBody();
        logger.info("认证结束，结果="+result);
        JSONObject jsonObject = JSON.parseObject(result);
        if (jsonObject.getInteger("error_code").equals(SUCCESS_CODE)) {
            return jsonObject.getJSONObject("result").getBoolean("isok");
        }else {
            return false;
        }

    }



}
