import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2000);

        System.out.println("Connecting ...");
        System.out.println("[INFO Sercer] Prepared !");
        System.out.println("[INFO Sercer] " + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());

        while (true) {
            Socket client = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(client);
            clientHandler.start();
        }

    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private boolean flag = true;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("[INFO Sercer] New Client Connected !" + socket.getInetAddress() + ":" + socket.getPort());

            try {
                // 用于服务器发送数据
                PrintStream socketOutput = new PrintStream(socket.getOutputStream());
                // 用于服务器读取数据
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while (flag) {
                    String str = socketInput.readLine();
                    if ("bye".equalsIgnoreCase(str)) {
                        flag = false;
                        socketOutput.println("bye");
                    } else {
                        System.out.println(str);
                        socketOutput.println("[INFO Sercer] Receive " + str.length());
                    }

                }

                socketInput.close();
                socketOutput.close();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("[INFO Sercer] Client is Exist !");
        }
    }
}
