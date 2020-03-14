package proxy.staticProxy;

/**
 * @author lyy
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Person zhanglong=new Student("张龙");

        Person monitor=new StudentProxy(zhanglong);
        Student student=new Student("王五");
        Person moniter=new StudentProxy(student);

        moniter.giveWater();
        monitor.giveMoney();
    }
}
