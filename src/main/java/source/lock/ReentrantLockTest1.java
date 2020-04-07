package source.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *  ReentrantLock重入实例
 *
 * source.lock()方法先获取锁三次，然后通过unlock()方法释放锁3次，程序可以正常退出。
 * 从上面的例子可以看出,ReentrantLock是可以重入的锁,当一个线程获取锁时,还可以接着重复获取多次。
 * 在加上ReentrantLock的的独占性，我们可以得出以下ReentrantLock和synchronized的相同点。
 *     1.ReentrantLock和synchronized都是独占锁,只允许线程互斥的访问临界区。
 *  但是实现上两者不同:synchronized加锁解锁的过程是隐式的,用户不用手动操作,优点是操作简单，
 *  但显得不够灵活。一般并发场景使用synchronized的就够了；
 *  ReentrantLock需要手动加锁和解锁,且解锁的操作尽量要放在finally代码块中,保证线程正确释放锁。
 *  ReentrantLock操作较为复杂，但是因为可以手动控制加锁和解锁过程,在复杂的并发场景中能派上用场。
 *     2.ReentrantLock和synchronized都是可重入的。
 *  synchronized因为可重入因此可以放在被递归执行的方法上,且不用担心线程最后能否正确释放锁；
 *  而ReentrantLock在重入时要却确保重复获取锁的次数必须和重复释放锁的次数一样，
 *  否则可能导致其他线程无法获得该锁。
 *
 * @author lyy
 */
public class ReentrantLockTest1 {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
            lock.lock();
        }
        for(int i=1;i<=3;i++){
            try {

            } finally {
                lock.unlock();
            }
        }
    }
}