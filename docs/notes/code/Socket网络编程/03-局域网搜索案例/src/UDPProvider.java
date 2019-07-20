import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.UUID;

public class UDPProvider {

    private static class Provider extends Thread {
        private final String sn;
        private boolean done = false;
        private DatagramSocket ds = null;

        public Provider(String sn) {
            super();
            this.sn = sn;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("UDPProvider Started.");

            try {
                // 作为接收者没指定一个端口用于监听数据接收
                ds = new DatagramSocket(20000);

                while (!done) {
                    // 构建接收实体
                    final byte[] buf = new byte[512];
                    DatagramPacket receivePack = new DatagramPacket(buf, buf.length);

                    // 接收消息
                    ds.receive(receivePack);

                    // 解析packet获得发送端的信息
                    String ip = receivePack.getAddress().getHostAddress();
                    int port = receivePack.getPort();
                    int dataLen = receivePack.getLength();
                    String data = new String(receivePack.getData(), 0, dataLen);


                    // 解析端口号
                    int responsePort = MessageCreator.parasePort(data);
                    if (responsePort != -1) {

                        System.out.println("UDPProvider receive from ip:" + ip + "\tport:" + port);
                        System.out.println("[Data] " + data);

                        // 回送消息
                        String responseData = MessageCreator.buildWithSn(sn);
                        DatagramPacket responcePacket = new DatagramPacket(
                                responseData.getBytes(),
                                responseData.getBytes().length,
                                receivePack.getAddress(),
                                responsePort
                        );

                        ds.send(responcePacket);
                    }
                }
            } catch (Exception ignore) {
            } finally {
                System.out.println("UDPProvider Closed.");
                close();
            }

        }

        private void close() {
            if (ds != null) {
                ds.close();
                ds = null;
            }
        }

        void exit() {
            done = true;
            close();
        }
    }

    public static void main(String[] args) throws IOException {
        String sn = UUID.randomUUID().toString();
        Provider provider = new Provider(sn);
        provider.start();

        System.in.read();
        provider.exit();
    }
}
