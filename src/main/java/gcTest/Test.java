package gcTest;

import java.util.Vector;

/**
 * @author lyy
 */
public class Test {
    private static Vector<Integer> vector=new Vector();

    public static void main(String[] args) {
        while(true){
            for(int i=0;i<10;i++){
                vector.add(i); //往vector中添加元素
            }
            Thread removeThread=new Thread(new Runnable() {
                @Override
                public void run() {
                    //获取vector的大小
                    for(int i=0;i<vector.size();i++){
                        //当前线程让出CPU,使例子中的错误更快出现
                        Thread.yield();
                        //移除第i个数据
                        vector.remove(i);
                    }
                }
            });
            Thread printThread=new Thread(new Runnable() {
                @Override
                public void run() {
                    //获取vector的大小
                    for(int i=0;i<vector.size();i++){
                        //当前线程让出CPU,使例子中的错误更快出现
                        Thread.yield();
                        //获取第i个数据并打印
                        System.out.println(vector.get(i));
                    }
                }
            });
            removeThread.start();
            printThread.start();
            //避免同时产生过多线程
            while(Thread.activeCount()>20) {
            }
        }
    }

}
