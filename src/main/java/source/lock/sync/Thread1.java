package source.lock.sync;

/**
 * 修饰实例方法
 * @author lyy
 */
public class Thread1 implements Runnable{
    /**共享资源(临界资源)*/
    static int i=0;
 
    /**如果没有synchronized关键字，输出小于20000*/
    public synchronized void increase(){
        i++;
    }
    @Override
    public void run() {
        for(int j=0;j<10000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 t=new Thread1();
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        t1.start();
        t2.start();
        t1.join();//主线程等待t1执行完毕
        t2.join();//主线程等待t2执行完毕
        System.out.println(i);
    }
    /**
     * 输出结果:
     * 20000
     */
}