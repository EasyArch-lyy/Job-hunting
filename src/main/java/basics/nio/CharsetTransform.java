package basics.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author lyy
 */
public class CharsetTransform {
    public static void main(String[] args)throws Exception {
        //创建Charset
        Charset cn =Charset.forName("utf-8");
        CharsetEncoder cnEncoder=cn.newEncoder();
        CharsetDecoder cnDecoder=cn.newDecoder();
        //创建CharBuffer对象
        CharBuffer charBuffer=CharBuffer.allocate(8);
        charBuffer.put("孙");
        charBuffer.put("悟");
        charBuffer.put("空");
        charBuffer.flip();
        //CharBuffer中的字符序列转换成字节序列
        ByteBuffer buffer=cnEncoder.encode(charBuffer);
        //循环访问ByteBuffer中每个字节
        for(int i=0;i<buffer.limit();i++){
            System.out.println(buffer.get(i)+"（字节）");
        }
        //将ByteBuffer的数据解码成字符序列
        System.out.println("\n"+cnDecoder.decode(buffer));
    }
}
