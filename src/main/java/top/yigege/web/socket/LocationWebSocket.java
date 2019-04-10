package top.yigege.web.socket;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * @ClassName: LocationWebSocket
 * @Description:TODO
 * @author: yigege
 * @date: 2019年04月09日 12:57
 */
@ServerEndpoint("/locationWebSocket.websocket")
public class LocationWebSocket {

    private  static Logger logger =  org.apache.log4j.Logger.getLogger(LocationWebSocket.class);

    /**维护所有链接对象*/
    private static CopyOnWriteArraySet<LocationWebSocket> webSockets = new CopyOnWriteArraySet<>();

    //总连接数
    private static int count = 0 ;

    /**连接的session*/
    private Session session;

    public static synchronized  void addCount() {
        count++;
    }

    public static synchronized  void subCount() {
        count--;
    }

    public static synchronized  int getCount() {
        return count;
    }

    public static CopyOnWriteArraySet<LocationWebSocket> getWebSockets() {
        return webSockets;
    }

    public static void setWebSockets(CopyOnWriteArraySet<LocationWebSocket> webSockets) {
        LocationWebSocket.webSockets = webSockets;
    }

    /**
     * 连接成功回调
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        logger.info("onOpen()");
        this.session = session;
        webSockets.add(this);
        this.addCount();
    }

    /**
     * 连接关闭回调
     */
    @OnClose
    public void close() {
        logger.info("close()");
        webSockets.remove(this);
        this.subCount();
    }

    /**
     * 收到消息回调
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session) {
        logger.info("onMessage()");
        /*//获取客户端数据
        JSONObject messageJson = JSONObject.parseObject(message);
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        messageJson.put("date",df.format(new Date()));

        //向所有session发送数据
        Iterator<ChatWebSocket> it = ChatWebSocket.webSockets.iterator();
        while(it.hasNext()){
            ChatWebSocket cw = it.next();
            cw.session.getAsyncRemote().sendText(messageJson.toJSONString());
        }*/
    }

    /**
     *
     * @param session
     * @param error
     */
    public void onError(Session session,Throwable error) {
        logger.info("onError()");
        error.printStackTrace();;
    }

    public static void changeRiderLocation(double longitude, double latitude, String riderId) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("longitude",longitude);
        jsonObject.put("latitude",latitude);
        jsonObject.put("riderId",riderId);

        logger.info(jsonObject.toJSONString());
        //向所有session发送数据
        Iterator<LocationWebSocket> it = LocationWebSocket.webSockets.iterator();
        while(it.hasNext()){
            LocationWebSocket cw = it.next();
            cw.session.getAsyncRemote().sendText(jsonObject.toJSONString());
        }
    }

}
