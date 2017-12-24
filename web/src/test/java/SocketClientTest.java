import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Jabin on 2017/12/24.
 */
public class SocketClientTest {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            new Thread(){
                @Override
                public void run() {
                    while (true) {
                        try {
                            try {
                                socket.getOutputStream().write(("回话" + "\n").getBytes("UTF-8"));//接收来自服务器端的数据
                                Thread.sleep(2000);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    try {
                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream(), "UTF-8"));//当前服务器会不断读取当前客户端的数据
                        String line = null;
                        while ((line = br.readLine()) != null) {//客户端发送给服务器的数据
                            //然后服务器再将所有的信息转发给每一个客户端，调用publish方法
                            System.out.println(line);
                        }
                        br.close();
                        System.out.println("断开了一个客户端链接");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
