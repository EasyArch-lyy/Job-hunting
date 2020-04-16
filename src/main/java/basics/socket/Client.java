package basics.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lyy
 */
public class Client {

    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 55533;
        //与服务端建立连接
        Socket socket = new Socket(host, port);
        //建立连接获取输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "hello";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //编码格式一致
            sb.append(new String(bytes, 0, len, "UTF-8"));
            System.out.println("get message from server: " + sb);
            inputStream.close();
            outputStream.close();
            socket.close();
        }
    }
}
