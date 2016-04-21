package com.cloudcode.push.hndler;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.cloudcode.push.utils.Constants;

@Component
public class SystemWebSocketHandler implements WebSocketHandler {
    private static final ArrayList<WebSocketSession> users=new ArrayList<WebSocketSession>();
  //  @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("connect to the websocket success......");
        System.out.println(session.getId());
        users.add(session);
        session.sendMessage(new TextMessage("Server:connected OK!"));
    }

 //   @Override
    public void handleMessage(WebSocketSession wss, WebSocketMessage<?> wsm) throws Exception {
    	 System.out.println(wss.getId());
    	TextMessage returnMessage = new TextMessage(wsm.getPayload()
				+ " received at server");
		wss.sendMessage(returnMessage);
		 Thread.sleep(16000);
		send(wss,wsm);
    }
	public void send(WebSocketSession wss,WebSocketMessage<?> wsm) throws IOException{
		 TextMessage returnMessage = new TextMessage(wsm.getPayload()
					+ "测试成功！！！");
			wss.sendMessage(returnMessage);
	}
  //  @Override
    public void handleTransportError(WebSocketSession wss, Throwable thrwbl) throws Exception {
        if(wss.isOpen()){
            wss.close();
            users.remove(wss);
        }
       System.out.println("websocket connection closed......");
    }

   // @Override
    public void afterConnectionClosed(WebSocketSession wss, CloseStatus cs) throws Exception {
        System.out.println("websocket connection closed......");
        users.remove(wss);
    }

  //  @Override
    public boolean supportsPartialMessages() {
        return false;
    }
    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String userName, TextMessage message) {
        for (WebSocketSession user : users) {
            if (user.getAttributes().get(Constants.WEBSOCKET_USERNAME).equals(userName)) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
