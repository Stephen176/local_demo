package com.wz.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket")
public class TestWebSocket {

    //线程安全的静态变量，表示在线连接数
    private static volatile int onlineCount = 0;

    //用来存放每个客户端对应的TestWebSocket对象，适用于同时与多个客户端通信
    public static CopyOnWriteArraySet<TestWebSocket> webSocketSet = new CopyOnWriteArraySet<TestWebSocket>();
    //若要实现服务端与指定客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    public static ConcurrentHashMap<Session, Object> webSocketMap = new ConcurrentHashMap<Session, Object>();

    //与某个客户端的连接会话，通过它实现定向推送(只推送给某个用户)
    private Session session;


    /**
     * 建立连接成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);  // 添加到set中
        webSocketMap.put(session, this);    // 添加到map中
        addOnlineCount();    // 添加在线人数
        System.out.println("新人加入，当前在线人数为：" + getOnlineCount());
    }

    /**
     * 关闭连接调用的方法
     */

    @OnClose
    public void onClose(Session closeSession) {
        webSocketMap.remove(session);
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有人离开，当前在线人数为：" + getOnlineCount());
    }

    /**
     * 收到客户端小心调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session mysession) throws Exception {
        for (TestWebSocket item : webSocketSet) {
            item.sendAllMessage("return: " + message);
        }
    }


    public void sendAllMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    // 获取在线人数
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    // 添加在线人+1
    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    // 减少在线人-1
    public static synchronized void subOnlineCount() {
        onlineCount--;
    }
}
