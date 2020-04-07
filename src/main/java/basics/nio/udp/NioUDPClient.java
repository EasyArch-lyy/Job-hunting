package basics.nio.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author lyy
 */
public class NioUDPClient extends Thread {

    private byte[] sendData;
    private InetAddress serverAddr;
    private int port;
    private int dataLen;

    public NioUDPClient(InetAddress ip, int port, byte[] str, int len) {
        this.serverAddr = ip;
        this.sendData = str;
        this.dataLen = len;
        this.port = port;
    }

    public static void main(String[] args) {

        //测试字符串
        byte[] bys = new byte[77];
        for (int i = 48, j = 0; i < 123; i++, j++) {
            bys[j] = (byte) i;
        }
        bys[76] = (byte) 10;
        for (int i = 0; i < bys.length; i++) {
            System.out.println(i + "--->" + bys[i]);
        }
        while (true) {
            try {
                new Thread(new NioUDPClient(InetAddress.getLocalHost(), 8888, bys, 77)).start();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            Thread.currentThread();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Client: Start connecting\n");
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket packet = new DatagramPacket(sendData, dataLen, serverAddr, port);
            System.out.println("Client: Sending " + dataLen + "bytes'" + new String(sendData) + "'\n");
            socket.send(packet);
            System.out.println("Client: Message sent\n");
            System.out.println("Client: Succeed!\n");
        } catch (Exception e) {
            System.out.println("Client: Error!\n");
        }
    }
}
