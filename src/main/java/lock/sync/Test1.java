package lock.sync;

/**
 * javac编译，javap -verbose反编译实例
 * @author lyy
 */
public class Test1 {
    public void testSyn() {
        synchronized (this) {
        }
    }
}
//    如果monitor的进入数为0，则该线程进入monitor，然后将进入数设置为1，该线程即为monitor的owner
//    如果线程已经占有该monitor，只是重新进入，则进入monitor的进入数加1.
//    如果其他线程已经占用了monitor，则该线程进入阻塞状态，直到monitor的进入数为0，再重新尝试获取monitor的所有权

//警告: 二进制文件Test包含lock.sync.Test
//Classfile /home/lyy/桌面/Job-hunting/src/main/java/lock/sync/Test.class
//  Last modified 2020-3-19; size 353 bytes
//  MD5 checksum 9790fab9512ca37c6447be7210ef7837
//  Compiled from "Test.java"
//public class lock.sync.Test
//  minor version: 0
//  major version: 52
//  flags: ACC_PUBLIC, ACC_SUPER
//Constant pool:
//   #1 = Methodref          #3.#15         // java/lang/Object."<init>":()V
//   #2 = Class              #16            // lock/sync/Test
//   #3 = Class              #17            // java/lang/Object
//   #4 = Utf8               <init>
//   #5 = Utf8               ()V
//   #6 = Utf8               Code
//   #7 = Utf8               LineNumberTable
//   #8 = Utf8               testSyn
//   #9 = Utf8               StackMapTable
//  #10 = Class              #16            // lock/sync/Test
//  #11 = Class              #17            // java/lang/Object
//  #12 = Class              #18            // java/lang/Throwable
//  #13 = Utf8               SourceFile
//  #14 = Utf8               Test.java
//  #15 = NameAndType        #4:#5          // "<init>":()V
//  #16 = Utf8               lock/sync/Test
//  #17 = Utf8               java/lang/Object
//  #18 = Utf8               java/lang/Throwable
//{
//  public lock.sync.Test();
//    descriptor: ()V
//    flags: ACC_PUBLIC
//    Code:
//      stack=1, locals=1, args_size=1
//         0: aload_0
//         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//         4: return
//      LineNumberTable:
//        line 7: 0
//
//  public void testSyn();
//    descriptor: ()V
//    flags: ACC_PUBLIC
//    Code:
//      stack=2, locals=3, args_size=1
//         0: aload_0
//         1: dup
//         2: astore_1
//         3: monitorenter                     //申请获得对象的内置锁
//         4: aload_1
//         5: monitorexit                      //释放对象内置锁
//         6: goto          14
//         9: astore_2
//        10: aload_1
//        11: monitorexit                      //释放对象内置锁
//        12: aload_2
//        13: athrow
//        14: return
//      Exception table:
//         from    to  target type
//             4     6     9   any
//             9    12     9   any
//      LineNumberTable:
//        line 9: 0
//        line 10: 4
//        line 11: 14
//      StackMapTable: number_of_entries = 2
//        frame_type = 255 /* full_frame */
//          offset_delta = 9
//          locals = [ class lock/sync/Test, class java/lang/Object ]
//          stack = [ class java/lang/Throwable ]
//        frame_type = 250 /* chop */
//          offset_delta = 4
//}
//SourceFile: "Test.java"