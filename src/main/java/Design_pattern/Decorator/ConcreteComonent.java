package Design_pattern.Decorator;

/**
 * @author lyy
 */
public class ConcreteComonent implements Component{
    @Override
    public void doSomething() {
        System.out.println("功能A");
    }
}
