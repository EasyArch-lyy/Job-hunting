package basics.reference;

import java.util.ArrayList;

/**
 *      强引用
 *  当内存空间不足时，Java虚拟机宁愿抛出OutOfMemoryError错误，使程序异常终止，也不会靠随意回收具有强引用的对象来解决内存不足的问题。
 *  如果强引用对象不使用时，需要弱化从而使GC能够回收，如下：
 *  strongReference = null;
 *
 *  @author lyy
 */
public class Test1 {

   /**
    *     方法的内部有一个强引用，这个引用保存在Java栈中，而真正的引用内容(Object)保存在Java堆中。
    * 当这个方法运行完成后，就会退出方法栈，则引用对象的引用数为0，这个对象会被回收。
    * 但是如果这个strongReference是全局变量时，就需要在不用这个对象时赋值为null，因为强引用不会被垃圾回收。
    */
    public void test1(){
        Object strongReference =new Object();
    }
    /**
     *      ArrayList的Clear方法：
     * 在ArrayList类中定义了一个elementData数组，在调用clear方法清空数组时，每个数组元素被赋值为null。
     * 不同于elementData=null，强引用仍然存在，避免在后续调用add()等方法添加元素时进行内存的重新分配。
     * 使用如clear()方法内存数组中存放的引用类型进行内存释放特别适用，这样就可以及时释放内存。
     */
    public void test2(){
        ArrayList list=new ArrayList();
        list.clear();
    }
}
