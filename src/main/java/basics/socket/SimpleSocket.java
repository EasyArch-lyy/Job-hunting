package basics.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lyy
 */
public class SimpleSocket {
    public static void main(String[] args) throws IOException {
        int port=55533;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("等待连接到来");
        while (true){
            Socket socket=serverSocket.accept();
            InputStream inputStream=socket.getInputStream();
            byte[]bytes=new byte[1024];
            int len;
            StringBuilder stringBuilder=new StringBuilder();
            while ((len=inputStream.read(bytes))!=-1){
                stringBuilder.append(new String(bytes,0,len,"UTF-8"));
            }
            inputStream.close();
            serverSocket.close();
            socket.close();
        }
    }
}
