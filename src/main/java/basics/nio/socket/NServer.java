package basics.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

/**
 * @author lyy
 */
public class NServer {

    /**
     * 用于检测所有Channel状态的Selector
     */
    private Selector selector=null;

    static final int PORT=30000;
    /**
     * 定义实现编码、解码的字符集对象
     */
    private Charset charset=Charset.forName("UTF-8");

    public void init() throws IOException {

        selector = Selector.open();
        //通过open方法来打开一个未绑定的ServerSocketChannel实例
        ServerSocketChannel server = ServerSocketChannel.open();
        InetSocketAddress isa = new InetSocketAddress("0.0.0.0", PORT);
        //绑定指定IP
        server.socket().bind(isa);
        //设置ServerSocket非阻塞方式工作
        server.configureBlocking(false);
        //将server注册到指定的Selector对象
        server.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            //依次处理selector上的每个已选择的SelectionKey
            for (SelectionKey sk : selector.selectedKeys()) {
                //从selector上的已选择Key集中删除正在处理的SelectionKey
                selector.selectedKeys().remove(sk);
                //如果sk对应的Channel包含客户端的连接请求
                if (sk.isAcceptable()) {
                    // 调用accept方法接受连接，产生服务器端的SocketChannel
                    //ServerSocketChannel ss= (ServerSocketChannel) sk.channel();
                    //SocketChannel sc =ss.accept();
                    SocketChannel sc = server.accept();
                    //采用非阻塞模式
                    sc.configureBlocking(false);
                    //将SocketChannel注册到selector
                    sc.register(selector, SelectionKey.OP_READ);
                    //将sk对应的Channel设置成准备接受其他请求
                    sk.interestOps(SelectionKey.OP_ACCEPT);
                }
                //如果sk对应的Channel有数据需求读取
                if (sk.isReadable()) {
                    //获取该SelectionKey对应的Channel,该Channel中有可读的数据
                    SocketChannel sc = (SocketChannel) sk.channel();
                    ByteBuffer buff = ByteBuffer.allocate(1024);
                    String content = "";
                    try {
                        //有可读数据
                        while (sc.read(buff) > 0) {
                            buff.flip();
                            content += charset.decode(buff);
                        }
                        // 打印从该sk对应的Channel里读取到的数据
                        System.out.println("读取的数据：" + content);
                        // 将sk对应的Channel设置成准备下一次读取
                        sk.interestOps(SelectionKey.OP_READ);
                        //捕获sk对应的Channel出现异常,表明该Channel对应的Client出现了问题，从Selector取消对sk的注册
                    } catch (IOException e) {
                        //从Selector中删除指定的SelectionKey
                        sk.cancel();
                        if (sk.channel() != null) {
                            sk.channel().close();
                        }
                    }
                    //如果content长度>0，聊天消息不为空
                    if (content.length() > 0) {
                        //遍历给selector里注册的SelectionKey
                        for (SelectionKey key : selector.keys()) {
                            //获取该key对应的Channel
                            Channel targetChannel = key.channel();
                            //如果该channel是SocketChannel对象
                            if (targetChannel instanceof SocketChannel) {
                                //将读到的内容写入该Channel
                                SocketChannel dest = (SocketChannel) targetChannel;
                                dest.write(charset.encode(content));
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new NServer().init();
    }
}
