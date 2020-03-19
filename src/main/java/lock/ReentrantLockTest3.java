package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock响应中断实例
 *
 * 当使用synchronized实现锁时,阻塞在锁上的线程除非获得锁否则将一直等待下去，
 * 而ReentrantLock给我们提供了一个可以响应中断的获取锁的方法lockInterruptibly()。
 * 通过使其中一个线程中断，来结束线程间毫无意义的等待。
 * 被中断的线程将抛出异常，而另一个线程将能获取锁后正常结束
 * 解决死锁问题。
 *
 * @author lyy
 */
public class ReentrantLockTest3 {
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {

        //该线程先获取锁1,再获取锁2
        Thread thread = new Thread(new ThreadDemo(lock1, lock2));
        //该线程先获取锁2,再获取锁1
        Thread thread1 = new Thread(new ThreadDemo(lock2, lock1));
        thread.start();
        thread1.start();
        //是第一个线程中断
        thread.interrupt();
    }

    static class ThreadDemo implements Runnable {
        Lock firstLock;
        Lock secondLock;
        public ThreadDemo(Lock firstLock, Lock secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }
        @Override
        public void run() {
            try {
                firstLock.lockInterruptibly();
                //更好的触发死锁
                TimeUnit.MILLISECONDS.sleep(10);
                secondLock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
                System.out.println(Thread.currentThread().getName()+"正常结束!");
            }
        }
    }
}