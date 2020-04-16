package basics.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lyy
 */
public class Server {

    public static void main(String[] args) throws IOException {
        int port=55533;
        ServerSocket server=new ServerSocket(port);
        System.out.println("server将一直等待连接到来");
        Socket socket=server.accept();
        //建立连接后，从socket获取输入流
        InputStream inputStream=socket.getInputStream();
        byte[]bytes=new byte[1024];
        int len;
        StringBuilder sb=new StringBuilder();
        while ((len=inputStream.read(bytes))!=-1){
            sb.append(new String(bytes,0,len,"UTF-8"));

        }
        System.out.println("get message from client "+sb);
        inputStream.close();
        socket.close();
        server.close();
    }
}
