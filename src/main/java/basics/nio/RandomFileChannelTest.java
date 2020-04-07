package basics.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author lyy
 */
public class RandomFileChannelTest {
    public static void main(String[] args) throws IOException {
        File file=new File("a.txt");
        RandomAccessFile raf=new RandomAccessFile(file,"rw");
        FileChannel randomChannel=raf.getChannel();
        ByteBuffer buffer =randomChannel.map(FileChannel.MapMode.READ_WRITE,0,file.length());
        randomChannel.position(file.length());
        randomChannel.write(buffer);
    }
}
