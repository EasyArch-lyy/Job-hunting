package Design_pattern.Decorator;

/**
 * 装饰器模式
 *
 * @author lyy
 */
public class Client {
    public static void main(String[] args) {
        Component component=new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComonent()));
        component.doSomething();
    }
}
