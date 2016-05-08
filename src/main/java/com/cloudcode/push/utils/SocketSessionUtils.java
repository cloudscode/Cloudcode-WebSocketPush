package com.cloudcode.push.utils;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
@Repository
public class SocketSessionUtils {
	private static Logger log = LoggerFactory.getLogger(SocketSessionUtils.class);
    private static Map<String, WebSocketSession> clients = new ConcurrentHashMap<String, WebSocketSession>();  
  
    /** 
     * 保存一个连接 
     * @param id 
     * @param session 
     */  
    public static void add(String id, WebSocketSession session){  
        clients.put(id, session);  
    }  
  
    /** 
     * 获取一个连接 
     * @param id 
     * @return 
     */  
    public static WebSocketSession get(String id){  
        return clients.get(id);  
    }  
  
    /** 
     * 移除一个连接 
     * @param id 
     */  
    public static void remove(String id) throws IOException {  
        clients.remove(id);  
    }  
    /** 
     * 判断是否有效连接 
     * 判断是否存在 
     * 判断连接是否开启 
     * 无效的进行清除 
     * @param id 
     * @return 
     */  
    public static boolean hasConnection(String id) {  
        if (clients.containsKey(id)) {  
            return true;  
        }  
  
        return false;  
    }  
  
    /** 
     * 获取连接数的数量 
     * @return 
     */  
    public static int getSize() {  
        return clients.size();  
    }  
  
    /** 
     * 发送消息到客户端 
     * @param id 
     * @param message 
     * @throws Exception 
     */  
    public static void sendMessage(String id, String message) throws Exception {  
        if (!hasConnection(id)) {  
            throw new NullPointerException(id + " connection does not exist");  
        }  
  
        WebSocketSession session = get(id);  
        try {  
            session.sendMessage(new TextMessage(message));  
        } catch (IOException e) {  
        	log.error("websocket sendMessage exception: " + id);  
            log.error(e.getMessage(), e);  
            clients.remove(id);  
        }  
    } 
}
