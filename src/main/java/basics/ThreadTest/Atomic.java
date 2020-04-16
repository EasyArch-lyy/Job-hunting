package basics.ThreadTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic变量自增测试
 * @author lyy
 */
public class Atomic {
    public static AtomicInteger race=new AtomicInteger(0);
    public static void increase(){
        race.incrementAndGet();
    }

    public static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        for(int i=0;i<THREAD_COUNT;i++){
            new Thread(()->{
                for(int j=0;j<10000;j++){
                    increase();
                }
            }).start();
        }
        //等待所有累加的线程结束,若还有线程运行,主线程出让cpu资源
        //
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(race);
    }
}
