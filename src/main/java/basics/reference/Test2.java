package basics.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 *     软引用
 * 如果一个对象只具有软引用，则内存空间充足时，垃圾回收器就不会回收它；如果内存空间不足了，就会回收这些对象的内存。只要垃圾回收器没有回收它，该对象就可以被程序使用。
 *
 * @author lyy
 */
public class Test2 {

    public void test1(){
         // 强引用
         String strongReference = new String("abc");
         // 软引用
         String str = new String("abc");
         SoftReference<String> softReference = new SoftReference<String>(str);
    }
    /**
     * 软引用可以和一个引用队列(ReferenceQueue)联合使用.如果软引用所引用对象被垃圾回收,JAVA虚拟机就会把这个软引用加入到与之关联的引用队列中。
     */
    public void test2(){
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        String str = new String("abc");
        SoftReference<String> softReference = new SoftReference<>(str, referenceQueue);
        str = null;
        //Notify GC
        System.gc();
        System.out.println(softReference.get());
        Reference<? extends String> reference = referenceQueue.poll();
        System.out.println(reference);

        /**
         *     注意：软引用对象是在jvm内存不够的时候才会被回收,我们调用System.gc()方法只是起通知作用,JVM什么时候扫描回收对象是JVM自己的状态决定的.就算扫描到软引用对象也不一定会回收它，只有内存不够的时候才会回收。
         * 当内存不足时,JVM首先将软引用中的对象引用置为null,然后通知垃圾回收器进行回收,
         * 垃圾收集线程会在虚拟机抛出OutOfMemoryError之前回收软引用对象，而且虚拟机会尽可能优先回收长时间闲置不用的软引用对象。对那些刚构建的或刚使用过的“较新的”软对象会被虚拟机尽可能保留，这就是引入引用队列ReferenceQueue的原因。
         */
    }
    /**
     *    软引用应用场景：
     * 浏览器的后退按钮。按后退时，这个后退时显示的网页内容是重新进行请求还是从缓存中取出呢？
     * 如果一个网页在浏览结束时就进行内容的回收，则按后退查看前面浏览过的页面时，需要重新构建
     * 如果将浏览过的网页存储到内存中会造成内存的大量浪费，甚至会造成内存溢出
     * */
    public void test3(){

        // 获取浏览器对象进行浏览
//    Browser browser = new Browser();
//    // 从后台程序加载浏览页面
//    BrowserPage page = browser.getPage();
//    // 将浏览完毕的页面置为软引用
//    SoftReference softReference = new SoftReference(page);
//
//    // 回退或者再次浏览此页面时
//    if(softReference.get() != null) {
//        // 内存充足，还没有被回收器回收，直接获取缓存
//        page = softReference.get();
//    } else {
//        // 内存不足，软引用的对象已经回收
//        page = browser.getPage();
//        // 重新构建软引用
//        softReference = new SoftReference(page);
//    }
    }
}

