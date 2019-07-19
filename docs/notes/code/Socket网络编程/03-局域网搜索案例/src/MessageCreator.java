public class MessageCreator {
    private static final String SN_HEADER = "收到暗号，我是（SN）";
    private static final String PORT_HEADER = "这是暗号请回复端口（Port）";

    public static String buildWithPort(int port) {
        return PORT_HEADER + port;
    }

    public static int parasePort(String data) {
        if (data.startsWith(PORT_HEADER))
            return Integer.parseInt(data.substring(PORT_HEADER.length()));

        return -1;
    }

    public static String buildWithSn(String sn) {
        return SN_HEADER + sn;
    }

    public static String paraseSn(String data) {
        if (data.startsWith(SN_HEADER))
            return data.substring(SN_HEADER.length());

        return null;
    }
}
