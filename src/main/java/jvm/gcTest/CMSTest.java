package jvm.gcTest;

/**
 * CMS垃圾回收
 * @author lyy
 */
public class CMSTest {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] byte1 = new byte[4 * size];
        System.out.println("11111");
        byte[] byte2 = new byte[4 * size];
        System.out.println("22222");
        byte[] byte3 = new byte[4 * size];
        System.out.println("33333");
        byte[] byte4 = new byte[4 * size];
        System.out.println("44444");
    }
}

