import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class UDPSearcher {

    private static final int LISTEN_PORT = 30000;

    public static void main(String[] args) throws IOException, InterruptedException {
        Listrner listrner = listen();
        sendBroadcast();


        System.in.read();

        List<Device> devices = listrner.getDevicesAndClose();

        for (Device device : devices) {
            System.out.println(device);
        }
    }

    private static Listrner listen() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Listrner listrner = new Listrner(LISTEN_PORT, countDownLatch);
        listrner.start();

        countDownLatch.await();
        return listrner;
    }

    private static void sendBroadcast() throws IOException {
        System.out.println("向局域网内的20000端口发送广播");

        // 作为搜索者，无需指定端口
        DatagramSocket ds = new DatagramSocket();

        // 发送消息
        String requestData = MessageCreator.buildWithPort(LISTEN_PORT);
        DatagramPacket requestPacket = new DatagramPacket(
                requestData.getBytes(),
                requestData.getBytes().length
        );

        requestPacket.setAddress(InetAddress.getByName("255.255.255.255"));
        requestPacket.setPort(20000);

        ds.send(requestPacket);

        ds.close();
        System.out.println("发送广播完成！");
    }

    private static class Device {
        final int port;
        final String ip;
        final String sn;

        public Device(int port, String ip, String sn) {
            this.port = port;
            this.ip = ip;
            this.sn = sn;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "port=" + port +
                    ", ip='" + ip + '\'' +
                    ", sn='" + sn + '\'' +
                    '}';
        }
    }

    private static class Listrner extends Thread {
        private final int listenPort;
        private final CountDownLatch countDownLatch;
        private final List<Device> devices = new ArrayList<>();
        private boolean done = false;
        private DatagramSocket ds = null;

        private Listrner(int listenPort, CountDownLatch countDownLatch) {
            this.listenPort = listenPort;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            super.run();

            countDownLatch.countDown();

            try {
                ds = new DatagramSocket(listenPort);
                while (!done) {
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

                    String sn = MessageCreator.paraseSn(data);
                    if (sn != null) {
                        Device device = new Device(port, ip, sn);
                        devices.add(device);
                    }
                }

            } catch (Exception e) {

            } finally {
                close();
            }
        }

        private void close() {
            if (ds != null) {
                ds.close();
                ds = null;
            }
        }

        List<Device> getDevicesAndClose() {
            done = true;
            close();
            return devices;
        }
    }
}
