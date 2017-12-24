import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ChatManager {
    //因为一个聊天服务器只有一个ChatManager所以需要创建一个单例

    private ChatManager() {
    }

    private static final ChatManager cm = new ChatManager();

    public static ChatManager getchaChatManager() {
        return cm;
    }

    Vector<ChatSocket> vector = new Vector<ChatSocket>();

    public void add(ChatSocket cs) {
        vector.add(cs);//将每一个线程加入集合中
    }

    public void remove(ChatSocket cs) {
        vector.remove(cs);
    }

    public void registe(ChatSocket cs, ChatMessage chatMessage) {//注册客户端ID
        //要给集合中所有的线程发送信息就必须遍历这个集合
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket csChatSocket = vector.get(i);
            if (csChatSocket.equals(cs)) {//则需要判断不许给当前客户端发送信息，也即不给自己发送信息
                csChatSocket.id = chatMessage.fromId;
            }
        }
    }

    public void publish(ChatSocket cs, ChatMessage chatMessage) {//表示当前的线程给集合中的每一个线程发送的信息，也即当前的客户端给每一个客户端发送信息
        //要给集合中所有的线程发送信息就必须遍历这个集合
        List<Integer> toIds = new ArrayList<>();
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket csChatSocket = vector.get(i);
            if (!csChatSocket.equals(cs) && csChatSocket.id != null) {//则需要判断不许给当前客户端发送信息，也即不给自己发送信息
                toIds.add(csChatSocket.id);
            }
        }
        chatMessage.toIds = toIds;
        send(chatMessage);
    }

    public void send(ChatMessage chatMessage) {
        ChatMessage chatMessageNew = new ChatMessage();
        chatMessageNew.fromId = chatMessage.fromId;
        chatMessageNew.content = chatMessage.content;
        //要给集合中所有的线程发送信息就必须遍历这个集合
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket csChatSocket = vector.get(i);
            if (chatMessage.toIds.contains(csChatSocket.id)) {//需要判断需要发送的客户端
                csChatSocket.out(JSON.toJSONString(chatMessageNew));//发送信息给其他的客户端
            }
        }
    }
}