package basics.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lyy
 */
public class TwoWayClient {

    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 55533;
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好，Runnable";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            stringBuilder.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println("get message from server: " + stringBuilder);
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
