package basics.socket;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lyy
 */
public class ThreadServer {

    public static void main(String[] args) throws IOException {
        int port = 55533;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("server等待连接");
        //使用线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        while (true) {
            Socket socket = serverSocket.accept();
            Runnable runnable = () -> {
                try {
                    // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    StringBuilder stringBuilder = new StringBuilder();
                    // 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                    while ((len = inputStream.read(bytes)) != -1) {
                        stringBuilder.append(new java.lang.String(bytes, 0, len, StandardCharsets.UTF_8));
                    }
                    System.out.println("get message from client: " + stringBuilder);
                    inputStream.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            threadPool.submit(runnable);
        }
    }
}
