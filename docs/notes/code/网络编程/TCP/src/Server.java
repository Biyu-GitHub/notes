import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        byte[] b = new byte[1024 * 1024];

        while (true) {
            int len = inputStream.read(b);
            String msg = new String(b, 0, len);
            msg = msg.toUpperCase();

//            outputStream.write(msg.getBytes());

            if (msg.equals("CLOSE"))
                break;
        }
        socket.close();
        serverSocket.close();
    }
}
