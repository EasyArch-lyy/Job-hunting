package jvm.gcTest;

public class FinalizeTest {
    public FinalizeTest(){

    }
    private static FinalizeTest ft = null;

    public void info() {
        System.out.println("xxxxxxxx");
    }

    public static void main(String[] args) throws Exception {
        FinalizeTest t=new FinalizeTest();
        t=null;
        System.gc();
        //
        Runtime.getRuntime().gc();
		Runtime.getRuntime().runFinalization();//尽量执行finalize方法

        System.runFinalization();
        System.in.read();
        ft.info();


    }

    @Override
    public void finalize() {
        System.out.println("ok");
        ft = new FinalizeTest();

    }
}
