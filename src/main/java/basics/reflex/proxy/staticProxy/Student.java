package basics.reflex.proxy.staticProxy;


/**
 * 实现Person接口，具体实施动作
 * @author lyy
 */
public class Student implements Person{
    private String name;
    public Student(String name){
        this.name=name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name+"上交班费50元");
    }

    @Override
    public void giveWater() {
        System.out.println(name+"给水");
    }
}
