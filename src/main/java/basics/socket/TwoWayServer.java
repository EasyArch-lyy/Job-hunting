package basics.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lyy
 */
public class TwoWayServer {

    public static void main(String[] args) throws IOException {
        int port = 55533;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder builder = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            builder.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println("get message from client: " + builder);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello Client,I get the message.".getBytes());
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
