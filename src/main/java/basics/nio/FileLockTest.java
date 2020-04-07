package basics.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author lyy
 */
public class FileLockTest {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            FileChannel channel = new FileOutputStream("a.txt").getChannel();
            //使用非阻塞方式对指定文件加锁
            FileLock lock = channel.tryLock();
            Thread.sleep(10000);
            //释放锁
            lock.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
