import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPProvider {
    public static void main(String[] args) throws IOException {
        System.out.println("UDPProvider Started.");

        // 作为接收者没指定一个端口用于监听数据接收
        DatagramSocket ds = new DatagramSocket(20000);

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

        System.out.println("UDPProvider receive from ip:" + ip + "\tport:" + port);
        System.out.println("[Data] " + data);

        // 回送消息
        String responseData = "Received data with len:" + dataLen;
        DatagramPacket responcePacket = new DatagramPacket(
                responseData.getBytes(),
                responseData.getBytes().length,
                receivePack.getAddress(),
                receivePack.getPort()
        );

        ds.send(responcePacket);

        System.out.println("UDPProvider Closed.");
        ds.close();
    }
}
