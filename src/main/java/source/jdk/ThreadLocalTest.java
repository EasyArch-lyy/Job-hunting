package source.jdk;

/**
 * 在该方法中针对脏entry做了这样的处理：
 *     如果当前table[i]！=null的话说明hash冲突就需要向后环形查找，若在查找过程中遇到脏entry就通过replaceStaleEntry进行处理；
 *     如果当前table[i]==null的话说明新的entry可以直接插入，但是插入后会调用cleanSomeSlots方法检测并清除脏entry
 *
 * @author lyy
 */
public class ThreadLocalTest {

    /**解决ThreadLocal内存泄漏，脏Entry*/
    private void set(ThreadLocal<?> key, Object value) {

        // We don't use a fast path as with get() because it is at
        // least as common to use set() to create new entries as
        // it is to replace existing ones, in which case, a fast
        // path would fail more often than not.

//        Entry[] tab = table;
//        int len = tab.length;
//        int i = key.threadLocalHashCode & (len-1);
//
//        for (Entry e = tab[i];
//             e != null;
//             e = tab[i = nextIndex(i, len)]) {
//            ThreadLocal<?> k = e.get();
//
//            if (k == key) {
//                e.value = value;
//                return;
//            }
//
//            if (k == null) {
//                replaceStaleEntry(key, value, i);
//                return;
//            }
//        }
//
//        tab[i] = new Entry(key, value);
//        int sz = ++size;
//        if (!cleanSomeSlots(i, sz) && sz >= threshold)
//            rehash();
    }

}
