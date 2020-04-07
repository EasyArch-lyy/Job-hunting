package basics.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * FileChannel
 * @author lyy
 */
public class FileChannelTest {

    public static void main(String[] args) {
        File file = new File("/opt/test");
        try {
            //创建FileInputStream，以该文件输入流创建FileChannel
            FileChannel inChannel = new FileInputStream(file).getChannel();
            FileChannel outChannel=new FileOutputStream("c.txt").getChannel();
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            Charset charset=Charset.forName("utf-8");
            //直接将buffer数据输出
//            outChannel.write(buffer);
            CharsetDecoder decoder=charset.newDecoder();
            CharsetEncoder encoder=charset.newEncoder();
            CharBuffer charBuffer=decoder.decode(buffer);
            ByteBuffer bf=encoder.encode(charBuffer);
            System.out.println("charBuffer:"+charBuffer.toString());
            System.out.println(bf);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }
}
