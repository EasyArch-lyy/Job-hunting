package basics.nio.udp;

import java.io.*;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lyy
 */
public class NioUDPServer {

    public static void main(String[] args) {
        try {
            Selector selector=Selector.open();
            DatagramChannel channel=DatagramChannel.open();
            channel.configureBlocking(false);
            DatagramSocket socket=channel.socket();
            socket.bind(new InetSocketAddress(8888));
            channel.register(selector, SelectionKey.OP_READ);
            ByteBuffer receiveBuffer=ByteBuffer.allocate(1024);
            final int PACKAGE_SIZE=10;
            while (true){
                int n=selector.select();
                if(n==0){
                    continue;
                }
                Set<SelectionKey>readyKeys=selector.selectedKeys();
                Iterator<SelectionKey> iterator = readyKeys.iterator();
                for (SelectionKey key : readyKeys) {
                    readyKeys.remove(key);
                    if (key.isReadable()) {
                        DatagramChannel dc = (DatagramChannel) key.channel();
                        //接收来自任意一个Client的数据报
                        InetSocketAddress client = (InetSocketAddress) dc.receive(receiveBuffer);
                        key.interestOps(SelectionKey.OP_READ);

                        System.out.println("client ----> IP: " + client.getAddress().getHostAddress() + ", port: " + client.getPort());
                        System.out.println("receiveBuffer.position() = " + receiveBuffer.position());
                        if (receiveBuffer.position() >= PACKAGE_SIZE) {
                            receiveBuffer.flip();
                            DataInputStream dis = new DataInputStream(new ByteArrayInputStream(receiveBuffer.array()));
                            BufferedReader d = new BufferedReader(new InputStreamReader(dis));
                            System.out.println(d.readLine());

                            receiveBuffer.clear();
                        } else {
                            dc.register(selector, SelectionKey.OP_READ);
                        }
                    }//if
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
