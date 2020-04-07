package basics.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * nio通道模拟
 *
 * @author lyy
 */
public class PipeTest {
    public static void main(String[] args) throws IOException {
        //初始化Pipe实例
        Pipe pipe = Pipe.open();
        //获取写通道
        Pipe.SinkChannel sinkChannel = pipe.sink();
        String testData = "Test Data to Check java NIO Channels Pipe.";
        ByteBuffer buffer = ByteBuffer.allocate(512);
        buffer.put(testData.getBytes());
        buffer.flip();
        //向通道写入数据
        while (buffer.hasRemaining()) {
            sinkChannel.write(buffer);
        }
        //读取数据通道
        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer buffer1 = ByteBuffer.allocate(512);

        buffer1.clear();
        //数据写入控制台
        while (sourceChannel.read(buffer1) > 0) {
            buffer1.flip();
            while (buffer1.hasRemaining()) {
                char ch = (char) buffer1.get();
                System.out.println(ch);
            }
            buffer1.clear();
        }
    }
}
