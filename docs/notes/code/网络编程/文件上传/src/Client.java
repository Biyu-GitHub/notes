import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\BiYu\\Downloads\\xiuxiu_setup.exe");
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        int len = 0;
        byte[] b = new byte[1024];

        while ((len = fileInputStream.read(b)) != -1) {
            outputStream.write(b, 0, len);
        }
        socket.shutdownOutput();

        len = inputStream.read(b);
        System.out.println(new String(b, 0, len));

        fileInputStream.close();
        socket.close();

        System.out.println("Client closed!");
    }
}
