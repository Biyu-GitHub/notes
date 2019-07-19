import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSearcher {
    public static void main(String[] args) throws IOException {
        System.out.println("UDPSearcher Started.");

        // 作为搜索者，无需指定端口
        DatagramSocket ds = new DatagramSocket();

        // 发送消息
        String requestData = "Hello";
        DatagramPacket requestPacket = new DatagramPacket(
                requestData.getBytes(),
                requestData.getBytes().length
        );

        requestPacket.setAddress(InetAddress.getLocalHost());
        requestPacket.setPort(20000);

        ds.send(requestPacket);


        // 构建接收实体
        final byte[] buf = new byte[512];
        DatagramPacket receivePack = new DatagramPacket(buf, buf.length);

        // 接收消息
        ds.receive(receivePack);

        // 发送端ip地址
        String ip = receivePack.getAddress().getHostAddress();
        int port = receivePack.getPort();
        int dataLen = receivePack.getLength();
        String data = new String(receivePack.getData(), 0, dataLen);

        System.out.println("UDPSearcher receive from ip:" + ip + "\tport:" + port);
        System.out.println("[Data] " + data);

        System.out.println("UDPSearcher Closed.");
        ds.close();
    }
}
