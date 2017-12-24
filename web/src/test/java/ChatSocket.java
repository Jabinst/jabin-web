import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {
    //创建一个Socket对象来接收SocketListener传来的Socket对象
    Socket socket;
    Integer id;

    public ChatSocket(Socket s) {
        this.socket = s;
    }

    public void out(String out) {
        try {
            socket.getOutputStream().write((out + "\n").getBytes("UTF-8"));//接收来自服务器端的数据
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("断开了一个客户端链接");
            ChatManager.getchaChatManager().remove(this);
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("开启了一个客户端链接");
        out("您已经连接到服务器");
        try {

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream(), "UTF-8"));//当前服务器会不断读取当前客户端的数据
            String line = null;
            while ((line = br.readLine()) != null) {//客户端发送给服务器的数据
                //然后服务器再将所有的信息转发给每一个客户端，调用publish方法
                System.out.println("收到客户端[" + socket + "]消息:\n" + line);
                ChatMessage chatMessage = JSON.parseObject(line, ChatMessage.class);
                ChatMsgType chatMsgType = ChatMsgType.valueOfId(chatMessage.msgType);
                if (chatMsgType == null) {
                    System.err.println("未知的消息类型["+ chatMessage.msgType +"]");
                    return;
                }
                switch (chatMsgType) {
                    case REGISTE:
                        ChatManager.getchaChatManager().registe(this, chatMessage);
                        break;
                    case SEND_MSG:
                        ChatManager.getchaChatManager().send(chatMessage);
                        break;
                    case PUBLISH_MSG:
                        ChatManager.getchaChatManager().publish(this, chatMessage);
                        break;
                    default:
                        break;
                }
            }
            br.close();
            System.out.println("断开了一个客户端链接");
            ChatManager.getchaChatManager().remove(this);
        } catch (IOException e) {
            System.out.println("断开了一个客户端链接");
            ChatManager.getchaChatManager().remove(this);
            e.printStackTrace();
        }

    }
}