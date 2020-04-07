package source.lock.sync;

/**
 * 修饰静态方法
 * @author lyy
 */
public class Thread2 {
    /**共享资源(临界资源)*/
    static int i = 0;

    /**如果没有synchronized关键字，输出小于20000*/
    public static synchronized void increase() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            }
        });
        t1.start();
        t2.start();
        //主线程等待t1执行完毕
        t1.join();
        //主线程等待t2执行完毕
        t2.join();
        System.out.println(i);
    }
    /**
     * 输出结果:
     * 20000
     */
}