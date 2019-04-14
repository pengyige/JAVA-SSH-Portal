package top.yigege.jsontest;

import com.alibaba.fastjson.JSONObject;
import top.yigege.domain.VerfifyReturnDTO;
import top.yigege.domain.VerifyResult;

/**
 * @ClassName: FastJsonTest
 * @Description:TODO
 * @author: yigege
 * @date: 2019年04月14日 17:12
 */
public class FastJsonTest {

    public static void main(String[] args) {
      /*  String test = "{\n" +
                "  \"aAttr1\": \"我是A\",\n" +
                "  \"b\": {\n" +
                "    \"bAttr1\": \"我是B\",\n" +
                "    c: {\n" +
                "      \"cAttr1\": \"我是C\"\n" +
                "    }\n" +
                "  }\n" +
                "}";*/
      /*  A a = JSONObject.parseObject(test,A.class);
        System.out.println(a.toString());*/
       /*String test = "{\"realname\":\"余越\",\"idcard\":\"429006199802126410\",\"isok\":true,\"IdCardInfor\":{\"area\":\"湖北省省直辖行政单位天门市\",\"sex\":\"男\",\"birthday\":\"1998-2-12\"}}";
       VerifyResult verifyResult  = JSONObject.parseObject(test, VerifyResult.class);*/
        String result = "{\n" +
                "  \"error_code\": 0,\n" +
                "  \"reason\": \"成功\",\n" +
                "  \"result\": {\n" +
                "    \"realname\": \"余越\",\n" +
                "    \"idcard\": \"429006199802126410\",\n" +
                "    \"isok\": true,\n" +
                "    \"IdCardInfor\": {\n" +
                "      \"area\": \"湖北省省直辖行政单位天门市\",\n" +
                "      \"sex\": \"男\",\n" +
                "      \"birthday\": \"1998-2-12\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        VerfifyReturnDTO verfifyReturnDTO = JSONObject.parseObject(result,VerfifyReturnDTO.class);
        System.out.println(verfifyReturnDTO.toString());
    }
}


class A {
    private int aAttr1;
    private B b;

    public int getaAttr1() {
        return aAttr1;
    }

    public void setaAttr1(int aAttr1) {
        this.aAttr1 = aAttr1;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}

class  B {
    private int bAttr1;
    private C c;

    public int getbAttr1() {
        return bAttr1;
    }

    public void setbAttr1(int bAttr1) {
        this.bAttr1 = bAttr1;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}

class  C {
    private int cAttr1;

    public int getcAttr1() {
        return cAttr1;
    }

    public void setcAttr1(int cAttr1) {
        this.cAttr1 = cAttr1;
    }
}
