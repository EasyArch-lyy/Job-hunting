package basics.annotation;

/**
 * 提供划线注解
 * */
@Deprecated
class Apple {

    @Deprecated
    public void info() {
        System.out.println("aaaa");
    }

    @Deprecated
    private String str;
}
/**
 * 类被@Deprecated标识，IDE会给出提示
 * 划线注解@Deprecated
 * @author lyy
 */
public class Test1 {
    public static void main(String[] args) {
        new Apple().info();
    }
}
