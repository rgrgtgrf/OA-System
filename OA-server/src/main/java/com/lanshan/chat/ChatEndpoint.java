package com.lanshan.chat;

import com.alibaba.fastjson.JSON;
import com.lanshan.config.GetHttpSessionConfigurator;
import com.lanshan.entity.Message;
import com.lanshan.utils.MessageUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/chat", configurator = GetHttpSessionConfigurator.class)
@Component
public class ChatEndpoint {

    private static Map<String, Session> onlineUsers = new ConcurrentHashMap<>();
    private HttpSession httpSession;

    @OnOpen
    public void OnOpen(Session session, EndpointConfig config) {
        System.out.println(session.getId());
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        String user = (String)this.httpSession.getAttribute("user");
        onlineUsers.put(user, session);
        //广播消息
        String message =  MessageUtil.getMessage(true,null,getFriends());
        broadcastAllUsers(message);
    }

    public Set getFriends() {
        Set<String> set = onlineUsers.keySet();
        return set;
    }

    private void broadcastAllUsers(String message){
        try{
            Set<Map.Entry<String, Session>> entries = onlineUsers.entrySet();
            for (Map.Entry<String, Session> entry : entries) {
                Session session = entry.getValue();
                session.getBasicRemote().sendText(message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @OnMessage
    public void OnMessage(Session session, String message) {
        try {
            System.out.println(session.getId());
            Message msg = JSON.parseObject(message, Message.class);

            String toName = msg.getToName();
            String mess = msg.getMessage();

            onlineUsers.get(toName);
            String user = (String) this.httpSession.getAttribute("user");
            String message1 = MessageUtil.getMessage(false, user, mess);
            session.getBasicRemote().sendText(message1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @OnClose
    public void OnClose(Session session) {
        System.out.println(session.getId());
        String user = (String)this.httpSession.getAttribute("user");
        onlineUsers.remove(user);

        String message =  MessageUtil.getMessage(true,null,getFriends());
        broadcastAllUsers(message);
    }
}
