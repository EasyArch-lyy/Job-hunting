package jvm.gcTest;

import java.io.IOException;

/**
 * 对象回收前处理
 * @author lyy
 */
public class Finalize {

    private static Finalize ft=null;
    public Finalize(){

    }

    public void info() {
        try {
            Thread.sleep(2000);
            System.out.println("xxxx");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Finalize t=new Finalize();
        t.info();
        System.out.println(ft);
        ft=t;
        t=null;
        System.gc();
//        System.out.println(Runtime.getRuntime());
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        t=null;
        System.gc();
        t.info();
//        System.runFinalization();
//        System.in.read();
    }

    @Override
    public void finalize(){
        System.out.println("ok");
        ft=new Finalize();
//        ft.info();
    }
}
