package basics.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author lyy
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("a.txt");
        FileChannel fcin=fis.getChannel();
        ByteBuffer bbuff= ByteBuffer.allocate(256);
        while (fcin.read(bbuff)!=-1){
            bbuff.flip();
            Charset charset=Charset.forName("utf-8");
            CharsetDecoder decoder=charset.newDecoder();
            CharBuffer cbuff=decoder.decode(bbuff);
            System.out.println(cbuff);
            bbuff.clear();
        }
    }
}
