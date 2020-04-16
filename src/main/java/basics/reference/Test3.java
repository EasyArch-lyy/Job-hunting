package basics.reference;

import java.lang.ref.WeakReference;

/**
 *    弱引用
 *弱引用与软引用的区别在于:只具有弱引用的对象拥有更短暂的生命周期.在垃圾回收器线程扫描它所管辖的内存区域的过程中，一旦发现了只具有弱引用的对象，不管当前内存空间足够与否,都会回收它的内存.垃圾回收器是一个优先级很低的线程,因此不一定会很快发现那些只具有弱引用的对象。
 *注意：如果一个对象是偶尔(很少)的使用，并且希望在使用时随时就能获取到，但又不想影响此对象的垃圾收集，那么你应该用Weak Reference来记住此对象。
 *  @author lyy
 */
public class Test3 {

    public void test1(){
        String str = new String("abc");
        WeakReference<String> weakReference = new WeakReference<>(str);
        str = null;
    }

    public void test2() {
        String str = new String("abc");
        WeakReference<String> weakReference = new WeakReference<>(str);
        // 弱引用转强引用
        String strongReference = weakReference.get();
    }
}

//弱引用与软引用的区别在于：只具有弱引用的对象拥有更短暂的生命周期。在垃圾回收器线程扫描它所管辖的内存区域的过程中，一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。不过，由于垃圾回收器是一个优先级很低的线程，因此不一定会很快发现那些只具有弱引用的对象。
//
//    String str = new String("abc");
//    WeakReference<String> weakReference = new WeakReference<>(str);
//    str = null;
//
//    1
//    2
//    3
//
//JVM首先将软引用中的对象引用置为null，然后通知垃圾回收器进行回收：
//
//    str = null;
//    System.gc();
//
//    1
//    2
//
//    注意：如果一个对象是偶尔(很少)的使用，并且希望在使用时随时就能获取到，但又不想影响此对象的垃圾收集，那么你应该用Weak Reference来记住此对象。
//
//下面的代码会让一个弱引用再次变为一个强引用：
//
//    String str = new String("abc");
//    WeakReference<String> weakReference = new WeakReference<>(str);
//    // 弱引用转强引用
//    String strongReference = weakReference.get();
//
//    1
//    2
//    3
//    4
//
//同样，弱引用可以和一个引用队列(ReferenceQueue)联合使用，如果弱引用所引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与之关联的引用队列中。
//
//简单测试：
//
//GCTarget.java
//
//public class GCTarget {
//    // 对象的ID
//    public String id;
//
//    // 占用内存空间
//    byte[] buffer = new byte[1024];
//
//    public GCTarget(String id) {
//        this.id = id;
//    }
//
//    protected void finalize() throws Throwable {
//        // 执行垃圾回收时打印显示对象ID
//        System.out.println("Finalizing GCTarget, id is : " + id);
//    }
//}
//
//GCTargetWeakReference.java
//
//public class GCTargetWeakReference extends WeakReference<GCTarget> {
//    // 弱引用的ID
//    public String id;
//
//    public GCTargetWeakReference(GCTarget gcTarget,
//              ReferenceQueue<? super GCTarget> queue) {
//        super(gcTarget, queue);
//        this.id = gcTarget.id;
//    }
//
//    protected void finalize() {
//        System.out.println("Finalizing GCTargetWeakReference " + id);
//    }
//}
//WeakReferenceTest.java
//
//public class WeakReferenceTest {
//    // 弱引用队列
//    private final static ReferenceQueue<GCTarget> REFERENCE_QUEUE = new ReferenceQueue<>();
//
//    public static void main(String[] args) {
//        LinkedList<GCTargetWeakReference> gcTargetList = new LinkedList<>();
//
//        // 创建弱引用的对象，依次加入链表中
//        for (int i = 0; i < 5; i++) {
//            GCTarget gcTarget = new GCTarget(String.valueOf(i));
//            GCTargetWeakReference weakReference = new GCTargetWeakReference(gcTarget,
//                REFERENCE_QUEUE);
//            gcTargetList.add(weakReference);
//
//            System.out.println("Just created GCTargetWeakReference obj: " +
//                gcTargetList.getLast());
//        }
//
//        // 通知GC进行垃圾回收
//        System.gc();
//
//        try {
//            // 休息几分钟，等待上面的垃圾回收线程运行完成
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // 检查关联的引用队列是否为空
//        Reference<? extends GCTarget> reference;
//        while((reference = REFERENCE_QUEUE.poll()) != null) {
//            if(reference instanceof GCTargetWeakReference) {
//                System.out.println("In queue, id is: " +
//                    ((GCTargetWeakReference) (reference)).id);
//            }
//        }
//    }
//}
//
//运行WeakReferenceTest.java，运行结果如下：
//
//可见WeakReference对象的生命周期基本由垃圾回收器决定，一旦垃圾回收线程发现了弱引用对象，在下一次GC过程中就会对其进行回收。
