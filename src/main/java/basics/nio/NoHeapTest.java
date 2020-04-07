package basics.nio;

import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;

/**
 * 参数
 * -XX:MaxDirectMemorySize=10M
 * @author lyy
 */
public class NoHeapTest {
    public static void clean(final ByteBuffer byteBuffer){
        if(byteBuffer.isDirect()){
            ((DirectBuffer)byteBuffer).cleaner().clean();
        }
    }
    public static void sleep(long i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocateDirect(1024);
        System.out.println("start");
        sleep(5000);
        //执行垃圾回收
        clean(buffer);
        //执行Full GC垃圾回收
        System.gc();
        System.out.println("end");
        sleep(5000);
    }
}
