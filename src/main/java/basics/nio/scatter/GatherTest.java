package basics.nio.scatter;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author lyy
 */
public class GatherTest {
    private static Charset charset = Charset.forName("UTF-8");
    private static void gather(String fileName) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw");
        //获取文件通道
        FileChannel channel = accessFile.getChannel();
        //创建两个缓冲区
        ByteBuffer headBuffer = ByteBuffer.allocate(3);
        headBuffer.put("abc".getBytes());

        ByteBuffer bodyBuffer = ByteBuffer.allocate(1024);
        bodyBuffer.put("defg".getBytes());

        ByteBuffer[] allBuffers = new ByteBuffer[]{headBuffer, bodyBuffer};

        headBuffer.flip();
        bodyBuffer.flip();

        //将按allBuffers顺序  写入abcdefg
        long n = channel.write(allBuffers);

        System.out.println("共写入多少字节:" + n);

        accessFile.close();
        channel.close();
    }
    private static void gather2(String fileName) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw");
        //获取文件通道
        FileChannel channel = accessFile.getChannel();
        //创建两个缓冲区
        ByteBuffer headBuffer = ByteBuffer.allocate(3);
        ByteBuffer bodyBuffer1 = ByteBuffer.allocate(4);
        ByteBuffer bodyBuffer2 = ByteBuffer.allocate(20);
        ByteBuffer bodyBuffer3 = ByteBuffer.allocate(20);
        ByteBuffer bodyBuffer4 = ByteBuffer.allocate(20);

        headBuffer.put("abc".getBytes());
        bodyBuffer1.put("defg".getBytes());
        bodyBuffer2.put("bnbnbnb".getBytes());
        bodyBuffer3.put("zzz444".getBytes());

        ByteBuffer[] allBuffers = new ByteBuffer[]{
                headBuffer,
                bodyBuffer1, bodyBuffer2,
                bodyBuffer3, bodyBuffer4,};

        headBuffer.flip();
        bodyBuffer1.flip();
        bodyBuffer2.flip();
        bodyBuffer3.flip();
        bodyBuffer4.flip();

        //将按allBuffers数组顺序使用两个缓冲区
        //0从哪开始
        //2使用几个
        //当前使用headBuffer  bodyBuffer1
        //最终写入abcdefg
        long n = channel.write(allBuffers, 0, 2);

        //应该返回7个字节
        System.out.println("共写入多少字节:" + n);

        accessFile.close();
        channel.close();
    }
    public static void main(String[] args) throws IOException {
        final String fileName = "/home/lyy/test.log";
        /**----------Gather------------*/
        //FileChannel#write(java.nio.ByteBuffer[])
        gather(fileName);

        //FileChannel#write(java.nio.ByteBuffer[], int, int)
        gather2(fileName);
    }
}
