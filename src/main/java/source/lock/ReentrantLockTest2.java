package source.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock公平锁实现(每个线程都依次获取到了锁)
 * @author lyy
 */
public class ReentrantLockTest2 {

    static Lock lock = new ReentrantLock(true);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
//            Thread.sleep(2000);
            System.out.println(i+"加入队列");
            new Thread(new ThreadDemo(i)).start();
        }
    }

    static class ThreadDemo implements Runnable {
        Integer id;
        public ThreadDemo(Integer id) {
            this.id = id;
        }
        @Override

      public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<2;i++){
                lock.lock();
                System.out.println("获得锁的线程："+id);
                lock.unlock();
            }
        }
    }
}