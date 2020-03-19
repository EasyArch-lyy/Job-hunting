package lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列是一种特殊的先进先出队列,它有以下几个特点
 * 1.入队和出队线程安全
 * 2.当队列满时,入队线程会被阻塞;当队列为空时,出队线程会被阻塞。
 *
 * @author lyy
 */
public class MyBlockingQueue<E> {

    /**阻塞队列最大容量*/
    int size;
    ReentrantLock lock = new ReentrantLock();
    /**队列底层实现*/
    LinkedList<E> list = new LinkedList<>();
    /**队列满时的等待条件*/
    Condition notFull = lock.newCondition();
    /**队列空时的等待条件*/
    Condition notEmpty = lock.newCondition();

    public MyBlockingQueue(int size) {
        this.size = size;
    }

    public void enqueue(E e) throws InterruptedException {
        lock.lock();
        try {
            //队列已满,在notFull条件上等待
            while (list.size() ==size) {
                notFull.await();
            }
            //入队:加入链表末尾
            list.add(e);
            System.out.println("入队：" +e);
            notEmpty.signal(); //通知在notEmpty条件上等待的线程
        } finally {
            lock.unlock();
        }
    }

    public E dequeue() throws InterruptedException {
        E e;
        lock.lock();
        try {
            //队列为空,在notEmpty条件上等待
            while (list.size() == 0)
            {
                notEmpty.await();
            }
            //出队:移除链表首元素
            e = list.removeFirst();
            System.out.println("出队："+e);
            //通知在notFull条件上等待的线程
            notFull.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(2);
        for (int i = 0; i < 10; i++) {
            final int data = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        queue.enqueue(data);
                    } catch (InterruptedException e) {

                    }
                }
            }).start();

        }
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Integer data = queue.dequeue();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}