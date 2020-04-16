package basics.ThreadTest;

import java.util.Vector;

/**
 * 线程不安全的Vector
 * @author lyy
 */
public class VectorTest {

    private static Vector<Integer>vector =new Vector<>();

    public static void main(String[] args) {

        while (true){
            for(int i=0;i<10;i++){
                vector.add(i);
            }
            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            }).start();

            new Thread(()->{
                for(int i=0;i<vector.size();i++){
                    System.out.println(vector.get(i));
                }
            }).start();
            while (Thread.activeCount()>90) {

            }
        }
    }
}
