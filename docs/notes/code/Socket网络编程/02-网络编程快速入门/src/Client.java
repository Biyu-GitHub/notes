import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();

        socket.setSoTimeout(3000);

        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000), 3000);

        System.out.println("Connecting ...");
        System.out.println("[INFO Client] " + socket.getLocalAddress() + ":" + socket.getLocalPort());
        System.out.println("[INFO Sercer] " + socket.getLocalAddress() + ":" + socket.getLocalPort());

        try {
            todo(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }

        socket.close();
        System.out.println("[INFO Client] Closed !");
    }

    private static void todo(Socket client) throws IOException {
        // 构建一个键盘输入流
        InputStream in = System.in;
        BufferedReader input = new BufferedReader(new InputStreamReader(in));

        // 网络输出流 --> 打印流
        OutputStream outputStream = client.getOutputStream();
        PrintStream socketPrintStream = new PrintStream(outputStream);

        // 网络输入流 --> BufferedReader
        InputStream inputStream = client.getInputStream();
        BufferedReader socketBufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        boolean flag = true;

        while (flag) {
            // 获取输入
            String str = input.readLine();

            // 发送到服务器
            socketPrintStream.println(str);

            // 读取服务器回写数据
            String echo = socketBufferedReader.readLine();

            if ("bye".equalsIgnoreCase(echo))
                flag = false;
            else
                System.out.println(echo);
        }

        socketPrintStream.close();
        socketBufferedReader.close();
    }
}
