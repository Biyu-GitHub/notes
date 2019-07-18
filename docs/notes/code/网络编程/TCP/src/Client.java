import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * TCP客户端的实现
 * 1. 创建Socket对象，绑定服务器的ip地址和端口号
 * 2. 获取字节输出流对象
 * 3. 发送数据
 * 4. 获取字节输入流
 * 5. 读取数据
 * 6. 释放资源
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024 * 1024];

        while (true) {
            String msg = sc.nextLine();
            outputStream.write(msg.getBytes());
            System.out.println("发送:" + msg);

            int len = inputStream.read(b);
            msg = new String(b, 0, len);
            System.out.println("接收:" + msg);

            if (msg.equals("CLOSE"))
                break;
        }
        socket.close();
    }
}