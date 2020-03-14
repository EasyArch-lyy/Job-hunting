package proxy.dynamicProxy;

/**
 * @author lyy
 */
public class Student implements Person{
    private String name;
    public Student(String name){
        this.name=name;
    }

    @Override
    public void giveMoney() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"上交班费50");
    }
}
