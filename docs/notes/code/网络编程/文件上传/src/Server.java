import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Random;

public class Server {
    public static void main(String[] args) throws IOException {

        Random r = new Random();
        File path = new File("C:\\Users\\BiYu\\Downloads\\upload\\");
        if (!path.exists())
            path.mkdirs();


        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            Socket socket = serverSocket.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        OutputStream outputStream = socket.getOutputStream();

                        String newName = "up" + System.currentTimeMillis() + r.nextInt(9999) + ".exe";
                        FileOutputStream fileOutputStream = new FileOutputStream(path + "\\" + newName);

                        int len = 0;
                        byte[] b = new byte[1024];

                        while ((len = inputStream.read(b)) != -1) {
                            fileOutputStream.write(b, 0, len);
                        }

                        outputStream.write("Finished".getBytes());

                        fileOutputStream.close();
                        socket.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
