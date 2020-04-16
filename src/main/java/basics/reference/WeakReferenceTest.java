package basics.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;

/**
 * @author lyy
 */
public class WeakReferenceTest {

    /**
     * 弱引用队列
     */
    private final static ReferenceQueue<GCTarget> REFERENCE_QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        //创建弱引用的对象，依次加入链表中
        LinkedList<GCTargetWeakReference> gcTargetList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            GCTarget gcTarget = new GCTarget(String.valueOf(i));
            GCTargetWeakReference weakReference = new GCTargetWeakReference(gcTarget, REFERENCE_QUEUE);
            gcTargetList.add(weakReference);
            System.out.println("Just created GCTargetWeakReference obj: " + gcTargetList.getLast());
        }
        //通知GC进行垃圾回收
        System.gc();
        try {
            // 休息几分钟，等待上面的垃圾回收线程运行完成
             Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //检查关联的引用队列是否为空
        Reference<? extends GCTarget> reference;
        while ((reference = REFERENCE_QUEUE.poll()) != null) {

            if (reference instanceof GCTargetWeakReference) {
                System.out.println("In queue, id is: " + ((GCTargetWeakReference) (reference)).id);
            }
        }
    }
}
